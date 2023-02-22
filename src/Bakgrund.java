import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bakgrund extends JPanel implements MouseListener {
    //Attributes
    final int SIZE = 400; //Will be used as size of our window. Big letters because it wont be changed.
    private Boolean firstcolor = false; //Will be used to change the color of the background.
    private int number = 0; //Will be used to count how many times clicked.
    private Boolean LR = false; //Will be used to know whether left or right has been clicked.

    //Constructors
    public Bakgrund() {
        this.setBackground(Color.BLACK); //Sets the color of the background
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
        if (LR) { //Will draw an "X"
            g.drawLine((int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.9),(int)(SIZE*0.9));
            g.drawLine((int)(SIZE*0.9),(int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.9));
        } else { //Will draw an "O"
            g.drawOval((int)(SIZE*0.1),(int)(SIZE*0.1),(int)(SIZE*0.8),(int)(SIZE*0.8));
        }
        g.setFont(new Font("SansSerif", Font.PLAIN, 50)); //How the text will look
        g.drawString(String.valueOf(number),SIZE/2-25,SIZE/2); //What text will be printed and where
        repaint(); //Makes it so that it will update :)
    }

    /*
    *   What will happen when the mouse is clicked
    */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { //If the left button is pressed
            System.out.println("LEFT");
            LR = false; //Sets LR to false
        }
        if (e.getButton() == MouseEvent.BUTTON3) { //If the right button is pressed
            System.out.println("RIGHT");
            LR = true; //Sets LR to true
        }
        System.out.println("Mouse clicked! ");
        number += 1; //Adds 1 to number every time the mouse is clicked.
        if (!firstcolor) {
            this.setBackground(Color.cyan);
        } else {
            this.setBackground(Color.YELLOW);
        }
        firstcolor = !firstcolor; //Changes firstcolor to what it isnt. True->false. False->true
        repaint(); //Updates
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
