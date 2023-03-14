import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bakgrund extends JPanel implements MouseListener {
    //Attributes
    final int SIZE = 200; //Will be used as size of our window. Big letters because it won't be changed (final).
    private Boolean firstcolor = false; //Will be used to change the color of the background.
    private int number = 0; //Will be used to count how many times clicked.
    private Boolean LR = false; //Will be used to know whether left or right has been clicked.
    private int LR2 = 0;

    Window myWindow;
    boolean xo;

    //Constructors
    public Bakgrund(Window window) {
        myWindow = window;
        this.xo = window.isXo();
        this.setBackground(Color.BLACK); //Sets the color of the background
        this.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        this.setPreferredSize(new Dimension(SIZE,SIZE)); //Sets preferred size of window
        this.addMouseListener(this); //Adds a mouse listener. The mouse listener will react if something happens to the mouse. (AKA, if anything is clicked)
    }

    //Methods

    /*
    *   The paint component method deals with changing how the window looks.
    */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //Makes g our "paintbrush". AKA what we will use to refer to.
        g.setColor(Color.BLACK); //Sets the color of our "paintbrush" to black
        if (LR2 == 1) { //Will draw an "X"
            g.drawLine((int) (SIZE * 0.1), (int) (SIZE * 0.1), (int) (SIZE * 0.9), (int) (SIZE * 0.9));
            g.drawLine((int) (SIZE * 0.9), (int) (SIZE * 0.1), (int) (SIZE * 0.1), (int) (SIZE * 0.9));
        } else if (LR2 == 2){ //Will draw an "O"
            g.drawOval((int) (SIZE * 0.1), (int) (SIZE * 0.1), (int) (SIZE * 0.8), (int) (SIZE * 0.8));
        }
        g.setFont(new Font("SansSerif", Font.PLAIN, 50)); //How the text will look
        repaint(); //Makes it so that it will update :)
        if (myWindow.last == this) {
            this.setBackground(Color.MAGENTA);
        } else {
            this.setBackground(Color.white);
        }
    }

    /*
    *   What will happen when the mouse is clicked
    */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (xo) {
            if (myWindow.isLeftRight()) {
                LR2 = 1;
            } else {
                LR2 = 2;
            }
            System.out.println("Mouse clicked! ");
            myWindow.setBlue();
            repaint(); //Updates
            xo = !xo;
        }
        for (int i = 0; i < myWindow.getPosition().size(); i++) { //THIS IS JONIS WORK.

        }
        if (myWindow.last != null) {
            myWindow.last.repaint();
        }
        myWindow.last = this;
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

    //Getters/Setters

}
