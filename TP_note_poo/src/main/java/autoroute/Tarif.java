package autoroute;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Tarif {
	
	Porte entree;
	Porte sortie;
	LocalDateTime dateValidite;
	BigDecimal prix;
	
	public Tarif (Porte porte1, Porte porte2, BigDecimal bd){
		this.entree = porte1;
		this.sortie = porte2;
		this.prix = bd;
		this.dateValidite = LocalDateTime.now();
	}
	
	public String toString() {
		return "Le prix entre la porte " + entree.numero_porte + 
				" et " + sortie.numero_porte + " est de " + this.prix;
	}

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

	public LocalDateTime getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(LocalDateTime dateValidite) {
		this.dateValidite = dateValidite;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
}
