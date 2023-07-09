package reflection;

import com.sun.source.tree.BreakTree;

import java.util.Comparator;
@MyAnnotation(value = "hi")
public class person1 extends Creature<String> implements Comparable<String>,MyInterface {

    private String name;
    int age;
    public int id;

    public person1(){}
    @MyAnnotation(value = "abc")
    private person1(String name){
        this.name=name;
    }
    person1(String name,int age){
        this.name=name;
        this.age=age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println(nation);
        return nation;
    }
    private String display(String interest){
        return interest;
    }




    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("I am great");
    }
    private static void showDec(){
        System.out.println("cool");
    }

    @Override
    public String toString() {
        return "person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
