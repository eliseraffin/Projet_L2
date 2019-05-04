import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class AWT_Recette extends JPanel implements Observer {
	
	Modele m;
	String nom_recette = "0r";
	
	public AWT_Recette(Modele m, ActionListener al) {
		this.m = m;
		GridLayout gridlayout_recette = new GridLayout(1,1);
		gridlayout_recette.setColumns(1);
		gridlayout_recette.setRows(1);
		this.setLayout(gridlayout_recette);
		//this.setBounds(new Rectangle(545,120,100,100));
		JButton jb = new JButton();
		jb.setBackground(Color.GRAY);
		jb.setOpaque(true);
		jb.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		jb.setIcon(null);
		jb.setName(nom_recette);
		jb.addActionListener(al); 
		this.add(jb);
		this.setName("recette_finale");
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (m.r.lib != null) {
			JButton jb = (JButton)this.getComponent(0);
			jb.setIcon(new ImageIcon("Recette_images/"+m.cheminRecette(m.r)));
			
		} if (m.r.lib==null) {
			JButton jb = (JButton)this.getComponent(0);
			jb.setIcon(null);
		}
		
		
		
	}
}