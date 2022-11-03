package eu.rmjoia.atu.swdev.ca1.manager;

import eu.rmjoia.atu.swdev.ca1.Interfaces.Moveable;
import eu.rmjoia.atu.swdev.ca1.Interfaces.Rotatable;
import eu.rmjoia.atu.swdev.ca1.Presentation.CustomWindow;
import eu.rmjoia.atu.swdev.ca1.drawing.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeManager {

    /**
     * field shapes used to store all the shapes to be drawn
     */
    private final ArrayList<Shape> shapes;
    /**
     * field drawBoundingBox used to store if we will draw bounding box with the shape when drawing
     */
    boolean drawBoundingBox;
    /**
     * field displayName used to store if we will draw the Class Name with the shape when drawing
     */
    private boolean displayName;

    /**
     * Constructor
     * Initializes the Array list so that we can add shapes when a new instance is created
     */
    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    /**
     * AddShape - Modifier method which will allow consumers of the ShapeManager class to add shapes to the Shapes Array List to be drawn
     *
     * @param shape adds a shape to the shapes list
     */
    public void AddShape(Shape shape) {
        shapes.add(shape);
    }

    public void CreateWindow() {
        CustomWindow customWindow = new CustomWindow(this);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }

    /**
     * DrawShapes - This method will be used to loop through the existing shapes in the Array List and draw each one of them
     *
     * @param g Graphic object used to draw shapes
     */
    public void DrawShapes(Graphics g) {
        for (var currentShape : shapes) {
            currentShape.DrawShape(g);

            if (drawBoundingBox) {
                currentShape.DrawBoundingBox(g);
            }

            if (displayName) {
                currentShape.DisplayName(g);
            }
        }
    }

    /**
     * SetDisplayName directs the shape to display or not the name of the class in the UI
     *
     * @param displayName boolean value used to toggle if the shape is to display its name in the UI or not
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    /**
     * setDrawBoundingBox directs the shape to display or not the name of the class in the UI
     *
     * @param drawBoundingBox boolean value used to toggle if the shape is to display its Bounding Box in the UI or not
     */
    public void setDrawBoundingBox(boolean drawBoundingBox) {
        this.drawBoundingBox = drawBoundingBox;
    }

    /**
     * IsShapeClicked is used to understand if the user click was over any of the shapes displayed on the screen
     * and if there is any intention by action of inspection which button was clicked
     *
     * @param locationOnScreen Point x & y coordinates of the mouse click by the user
     * @param button int which button was pressed 1 for left button, 3 for right button
     */
    public boolean IsShapeClicked(Point locationOnScreen, int button) {

        for (var currentShape : shapes) {
            if (currentShape.OnIt(locationOnScreen)) {
                switch (button) {
                    case 1:
                        currentShape.ToggleFill();
                        break;
                    case 3:
                        if (currentShape instanceof Rotatable) {
                            ((Rotatable) currentShape).Rotate();
                        } else if (currentShape instanceof Moveable) {
                            ((Moveable) currentShape).Move();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        return false;
    }
}
