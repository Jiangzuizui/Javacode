package day20211206;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("我在学习Java语言,共");
        System.out.println("原字符串是: "+sb);
        System.out.println("原字符串长度是: "+sb.length());
        System.out.println("添加后的字符串是: "+sb.append("学时."));
        System.out.println("插入后的字符串是: "+sb.insert(8,"程序设计"));
        System.out.println("插入数字后的字符串是: "+sb.insert(16,60));
        System.out.println("替换后的字符串是: "+sb.replace(0,1,"本学期"));
        System.out.println("删除后的字符串是: "+sb.deleteCharAt(16));
        System.out.println("逆序排列后的字符串是: "+sb.reverse());
        System.out.println("处理后的字符串是: "+sb);
    }
}


