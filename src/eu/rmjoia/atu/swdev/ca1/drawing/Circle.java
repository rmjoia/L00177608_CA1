package eu.rmjoia.atu.swdev.ca1.drawing;

import java.awt.*;

public class Circle extends Shape {

    /**
     * field radius used to store the circle radius internally in the class
     */
    private final int radius;

    /**
     * field diameter used to store the circle diameter used internally in the class for calculations
     */
    private final int diameter;

    /**
     * Circle
     * Constructor Creates an instance of the shape Circle
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param filled  true if the circle should be initially filled or not, false by default
     * @param radius  Radius of the circle
     */
    public Circle(Color color, int xCenter, int yCenter, boolean filled, int radius) {
        super(color, xCenter, yCenter, filled);
        this.radius = radius;
        diameter = radius * 2;
    }

    /**
     * Circle
     * Overloaded constructor doesn't take the filled boolean
     * using it, filled it's always set to false
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param radius  Radius of the circle
     */
    public Circle(Color color, int xCenter, int yCenter, int radius) {
        this(color, xCenter, yCenter, false, radius);
    }

    /**
     * DrawShape
     * Handles the logic to draw the Circle in the UI as well as setting the color, toggling the filling and setting the bounding box
     *
     * @param g Graphic class used to draw
     */
    @Override
    public void DrawShape(Graphics g) {

        g.setColor(color);

        if (filled) {
            g.fillOval(xCenter, yCenter, diameter, diameter);
        }
        g.drawOval(xCenter, yCenter, diameter, diameter);

        setBoundingBox();
    }

    /**
     * setBoundingBox
     * Sets the shape boundingBox
     */
    private void setBoundingBox() {
        var bottomLeft = new Point(xCenter, yCenter);
        var topRight = new Point(xCenter + diameter, yCenter + diameter);

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
        g.drawString(this.getClass().getSimpleName(), xCenter + radius, yCenter + radius);
    }

    /**
     * DrawBoundingBox Draws the Bounding box for the Circle Shape
     *
     * @param g graphic context object
     */
    @Override
    public void DrawBoundingBox(Graphics g) {
        super.DrawBoundingBox(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(xCenter, yCenter, diameter, diameter);
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

        return "Circle Shape {" +
                super.toString() +
                "radius=" + radius +
                ", diameter=" + diameter +
                ", boundingBox=" + boundingBox +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }
}
