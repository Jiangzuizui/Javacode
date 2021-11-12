package day20211111;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//用循环的(非递归)的方式遍历二叉树
public class BianLi {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }

        public TreeNode(int val){
            this.val=val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //前序遍历(非递归)
    class Solution{
        public List<Integer> preorderTravelsal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }
            //从上往下遍历最左侧路径中的每个结点,
            //并将其右子树保存到栈中
            Stack<TreeNode> s=new Stack<>();
            TreeNode cur=root;
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    list.add(cur.val);
                    if(cur.right!=null){
                        s.push(cur.right);
                    }
                    cur=cur.left;
                }
                if(!s.empty()){
                    cur=s.pop();
                }
            }
            return list;
        }
    }


    //中序遍历(非递归)
    class Solution2{
        public List<Integer> inOrderTraversal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }

            TreeNode cur=root;
            Stack<TreeNode> s=new Stack<>();
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    s.push(cur);
                    cur=cur.left;
                }
                cur=s.pop();
                list.add(cur.val);

                cur=cur.right;
            }
            return list;
        }
    }

    //后序遍历(非递归)
    class solution3{
        public List<Integer> postorderTraversal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }
            Stack<TreeNode> s=new Stack<>();
            TreeNode prev=null;
            TreeNode cur=root;
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    s.push(cur);
                    cur=cur.left;
                }

                TreeNode top=s.peek();
                if(top.right==null || top.right==prev){
                    list.add(top.val);
                    prev=top;
                    s.pop();
                } else{
                    cur=top.right;
                }
            }
            return list;
        }
    }

    //知道前序和中序构造二叉树
    class Solution4{
        int index=0;
        TreeNode rebuildTree(int[] preorder,int[] inorder,
                             int left,int right){
            if(index>=preorder.length || left>=right){
                return null;
            }
            //1.从前序遍历结果中找根的位置,index的位置
            //pre[index]根的位置上

            //2.从中序遍历结果中找跟的位置pos,确认根的左右子树
            int pos=left;
            while(pos<right){
                if(inorder[pos]==preorder[index]){
                    break;
                }
                pos++;
            }
            //还原根节点
            TreeNode root=new TreeNode(preorder[index]);

            index++;
            //递归还原左右子树
            root.left=rebuildTree(preorder,inorder,left,pos);
            root.right=rebuildTree(preorder,inorder,pos+1,right);

            return root;
        }

        public TreeNode bulidTree(int[] preorder,int[] inorder){
            index=0;
            //[0,inorder.length]
            return rebuildTree(preorder, inorder,
                    0,inorder.length);
        }
    }

    //根据中序和后序构造二叉树
    class solution5{
        int index=0;
        TreeNode rebulidTree(int[] postorder,int[] inoder,
                             int left,int right){
            if(index<0 || left>=right){
                return null;
            }
            int pos=left;
            while(pos<right){
                if(postorder[index]==inoder[pos]){
                    break;
                }
                pos++;
            }
            TreeNode root=new TreeNode(postorder[index]);

            index--;
            root.right=rebulidTree(postorder,inoder,pos+1,right);
            root.left=rebulidTree(postorder,inoder,0,pos);

            return root;
        }

        public TreeNode buildTree(int[] postorder,int[] inorder){
           index=postorder.length-1;
           return rebulidTree(postorder,inorder,
                   0,inorder.length);
        }
    }


    //根据二叉树创建字符串
    class Solution6{
        void tree2str(TreeNode root,StringBuilder sb){
            if(root==null){
                return;
            }
            //转换根结点
            sb.append(root.val);
            //递归转换左右子树
            if(root.left==null){
                if(root.right==null){
                    //左空右空
                    return;
                }else{
                    //左空右不空
                    sb.append("()");
                }
            }else{
                //左不空
                sb.append('(');
                tree2str(root.left,sb);
                sb.append(')');
            }

            if(root.right==null){
                return;
            }else{
                sb.append('(');
                tree2str(root.right,sb);
                sb.append(')');
            }
        }

        public String tree2str(TreeNode root){
            StringBuilder sb=new StringBuilder();
            tree2str(root,sb);
            return sb.toString();
        }
    }

    //最近公共祖先(类似最小公倍数)方法一
    class Solution7{
        //从根到某个节点对应路径中的所有节点
        boolean getNodePath(TreeNode root,
                    Stack<TreeNode> sPath,TreeNode node){
            if(root==null || node==null){
                return false;
            }
            sPath.push(root);
            if(root==node){
                return true;
            }
            if(getNodePath(root.left,sPath,node)){
                return true;
            }
            if(getNodePath(root.right,sPath,node)){
                return true;
            }
            sPath.pop();
            return false;
        }

        public TreeNode lowestCommonAncestor(TreeNode root,
                             TreeNode p,TreeNode q){
            if(root==null || p==null ||q==null){
                return null;
            }
            //找从root到p或者q对应路径中包含的所有节点
            Stack<TreeNode> pPath=new Stack<>();
            Stack<TreeNode> qPath=new Stack<>();
            getNodePath(root,pPath,p);
            getNodePath(root,qPath,q);

            int pSize=pPath.size();
            int qSize=qPath.size();
            while(!pPath.empty() && !qPath.empty()){
                if(pPath.peek()==qPath.peek()){
                    return pPath.peek();
                }
                if(pSize>qSize){
                    pPath.pop();
                    pSize--;
                }else if(pSize<qSize){
                    qPath.pop();
                    qSize--;
                }else{
                    pPath.pop();
                    qPath.pop();
                    pSize--;
                    qSize--;
                }
            }
            return null;
        }
    }


    //最近公共祖先 方法二
    class Solution8{
        //如果知道一个结点在其子树中的位置,也可以解决
        //想法来源于二叉搜索树
        boolean isNodeInTree(TreeNode root,TreeNode node){
            if(root==null || node==null){
                return false;
            }
            if(root==node){
                return true;
            }
            if(isNodeInTree(root.left,node)){
                return true;
            }
            return isNodeInTree(root.right,node);
        }

        public TreeNode lowestCommonAncestor(TreeNode root,
                                             TreeNode p,TreeNode q){
            if(root==null){
                return null;
            }
            //p和q只要有一个在根节点的位置上,则最近公共祖先就是根节点
            if(root==p || root==q){
                return root;
            }

            boolean ispInLeft=false;
            boolean isqInLeft=false;
            boolean ispInRight=false;
            boolean isqInRight=false;

            //检测p是否在root的左子树中
            if(isNodeInTree(root.left,p)){
                ispInLeft=true;
                ispInRight=false;
            }else{
                ispInRight=true;
                ispInLeft=false;
            }

            //检测去是否在root的左子树中
            if(isNodeInTree(root.left,q)){
                isqInLeft=true;
                isqInRight=false;
            }else{
                isqInRight=true;
                isqInLeft=false;
            }

            if(ispInLeft && isqInLeft){
                return lowestCommonAncestor(root.left,p,q);
            }else if(ispInRight && isqInRight){
                return lowestCommonAncestor(root.right,p,q);
            }else{
                return root;
            }
        }
    }

}





