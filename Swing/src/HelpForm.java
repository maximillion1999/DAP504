import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpForm {
    private JFrame HelpForm;
    private JTextArea helpTextArea;
    private JPanel HelpPanel;
    private JButton backToHomeScreenButton;


    public HelpForm(JFrame helpForm) {
        HelpForm = helpForm;
        backToHomeScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeJFrame(helpForm);
            }
        });
    }

    private void disposeJFrame(JFrame HelpForm){
        HelpForm.setVisible(false);
        HelpForm.dispose();
    }

    public JTextArea getHelpTextArea() {
        return helpTextArea;
    }

    public void setHelpTextArea(JTextArea helpTextArea) {
        this.helpTextArea = helpTextArea;
    }

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
}
