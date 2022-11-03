package eu.rmjoia.atu.swdev.ca1.Presentation;

import eu.rmjoia.atu.swdev.ca1.manager.ShapeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {
    private final ShapeManager shapeManager;

    public CustomPanel(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;

        addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e Mouse Event
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (shapeManager.IsShapeClicked(e.getPoint(), e.getButton())) {
                    CustomPanel.super.revalidate();
                    CustomPanel.super.repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.
        super.paintComponent(g);

        shapeManager.DrawShapes(g);
    }

}
