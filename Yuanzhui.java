package pack2;

public class Yuanzhui implements Volume{
    private float radius;
    private float height;
    public Yuanzhui(float radius,float height){
        this.radius=radius;
        this.height=height;
    }
    public float getVolume(){
        return (PI*radius*radius*height*1/3);
    }
}


