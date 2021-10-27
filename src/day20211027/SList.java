package day20211027;

public class SList {
    ListNode head;

    public void add(int val){
        ListNode newNode=new ListNode(val);
        if(head==null){
            head=newNode;
        }else{
            ListNode cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newNode;
        }
    }

    @Override
    public String toString() {
        String s="[";
        ListNode cur=head;
        if(head==null){
            s+="]";
            return s;
        }
        while(cur.next!=null){
            s+=cur.val;
            s+=",";
            cur=cur.next;
        }
        s+=cur.val;
        s+="]";
        return s;
    }
}
