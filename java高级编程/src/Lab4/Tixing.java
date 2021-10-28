package Lab4;

public class Tixing implements Cumulate {
    double toplong;
    double bottomlong;
    double high;
    double left;
    double right;

    public Tixing(double toplong, double bottomlong, double high, double left, double right) {
        this.toplong = toplong;
        this.bottomlong = bottomlong;
        this.high = high;
        this.left = left;
        this.right = right;
    }

    @Override
    public double area() {
        return (bottomlong+toplong)*high;
    }

    @Override
    public double cricum() {
        return toplong+bottomlong+left+right;
    }
}
