package graphics;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private Frame frame;

    public Frame initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame();
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        return frame;
    }
}
