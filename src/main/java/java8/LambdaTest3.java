package java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTest3 {
    @Test
    public void test1(){
        Consumer<String> con1 =str -> System.out.println(str);
        con1.accept("北京");
        PrintStream ps=System.out;
        Consumer<String> con2=ps::println;
        con2.accept("beijing");
    }

    @Test
    public  void test2(){
        Comparator<Integer> com1=(t1,t2)->Integer.compare(t1,t2);
        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(12,3));
    }
    @Test
    public void test3(){
        Function<Double,Long> func1=d->Math.round(d);
        System.out.println(func1.apply(12.3));
        Function<Double,Long> func2=Math::round;
        System.out.println(func2.apply(12.6));
    }
    @Test
    public void test4(){
        Comparator<String> com1=(s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("abc","abc"));
        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("d","m"));
    }

    @Test
    public void test5(){
        BiPredicate<String,String> pre1=(s1,s2)->s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));
        BiPredicate<String,String> pre2=String::equals;
        System.out.println(pre2.test("abc","abd"));
    }
    @Test
    public void test6(){
        Function<Integer,String[]> func1=length->new String[length];
        String[] arr1= func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        Function<Integer,String[]> func2=String[]::new;
        String[] arr2=func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
