package autoroute;

import java.util.ArrayList;

public class Route {
	
	public ArrayList<Porte> list_porte = new ArrayList<Porte>();
	
	public void addPorte(Porte porte) {
		list_porte.add(porte);
	}
	
	public String toString() {
		return "Cette route a les portes suivante " + list_porte.toString();
	}

}
