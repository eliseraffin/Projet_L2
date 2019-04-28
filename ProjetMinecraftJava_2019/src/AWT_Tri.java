import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AWT_Tri extends JPanel implements Observer{

	Modele m;
	String[] modele_tri = {"Combat", "Matière première", "Outil", "Véhicule", "Maison"};

	public AWT_Tri(Modele m, ActionListener al) {
		this.m = m;
		GridLayout givt = new GridLayout(5,1);
		givt.setColumns(5);
		givt.setRows(1);
		this.setLayout(givt);
		this.setName("inventaire objets");
		Button_Tri jb_mat_prem = new Button_Tri("Matière première", Color.WHITE);
		jb_mat_prem.setName("Matière première");
		jb_mat_prem.addActionListener(al);
		Button_Tri jb_combat = new Button_Tri("Combat", Color.CYAN);
		jb_combat.setName("Combat");
		jb_combat.addActionListener(al);
		Button_Tri jb_outils = new Button_Tri("Outils", Color.CYAN);
		jb_outils.setName("Outil");
		jb_outils.addActionListener(al);
		Button_Tri jb_vehicule = new Button_Tri("Véhicule", Color.CYAN);
		jb_vehicule.setName("Véhicule");
		jb_vehicule.addActionListener(al);
		Button_Tri jb_maison = new Button_Tri("Maison", Color.CYAN);
		jb_maison.setName("Maison");
		jb_maison.addActionListener(al);
		this.add(jb_combat);
		this.add(jb_mat_prem);
		this.add(jb_outils);
		this.add(jb_vehicule);
		this.add(jb_maison);
		this.setBackground(new Color(213/255.0f,141/255.0f,125/255.0f,.5f));
		m.addObserver(this);
	}



	@Override
	public void update(Observable o, Object arg) {

		for (int j = 0; j<5; j++) {
			if (m.categorie != modele_tri[j] || m.categorie==null) {
				Button_Tri jb2 = (Button_Tri)this.getComponent(j);
				jb2.col = Color.CYAN;
				repaint();
			}
		}

		for (int i = 0; i<5; i++) {	
			if (m.categorie == modele_tri[i]) {
				Button_Tri jb = (Button_Tri)this.getComponent(i);
				jb.col = Color.LIGHT_GRAY;
			}

		}





	}

}
