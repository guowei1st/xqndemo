package Lab4;

class Triangle implements Cumulate {
    double area;
    double cricum;
    double s1;
    double s2;
    double s3;
    public Triangle(double s1, double s2, double s3) {
        if (isTri(s1, s2, s3)) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        } else {
            System.out.println("输入的三边长" + s1 + "、" + s2 + "、" + s3
                    + "不能组成一个三角形，请重新输入三边长！");
        }
    }
    public boolean isTri(double s1, double s2, double s3) {
        if (s1 + s2 < s3) {
            return false;
        }
        if (s1 + s3 < s2) {
            return false;
        }
        if (s2 + s3 < s1) {
            return false;
        }
        return true;
    }
    @Override
    public double area() {
        double p = (s1 + s2 + s3) / 2;
        return Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
    }

    @Override
    public double cricum() {
        return s1 + s2 + s3;
    }
}
