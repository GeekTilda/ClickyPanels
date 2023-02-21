import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bakgrund extends JPanel implements MouseListener {
    //Attributes
    final int SIZE = 400;
    private Boolean firstcolor = false;
    private int number = 0;

    //Constructors
    public Bakgrund() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(SIZE,SIZE));
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if (firstcolor) {
            g.drawLine((int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.9),(int)(SIZE*0.9));
            g.drawLine((int)(SIZE*0.9),(int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.9));
        } else {
            g.drawOval((int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.8),(int)(SIZE*0.8));
        }
        g.setFont(new Font("SansSerif", Font.PLAIN, 50));
        g.drawString(String.valueOf(number),SIZE/2-25,SIZE/2);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked! ");
        number += 1;
        if (!firstcolor) {
            this.setBackground(Color.CYAN);
        } else {
            this.setBackground(Color.YELLOW);
        }
        firstcolor = !firstcolor;
        repaint();
    }

    /*
    * All of these had to be implemented for Mouselistener to work.
    */

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    //Methods

    //Getters/Setters

}
