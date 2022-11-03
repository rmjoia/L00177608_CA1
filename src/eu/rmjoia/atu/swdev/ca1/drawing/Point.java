package eu.rmjoia.atu.swdev.ca1.drawing;

/**
 * Point Class
 * Point represents the coordinates for X and Y for a given point
 */
public class Point {
    /**
     * field x used to store the x coordinate point
     */
    int x;
    /**
     * field y used to store the y coordinate point
     */
    int y;

    /**
     * Instantiates a Point Class with an X and Y point coordinates
     *
     * @param x X Point
     * @param y Y Point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the value x of the Point
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the value y of the Point
     * @return int
     */
    public int getY() {
        return y;
    }
}
