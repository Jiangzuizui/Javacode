package day20211108;

public class Wolfdog1 {

    //狼狗的姓名
    String name;
    //狼狗的年龄
    int age;
    //狼狗的颜色
    String color;

    //狼狗叫
    public void bark(){
        System.out.println("名叫"+name+age+"岁的狗颜色是"+color);
    }

    public static void main(String[] args) {
        Wolfdog1 teddyDog=new Wolfdog1();
        teddyDog.age=6;
        teddyDog.name="王一阳";
        teddyDog.color="黑色";
        teddyDog.bark();
    }

}
