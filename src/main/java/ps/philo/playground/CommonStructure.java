package ps.philo.playground;

import java.util.ArrayDeque;
import java.util.Queue;

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
        public int depth = 0;
        public TreeNode(T v, TreeNode l, TreeNode r){
            this.value = v;
            this.left = l;
            this.right = r;
        }

        public TreeNode(T v, TreeNode l, TreeNode r, int d){
            this(v, l, r);
            this.depth = d;
        }

        @Override
        public String toString() {
            Queue<TreeNode<T>> nodes = new ArrayDeque<>();
            StringBuilder builder = new StringBuilder();
            nodes.add(this);
            while (!nodes.isEmpty()){
                TreeNode<T> curNode = nodes.poll();
                builder.append("  ").append(curNode.value).append("  -- ").append(curNode.depth)
                        .append("\n");
                addToQueue(nodes,curNode.left);
                addToQueue(nodes,curNode.right);
            }
            return builder.toString();
        }

        private TreeNode<T> printWhiteSpace(StringBuilder builder, int count){
            for (int i = 0; i < count; i++) {
                builder.append(" ");
            }
            return this;
        }

        private <T> void addToQueue(Queue<TreeNode<T>> queue, TreeNode<T> item){
            if(item != null){
                queue.add(item);
            }
        }

        private String preOrderTraversal(TreeNode<T> root){
            StringBuilder builder = new StringBuilder();
            if(root != null){
                builder.append(root.value);
                builder.append(preOrderTraversal(root.left));
                builder.append(preOrderTraversal(root.right));
            }
            return builder.toString();
        }

        private String deepFirst(){
            StringBuilder builder = new StringBuilder();
            if(left == null && right == null){
                builder.append(value);
            }
            else if(left != null && right == null) {
                builder.append("  ").append(value).append("  ")
                        .append("\n")
                        .append(" ").append("/").append(" ").append(" ").append(" ")
                        .append("\n")
                        .append(left.toString()).append("   ").append(" ");
            }
            else if(left == null && right != null){
                builder.append("  ").append(value).append("  ")
                        .append("\n")
                        .append(" ").append(" ").append(" ").append("\\").append(" ")
                        .append("\n")
                        .append(" ").append("   ").append(right.toString());
            }
            else {
                builder.append("  ").append(value).append("  ")
                        .append("\n")
                        .append(" ").append("/").append(" ").append("\\").append(" ")
                        .append("\n")
                        .append(left.toString()).append("   ").append(right.toString());
            }
            return builder.toString();
        }
    }


}
