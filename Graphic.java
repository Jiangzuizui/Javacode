package Pack1;

class Shape{
    public double area(){
        //面积
        return 0;
    }
    public double girth(){
        //周长
        return 0;
    }
}

class Circle extends Shape{//圆形
    private double r;//半径
    public Circle(double r){
        this.r=r;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(r,2);
    }

    @Override
    public double girth() {
        return 2*Math.PI*r;
    }
}

class Rectangle extends Shape{//矩形
    private double length;//长
    private double width;//宽
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }

    @Override
    public double area() {
        return length*width;
    }

    @Override
    public double girth() {
        return 2*(length+width);
    }
}

class parallelogram extends Shape{//平行四边形
    private double base;//底
    private double height;//高
    private double side;//斜边

    public parallelogram(double base,double height,double side){
        this.base=base;
        this.height=height;
        this.side=side;
    }

    @Override
    public double area() {
        return base*height;
    }

    @Override
    public double girth() {
        return 2*(base+side);
    }
}

public class Graphic {
    public static void main(String[] args) {
        Circle circle=new Circle(4);
        System.out.println("圆形的面积是"+circle.area());
        System.out.println("圆形的周长是"+circle.girth());

        Rectangle rect=new Rectangle(5.2,6);
        System.out.println("矩形的面积是"+rect.area());
        System.out.println("矩形的周长是"+rect.girth());

        parallelogram para=new parallelogram(6,7,3);
        System.out.println("平行四边形的面积为"+para.area());
        System.out.println("平行四边形的周长为"+para.girth());
    }
}
