package day20211030;

import java.util.Stack;

public class Hehe {
    public boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                st.push(c);
            }else{
                if(st.empty()){
                    return false;
                }
                char top=st.peek();
                if((top=='('&&c==')')||
                        (top=='['&&c==']')||
                        (top=='{'&&c=='}')){
                    st.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!st.empty()){
            return false;
        }
        return true;
    }
}
