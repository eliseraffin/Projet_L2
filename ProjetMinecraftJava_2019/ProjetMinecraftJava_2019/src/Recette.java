import java.util.HashMap;

public class Recette {

	String lib;
	Objet[][] matrice;
	Objet miniature;
	HashMap<String, Integer> liste;
	Boolean possible;
	
	public Recette(String lib, Objet[][] matrice,Objet miniature, HashMap<String, Integer> liste, Boolean possible) {
		this.lib = lib;
		this.matrice = matrice;
		this.miniature = miniature;
		this.liste = liste;
		this.possible = possible;
	}
	
}
