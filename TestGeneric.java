package day20211122;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    public static void printAll(List<? extends Animal> list){
        //该方法中只能对list中的元素进行访问操作
        for(Animal a:list){
            System.out.println(a);
        }
    }

    //上通配符
    public static void main1(String[] args) {
        List<? extends Animal> list1=new ArrayList<Cat>();
        List<? extends Animal> list2=new ArrayList<Dog>();
        List<? extends Animal> list3=new ArrayList<Animal>();

        //List<? extends Animal> list4=new ArrayList<Object>();

        //list3.add(new Cat());//报错
        //list3.add(Animal());//报错

        List<Dog> list4=new ArrayList<>();
        list4.add(new Dog());
        list4.add(new Dog());
        list4.add(new Dog());
        printAll(list4);

        List<Cat> list5=new ArrayList<>();
        list5.add(new Cat());
        list5.add(new Cat());
        list5.add(new Cat());

    }


    //下通配符
    public static void print(List<? super Cat> list){

    }

    public static void main(String[] args) {
        List<? super Animal> list=new ArrayList<>();
        list.add(new Cat());
        list.add(new Animal());
        list.add(new Dog());

        List<Cat> list1=new ArrayList<>();
        list1.add(new Cat());
        list1.add(new Cat());
        print(list1);

        List<Dog> list2=new ArrayList<>();
        list2.add(new Dog());
        list2.add(new Dog());
        //print(list2);//报错 ∵只能比Cat的级别高 Cat是下限

        List<Animal> list3=new ArrayList<>();
        list3.add(new Animal());
        list3.add(new Animal());
        print(list3);
    }
}
