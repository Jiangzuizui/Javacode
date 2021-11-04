package day20211103;



public class Node {
    public int val;
    public Node next=null;

    public Node(int val){
        this.val=val;
    }

    public static Node creatList(){
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        return a;
    }

    public static void main(String[] args) {
        Node head=creatList();

        //1.链表遍历
        Node cur=head;
        while(cur!=null){
            cur=cur.next;
            System.out.println(cur.val);
        }


        //2.遍历链表,找到最后一个结点
        while(cur!=null && cur.next!=null){
            cur=cur.next;
        }
        System.out.println(cur.val);

        //3.遍历链表,找到倒数第二个结点
        while(cur!=null && cur.next!=null &&
        cur.next.next!=null){
            cur=cur.next;
        }
        System.out.println(cur.val);

        //4.通过遍历，找到链表的第 n 个结点
        int N=3;
        for(int i=1;i<N;i++){
            cur=cur.next;
        }
        System.out.println(cur.val);

        //5.获取链表长度
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        System.out.println(count);

        //查找链表中是否包含某个元素
        int toFind=3;
        while(cur!=null){
            cur=cur.next;
            if(cur.val==toFind){
                break;
            }
        }
        if(cur!=null){
            System.out.println("没找到");
        }else{
            System.out.println("找到了");
        }
    }
}
