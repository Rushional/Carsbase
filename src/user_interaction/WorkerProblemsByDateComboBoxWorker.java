package user_interaction;

import javax.swing.*;
import java.awt.*;

public class WorkerProblemsByDateComboBoxWorker extends JComboBox {
    public WorkerProblemsByDateComboBoxWorker(String[] workerIds) {
        super(workerIds);
        setPreferredSize(new Dimension(160, 30));
    }
}