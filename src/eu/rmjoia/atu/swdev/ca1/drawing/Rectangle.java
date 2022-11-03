package eu.rmjoia.atu.swdev.ca1.drawing;

import eu.rmjoia.atu.swdev.ca1.Interfaces.Moveable;

import java.awt.*;

/**
 * Rectangle Class
 * Rectangle extends the Shape abstract class and encapsulates the logic to draw a rectangle
 * It's also the super class for Square since it's a specialized type of rectangle
 */
public class Rectangle extends Shape implements Moveable {

    /**
     * field height to store the Rectangle Height
     */
    int height;
    /**
     * field width to store the Rectangle Width
     */
    int width;

    /**
     * Rectangle
     * Constructor Creates an instance of the shape Rectangle
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param filled  true if the circle should be initially filled or not, false by default
     * @param width   the width of the Rectangle
     * @param height  the height of the Rectangle
     */
    public Rectangle(Color color, int xCenter, int yCenter, boolean filled, int width, int height) {
        super(color, xCenter, yCenter, filled);
        this.height = height;
        this.width = width;
    }

    /**
     * Rectangle
     * Overloaded constructor of the rectangle
     * Doesn't take the filled parameter so using this constructor, the shape is always initialized without filling.
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param width   the width of the Rectangle
     * @param height  the height of the Rectangle
     */
    public Rectangle(Color color, int xCenter, int yCenter, int width, int height) {
        this(color, xCenter, yCenter, false, width, height);
    }

    /**
     * DrawShape
     * Handles the logic to draw the Rectangle in the UI as well as setting the color, toggling the filling and setting the bounding box
     *
     * @param g Graphic class used to draw
     */
    @Override
    public void DrawShape(Graphics g) {

        g.setColor(color);

        if (filled) {
            g.fillRect(xCenter, yCenter, width, height);
        }

        g.drawRect(xCenter, yCenter, width, height);

        setBoundingBox();
    }

    /**
     * setBoundingBox
     * Sets the shape boundingBox
     */
    private void setBoundingBox() {
        var bottomLeft = new Point(xCenter, yCenter);
        var topRight = new Point(xCenter + width, yCenter + height);

        boundingBox = new BoundingBox(bottomLeft, topRight);
    }

    /**
     * DisplayName Draws on screen the name of the Shape Class Name
     *
     * @param g Graphics object used to draw the shape on screen, in this case the class name
     */
    @Override
    public void DisplayName(Graphics g) {
        g.setColor(Color.black);
        g.drawString(this.getClass().getSimpleName(), xCenter + width / 2, yCenter + height / 2);
    }

    /**
     * DrawBoundingBox Draws the Bounding box for the Rectangle Shape
     *
     * @param g graphic context object
     */
    @Override
    public void DrawBoundingBox(Graphics g) {
        super.DrawBoundingBox(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawRect(xCenter, yCenter, width, height);
    }

    /**
     * ToggleFill
     * Toggles the filled field, reverses the previous state
     */
    @Override
    public void ToggleFill() {
        filled = !filled;
    }

    /**
     * Move
     * Moves the shape by x pixels
     */
    @Override
    public void Move() {
        this.xCenter += 10;
    }

    /**
     * toString
     * representation of the state of the object on a given point
     * @return string printout of the state of the object
     */
    @Override
    public String toString() {
        return "Rectangle shape {" +
                super.toString() +
                "height=" + height +
                ", width=" + width +
                ", boundingBox=" + boundingBox +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }
}
