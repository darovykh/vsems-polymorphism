import java.util.Objects;

public class Circle implements IFigure, IStorable {

    private int radius;
    private int x0;
    private int y0;

    public Circle(int radius, int x0, int y0) {
        this.radius = radius;
        this.x0 = x0;
        this.y0 = y0;
    }

    public Circle() {

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && x0 == circle.x0 && y0 == circle.y0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, x0, y0);
    }

    @Override
    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArcLength(int angle) {
        return Math.PI * this.getRadius() * angle / 180;
    }

    public double getSectorArea(int angle) {
        return getArcLength(angle) * this.getRadius() / 2;
    }

    public double getChordLength(int angle) {
        return 2 * this.getRadius() * Math.sin((double) angle / 2);
    }

    public boolean belongToCircle(int x, int y) {
        if (Math.pow(x - this.getX0(), 2) + Math.pow(y - this.getY0(), 2) <= Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }

    @Override
    public String getXML() {
        return "<circle>" + System.lineSeparator() +
                "\t<radius>" + this.getRadius() + "</radius>" + System.lineSeparator() +
                "\t<x0>" + this.getX0() + "</x0>" + System.lineSeparator() +
                "\t<y0>" + this.getY0() + "</y0>" + System.lineSeparator() +
                "</circle>";
    }

    @Override
    public String getJSON() {
        return"{" + System.lineSeparator() +
                "\t\"radius\": \"" + this.getRadius() + "\"," + System.lineSeparator() +
                "\t\"x0\": \"" + this.getX0() + "\"," + System.lineSeparator() +
                "\t\"y0\": \"" + this.getY0() + "\"" + System.lineSeparator() +
                "}";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", x0=" + x0 +
                ", y0=" + y0 +
                '}';
    }
}