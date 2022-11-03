package eu.rmjoia.atu.swdev.ca1.Presentation;

import eu.rmjoia.atu.swdev.ca1.manager.ShapeManager;

import javax.swing.*;
import java.awt.*;

/**
 * We can think of a JFrame as a window
 * By extending (inheriting from) the class javax.swing.JFrame we can
 * define what goes into our window - in this case a single JPanel which is
 * a component container for GUI elements.
 */
public class CustomWindow extends JFrame {

    private final CustomPanel mainPanel;

    public CustomWindow(ShapeManager shapeManager) {
        mainPanel = new CustomPanel(shapeManager);

        //add our new panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }

}
