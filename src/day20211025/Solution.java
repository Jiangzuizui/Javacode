package day20211025;

import java.util.LinkedList;
import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}

//判断链表是否带环
public class Solution {
    public  boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast==slow){
            return true;
        }
        return false;
    }

    //返回环中的第一个结点 没有环返回null
    public ListNode detectCycle(ListNode head){
         ListNode fast=head;
         ListNode slow=head;

         boolean isCircle=false;
         while(fast!=null && fast.next!=null){
             fast=fast.next.next;
             slow=slow.next;

             //说明链表带环
             if(fast==slow){
                isCircle=true;
                break;
             }
         }
         if(!isCircle){
             return null;
         }
         //求入口点
        ListNode pH=head;
        ListNode pM=fast;
        while(pH!=pM){
            pH=pH.next;
            pM=pM.next;
        }
        return pH;
    }

    public static void main(String[] args) {
        //List<Integer> list=new LinkedList<>(1,2,3,4,5);


    }
}
