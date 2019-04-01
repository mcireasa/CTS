package s6.testare;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import s6.clase.ETipMagazin;
import s6.clase.Magazin;
import s6.exceptii.ExceptieMagazin;

public class TestContructorMagazin {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testRight() throws ExceptieMagazin {
		Magazin m = new Magazin("Magazin",10,ETipMagazin.COSMETICE,50);
		//verif ca s-au setat corect toate atributele
		assertEquals("set denumire","Magazin",m.getDenumire());
		assertEquals("set angajati",10,m.getNrAngajati());
		assertEquals("set tip magazin",ETipMagazin.COSMETICE,m.getTipMagazin());
		assertEquals("set suprafata",50,m.getSuprafataMp());
		//nu ar trebui sa arunce exceptie, nu folosim expected = ExceptieMagazin.class
	}
	
	@Test(expected = ExceptieMagazin.class)
	public void testException() throws ExceptieMagazin {
		Magazin m = new Magazin("Magazin1",-1,ETipMagazin.DECORATIUNI,50);
		//verificam constructor cu input ce genereaza exceptie(nr angajati <=0, un exemplu)
		//nu trebuie ca tot inputul sa genereze exceptie
		//o sa arunce exceptie la prima verificare de input ce pica
	}
	
	@Test(expected = ExceptieMagazin.class)
	public void testExistence() throws ExceptieMagazin {
		Magazin m = new Magazin(null,10,ETipMagazin.COSMETICE,50);
		//verificam constructorul cu input null(denumire magazin)
		//ar trebui sa arunce exceptie, deci folosim expected
	}
	
	

}
