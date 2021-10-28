//package Lab3;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import Lab3.Data.Source;
//import Lab3.impl.pearsonImpl;
//import Lab3.impl.sim_DistanceImpl;
//import Lab3.impl.similarityImpl;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//public class Main {
//    public static void main(String args[]) {
//        //定义接口
//        Server server=null;
//        //开启source 获取数据
//        Source source=new Source();
//
//
//        /*
//        数据获取
//         */
//        List<Double> simple1 = new ArrayList<Double>();
//        List<Double> simple2 = new ArrayList<Double>();
//        List<Double> simple3 = new ArrayList<Double>();
//        List<Double> simple4 = new ArrayList<Double>();
//        List<Double> simple5 = new ArrayList<Double>();
//        simple1 = source.getData(1);
//        simple2 = source.getData(2);
//        simple3 = source.getData(3);
//        simple4 = source.getData(4);
//        simple5 = source.getData(5);
//        Double[] s1 = new Double[simple1.size()];
//        s1 = (Double[]) simple1.toArray(s1);
//        Double[] s2 = new Double[simple2.size()];
//        s2 = (Double[]) simple2.toArray(s2);
//        Double[] s3= new Double[simple3.size()];
//        s3 = (Double[]) simple3.toArray(s3);
//        Double[] s4 = new Double[simple4.size()];
//        s4 = (Double[]) simple4.toArray(s4);
//        Double[] s5 = new Double[simple5.size()];
//        s5= (Double[]) simple5.toArray(s5);
//        ArrayList a1=new ArrayList();
//        a1.addAll(simple1);
//        ArrayList a2=new ArrayList();
//        a2.addAll(simple2);
//        ArrayList a3=new ArrayList();
//        a3.addAll(simple3);
//        ArrayList a4=new ArrayList();
//        a4.addAll(simple4);
//        ArrayList a5=new ArrayList();
//        a5.addAll(simple5);
//
//
//
//        System.out.println("----------------数据展示----------------");
//        System.out.println(simple1);
//        System.out.println(simple2);
//        System.out.println(simple3);
//        System.out.println(simple4);
//        System.out.println(simple5);
//        System.out.println("----------------pearson算法结果(越高越相似）----------------");
//        System.out.println("1和2的相似度是：" + ((pearsonImpl) server).getPearsonBydim(simple1, simple2));
//        System.out.println("1和3的相似度是：" + ((pearsonImpl) server).getPearsonBydim(simple1, simple3));
//        System.out.println("1和4的相似度是：" + ((pearsonImpl) server).getPearsonBydim(simple1, simple4));
//        System.out.println("1和5的相似度是：" + ((pearsonImpl) server).getPearsonBydim(simple1, simple5));
//        System.out.println("和1最符合的数据是：数据2");
//        System.out.println("----------------欧几里得相似度算法结果(越低越相似）----------------");
//        System.out.println("1和2的相似度是：" + ((sim_DistanceImpl) server).sim_distance(s1, s2));
//        System.out.println("1和3的相似度是：" + ((sim_DistanceImpl) server).sim_distance(s1, s3));
//        System.out.println("1和4的相似度是：" + ((sim_DistanceImpl) server).sim_distance(s1, s4));
//        System.out.println("1和5的相似度是：" + ((sim_DistanceImpl) server).sim_distance(s1, s5));
//        System.out.println("和1最符合的数据是：数据2");
//        System.out.println("----------------余弦相似度算法结果(越高越相似）----------------");
//        System.out.println("1和2的相似度是：" + ((similarityImpl) server).similarity(a1, a2));
//        System.out.println("1和3的相似度是：" + ((similarityImpl) server).similarity(a1, a3));
//        System.out.println("1和4的相似度是：" + ((similarityImpl) server).similarity(a1, a4));
//        System.out.println("1和5的相似度是：" + ((similarityImpl) server).similarity(a1, a5));
//        System.out.println("和1最符合的数据是：数据2");
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//}