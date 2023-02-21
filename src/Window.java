import javax.swing.*;

public class Window extends JFrame { //JFrame is the frame of the console. It is in a JFrame everything will happen
    //Attributes

    //Concrtuctors
    public Window(){
        //Window design and function
        this.setTitle("Color Clicker! :D");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The program will close when the window is closed.

        //Window content
        this.add(new Bakgrund());

        //Window visible
        this.pack();
        this.setVisible(true); //Makes the window visible
    }

    //Methods

    //Getters/Setters
}
