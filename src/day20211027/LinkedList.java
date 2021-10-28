package day20211027;

public class LinkedList<E> {

    //双向链表结点的结构
    public static class ListNode<E>{
        E elem;
        ListNode<E> next;
        ListNode<E> prev;

        public ListNode(E e){
            elem=e;
        }
    }

    //双向链表中的成员变量
    ListNode<E> first;
    ListNode<E> last;
    int size=0;

    public LinkedList(){

    }

    //头插法
    public void addFirst(E e){
        ListNode<E> newNode=new ListNode<>(e);
        if(first==null){
            //1.为空
            last=newNode;
            //first=newNode;
        }else {
            //2.不为空
            first.prev=newNode;
            newNode.next=first;
            //first=newNode;
        }
        first=newNode;
        size++;
    }


    //尾插法
    public void addLast(E e){
        ListNode<E> newNode=new ListNode<>(e);
        if(first==null){
            //1.为空
            first=newNode;
            //last=newNode;
        }else {
            //2.不为空
            last.next=newNode;
            newNode.prev=last;
            //last=newNode;
        }
        last=newNode;
        size++;
    }

    //将e尾插到链表中
    public void add(E e){
        addLast(e);
    }

    //任意位置插入,第一个数据结点为0号下标
    public boolean addIndex(int index,E e){

        return true;
    }

    //查找链表中是否包含关键字e
    public boolean contains(E e){
        ListNode<E> cur=first;
        while(cur!=null){
            if(e.equals(cur.elem)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public int indexOf(E e){
        ListNode<E> cur=first;
        int index=0;
        while(cur!=null){
            if(e.equals(cur.elem)){
                return index;
            }
            index++;
            cur=cur.next;
        }
        return -1;
    }

    //从后往前找第一个只出现一次的e的位置
    public int lastIndexOf(E e){
        ListNode<E> cur=last;
        int index=size-1;
        while(cur!=null){
            if(e.equals(cur.elem)){
                return index;
            }
            cur=cur.prev;
            index--;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public E remove(E e){
        return null;
    }

    @Override
    public String toString() {
        String s="[";
        if(first==null){
            s+="]";
            return s;

        }
        ListNode<E> cur=first;
        while(cur.next!=null){
            s+=cur.elem;
            s+=",";
            cur=cur.next;
        }
        s+=cur.elem;
        s+="]";

        return s;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        System.out.println(list);

        //尾插
        /*list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);*/

        //头插
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println(list);
    }
}
