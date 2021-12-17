package Pack2;

class body{
    public double volume(){
        return 0;
    }
}

class cylinder extends body{//圆柱体
    private double r1;
    private double h1;
    public cylinder(double r1,double h1){
        this.h1=h1;
        this.r1=r1;
    }

    @Override
    public double volume() {
        return Math.PI*r1*r1*h1;
    }
}

class cone extends body{//圆锥体
    private double r2;
    private double h2;
    public cone(double r2,double h2){
        this.h2=h2;
        this.r2=r2;
    }

    @Override
    public double volume() {
        return Math.PI*r2*r2*h2*1/3;
    }
}

public class Substance {
    public static void main(String[] args) {
        cylinder cy=new cylinder(3,6);
        System.out.println("圆柱体的体积是"+cy.volume());

        cone co=new cone(3,6);
        System.out.println("圆锥体的体积是"+co.volume());
    }
}
