package Test;

import pack1.Circle;
import pack1.PingMian;
import pack1.PingXingSiBian;
import pack1.Rectangle;
import pack2.Volume;
import pack2.Yuanzhu;
import pack2.Yuanzhui;
import java.util.Scanner;

public class ComputerTest {
    public static void main(String[] args) {
        int type;
        Scanner sc=new Scanner(System.in);
        try{
            do{
                System.out.println("请输入需要计算的几何图形:1.长方形,2.圆," +
                        "3.平行四边形,4.圆柱体,5.圆锥体,0.退出系统");
                type=sc.nextInt();
                if(type==1){
                    System.out.println("请输入长方形的长");
                    float length=sc.nextFloat();
                    System.out.println("请输入长方形的宽");
                    float width=sc.nextFloat();
                    PingMian rect=new Rectangle(length,width);
                    System.out.println("长方形的周长是:"+ rect.getPerimeter());
                    System.out.println("长方形的面积是:"+rect.getArea());
                }
                if(type==2){
                    System.out.println("请输入圆的半径");
                    float radius=sc.nextFloat();
                    PingMian rect2=new Circle(radius);
                    System.out.println("圆的周长是:"+ rect2.getPerimeter());
                    System.out.println("圆的面积是:"+rect2.getArea());
                }
                if(type==3){
                    System.out.println("请输入平行四边形的底");
                    float length=sc.nextFloat();
                    System.out.println("请输入平行四边形的高");
                    float height=sc.nextFloat();
                    System.out.println("请输入平行四边形的斜边");
                    float side=sc.nextFloat();
                    PingMian rect3=new PingXingSiBian(length,height,side);
                    System.out.println("平行四边形的周长是"+rect3.getPerimeter());
                    System.out.println("平行四边形的面积是"+rect3.getArea());
                }
                if(type==4){
                    System.out.println("请输入圆柱体的半径");
                    float radius=sc.nextFloat();
                    System.out.println("请输入圆柱体的高");
                    float height=sc.nextFloat();
                    Volume vo1=new Yuanzhu(radius,height);
                    System.out.println("圆柱体的体积是:"+ vo1.getVolume());
                }
                if(type==5){
                    System.out.println("请输入圆锥体的半径");
                    float radius=sc.nextFloat();
                    System.out.println("请输入圆锥体的高");
                    float height=sc.nextFloat();
                    Volume vo2=new Yuanzhui(radius,height);
                    System.out.println("圆锥体的体积是:"+ vo2.getVolume());
                }
            }while(type!=0);
            System.out.println("程序结束,谢谢使用");
            sc.close();
        }catch (Exception e){
            System.out.println("输入的格式有误");
            System.out.println("程序结束,谢谢使用!");
        }
    }
}

