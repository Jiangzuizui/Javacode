package pack1;

public class PingXingSiBian extends PingMian{
    private float length;
    private float height;
    private float side;//平行四边形斜边

    public PingXingSiBian(float length,
                          float height,float side){
        this.length=length;
        this.height=height;
        this.side=side;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setSide(float side) {
        this.side = side;
    }
    @Override
    public float getArea() {
        return length*height;
    }
    @Override
    public float getPerimeter() {
        return (length+side)*2;
    }
}


