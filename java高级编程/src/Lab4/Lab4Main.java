package Lab4;

public class Lab4Main {
    public static void main(String args[]){
        Triangle triangle=new Triangle(3,4,5);
        Tixing tixing=new Tixing(3,5,2,3,3);
        Circle circle=new Circle(3);
        Director director=new Director(3,4);

        System.out.println("三角形triangle的周长为：" + triangle.cricum());
        System.out.println("三角形triangle的面积为：" + triangle.area());

        System.out.println("该长方形的周长为：" + director.cricum());
        System.out.println("该长方形的面积为：" + director.area());
        System.out.printf("圆形的周长为：%.2f\n" , circle.cricum());
        System.out.printf("圆形的面积为：%.2f\n", circle.area());
        System.out.println("梯形的周长为：" + tixing.cricum());
        System.out.println("梯形的面积为：" + tixing.area());

    }





}
