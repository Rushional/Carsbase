package user_interaction;

import javax.swing.*;
import java.awt.*;

public class ClientCostComboBox extends JComboBox {
    //TO DO change constructor so that it gets ints instead of strings and then converts them into strings
    public ClientCostComboBox(String[] clientIds) {
        super(clientIds);
        setPreferredSize(new Dimension(200, 30));
    }
}