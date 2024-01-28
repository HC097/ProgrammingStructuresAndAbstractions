import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame{

    //array to check state of game, and if game has finished.
    private static int gamestate[][] = {{0,0,0},{0,0,0},{0,0,0}};

    private static int whoeTurn = 1;

    static JPanel controls = new JPanel();
    static JPanel info = new JPanel();

    static JButton b1 = new JButton("1");
    static JButton b2 = new JButton("2");
    static JButton b3 = new JButton("3");
    static JButton b4 = new JButton("4");
    static JButton b5 = new JButton("5");
    static JButton b6 = new JButton("6");
    static JButton b7 = new JButton("7");
    static JButton b8 = new JButton("8");
    static JButton b9 = new JButton("9");

    //constructor, we set the layouts and size
    public TicTacToe(String name){
        super(name);
        controls.setLayout(new GridLayout(3, 3));
        infor.setLayout(new FlowLayout());
        b1.setPreferredSize(buttonSize);
        setResizable(false);
        this.setSize(300, 400);
    }

    public void addComponentsToPane(final Container pane){

        //adding com
        controls.add(b1);

        b1.addActionLister(new ActionLIstener(){
            public void actionPerformed(ActionEvent 3){
                turnMode(1);
            }
        });
    }

    

}