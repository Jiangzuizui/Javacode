package day20211206;

public class StringConversion {
    public static void main(String[] args) {
        String s=new String("20");
        System.out.println("转换为byte类型后: "+Byte.parseByte(s));
        System.out.println("转换为short类型后: "+Short.parseShort(s));
        System.out.println("转换为int类型后: "+Integer.parseInt(s));
        System.out.println("转换为float类型后: "+Float.parseFloat(s));
    }
}
