package day20211127;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> m=new TreeMap<>();
        m.put("orange" ,"橘子");
        m.put("apple" ,"苹果");
        m.put("grape" ,"葡萄");
        System.out.println(m.size());
        System.out.println(m.get("orange"));

        //m.put(null,"未知");
        m.put("orange","橙子");
        System.out.println(m.get("orange"));
        System.out.println(m.size());

        m.put("unknown" ,null);
        System.out.println(m.size());

        System.out.println(m.getOrDefault("apple","毒苹果"));
        System.out.println(m.getOrDefault("badapple","坏苹果"));

        System.out.println();
    }
}
