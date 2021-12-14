package day20211030;

import day20211023.SingleLinkList;
import day20211103.Node;

import java.util.Stack;
import java.util.List;

public class Solution2 {
    public boolean isPalindrome1(Node head){
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            //检测第i个括号是左还是右
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                //左括号,入栈
                st.push(c);
            }else{
                //右括号,将其与栈顶元素相比
                if(st.empty()){
                    return false;
                }
                //获取栈顶的左括号
                char top=st.peek();//peek只会将栈顶的元素获取到,并不会删除
                if((top=='('&&c==')') ||
                    (top=='['&&c==']') ||
                    (top=='{'&&c=='}')){
                        st.pop();
                        continue;
                }else{
                    return false;
                }
            }
        }
        //如果栈中不为空,说明左括号多了
        if(!st.empty()){
            return false;
        }
        return true;
    }

    public int evalRPN(String[] tokens){
        Stack<Integer> s=new Stack<>();
        for(String e:tokens){
            //char ch=e.charAt(0);
            //if(!((ch=='+')||(ch=='-')
              //      ||(ch=='*')||(ch=='/'))){
            //这种方式测不到负数的情况,会把负号当做减号
            if(!((e.equals("+"))||(e.equals("-"))||
                    (e.equals("*"))||(e.equals("/")))){
            //e是数字字符串--先将数字字符串转为数字,然后入栈
                s.push(Integer.parseInt(e));
            }else{
                //e是运算符
                //从栈顶取两个操作数进行运算
                int right=s.pop();
                int left=s.pop();
                switch(e.charAt(0)){
                    case '+':
                        s.push(left+right);
                        break;
                    case '-':
                        s.push(left-right);
                        break;
                    case '*':
                        s.push(left*right);
                        break;
                    case '/':
                        s.push(left/right);
                        break;
                }
            }
        }
        return s.peek();
    }

    public boolean IsPopOrder(int[] pushA,int[] popA){
        Stack<Integer> s=new Stack<>();
        int pushIdx=0,outIdx=0;

        while(outIdx<popA.length) {
            while (s.empty() || s.peek() != popA[outIdx]) {
                //有元素时,继续入栈
                if (pushIdx < pushA.length) {
                    s.push(pushA[pushIdx]);
                    pushIdx++;
                } else {
                    return false;
                }
            }
            s.pop();
            outIdx++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
