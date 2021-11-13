package day20211027;

import java.util.List;

public class Solution {

    public static int middleElement(ListNode head){
        int length=0;
        ListNode x=head;
        while(x!=null){
            length++;
            x=x.next;
        }
        int index=(length-1)/2;

        x=head;
        for(int i=0;i<index;i++){
            x=x.next;
        }
        return x.val;
    }

    public static int nTolast(ListNode head,int k){
        if(head==null){
            return 0;
        }
        int i=nTolast(head.next,k)+1;
        if(i==k){
            System.out.println(head.val);
        }
        return i;
    }

    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode next=null;
        ListNode prev=null;


        while(cur!=null){
            next=cur.next;

            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }



    public static void main(String[] args) {
        SList s=new SList();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        System.out.println(s);

        Solution st=new Solution();
        s.head=st.reverseList(s.head);
        System.out.println(s);
    }
}
