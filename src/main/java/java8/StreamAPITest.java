package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    @Test
    public void test1(){
        //自然排序
        List<Integer> list = Arrays.asList(12, 34, 53, 12, 42, 124, 54, 33, 4);
        list.stream().sorted().forEach(System.out::println);
    }
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

}
