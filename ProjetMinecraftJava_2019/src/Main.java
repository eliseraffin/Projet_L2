

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		Modele m = new Modele();
		FondJeu fj = new FondJeu();
		Accompagnement acc = new Accompagnement(m);
		Application app = new Application(m);
        
	}
	
	
	
}
