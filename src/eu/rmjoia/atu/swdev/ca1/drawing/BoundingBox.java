package eu.rmjoia.atu.swdev.ca1.drawing;

/**
 * BoundingBox Class
 * Bounding boxes are imaginary boxes that are around objects that are being checked for things like
 * intersection (part of our requirements) or collision (for games, physics, etc – not part of our
 * requirements).
 */
public class BoundingBox {
    /**
     * bottomLeft field used to store the point coordinate for the bottom left point of the bounding box
     */
    private final Point bottomLeft;
    /**
     * bottomRight field used to store the point coordinate for the bottom right point of the bounding box
     */
    private final Point topRight;

    /**
     * BoundingBox Constructor, initializes a Bounding Box instance of the class with a bottomLeft and TopRight Point
     *
     * @param bottomLeft
     * @param topRight
     */
    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }
}
