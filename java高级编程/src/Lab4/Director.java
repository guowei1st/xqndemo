package Lab4;

public class Director implements Cumulate{
    double longe;
    double width;

    public Director(double longe, double width) {
        this.longe = longe;
        this.width = width;
    }

    @Override
    public double area() {
        return longe*width;
    }

    @Override
    public double cricum() {
        return (longe+width)*2;
    }
}
