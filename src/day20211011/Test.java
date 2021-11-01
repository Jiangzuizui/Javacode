package day20211011;

public class Test {
    public static void main(String[] args){
        //int a=0xABCDEF;
        //System.out.printf("%15d",a);
        System.out.println(100%3);
        System.out.println(100%3.0);
    }

    public static void main3(String[] args){
        System.out.printf("%#o %#X",1234,1234);
    }


    public static void main2(String[] args){
        System.out.println("The size of short is "+Short.BYTES+" bytes.");
        System.out.println("The size of int is "+Integer.BYTES+" bytes.");
        System.out.println("The size of long is "+Long.BYTES+" bytes.");
        System.out.println("The size of long long is "+Long.BYTES+" bytes.");
    }

    public static void main1(String[] args){
        System.out.println("     **     ");
        System.out.println("     **     ");
        System.out.println("************");
        System.out.println("************");
        System.out.println("    *  *    ");
        System.out.println("    *  *    ");

    }
}
