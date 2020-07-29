import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpForm {
    private JFrame HelpForm;
    private JPanel HelpPanel;
    private JButton backToHomeScreenButton;
    private JTextArea helpTextArea;

    public JPanel getHelpPanel() {
        return HelpPanel;
    }

    public void setHelpPanel(JPanel helpPanel) {
        HelpPanel = helpPanel;
    }

    public JButton getBackToHomeScreenButton() {
        return backToHomeScreenButton;
    }

    public void setBackToHomeScreenButton(JButton backToHomeScreenButton) {
        this.backToHomeScreenButton = backToHomeScreenButton;
    }

    public String helptext = "TABLE TENNIS TOURNAMENT SIMULATOR README\n" +
            "\n" +
            "This application will allow you to simulate a table tennis tournament. Each round of the tournament, pairs of players will play a simulated match. Winners will progress to the next round, whilst losers are eliminated from the tournament. \n" +
            "\n" +
            "Within each simulated match are a number of simulated games, these games further simulate matches won to win the games. Within matches, points are also simulated.\n" +
            "\n" +
            "There are several elements of the tournament that you can customise.\n" +
            "\n" +
            " - Number of Players - the number of players can be selected using the top dropdown box. You can select from 2, 4, 8, 16, 32, 64 or 128 players.\n" +
            "\n" +
            " - Number of games required to win a match - the number of games required to win a match can be selected using the top dropdown box. You can select from Best of 3, 5, 7, or 9 games. \n" +
            "\n" +
            "- Player Names - player names can be customised by changing the values within the quotation marks / inverted commas of the players.json file found in the root of the project folder. Please take care to ensure that the format of the file is not altered. If in doubt, please replace the file with the players.json file found in the \"Backups\" folder in the root of the project folder by first deleting the file from the root of the project folder, then copying and pasting the new file into the root of the project folder. \n" +
            "\n" +
            "Once you have selected your requirements, you can click the \"Start Simulator\" button. This will run the tournament.\n" +
            "\n" +
            "The output of the simulation will be displayed on screen, as well as saved to a text file, the name of which will be the date and time of the simulation being run. The text files can be found within the \"Tournament Outputs\" folder found within the project root folder.\n" +
            "\n" +
            "You can modify the options between tournaments, and click the \"Start Simulator\" button to get a new set of results.\n" +
            "\n" +
            "Please click the below button to return to the main menu. ";


    public HelpForm(JFrame helpForm) {
        HelpForm = helpForm;

        helpTextArea.append(helptext);


        backToHomeScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpForm.dispose();
                HelpForm.setVisible(false);
            }
        });
    }
}