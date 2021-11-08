package day20211108;

public class PeopleDemo {
    public static void main(String[] args) {
        People person=new People("醉醉",20,100);
        System.out.println(person.toString());
        //person.age=30;//编译报错
        person.num=200;//不会报错,因为修改公共属性
        System.out.println(person.toString());
        person.setAge(50);
        System.out.println(person.toString());
        System.out.println(person.getAge());
    }
}

    class People{
        private String name;
        private int age;
        public int num;

        public People(String name,int age,int num){
            this.name=name;
            this.age=age;
            this.num=num;
        }

        //获取姓名
        public String getName(){
            return name;
        }
        //设置姓名
        public void setName(String name){
            this.name=name;
        }
        //获取年龄
        public int getAge(){
            return age;
        }
        //设置年龄
        public void setAge(int age){
            this.age=age;
        }
        //获取编号
        public int getNum(){
            return num;
        }
        //设置编号
        public void setNum(int num){
            this.num=num;
        }

        @Override
        public String toString() {
            return "People [name="+name+",age="+age+",num="+num+"]";
        }
    }


