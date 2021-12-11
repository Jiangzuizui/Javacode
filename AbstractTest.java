package day20211211;

interface Shape{
    static final float PI=3.14F;
    public abstract float getPerimeter();
    public abstract float getArea();
}

class Rectangle implements Shape{
    private float length;
    private float width;
    public Rectangle(float length,float width){
        this.length=length;
        this.width=width;
    }
    public float getPerimeter(){
        return (length+width)*2;
    }

    public float getArea(){
        return length*width;
    }
}

class Circle implements Shape{
    private float radius;
    public Circle(float r){
        radius=r;
    }
    public float getPerimeter(){
        return 2*PI*radius;
    }
    public float getArea(){
        return PI*radius*radius;
    }
}


public class AbstractTest {
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle(2,3);
        Circle c=new Circle(3);
        System.out.println("长方形的周长是"+rectangle.getPerimeter()+
                "面积是"+ rectangle.getArea());
        System.out.println("圆的周长是"+c.getPerimeter()+
                "面积是"+c.getArea());
    }

}


