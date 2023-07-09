package reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Properties;
import java.util.Random;

public class ReflectionTest {



    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        //1.use reflection, construct object with Person Class
        Constructor cons= personClass.getConstructor(String.class,int.class);
        Object tom = cons.newInstance("Tom", 12);
        System.out.println(tom.toString());
        //2 通过反射，调用对象的属性，方法
        //2.1调属性
        Field age = personClass.getDeclaredField("age");
        age.set(tom,10);
        System.out.println(tom.toString());
        //2.2调方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);
        //3通过反射，可以调用私有结构。
        //3.1调用私有构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person xxn = declaredConstructor.newInstance("xxn");
        System.out.println(xxn);
        //3.2调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(xxn,"G6666");
        System.out.println(xxn);
        //3.3调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object us = showNation.invoke(xxn, "US");
        System.out.println(us);
    }
    @Test
    public void test2() throws ClassNotFoundException {
        //1 调用运行时的属性
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //2通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        //3.调用Class的静态方法:forName
        Class<?> aClass1 = Class.forName("reflection.Person");
        System.out.println(aClass1);
    }
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        //读取配置文件的方法一
//        FileInputStream fileInputStream = new FileInputStream("/Users/xuxinan/Desktop/Java8/src/main/resources/jdbc1.properties");
//        properties.load(fileInputStream);
        //方法二类加载器，区别路径问题
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        System.out.println(resourceAsStream);
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user+password);
    }

    @Test
    public void test4() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        /*
        *newInstance()调用此方法，创建对应的运行时类的对象
        * 要求:1.必须有空参构造器2.访问权限得够。
        * */
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    @Test
    public void test5() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for(int j=1;j<100;j++){
            int i = new Random().nextInt(3);
            String classPath="";
            switch (i){
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="reflection.Person";
                    break;
            }
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }
    }

    /*
        创建一个制定类的对象
        classPath:制定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

    @Test
    public void test6(){
        Class<person1> person1Class = person1.class;
//        getFields()获取当前以及父类的public属性
        for (Field field : person1Class.getFields()) {
            System.out.println(field);
        }
        System.out.println("==========================");
//        getDeclaredFields()获取当前运行类的所有属性（不包含父类）
        for (Field declaredField : person1Class.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("==========================");
        for (Field declaredField : person1Class.getDeclaredFields()) {
//            getModifiers()返回一个整数--->权限修饰符
            System.out.print(declaredField.getModifiers()+"\t");
            System.out.print(Modifier.toString(declaredField.getModifiers())+"\t");
//            数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type+"\t");
//            数据名
            String name = declaredField.getName();
            System.out.println(name);
        }
        System.out.println("==========================");
//        方法
        for (Method method : person1Class.getMethods()) {
            System.out.println(method);
        }
        System.out.println("==========================");
        for (Method declaredMethod : person1Class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("==========================");
//        获取注解
        for (Method declaredMethod : person1Class.getDeclaredMethods()) {
            for (Annotation annotation : declaredMethod.getAnnotations()) {
                System.out.print(annotation+"\t");
            }
            //权限修饰符
            int modifiers = declaredMethod.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            //返回值类型
            String name = declaredMethod.getReturnType().getName();
            System.out.print(name+"\t");
            //方法名字
            String name1 = declaredMethod.getName();
            System.out.print(name1+"(");
            //行参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if(parameterTypes==null&&parameterTypes.length==0){
                System.out.print(")"+"\t");
            }else {
                for(Class p :parameterTypes){
                    System.out.print(p.getName()+"\t");
                }
                System.out.print(")"+"\t");
            }
//            异常
            for (Class<?> exceptionType : declaredMethod.getExceptionTypes()) {

            }
            System.out.println();

        }

    }

    @Test
    public void test7(){
        Class<person1> person1Class = person1.class;
        for (Constructor<?> constructor : person1Class.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("==========================");
        for (Constructor<?> declaredConstructor : person1Class.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
    }
    @Test
    public void test8(){
        Class<person1> person1Class = person1.class;
        //不带<>
        Class<? super person1> superclass = person1Class.getSuperclass();
        System.out.println(superclass);
        //带<>
        Type genericSuperclass = person1Class.getGenericSuperclass();
        System.out.println(genericSuperclass);
//        获取<>
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        for (Type actualTypeArgument : genericSuperclass1.getActualTypeArguments()) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }
    @Test
    public void test9(){
        //获取当前运行类的接口
        Class<person1> person1Class = person1.class;
        for (Class<?> anInterface : person1Class.getInterfaces()) {
            System.out.println(anInterface);
        }
        //获取父类的接口
        for (Class<?> anInterface : person1Class.getSuperclass().getInterfaces()) {
            System.out.println(anInterface);
        }
        //获取所在的包
        Package aPackage = person1Class.getPackage();
        System.out.println(aPackage);
        //获取当前类当前的注解
        for (Annotation annotation : person1Class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
    @Test
    public void test10() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<person1> person1Class = person1.class;
        //创建运行时类的对象
        person1 p= (person1)person1Class.newInstance();
//        //获取指定属性,要求声明为pubic
//        Field id = person1Class.getField("id");
//        /*
//        set()参数1 哪个对象 参数2属性值是多少
//         */
//        id.set(p,1001);
//        /*
//        get()参数 获取哪个对象
//         */
//        Object o = id.get(p);
//        System.out.println(o);

        //常用
        Field name = person1Class.getDeclaredField("name");
        //保证属性可访问
        name.setAccessible(true);
        name.set(p,"xxn");
        Object o1 = name.get(p);
        System.out.println(o1);
    }
    @Test
    public void test11() throws Exception {
        Class<person1> person1Class = person1.class;
        person1 person1 = person1Class.newInstance();
        Method show = person1Class.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object us = show.invoke(person1, "US");
        System.out.println(us);
        //调用静态方法
        Method showDec = person1Class.getDeclaredMethod("showDec");
        showDec.setAccessible(true);
        showDec.invoke(person1.class);
    }


    @Test
    public void test12() throws Exception {
        Class<person1> person1Class = person1.class;
        //getDeclaredConstructor()参数：指明构造器的参数列表
        Constructor<person1> declaredConstructor = person1Class.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        person1 tom = declaredConstructor.newInstance("Tom");
        System.out.println(tom);
    }
}
