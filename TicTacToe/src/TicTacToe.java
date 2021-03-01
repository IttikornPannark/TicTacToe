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

    TicTacToe() {

        if (size < 3) {
            System.out.println("Please enter number from 3 or above");
        }
        if (size >= 3) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.getContentPane().setBackground(new Color(198, 136, 25));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            text.setBackground(new Color(0, 0, 0));
            text.setForeground(new Color(164, 40, 180));
            text.setFont(new Font("Ink Free", Font.ITALIC, 50));
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setText(" OX ");
            text.setOpaque(true);

            title.setLayout(new BorderLayout());
            title.setBounds(0, 0, 800, 100);

            button.setLayout(new GridLayout(size, size));
            button.setBackground(new Color(125, 117, 117));

            for (int j = 0; j < m; j++) {
                buttons[j] = new JButton();
                button.add(buttons[j]);
                buttons[j].setFont(new Font("MV Boli", Font.BOLD, 50));
                buttons[j].setFocusable(false);
                buttons[j].addActionListener(this);
            }
            title.add(text);
            frame.add(title, BorderLayout.NORTH);
            frame.add(button);

            firstTurn();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < m; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text.setText("O Turn");
                        if (size == 3) {
                            check3();
                        }
                        if (size == 4) {
                            check4();
                        }
                        if (size == 5) {
                            check5();
                        }
                        if (size == 6) {
                            check6();
                        }
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text.setText("X Turn");
                        if (size == 3) {
                            check3();
                        }
                        if (size == 4) {
                            check4();
                        }
                        if (size == 5) {
                            check5();
                        }
                        if (size == 6) {
                            check6();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            for (int i = 0; i < m; i++) {
                buttons[i].setEnabled(false);
            }
            Thread.sleep(1500);
            for (int i = 0; i < m; i++) {
                buttons[i].setEnabled(true);
            }

        } catch (InterruptedException e) {
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

    public void check3() {
        //if x wins
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }


        //if o wins
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }

    public void check4() {
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X") &&
                        (buttons[3].getText() == "X")
        ) {
            xWins4(0, 1, 2, 3);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins4(4, 5, 6, 7);
        }
        if (
                (buttons[8].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[11].getText() == "X")
        ) {
            xWins4(8, 9, 10, 11);
        }
        if (
                (buttons[12].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            xWins4(12, 13, 14, 15);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[12].getText() == "X")
        ) {
            xWins4(0, 4, 8, 12);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[13].getText() == "X")
        ) {
            xWins4(1, 5, 9, 13);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[14].getText() == "X")
        ) {
            xWins4(2, 6, 10, 14);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            xWins4(3, 7, 11, 15);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            xWins4(0, 5, 10, 15);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[12].getText() == "X")
        ) {
            xWins4(3, 6, 9, 12);
        }


        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X") &&
                        (buttons[3].getText() == "X")
        ) {
            oWins4(0, 1, 2, 3);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            oWins4(4, 5, 6, 7);
        }
        if (
                (buttons[8].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[11].getText() == "X")
        ) {
            oWins4(8, 9, 10, 11);
        }
        if (
                (buttons[12].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            oWins4(12, 13, 14, 15);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[12].getText() == "X")
        ) {
            oWins4(0, 4, 8, 12);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[13].getText() == "X")
        ) {
            oWins4(1, 5, 9, 13);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[14].getText() == "X")
        ) {
            oWins4(2, 6, 10, 14);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            oWins4(3, 7, 11, 15);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[15].getText() == "X")
        ) {
            oWins4(0, 5, 10, 15);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[12].getText() == "X")
        ) {
            oWins4(3, 6, 9, 12);
        }
    }

    public void check5() {
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X")
        ) {
            xWins5(0, 1, 2, 3, 4);
        }
        if (
                (buttons[5].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[9].getText() == "X")
        ) {
            xWins5(5, 6, 7, 8, 9);
        }
        if (
                (buttons[10].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[14].getText() == "X")
        ) {
            xWins5(10, 11, 12, 13, 14);
        }
        if (
                (buttons[15].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[17].getText() == "X") &&
                        (buttons[18].getText() == "X") &&
                        (buttons[19].getText() == "X")
        ) {
            xWins5(15, 16, 17, 18, 19);
        }
        if (
                (buttons[20].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[22].getText() == "X") &&
                        (buttons[23].getText() == "X") &&
                        (buttons[24].getText() == "X")
        ) {
            xWins5(20, 21, 22, 23, 24);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[20].getText() == "X")
        ) {
            xWins5(0, 5, 10, 15, 20);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[21].getText() == "X")
        ) {
            xWins5(1, 6, 11, 16, 21);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[17].getText() == "X") &&
                        (buttons[22].getText() == "X")
        ) {
            xWins5(2, 7, 12, 17, 22);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[18].getText() == "X") &&
                        (buttons[23].getText() == "X")
        ) {
            xWins5(3, 8, 13, 18, 23);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[19].getText() == "X") &&
                        (buttons[24].getText() == "X")
        ) {
            xWins5(5, 6, 7, 8, 9);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[18].getText() == "X") &&
                        (buttons[24].getText() == "X")
        ) {
            xWins5(0, 6, 12, 18, 19);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[20].getText() == "X")
        ) {
            xWins5(4, 8, 12, 16, 20);
        }

        // 5*5 o wins
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O")
        ) {
            oWins5(0, 1, 2, 3, 4);
        }
        if (
                (buttons[5].getText() == "O") &&
                        (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O") &&
                        (buttons[9].getText() == "O")
        ) {
            oWins5(5, 6, 7, 8, 9);
        }
        if (
                (buttons[10].getText() == "O") &&
                        (buttons[11].getText() == "O") &&
                        (buttons[12].getText() == "O") &&
                        (buttons[13].getText() == "O") &&
                        (buttons[14].getText() == "O")
        ) {
            oWins5(10, 11, 12, 13, 14);
        }
        if (
                (buttons[15].getText() == "O") &&
                        (buttons[16].getText() == "O") &&
                        (buttons[17].getText() == "O") &&
                        (buttons[18].getText() == "O") &&
                        (buttons[19].getText() == "O")
        ) {
            oWins5(15, 16, 17, 18, 19);
        }
        if (
                (buttons[20].getText() == "O") &&
                        (buttons[21].getText() == "O") &&
                        (buttons[22].getText() == "O") &&
                        (buttons[23].getText() == "O") &&
                        (buttons[24].getText() == "O")
        ) {
            oWins5(20, 21, 22, 23, 24);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[10].getText() == "O") &&
                        (buttons[15].getText() == "O") &&
                        (buttons[20].getText() == "O")
        ) {
            oWins5(0, 5, 10, 15, 20);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[6].getText() == "O") &&
                        (buttons[11].getText() == "O") &&
                        (buttons[16].getText() == "O") &&
                        (buttons[21].getText() == "O")
        ) {
            oWins5(1, 6, 11, 16, 21);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[12].getText() == "O") &&
                        (buttons[17].getText() == "O") &&
                        (buttons[22].getText() == "O")
        ) {
            oWins5(2, 7, 12, 17, 22);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[8].getText() == "O") &&
                        (buttons[13].getText() == "O") &&
                        (buttons[18].getText() == "O") &&
                        (buttons[23].getText() == "O")
        ) {
            oWins5(3, 8, 13, 18, 23);
        }
        if (
                (buttons[4].getText() == "O") &&
                        (buttons[9].getText() == "O") &&
                        (buttons[14].getText() == "O") &&
                        (buttons[19].getText() == "O") &&
                        (buttons[24].getText() == "O")
        ) {
            oWins5(5, 6, 7, 8, 9);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[6].getText() == "O") &&
                        (buttons[12].getText() == "O") &&
                        (buttons[18].getText() == "O") &&
                        (buttons[24].getText() == "O")
        ) {
            oWins5(0, 6, 12, 18, 19);
        }
        if (
                (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O") &&
                        (buttons[12].getText() == "O") &&
                        (buttons[16].getText() == "O") &&
                        (buttons[20].getText() == "O")
        ) {
            oWins5(4, 8, 12, 16, 20);
        }

    }

    public void check6() {
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins6(0, 1, 2, 3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[11].getText() == "X")
        ) {
            xWins6(6, 7, 8, 9, 10, 11);
        }
        if (
                (buttons[12].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[17].getText() == "X")
        ) {
            xWins6(12, 13, 14, 15, 16, 17);
        }
        if (
                (buttons[18].getText() == "X") &&
                        (buttons[19].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[22].getText() == "X") &&
                        (buttons[23].getText() == "X")
        ) {
            xWins6(18, 19, 20, 21, 22, 23);
        }
        if (
                (buttons[24].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[26].getText() == "X") &&
                        (buttons[27].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[29].getText() == "X")
        ) {
            xWins6(24, 25, 26, 27, 28, 29);
        }
        if (
                (buttons[30].getText() == "X") &&
                        (buttons[31].getText() == "X") &&
                        (buttons[32].getText() == "X") &&
                        (buttons[33].getText() == "X") &&
                        (buttons[34].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            xWins6(30, 31, 32, 33, 34, 35);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[18].getText() == "X") &&
                        (buttons[24].getText() == "X") &&
                        (buttons[30].getText() == "X")
        ) {
            xWins6(0, 6, 12, 18, 24, 30);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[19].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[31].getText() == "X")
        ) {
            xWins6(1, 7, 13, 19, 25, 31);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[26].getText() == "X") &&
                        (buttons[32].getText() == "X")
        ) {
            xWins6(2, 8, 14, 20, 26, 32);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[27].getText() == "X") &&
                        (buttons[33].getText() == "X")
        ) {
            xWins6(3, 9, 15, 21, 27, 33);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[22].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[34].getText() == "X")
        ) {
            xWins6(4, 10, 16, 22, 28, 34);
        }
        if (
                (buttons[5].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[17].getText() == "X") &&
                        (buttons[23].getText() == "X") &&
                        (buttons[29].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            xWins6(5, 11, 17, 23, 29, 35);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            xWins6(0, 7, 14, 21, 28, 35);
        }
        if (
                (buttons[5].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[30].getText() == "X")
        ) {
            xWins6(5, 10, 15, 20, 25, 30);
        }


        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            oWins6(0, 1, 2, 3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[11].getText() == "X")
        ) {
            oWins6(6, 7, 8, 9, 10, 11);
        }
        if (
                (buttons[12].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[17].getText() == "X")
        ) {
            oWins6(12, 13, 14, 15, 16, 17);
        }
        if (
                (buttons[18].getText() == "X") &&
                        (buttons[19].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[22].getText() == "X") &&
                        (buttons[23].getText() == "X")
        ) {
            oWins6(18, 19, 20, 21, 22, 23);
        }
        if (
                (buttons[24].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[26].getText() == "X") &&
                        (buttons[27].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[29].getText() == "X")
        ) {
            oWins6(24, 25, 26, 27, 28, 29);
        }
        if (
                (buttons[30].getText() == "X") &&
                        (buttons[31].getText() == "X") &&
                        (buttons[32].getText() == "X") &&
                        (buttons[33].getText() == "X") &&
                        (buttons[34].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            oWins6(30, 31, 32, 33, 34, 35);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[6].getText() == "X") &&
                        (buttons[12].getText() == "X") &&
                        (buttons[18].getText() == "X") &&
                        (buttons[24].getText() == "X") &&
                        (buttons[30].getText() == "X")
        ) {
            oWins6(0, 6, 12, 18, 24, 30);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[13].getText() == "X") &&
                        (buttons[19].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[31].getText() == "X")
        ) {
            oWins6(1, 7, 13, 19, 25, 31);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[8].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[26].getText() == "X") &&
                        (buttons[32].getText() == "X")
        ) {
            oWins6(2, 8, 14, 20, 26, 32);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[9].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[27].getText() == "X") &&
                        (buttons[33].getText() == "X")
        ) {
            oWins6(3, 9, 15, 21, 27, 33);
        }
        if (
                (buttons[4].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[16].getText() == "X") &&
                        (buttons[22].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[34].getText() == "X")
        ) {
            oWins6(4, 10, 16, 22, 28, 34);
        }
        if (
                (buttons[5].getText() == "X") &&
                        (buttons[11].getText() == "X") &&
                        (buttons[17].getText() == "X") &&
                        (buttons[23].getText() == "X") &&
                        (buttons[29].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            oWins6(5, 11, 17, 23, 29, 35);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[14].getText() == "X") &&
                        (buttons[21].getText() == "X") &&
                        (buttons[28].getText() == "X") &&
                        (buttons[35].getText() == "X")
        ) {
            oWins6(0, 7, 14, 21, 28, 35);
        }
        if (
                (buttons[5].getText() == "X") &&
                        (buttons[10].getText() == "X") &&
                        (buttons[15].getText() == "X") &&
                        (buttons[20].getText() == "X") &&
                        (buttons[25].getText() == "X") &&
                        (buttons[30].getText() == "X")
        ) {
            oWins6(5, 10, 15, 20, 25, 30);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void xWins4(int a, int b, int c, int d) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void xWins5(int a, int b, int c, int d, int e) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void xWins6(int a, int b, int c, int d, int e, int f) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);
        buttons[f].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }

    public void oWins4(int a, int b, int c, int d) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }

    public void oWins5(int a, int b, int c, int d, int e) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }

    public void oWins6(int a, int b, int c, int d, int e, int f) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);
        buttons[f].setBackground(Color.GREEN);
        for (int i = 0; i < m; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }

}
