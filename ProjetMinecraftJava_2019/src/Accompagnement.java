import javax.swing.JFrame;

public class Accompagnement extends JFrame{


	Modele modl;
	
	public Accompagnement(Modele modl) {
		this.modl = modl;
		this.setTitle("Accompagnement");
		this.setSize(250, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Controleur ctrl = new Controleur(modl);
		AWT_Accompagnement acc = new AWT_Accompagnement(modl,ctrl);
		this.add(acc);
		this.setLocation(50, 50);
		this.setVisible(true);
		
	}
	
}
