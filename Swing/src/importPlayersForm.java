import javax.swing.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.*;

public class importPlayersForm {
    private JButton button1;
    private JButton importFileButton;
    private JTable importTable;
    private JLabel importLabel;

    public JTable getImportTable() {
        return importTable;
    }

    public void setImportTable(JTable importTable) {
        this.importTable = importTable;
    }

}
