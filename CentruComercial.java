package s6.clase;
import java.util.ArrayList;

import s6.exceptii.ExceptieCalculAsigurare;
import s6.exceptii.ExceptieMagazin;
import s6.interfete.IAutoritate;

public class CentruComercial {
	private String denumire;
	private int suprafataCentru;
	private ArrayList<Magazin> magazine;
	
	public CentruComercial(String denumire, int suprafataCentru,
			ArrayList<Magazin> magazine) {
		this.denumire = denumire;
		this.suprafataCentru = suprafataCentru;
		this.magazine = magazine;
	}
	
	public String getCelMaiMareMagazin(ETipMagazin tipMagazin) throws ExceptieMagazin {
		if(magazine == null || magazine.size() == 0)
			throw new ExceptieMagazin();
		boolean gasit = false;
		//initializare best cu o suprafata minima acceptata de validarile constructorului
		Magazin result = new Magazin("Magazin",15,tipMagazin,10);
		for(Magazin m: magazine) {
			if(m.getTipMagazin() == tipMagazin && m.getSuprafataMp()>result.getSuprafataMp()) {
				result = m;	
				gasit = true;
			}
		}
		if(gasit == false)
			throw new ExceptieMagazin();
		return result.getDenumire();
	}
	
	public float calculTarifAsigurare(IAutoritate autoritate) throws ExceptieCalculAsigurare {
		if(autoritate.esteAsigurat(this)){
			float taxa = autoritate.tarifAsigurareMp();
			int suprafata = 0;
			for(Magazin m: magazine) {
				suprafata += m.getSuprafataMp();
			}
			return taxa * suprafata;
		}
		else
			throw new ExceptieCalculAsigurare();
	}
}
