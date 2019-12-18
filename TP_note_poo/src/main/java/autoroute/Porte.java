package autoroute;

public class Porte {
	
	int numero_porte;

	public Porte(int i){
		this.numero_porte = i;
	}
	
	public boolean equals(Object o) {
		if (this == o) {return true;}
		return false;
	}
	
	public String toString() {
		return (" " + this.numero_porte);
	}

	public int getNumero_porte() {
		return numero_porte;
	}

	public void setNumero_porte(int numero_porte) {
		this.numero_porte = numero_porte;
	}
	
	
	
}
