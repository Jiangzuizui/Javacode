package day20211023;

public class PetDog {
    //字段
    public String name;
    public String color;

    //方法
    public void wag(){
        System.out.println("摇尾巴");
    }



    public static void main1(String[] args) {
        //PetDog--引用类型
        //dogH--对象
        PetDog dogH=new PetDog();
        dogH.name="小七";
        dogH.color="黄色";
        //方法必须通过对象来调用
        dogH.wag();
    }
}
