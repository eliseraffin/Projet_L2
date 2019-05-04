import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class Button_Tri extends JButton {
	String text;Color col;
    public Button_Tri(String s, Color c) {
        super(s);
        text = s;
        col = c;
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusable(false);
        setRolloverEnabled(false);
        
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        RoundRectangle2D.Double rec = new RoundRectangle2D.Double(0, 1, (getWidth()),(getHeight()), 42, 42);
        if (getModel().isPressed()) {
            g2.setColor(Color.LIGHT_GRAY);
            g2.fill(rec);
            g2.setStroke(new BasicStroke(30));
            g2.drawLine(0, getHeight(), getWidth(), getHeight());
            super.paintComponent(g);
            g2.dispose();
        }
        g2.setColor(col);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.2f));
        
        g2.fill(rec);
        g2.setStroke(new BasicStroke(30));
        g2.drawLine(0, getHeight(), getWidth(), getHeight());
        super.paintComponent(g);
        g2.dispose();
        
    }
    /**public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        Button_Tri xrButton = new Button_Tri("XrButton");
        frame.getContentPane().add(xrButton);
        frame.setSize(136, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }**/

}
