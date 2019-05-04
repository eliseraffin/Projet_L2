import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class AWT_crafting extends JPanel implements Observer{

	Modele m;
	String[][] boutons = {{"0c","1c","2c"},{"3c","4c","5c"},{"6c","7c","8c"}};
	Objet[][] tab_obj;

	public AWT_crafting(Modele m, ActionListener al) {
		this.m = m;
		tab_obj = new Objet[3][3];
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				tab_obj[i][j] = m.crafting[i][j];
			}
		}
		GridLayout gridlayout_crafting = new GridLayout(3,3);
		gridlayout_crafting.setColumns(3);
		gridlayout_crafting.setRows(3);
		this.setLayout(gridlayout_crafting);
		//this.setBounds(new Rectangle(240,95,150,150));
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				JButton jb = new JButton();
				jb.setSize(50, 50);
				jb.setName(boutons[i][j]);
				jb.setBackground(Color.GRAY);
				jb.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
				if (tab_obj[i][j].lib!=null) {
					jb.setIcon(new ImageIcon("Objet_images/"+m.cheminObjet(tab_obj[i][j])));
				} else {
					jb.setIcon(null);
				}jb.addActionListener(al); 
				this.add(jb);
			}
		} m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (m.ind!=10) {
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					if (2*i+j+i==m.ind && m.objt_select.lib!=null) {
						if (m.crafting[i][j].lib==null) {
							JButton jb = (JButton)this.getComponent(m.ind);
							jb.setIcon(null);	
						} else {
							if (m.objt_select.qte >0 ) {
								JButton jb = (JButton)this.getComponent(m.ind);
								jb.setIcon(new ImageIcon("Objet_images/"+m.cheminObjet(m.objt_select)));
							} 
								
						}
						
					} if (2*i+j+i==m.ind && m.objt_select.lib==null) {
						JButton jb = (JButton)this.getComponent(m.ind);
						jb.setIcon(null);	
					}
				}
			}
		} else {
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					if (m.crafting[i][j].lib==null) {
						JButton jb = (JButton)this.getComponent(2*i+j+i);
						jb.setIcon(null);
					}
				}
			}
		
		}
		
	}
}