import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FondJeu extends JFrame {

	public FondJeu() {
		this.setTitle("Minecraft");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(null);
		JPanel jp = new JPanel();
		JLabel jl = new JLabel(new ImageIcon("fond.png"));
		jp.add(jl);
		jp.setSize((int) dim.getWidth(), (int) dim.getHeight());
		this.add(jp);
		this.setVisible(true);
	}

	
}
