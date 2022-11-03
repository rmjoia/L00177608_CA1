package eu.rmjoia.atu.swdev.ca1.drawing;

import java.awt.Point;
import java.awt.*;

/**
 * Shape Class
 * Shape is the super class for all the specialization classes, such as Rectangle, Circle and Quadrilateral
 */
public abstract class Shape {

    protected BoundingBox boundingBox;
    /**
     * field color used to store the color of the shape
     */
    Color color;
    /**
     * field filled used to store if the shape is to be filled with color or not
     */
    boolean filled;
    /**
     * fields xCenter and yCenter used to store the x and y positions to take into consideration on positioning the shapes
     */
    int xCenter, yCenter;

    /**
     * Shape
     * Constructor
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     */
    public Shape(Color color, int xCenter, int yCenter) {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * Shape
     * Overloaded constructor with extra parameter filled
     *
     * @param color   Color used to draw the Circle, will use the same color for the stroke (border) and fill
     * @param xCenter X Position to take into consideration on where the shape is to be drawn
     * @param yCenter Y Position to take into consideration on where the shape is to be drawn
     * @param filled  true if the circle should be initially filled or not, false by default
     */
    public Shape(Color color, int xCenter, int yCenter, boolean filled) {
        this(color, xCenter, yCenter);
        this.filled = filled;
    }

    /**
     * DrawShape abstract Method which will be implemented by each derived shape
     * to draw themselves, each shape encapsulates the knowledge to draw themselves and the logic to do so
     *
     * @param g Graphic class used to draw
     */
    public abstract void DrawShape(Graphics g);

    /**
     * DisplayName abstract Method which will be implemented by each derived shape
     * to draw their Name, each shape encapsulates the knowledge to draw their own name
     *
     * @param g Graphic class used to draw
     */
    public abstract void DisplayName(Graphics g);

    /**
     * DrawBoundingBox will handle the base logic the bounding box for each shape with dotted lines
     * each shape will implement the specifics or can override it entirely.
     *
     * @param g graphic context object
     */
    public void DrawBoundingBox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.lightGray);

        float[] dash1 = {1f, 0f, 1f};

        BasicStroke bs1 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash1,
                1f);

        g2d.setStroke(bs1);
    }

    /**
     * Toggles the attribute filled on the shape which will make the shape to be filled or not on repaint
     */
    public abstract void ToggleFill();

    /**
     * @param locationOnScreen x & y coordinates for the mouse click
     * @return boolean true if the user clicked within the boundaries of the shape, false if not
     */
    public boolean OnIt(Point locationOnScreen) {

        return locationOnScreen.x >= boundingBox.getBottomLeft().x &&
                locationOnScreen.x <= boundingBox.getTopRight().x &&
                locationOnScreen.y >= boundingBox.getBottomLeft().y &&
                locationOnScreen.y <= boundingBox.getTopRight().y;
    }

    /**
     * toString
     * representation of the state of the object on a given point
     * @return string printout of the state of the object
     */
    @Override
    public String toString() {
        return "Shape {" +
                super.toString() +
                "boundingBox=" + boundingBox +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }
}
