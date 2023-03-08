import javax.swing.*;
import java.awt.*;

public class Window extends JFrame { //JFrame is the frame of the console. It is in a JFrame everything will happen
    //Attributes
    private boolean blue = true;
    private boolean xo = true;
    private boolean LeftRight = false;

    //Concrtuctors
    public Window(){

        //Window design and function
        this.setTitle("Color Clicker! :D");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The program will close when the window is closed.

        int row = 3;
        int col = 3;

        //Create a layout
        JPanel multipanel = new JPanel();
        GridLayout layout = new GridLayout(row,col);
        multipanel.setLayout(layout);
        multipanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));

        //Window content
        //this.add(new Bakgrund());
        for (int i = 0; i < row*col; i++) {
            multipanel.add(new Bakgrund(this)); //There needs to be added same amount of new backgrounds as there are rows*columns.
        }

        //Add the multipanel to the frame
        this.getContentPane().add(multipanel);

        //Window visible
        this.pack(); //Packages the window.
        this.setVisible(true); //Makes the window visible
    }

    //Methods

    public boolean isBlue() {
        return blue;
    }

    public void setBlue() {
        this.blue = !this.blue;
    }

    public boolean isXo() {
        return xo;
    }

    public void setXo(boolean xo) {
        this.xo = xo;
    }

    public boolean isLeftRight() {
        LeftRight = !LeftRight;
        System.out.println(LeftRight);
        return LeftRight;
    }

    public void setLeftRight(boolean leftRight) {
        LeftRight = leftRight;
    }
}
