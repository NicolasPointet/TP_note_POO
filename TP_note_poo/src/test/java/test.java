import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import autoroute.*;

public class test {
	


    @Test
    public void testCompare() {
    	ArrayList<Porte> list = new ArrayList<Porte>();

    	Porte p1 = new Porte_entre(1), p2 = new Porte_sortie(2), p3 = new Porte_entre(3), p4 = new Porte_sortie(4);
    	list.add(p4);
    	list.add(p3);
    	list.add(p1);
    	list.add(p2);
    	
    	Collections.sort(list, new OrdrePorteComparator());
    	assertEquals("Vérification des items de la liste", 1, list.get(0).getNumero_porte());
    	assertEquals("Vérification des items de la liste", 2, list.get(1).getNumero_porte());
    	assertEquals("Vérification des items de la liste", 3, list.get(2).getNumero_porte());
    	assertEquals("Vérification des items de la liste", 4, list.get(3).getNumero_porte());     
    
    }





	@Test
	public void testObtenirTarifExacte() {
	    Compagnie compagnie = new Compagnie();
	    Route r2 = new Route();
	    Porte pA = new Porte_entre(10), pB = new Porte_sortie(20), pC = new Porte_sortie(30), pD = new Porte_sortie(40);
	
	
	    r2.addPorte(pA);
	    r2.addPorte(pB);
	    r2.addPorte(pC);
	    r2.addPorte(pD);
	
	    compagnie.ajouterRoute(r2);
	
	    Tarif tABCD = new Tarif(pA, pD, new BigDecimal("1.23E+3"));
	
	
	    compagnie.ajouterTarif(tABCD);
	
	    assertEquals("Erreur calcul exacte du tarif", new BigDecimal("1.23E+3"), compagnie.obtenirTarif(pA, pD));
	}

	

	@Test
	public void testObtenirTarifCalculé() {
	    Compagnie compagnieAutoroute = new Compagnie();
	    Route r1 = new Route();
	    Porte p1 = new Porte_entre(1), p2 = new Porte_sortie(2), p3 = new Porte_entre(3), p4 = new Porte_sortie(4);
	
	    r1.addPorte(p4);
	    r1.addPorte(p3);
	    r1.addPorte(p1);
	    r1.addPorte(p2);
	
	    compagnieAutoroute.ajouterRoute(r1);
	    Collections.sort(r1.list_porte, new OrdrePorteComparator());
	
	    Tarif
	            t12 = new Tarif(p1, p2, new BigDecimal("1E+1")),
	            t23 = new Tarif(p2, p3, new BigDecimal("2E+1")),
	            t34 = new Tarif(p3, p4, new BigDecimal("3E+1"));
	
	    compagnieAutoroute.ajouterTarif(t12);
	    compagnieAutoroute.ajouterTarif(t23);
	    compagnieAutoroute.ajouterTarif(t34);
	
	    assertEquals("Erreur calcul du tarif", new BigDecimal("60"), compagnieAutoroute.obtenirTarif(p1, p4));
	}
}
