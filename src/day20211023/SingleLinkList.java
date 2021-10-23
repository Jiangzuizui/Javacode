package day20211023;

//不带头结点的单链表
public class SingleLinkList<E> {
    public static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }
    Node<E> head;//head指向链表中第一个有效节点

    //查找关键字e是否包含在单链表中
    public boolean contains(E e){
        Node<E> cur=head;
        while(cur!=null){
            if(e.equals(cur.value)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int size(){
        Node<E> cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //将链表中每个结点值域拼接成一个字符串返回
    public String toString(){
        Node<E> cur=head;
        String str="[";
        while(cur!=null){
            str+=cur.value;
            if(cur.next!=null){
                str+=",";
            }
            cur=cur.next;
        }
        str+="]";
        return str;
    }

    //尾插法
    public void addLast(E data){
        Node<E> newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node<E> cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newNode;
        }


        /*Node pre=null;
        while(cur!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=newNode;*/
    }

    //头插法
    public void addFirst(E data){
        Node<E> newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }

    /*public void initList(){
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        head=node1;
    }*/

    //任意位置插入,第一个数据结点为0号下标
    public boolean addIndex(int position,E data){
        if(position<0||position>=4){
            throw new IllegalArgumentException("addIndex:position非法");
        }
        if(position==0) {
            addFirst(data);
            return true;
        }
        Node<E> cur=head;
        Node<E> prev=null;
        while(position!=0){
            prev=cur;
            cur=cur.next;
            position--;
        }

        Node<E> newNode=new Node(data);
        newNode.next=cur;
        prev.next=newNode;

        return true;
    }

    //删除第一次出现e的结点
    public void remove(E e){
        Node<E> cur=head;
        Node<E> prev=null;
        while(cur!=null){
            if(e.equals(cur.value)){
                cur.value=null;
                if(prev==null){
                    //删除首节点
                    head=cur.next;
                }else{
                    //删除的不是第一个
                    prev.next=cur.next;
                }
                return;
            }
            prev=cur;
            cur=cur.next;
        }

    }

    //删除所有的e
    public void removeAllKey(E e){
        //O(N^2)
        /*while(contains(e)){
            remove(e);
        }*/

        Node<E> cur=head;
        Node<E> prev=null;
        while(cur!=null){
            if(e.equals(cur.value)){
                //删除结点
                cur.value=null;
                if(prev==null){
                    head=cur.next;
                    cur=head;

                }else{
                    prev.next=cur.next;
                    cur=prev.next;
                }
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public static void testSingleLinkList1() {
        SingleLinkList<Integer> s = new SingleLinkList<>();
        //s.initList();
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.contains(3));
        s.addLast(5);
        System.out.println(s);

    }

    public static void testSingleLinkList2(){
        SingleLinkList<Integer> s = new SingleLinkList<>();
        s.addFirst(0);
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        System.out.println(s);

    }


    public static void main(String[] args) {
        testSingleLinkList2();
    }
}
