package day20211101;

//模拟实现队列--底层使用双向链表
//在集合鲁昂家中Queue是一个接口--底层使用LinkedList
public class Queue<E> {
    //双向链表结点
    public static class ListNode<E>{
        ListNode<E> next;
        ListNode<E> prev;
        E value;

        ListNode(E value){
            this.value=value;
        }
    }

    ListNode<E> first; //队头
    ListNode<E> last;  //队尾
    int size=0;

    //入队列--向双向链表尾部插入新结点
    public void offer(E e){
        ListNode<E> newNode=new ListNode<E>(e);
        if(first==null){
            first=newNode;
            //last=newNode;
        }else{
            last.next=newNode;
            newNode.prev=last;
            //last=newNode;
        }
        last=newNode;
        size++;
    }

    //出队列--将双向链表首节点删除
    public E poll(){
        E value=null;
        if(first==null){
            //1.队列为空
            return null;
        }else if(first==last){
            //2.队列中只有一个元素--链表中只有一个结点
            value=first.value;
            first=null;
            last=null;
        }else{
            //3.队列中有多个元素--链表中有多个节点
            value=first.value;
            first=first.next;
            first.prev.next=null;
            first.prev=null;

        }
        size--;
        return value;
    }

    //获取队头元素--获取链表中第一个元素的值域
    public E peek(){
        if(first==null){
            return null;
        }
        return first.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args) {
        Queue<Integer> q=new Queue<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        System.out.println(q.size());
        System.out.println(q.peek());

        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        System.out.println(q.size());
        System.out.println(q.peek());

        q.poll();
        System.out.println(q.size());
        System.out.println(q.peek());

    }
}
