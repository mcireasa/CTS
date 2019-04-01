package s6.testare;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import s6.clase.CentruComercial;
import s6.clase.ETipMagazin;
import s6.clase.Magazin;
import s6.exceptii.ExceptieCalculAsigurare;
import s6.mock.AutoritateMock;

public class TestCalculTarifAsigurare {
	static CentruComercial cc = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Magazin m1 = new Magazin("Magazin1",10,ETipMagazin.COSMETICE,20);
		Magazin m2 = new Magazin("Magazin2",15,ETipMagazin.COSMETICE,20);
		Magazin m3 = new Magazin("Magazin3",13,ETipMagazin.COSMETICE,10);
		ArrayList<Magazin> listaM = new ArrayList<>();
		listaM.add(m1);
		listaM.add(m2);
		listaM.add(m3);
		cc = new CentruComercial("Mall Baneasa", 1000, listaM);
	}

	@Test
	public void testRight() throws ExceptieCalculAsigurare {
		//setare obiect Mock pentru a se incadra intr-un centru asigurat
		AutoritateMock autoritateMock = new AutoritateMock();
		autoritateMock.setEsteAsigurat(true);
		autoritateMock.setTarif(10);
		
		float actualValue = cc.calculTarifAsigurare(autoritateMock);
		float expectedValue = 500;
		assertEquals("verif mall asigurat", expectedValue, actualValue,0.001);
	}
	
	@Test(expected = ExceptieCalculAsigurare.class)
	public void testException() throws ExceptieCalculAsigurare {
		//setare obiect Mock pentru a se incadra intr-un centru neasigurat
		AutoritateMock autoritateMock = new AutoritateMock();
		autoritateMock.setEsteAsigurat(false);
		
		cc.calculTarifAsigurare(autoritateMock);
		fail("Nu a aruncat exceptie chiar daca centrul nu era asigurat");
		//asteptam sa arunce exceptie pentru ca centrul nu este asigurat
	}

}
