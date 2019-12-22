package user_interaction;

import javax.swing.*;
import java.awt.*;

public class WorkerProblemsByDateComboBoxDate extends JComboBox {
    public WorkerProblemsByDateComboBoxDate(String[] dateOptions) {
        super(dateOptions);
        setPreferredSize(new Dimension(160, 30));
    }
}
