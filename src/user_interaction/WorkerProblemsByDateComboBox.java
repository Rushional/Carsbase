package user_interaction;

import javax.swing.*;
import java.awt.*;

public class WorkerProblemsByDateComboBox extends JComboBox {
    public WorkerProblemsByDateComboBox(String[] dateOptions) {
        super(dateOptions);
        setPreferredSize(new Dimension(200, 30));
    }
}
