package pack1;

public class Circle extends PingMian{
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

