package eu.rmjoia.atu.swdev.ca1.drawing;

import eu.rmjoia.atu.swdev.ca1.Interfaces.Rotatable;
import eu.rmjoia.atu.swdev.ca1.Presentation.Consts;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Quadrilateral extends Shape implements Rotatable {

    /**
     * field height used to store the height of the quadrilateral
     */
    private int height;
    /**
     * field width used to store the height of the quadrilateral
     */
    private int width;
    /**
     * field points used to store the points used to draw the quadrilateral
     */
    Point[] points;

    /**
     * Quadrilateral
     * constructor takes a Center Point, and an array of Points to create a Quadrilateral
     *
     * @param centerPoint center Point for the Quadrilateral
     * @param points      an array of points to create a quadrilateral
     */
    public Quadrilateral(Point centerPoint, Point[] points) {
        super(null, centerPoint.x, centerPoint.y);

        /*  I'm not sure if I shouldn't throw here if more than 4 points are passed to the array as this is a quadrilateral
         *   Since it wasn't mentioned, and in the class was mentioned not to handle exceptions, I'm leaving as is, just a note.
         * */

        this.points = points;
        getWidthAndHeight();
    }


    /**
     * Quadrilateral
     * Overloaded constructor takes a Center Point, and 4 other Points to create a Quadrilateral
     *
     * @param centerPoint center Point for the Quadrilateral
     * @param p1          left bottom Point
     * @param p2          top left Point
     * @param p3          top right Point
     * @param p4          bottom right Point
     */
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4) {
        this(centerPoint, new Point[]{p1, p2, p3, p4});

        getWidthAndHeight();

        this.points = new Point[]{
                new Point(xCenter / 2 + p1.x, yCenter / 2 + p1.y),
                new Point(xCenter / 2 + p2.x, yCenter / 2 + p2.y),
                new Point(xCenter / 2 + p3.x, yCenter / 2 + p3.y),
                new Point(xCenter / 2 + p4.x, yCenter / 2 + p4.y)
        };
    }

    /**
     * Quadrilateral
     * Overloaded Constructor takes a Rectangle shape as a parameter to create a Quadrilateral
     *
     * @param rectangle Rectangle shape object which will be used to construct the quadrilateral
     */
    public Quadrilateral(Rectangle rectangle) {
        super(rectangle.color, rectangle.xCenter, rectangle.yCenter, rectangle.filled);
        width = rectangle.width;
        height = rectangle.height;
        convertToPoints(rectangle);
    }

    /**
     * Gets the max and min width and height from the Points array to get the actual width and height of the Quadrilateral
     */
    private void getWidthAndHeight() {
        var maxWidth = Arrays.stream(points).max(Comparator.comparing(Point::getX)).orElse(new Point(0, 0)).x;
        var minWidth = Arrays.stream(points).min(Comparator.comparing(Point::getX)).orElse(new Point(0, 0)).x;
        width = maxWidth - minWidth;
        var maxHeight = Arrays.stream(points).max(Comparator.comparing(Point::getY)).orElse(new Point(0, 0)).y;
        var minHeight = Arrays.stream(points).min(Comparator.comparing(Point::getY)).orElse(new Point(0, 0)).y;
        height = maxHeight - minHeight;
    }

    /**
     * convertToPoints
     * Converts the Rectangle Shape to Points
     *
     * @param rectangle Rectangle object used to convert to Points
     */
    private void convertToPoints(Rectangle rectangle) {

        var halfWidth = rectangle.width / 2;
        var halfHeight = rectangle.height / 2;

        points = new Point[]{
                new Point(xCenter - halfWidth, yCenter - halfHeight),
                new Point(xCenter - halfWidth, yCenter + halfHeight),
                new Point(xCenter + halfWidth, yCenter + halfHeight),
                new Point(xCenter + halfWidth, yCenter - halfHeight)
        };
    }

    /**
     * DrawShape
     * Handles the logic to draw the Quadrilateral in the UI as well as setting the color, toggling the filling and setting the bounding box
     *
     * @param g Graphic class used to draw
     */
    @Override
    public void DrawShape(Graphics g) {

        var xPoints = Arrays.stream(points).mapToInt(Point::getX).toArray();
        var YPoints = Arrays.stream(points).mapToInt(Point::getY).toArray();
        var numberOfPoints = points.length;

        g.setColor(color);

        var polygon = new Polygon(xPoints, YPoints, numberOfPoints);

        g.drawPolygon(polygon);

        if (filled) {
            g.fillPolygon(polygon);
        }

        setBoundingBox();
    }

    /**
     * setBoundingBox
     * Handles the logic to set Bounding Box for the Quadrilateral
     */
    private void setBoundingBox() {

        var bottomLeft = points[0];
        var topRight = points[2];

        boundingBox = new BoundingBox(bottomLeft, topRight);
    }

    /**
     * DisplayName
     * Handles the Class name display logic in the ui for the given class
     *
     * @param g Graphic class used to draw
     */
    @Override
    public void DisplayName(Graphics g) {
        g.setColor(Color.black);
        g.drawString(this.getClass().getSimpleName(), xCenter, yCenter);
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
        g2d.drawRect(xCenter - width / 2, yCenter - height / 2, width, height);
    }

    /**
     * ToggleFill
     * Toggles the filled attribute of the Quadrilateral making it filled or not filled when the user left-clicks the shape.
     */
    @Override
    public void ToggleFill() {
        filled = !filled;
    }

    /**
     * Rotate
     * Implements the interface Rotatable
     * Rotates the points for the quadrilateral
     */
    @Override
    public void Rotate() {
        for (Point point : points) {
            var centerPoint = new Point(xCenter, yCenter);
            point = rotatePoint(point, centerPoint);
        }
    }

    /**
     * rotatePoint
     * Handles the rotation of a given point in consideration to it's center point
     *
     * @param point       Point to rotate
     * @param centerPoint Center point to rotate around
     * @return Point
     */
    private Point rotatePoint(Point point, Point centerPoint) {
        var angle = (Math.toRadians(Consts.DEGREES_TO_ROTATE));
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        point.x = centerPoint.x + (int) ((point.x - centerPoint.x) * cosAngle - (point.y - centerPoint.y) * sinAngle);
        point.y = centerPoint.y + (int) ((point.x - centerPoint.x) * sinAngle + (point.y - centerPoint.y) * cosAngle);

        return point;
    }

    /**
     * toString
     * representation of the state of the object on a given point
     * @return string printout of the state of the object
     */
    @Override
    public String toString() {
        return "Quadrilateral shape {" +
                super.toString() +
                "height=" + height +
                ", width=" + width +
                ", points=" + Arrays.toString(points) +
                ", boundingBox=" + boundingBox +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }
}
