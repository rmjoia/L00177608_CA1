package eu.rmjoia.atu.swdev.ca1.drawing;

import java.awt.*;

public class Square extends Rectangle {

    /**
     * Square
     * Constructor Creates an instance of the shape Circle
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param size    Size of the circle
     */
    public Square(Color color, int xCenter, int yCenter, int size) {
        super(color, xCenter, yCenter, false, size, size);

        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = size;
        this.height = size;
    }

    /**
     * Square
     * Constructor Creates an instance of the shape Square
     * Overloaded constructor doesn't take the filled boolean
     * using it, filled it's always set to false
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param filled  true if the circle should be initially filled or not, false by default
     * @param size    Size of the circle
     */
    public Square(Color color, int xCenter, int yCenter, boolean filled, int size) {
        super(color, xCenter, yCenter, filled, size, size);

        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = size;
        this.height = size;
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
     * DrawBoundingBox Draws the Bounding box for the Square Shape
     *
     * @param g graphic context object
     */
    @Override
    public void DrawBoundingBox(Graphics g) {
        g.setColor(Color.lightGray);
        g.drawRect(xCenter, yCenter, width, height);
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
     * toString
     * representation of the state of the object on a given point
     * @return string printout of the state of the object
     */
    @Override
    public String toString() {
        return "Square shape {" +
                super.toString() +
                "height=" + height +
                ", width=" + width +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                ", boundingBox=" + boundingBox +
                '}';
    }
}
