package eu.rmjoia.atu.TesterApp;

import eu.rmjoia.atu.swdev.ca1.drawing.Point;
import eu.rmjoia.atu.swdev.ca1.drawing.Rectangle;
import eu.rmjoia.atu.swdev.ca1.drawing.*;
import eu.rmjoia.atu.swdev.ca1.manager.ShapeManager;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var shapeManager = new ShapeManager();

        shapeManager.setDisplayName(true);
        shapeManager.setDrawBoundingBox(true);

        // Create and Add Circle
        shapeManager.AddShape(new Circle(Color.green, 300, 80, 50));

        // Create and Add Rectangle
        var rectangle = new Rectangle(Color.blue, 50, 200, true, 50, 80);
        shapeManager.AddShape(rectangle);

        // Create a Quadrilateral
        var rectangle2 = new Rectangle(Color.red, 140, 180, 100, 50);
        var quad = new Quadrilateral(rectangle2);
        shapeManager.AddShape(quad);

        Point[] pointArray = {new Point(90, 50), new Point(50, 50), new Point(80, 130), new Point(130, 90)};
        var quad2 = new Quadrilateral(new Point(50, 50), pointArray);
        shapeManager.AddShape(quad2);

        // Create and Add Square
        var square = new Square(Color.cyan, 400, 300, true, 80);
        shapeManager.AddShape(square);

        // Create Window and Draw Shapes
        shapeManager.CreateWindow();
    }
}
