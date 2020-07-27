import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.File;


public class SwingTest {
    private JButton playTournamentButton;
    private JPanel PanelMain;
    private JButton exitButton;
    private JComboBox comboBoxNumberOfPlayers;
    private JTextArea outputBox;
    private JComboBox comboBoxGamesInMatch;

    public JComboBox getComboBoxNumberOfPlayers() {
        return comboBoxNumberOfPlayers;
    }

    public void setComboBoxNumberOfPlayers(JComboBox comboBoxNumberOfPlayers) {
        this.comboBoxNumberOfPlayers = comboBoxNumberOfPlayers;
    }

    public JComboBox getComboBoxGamesInMatch() {
        return comboBoxGamesInMatch;
    }

    public void setComboBoxGamesInMatch(JComboBox comboBoxGamesInMatch) {
        this.comboBoxGamesInMatch = comboBoxGamesInMatch;
    }

    public JTextArea getOutputBox() {
        return outputBox;
    }

    public void setOutputBox(JTextArea outputBox) {
        outputBox = outputBox;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new SwingTest().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public SwingTest() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        playTournamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String stringNumberofPlayers = getComboBoxNumberOfPlayers().getSelectedItem().toString();

                int numberofPlayers = Integer.parseInt(stringNumberofPlayers);

                String stringGamesInMatch = getComboBoxGamesInMatch().getSelectedItem().toString();

                int gamesToWinMatch;

                switch (stringGamesInMatch){

                    case "Best of 3 (first to 2)":
                        gamesToWinMatch = 2;
                        break;

                    case "Best of 5 (first to 3)":
                        gamesToWinMatch = 3;
                        break;

                    case "Best of 7 (first to 4)":
                        gamesToWinMatch = 4;
                        break;

                    case "Best of 9 (first to 5)":
                        gamesToWinMatch = 5;
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + stringGamesInMatch);
                }

                Tournament currentTournament = new Tournament();

                currentTournament.getNumberOfPlayersTournament();
                currentTournament.setNumberOfPlayersTournament(numberofPlayers);
                currentTournament.setGamesToWinMatch(gamesToWinMatch);

                currentTournament.runTournament();
/*
                Match currentMatch = new Match();

                currentMatch.setMinWinPoints(gamesToWinMatch);

                currentMatch.runMatch();*/




            }
        });


            }


}