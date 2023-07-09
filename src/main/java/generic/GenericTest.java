package generic;

import org.junit.Test;

import java.util.*;

public class GenericTest {
     @Test
    public void test1(){
         ArrayList<Integer> integers = new ArrayList<>();
         integers.add(22);
         integers.add(34);
         Iterator<Integer> iterator = integers.iterator();
         while (iterator.hasNext()){
             Integer next = iterator.next();
             System.out.println(next);
         }

         Map<String,Integer> map =new HashMap<>();
         map.put("Tom",92);
         map.put("xxn",93);
         for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
             System.out.println(stringIntegerEntry.getKey()+"----"+stringIntegerEntry.getValue());
         }
     }
     @Test
    public void test2(){
         //实例化时，指明类的泛型
         Order<String> order1=new Order<>("A",1001,"A1001");
         //由于继承带泛型的父类，所以实例化时不需要指明
         subOrder subOrder = new subOrder();
         subOrder.setOrderT(123);
         subOrder1<String> subOrder1 = new subOrder1();
     }


     @Test
    public void test3(){
         Order<String> objectOrder = new Order<>();
         Integer[] integers = {1, 2, 3};
         List<Integer> integers1 = objectOrder.copyFromArrayToList(integers);
         System.out.println(integers1);
     }
     @Test
    public void test4(){
         List<Object> list1=new ArrayList<>();
         list1.add(123);
         List<String> list2=new ArrayList<>();
         list2.add("123");
         List<?> list=null;
         list=list1;
         list=list2;
         print(list1);
         print(list2);

     }
     public void print(List<?> list){
         Iterator<?> iterator = list.iterator();
         while(iterator.hasNext()){
             Object next = iterator.next();
             System.out.println(next);
         }
     }


}
