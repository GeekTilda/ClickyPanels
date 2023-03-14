import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Window extends JFrame { //JFrame is the frame of the console. It is in a JFrame everything will happen
    //Attributes
    private int blue = 1;
    private boolean xo = true;
    private boolean LeftRight = false;

    public Bakgrund last;
    private HashMap<Integer, Bakgrund> position;

    //Concrtuctors
    public Window(){

        //Window design and function
        this.setTitle("Three in a row! :D");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The program will close when the window is closed.

        int row = 3;
        int col = 3;
        position = new HashMap<>();

        //Create a layout
        JPanel multipanel = new JPanel();
        GridLayout layout = new GridLayout(row,col);
        multipanel.setLayout(layout);
        multipanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));

        //Window content
        //this.add(new Bakgrund());
        Bakgrund b;
        for (int i = 0; i < row*col; i++) {
            multipanel.add(b = new Bakgrund(this)); //There needs to be added same amount of new backgrounds as there are rows*columns.
            position.put((i+1), b);
        }

        //Add the multipanel to the frame
        this.getContentPane().add(multipanel);

        //Window visible
        this.pack(); //Packages the window.
        this.setVisible(true); //Makes the window visible
    }

    //Methods

    public int isBlue() {
        return blue;
    }

    public void setBlue() {
        if (this.blue == 1) {
            this.blue = 2;
        } else if (this.blue == 2) {
            this.blue = 1;
        } else {
            this.blue = 1;
        }
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

    public HashMap<Integer,Bakgrund> getPosition() {
        return position;
    }
}
