package pack1;

public class Rectangle extends PingMian{
    private float length;
    private float width;

    public Rectangle(float length,float width){
        this.length=length;
        this.width=width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    @Override
    public float getArea() {
        return length*width;
    }
    @Override
    public float getPerimeter() {
        return (length+width)*2;
    }
}

