package day20211127;

public class TreeMap<K extends Comparable<K>,V> implements Map<K,V> {
    //二叉搜索树
    public static class TreeNode<K,V>{
        TreeNode left;
        TreeNode right;
        Map.Entry<K,V> kv; //结点中的值域--kv键值对

        public TreeNode(K key,V value){
            kv=new Entry<>();
            kv.key=key;
            kv.value=value;
        }
    }
    TreeNode<K,V> root=null;
    int size=0;

    @Override
    public V put(K key, V value) {
        //如果是空树
        if(root==null){
            root=new TreeNode<>(key, value);
            size=1;
            return value;
        }
        //非空
        //按照二叉搜索树的特性找待插入结点在树中的位置
        TreeNode<K,V> cur=root;
        TreeNode<K,V> parent=null;
        while(cur!=null){
            parent=cur;
            //key,value是带插入键值对
            int rst=key.compareTo(cur.kv.key);
            if(rst>0){
                cur=cur.right;
            }else if(rst<0){
                cur=cur.left;
            }else{
                V oldValue=cur.kv.value;
                cur.kv.value=value;
                return oldValue;
            }
        }
        //插入新结点
        int rst=key.compareTo(parent.kv.key);
        TreeNode<K,V> newNode=new TreeNode<>(key, value);
        if(rst>0){
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
        size++;
        return value;
    }

    @Override
    public V get(K key) {
        TreeNode<K,V> cur=root;
        while(cur!=null){
            int rst=key.compareTo(cur.kv.key);
            if(rst==0){
                return cur.kv.value;
            }else if(rst>0){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return null;
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        V value=get(key);
        return value==null?defaultValue:value;
    }

    @Override
    public V remove(K key) {
        //1.招待删除结点的位置
        TreeNode<K,V> cur=root;
        TreeNode<K,V> parent=null;
        while(cur!=null){
            int rst=key.compareTo(cur.kv.key);
            if(rst<0){
                parent=cur;
                cur=cur.left;
            }else if(rst>0){
                parent=cur;
                cur=cur.right;
            }else{
                break;
            }
        }
        if(cur==null){
            return null;
        }
        V value=cur.kv.value;

        //待删除结点已经找到了
        if(cur.left==null){
            //cur只有右孩子||cur是叶子结点
            if(parent==null){
                //cur是根节点
                root=cur.right;
            }else{
                //cur存在双亲
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    parent.right=cur.right;
                }
            }
            cur.right=null;

        }else if(cur.right==null){
            //cur只有左孩子
            if(parent==null){
                root=cur.left;
            }else{
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }
            cur.left=null;

        }else{
            //cur有左右孩子
            //1.在其右子树中招最小的节点||(在左子树找最大的)来代替根节点
            TreeNode<K,V> delNode=cur.right;
            parent=cur;
            while(delNode.left!=null){
                parent=delNode;
                //找右子树最左边的元素(就是右子树中最小的)
                delNode=delNode.left;
            }
            //2.将替代结点中的值域交给待删除结点cur
            cur.kv=delNode.kv;
            //3.删除
            if(parent.left==delNode){
                parent.left=delNode.right;
            }else{
                parent.right=delNode.right;
            }
        }
        return value;
    }

    @Override
    public boolean containsKey(K key) {
        TreeNode<K,V> cur=root;
        while(cur!=null){
            int rst= key.compareTo(cur.kv.key);
            if(rst==0){
                return true;
            }else if(rst>0){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        //将二叉树整体遍历一遍
        return containsValue(root,value);
    }
    private boolean containsValue(TreeNode<K,V> _root,V value){
        if(_root==null){
            return false;
        }
        if(containsValue(_root.left,value)){
            return true;
        }
        if(value.equals(_root.kv.value)){
            return true;
        }
        return containsValue(_root.right,value);

    }

    @Override
    public int size() {
        return size;
    }
}
