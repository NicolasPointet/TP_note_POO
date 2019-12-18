package autoroute;

import java.util.Comparator;

public class OrdrePorteComparator implements Comparator<Porte> {

	public int compare(Porte porte1, Porte porte2) {
		return porte1.numero_porte - porte2.numero_porte;
	}

	public boolean equals(Object o) {
		if (this == o) 
		{
			return true;
		}
		
		return false;	
	}
}
