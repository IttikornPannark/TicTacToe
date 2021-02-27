import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    int m = size * size;

    JButton[] buttons = new JButton[m];
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel text = new JLabel();
    boolean player1_turn;

    TicTacToe(){

        if( size < 3){
            System.out.println("Please enter number from 3 or above");
        }
        if( size >= 3){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.getContentPane().setBackground(new Color(198, 136, 25));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            text.setBackground(new Color(0, 0, 0));
            text.setForeground(new Color(164, 40, 180));
            text.setFont(new Font("Ink Free", Font.ITALIC,80));
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setText(" OX ");
            text.setOpaque(true);

            title.setLayout(new BorderLayout());
            title.setBounds(0,0,800,100);

            button.setLayout(new GridLayout(size,size));
            button.setBackground(new Color(125, 117, 117));

            for(int j = 0; j < m; j++){
                buttons[j] = new JButton();
                button.add(buttons[j]);
                buttons[j].setFont(new Font("MV Boli",Font.BOLD,100));
                buttons[j].setFocusable(false);
                buttons[j].addActionListener(this);
            }
            title.add(text);
            frame.add(title,BorderLayout.NORTH);
            frame.add(button);

            firstTurn();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < m; i++){
            if(e.getSource() == buttons[i]){
                if(player1_turn) {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text.setText("O Turn");
                        check();
                    }
                } else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public  void  firstTurn() {

        try {
            for(int i = 0; i < m; i++){
                buttons[i].setEnabled(false);
            }
            Thread.sleep(1500);
            for(int i = 0; i < m; i++){
                buttons[i].setEnabled(true);
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text.setText("X turn");
        } else {
            player1_turn = false;
            text.setText("O turn");
        }
    }

    public  void  check(){
        //if x wins
        if(
                (buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")
        ){
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")
        ){
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")
        ){
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")
        ){
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")
        ){
            xWins(2,4,6);
        }
        //if o wins
        if(
                (buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")
        ){
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")
        ){
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")
        ){
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")
        ){
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")
        ){
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i < m; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i < m; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }

}
