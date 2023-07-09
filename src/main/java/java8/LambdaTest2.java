package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {
    @Test
    public void test1(){
        happytime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("投资"+aDouble);
            }
        });

        happytime(400,money-> System.out.println("消费"+money));

    }
    public void happytime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","天津","南京");
        List<String> filterStrs=filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        List<String> filterStrs1=filterString(list,s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList =new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
