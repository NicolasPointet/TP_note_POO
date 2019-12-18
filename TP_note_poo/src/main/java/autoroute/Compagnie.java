package autoroute;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Compagnie {
	
	ArrayList<Route> list_route = new ArrayList<Route>();
	ArrayList<Tarif> list_tarif = new ArrayList<Tarif>();
	
	public Compagnie() {
		
	}
	
	public BigDecimal obtenirTarif(Porte porte1, Porte porte2) {
		BigDecimal calcul=new BigDecimal(0);
		calcul = getTarifExacte(porte1, porte2);
		if ( calcul != new BigDecimal(0) ) {
			return calcul;
		}
		return  getTarifCalcule(porte1, porte2);
	}
	
	public void ajouterTarif(Tarif tarif) {
		list_tarif.add(tarif);
	}
	
	public void ajouterRoute(Route route) {
		list_route.add(route);
	}
	
	BigDecimal getTarifCalcule(Porte porte1, Porte porte2) {
		BigDecimal prix = new BigDecimal(0);
		Route route = null;
		
		/* On regarde pour toutes les routes
		 * celle qui contient la premiere porte,
		 * puis on calcul le prix porte a porte
		 */
		
		for(Route r : list_route){
			if (r.list_porte.contains(porte1)) {
				route = r;
				break;
			}
		}
		
		/*for (int i = route.list_porte.indexOf(porte1); i < route.list_porte.indexOf(porte2); i++) {
			prix.add(getTarifExacte(route.list_porte.get(i), route.list_porte.get(i+1)));
		}*/
		
		int i = route.list_porte.indexOf(porte1);
		while (i < route.list_porte.indexOf(porte2)) {
			int k=route.list_porte.indexOf(porte2);
			while (getTarifExacte(route.list_porte.get(i), route.list_porte.get(k)) == (new BigDecimal(0))){
				k-=1;
				if (k == i) {
					break;
				}
			}
			prix.add(getTarifExacte(route.list_porte.get(i), route.list_porte.get(k)));
			i=k;
		}
		
		return prix;
	}
	
	BigDecimal getTarifExacte(Porte porte1, Porte porte2) {
		
		/*
		 * Pour chaque tarif on verifie qu'il correspond a celui que l'on cherche
		 */
		
		for (Tarif t : list_tarif) {
			if (t.entree.numero_porte == porte1.numero_porte && t.sortie.numero_porte == porte2.numero_porte) {
				return t.prix;
			}
		}
		return new BigDecimal(0); //si on trouve pas le tarif correspondant, alors le prix est de 0
	}
	
	

}
