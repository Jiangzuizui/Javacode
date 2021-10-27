package day20211027;

import java.util.List;

public class Solution {

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
