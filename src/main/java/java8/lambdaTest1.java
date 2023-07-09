package java8;
import org.junit.Test;
import java.util.Comparator;
import java.util.function.Consumer;

public class lambdaTest1 {
//    格式1：无参数，无返回值
    @Test
    public  void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("I love you");
            }
        };
        r1.run();
        System.out.println("****************");

        Runnable r2=()-> System.out.println("I love you");
        r2.run();
    }
    //格式2：有参数，无返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("好生气");
        System.out.println("****************");
        Consumer<String> con1=(String s)->{
            System.out.println(s);
        };
        con1.accept("烦死");
    }
    //格式3：数据类型可以省略，类型推断
    @Test
    public void test3() {

        Consumer<String> con1=(String s)->{
            System.out.println(s);
        };
        con1.accept("烦死");
        System.out.println("****************");

        Consumer<String> con2=(s)->{
            System.out.println(s);
        };
        con2.accept("烦死");
    }
    //格式4 ，只有一个参数，小括号可以省略
    @Test
    public void test4() {

        Consumer<String> con2=(s)->{
            System.out.println(s);
        };
        con2.accept("烦死");
        System.out.println("****************");
        Consumer<String> con3=s->{
            System.out.println(s);
        };
        con3.accept("烦死");
    }
    //格式5。2个参数，多条语句，返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12,21);
        System.out.println(compare1);
        //lambda表达式
        Comparator<Integer> com2 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        int compare2 = com2.compare(32,21);
        System.out.println(compare2);
    }
//    格式6：lambda体只有一条语句，return 与大括号可以省略
    @Test
    public void test6(){
        Comparator<Integer> com2 = (o1,o2)->{
            return Integer.compare(o1,o2);
        };
        int compare2 = com2.compare(32,21);
        System.out.println(compare2);

        Comparator<Integer> com3=(o1,o2)->Integer.compare(o1,o2);
        int compare3 = com3.compare(32,21);
        System.out.println(compare3);
    }
}
