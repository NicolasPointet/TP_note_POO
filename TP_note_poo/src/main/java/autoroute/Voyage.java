package autoroute;

import java.math.BigDecimal;

public class Voyage {
	
	Porte entree;
	Porte sortie;
	Compagnie autoroute;
	
	
	public Porte getEntree() {
		return entree;
	}

	public void setEntree(Porte entree) {
		this.entree = entree;
	}

	public Porte getSortie() {
		return sortie;
	}

	public void setSortie(Porte sortie) {
		this.sortie = sortie;
	}

	public Compagnie getAutoroute() {
		return autoroute;
	}

	public void setAutoroute(Compagnie autoroute) {
		this.autoroute = autoroute;
	}


	public BigDecimal getTarif() {
		return this.autoroute.obtenirTarif(entree,sortie);
	}
	
	Voyage(Porte porte1, Porte porte2, Compagnie compagnie){
		this.entree = porte1;
		this.sortie = porte2;
		this.autoroute = compagnie;
	}
	
	
	
}
