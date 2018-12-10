package ps.philo.playground;

/**
 * CommonStructure contains all kinds of class
 *
 * @author philo
 * @create 2018-03-27 9:31 AM
 **/
public class CommonStructure {
    public static class ListNode<T>{
        public T value;
        public ListNode<T> next;
        public ListNode(T data){
            value = data;
        }
    }

    public static class TreeNode<T>{
        public T value;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public TreeNode(T v, TreeNode l, TreeNode r){
            this.value = v;
            this.left = l;
            this.right = r;
        }
    }
}
