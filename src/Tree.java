import javax.swing.tree.TreeNode;

public class Tree<T> implements Iterable<TreeNode<T>> {

        T data;
        TreeNode<T> parent;
        List<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
            this.children = new LinkedList<TreeNode<T>>();
        }

        public TreeNode<T> addChild(T child) {
            TreeNode<T> childNode = new TreeNode<T>(child);
            childNode.parent = this;
            this.children.add(childNode);
            return childNode;
        }

        // other features ...

}