package s6.mock;

import s6.clase.CentruComercial;
import s6.interfete.IAutoritate;

public class AutoritateMock implements IAutoritate{
	private boolean esteAsigurat;
	private float tarif;

	public void setEsteAsigurat(boolean esteAsigurat) {
		this.esteAsigurat = esteAsigurat;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	@Override
	public boolean esteAsigurat(CentruComercial c) {
		// TODO Auto-generated method stub
		return esteAsigurat;
	}

	@Override
	public float tarifAsigurareMp() {
		// TODO Auto-generated method stub
		return tarif;
	}

}
