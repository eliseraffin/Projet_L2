import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;


public class AWT_Accompagnement extends JPanel implements Observer{


	Modele m;
	String[][] boutons = {{"0acc","1acc","2acc","3acc"},{"4acc","5acc","6acc","7acc"},{"8acc","9acc","10acc","11acc"},{"12acc","13acc","14acc","15acc"}}; 
	Recette[] tab_accomp;

	public AWT_Accompagnement(Modele m, ActionListener al) {
		this.m = m;
		tab_accomp = m.recettes;
		GridLayout gacc = new GridLayout(4,4);
		gacc.setColumns(4);
		gacc.setRows(4);
		this.setLayout(gacc);
		this.setBounds(new Rectangle(5,5,155,255));
		this.setName("inventaire objets");
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				JButton jb = new JButton();
				jb.setSize(50, 50);
				jb.setName(boutons[i][j]);
				jb.setBackground(Color.GRAY);

				jb.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
				if (tab_accomp[4*i+j].lib!="nulle") {
					String chemin = "Objet_images/"+m.cheminObjet(tab_accomp[4*i+j].miniature);
					jb.setIcon(new ImageIcon(chemin));
				} 
				jb.addActionListener(al);
				this.add(jb);
			} 
		}
		m.addObserver(this);


	}

	@Override
	public void update(Observable o, Object arg1) {

		if (m.affichage.equals("")==false) {
			JOptionPane.showMessageDialog(this, m.affichage, "Aide", 1, m.ic);
		}
	}



}
