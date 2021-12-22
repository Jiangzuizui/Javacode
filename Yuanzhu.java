package pack2;

public class Yuanzhu implements Volume{
    private float radius;
    private float height;
    public Yuanzhu(float radius,float height){
        this.radius=radius;
        this.height=height;
    }
    public float getVolume(){
        return (PI*radius*radius*height);
    }
}


