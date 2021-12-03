package day20211121;

public class Person implements Comparable<Person> {
    public  Person(){

    }

    public Person(int age){
        this.age=age;
    }

    @Override
    public int compareTo(Person o) {
        //return age-o.age;//升序
        return o.age-age;//降序
    }

    String name;
    String gender;
    int age;
}
