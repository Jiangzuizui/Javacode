package day20211108;

public class Wolfdog2 {

    String name;
    int age;
    String color;

    //无参构造函数
    public Wolfdog2(){

    }

    //无参数返回的方法
    public void bark(){
        System.out.println("汪汪汪");
    }

    //有参数有返回值的方法
    public String barkReturn(String name){
        System.out.println(name+"呜呜呜");
        return name;
    }

    public static void main(String[] args) {
        Wolfdog2 dog=new Wolfdog2();

        dog.bark();

        String name1="小七";
        String name2=dog.barkReturn(name1);
        System.out.println(name2);
    }
}


