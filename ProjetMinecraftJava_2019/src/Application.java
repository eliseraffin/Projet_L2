import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application extends JFrame  {


	Modele modl;
	
	public Application(Modele modl) {
		
		this.modl = modl;
		this.setTitle("Crafting");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(((int) dim.getWidth())/3, ((int) dim.getHeight())/3);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Controleur ctrl = new Controleur(modl);
		JLabel jl = new JLabel(new ImageIcon("craftingfleche.png"));
		jl.setBounds(new Rectangle(440,135,67,67));
		AWT_Inventaire inventaire = new AWT_Inventaire(modl,ctrl);
		inventaire.setBounds(new Rectangle(5,50,155,255));
		AWT_crafting craft = new AWT_crafting(modl,ctrl);
		craft.setBounds(new Rectangle(240,95,150,150));
		AWT_Recette recette = new AWT_Recette(modl,ctrl);
		recette.setBounds(new Rectangle(545,120,100,100));
		AWT_Tri tri = new AWT_Tri(modl,ctrl);
		tri.setBounds(new Rectangle(0,0,680,40));
		JButton raz = new JButton("Tout voir");
		raz.setBounds(new Rectangle(5,315,155,20));
		raz.setName("raz");
		raz.addActionListener(ctrl);
		JPanel jp = new JPanel();
		this.setSize(680, 370);
		jp.setSize(680,370);
		jp.setLayout(null);
		jp.setBackground(Color.LIGHT_GRAY);
		jp.add(tri);
		jp.add(recette);
		jp.add(craft);
		jp.add(inventaire);
		jp.add(jl);
		jp.add(raz);
		this.add(jp);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	
	

	
	
	
	
	
	
}