package Lab4;

public class Circle implements Cumulate {
    double radis;


    public Circle(double radis) {
        this.radis = radis;
    }

    @Override
    public double area() {
        return radis*radis*3.1415926;
    }

    @Override
    public double cricum() {
        return radis*2*3.1415926;
    }
}
