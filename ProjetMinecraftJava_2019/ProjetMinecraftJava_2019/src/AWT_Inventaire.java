import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class AWT_Inventaire extends JPanel implements Observer {

	Modele m;
	String[][] boutons = {{"0","1","2"},{"3","4","5"},{"6","7","8"},{"9","10","11"},{"12","13","14"}}; 
	Objet[][] tab_invt;


	public AWT_Inventaire(Modele m, ActionListener al) {
		this.m = m;
		tab_invt = m.objets_inventaire;
		GridLayout givt = new GridLayout(3,5);
		givt.setColumns(3);
		givt.setRows(5);
		this.setLayout(givt);
		this.setName("inventaire objets");
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++) {
				JButton jb = new JButton();
				jb.setSize(50, 50);
				jb.setName(boutons[i][j]);
				jb.setBackground(Color.GRAY);
				jb.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.GRAY,Color.DARK_GRAY));
				if (tab_invt[i][j].lib!=null) {
					jb.setIcon(new ImageIcon("Objet_images/"+m.cheminObjet(tab_invt[i][j])));
				} else {
					jb.setIcon(null);
				} 
				jb.addActionListener(al);
				this.add(jb);
			} 
		}
		m.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg1) {
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++) {
				if (m.objets_inventaire[i][j].qte == 0) {
					JButton jb = (JButton)this.getComponent(2*i+j+i);
					jb.setIcon(null);	
				} if (m.objets_inventaire[i][j].lib!=null && m.objets_inventaire[i][j].lib!="vide") {
					JButton jb = (JButton)this.getComponent(2*i+j+i);
					jb.setIcon(new ImageIcon("Objet_images/"+m.cheminObjet(m.objets_inventaire[i][j])));
				} if (m.categorie!=null) {
					if (m.objets_inventaire[i][j].lib==m.categorie) {

						JButton jb = (JButton)this.getComponent(2*i+j+i);
						jb.setIcon(new ImageIcon("Objet_images/"+m.cheminObjet(m.objets_inventaire[i][j])));
					} if (m.objets_inventaire[i][j].categorie!=m.categorie) {
						JButton jb = (JButton)this.getComponent(2*i+j+i);
						jb.setIcon(null);
					}

				}	}
		}

	}

}
