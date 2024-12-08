class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int data){
        this.data = data;
    }
}
class Tree{
    TreeNode root = null;
    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            TreeNode temp = root;
            TreeNode parent = null;
            while (temp != null) {
                parent = temp;
                if (data <= temp.data) {
                    temp = temp.left;
                } else if (data > temp.data) {
                    temp = temp.right;
                }
            }
            if (data < parent.data) {
                parent.left = new TreeNode(data);
            } else {
                parent.right = new TreeNode(data);
            }
        }
    }
    public void delete(int data) {
        TreeNode parent = null;
        TreeNode temp = root;
        while (temp != null && temp.data != data) {
            parent = temp;
            if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (temp == null) {
            return; // 没有找到值
        }
        // 情况1：没有子节点（叶子节点）
        if (temp.left == null && temp.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == temp) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // 情况2：有一个子节点
        else if (temp.left == null || temp.right == null) {
            TreeNode onlyChild = temp.left != null ? temp.left : temp.right;
            if (parent == null) {
                root = onlyChild;
            } else if (parent.left == temp) {
                parent.left = onlyChild;
            } else {
                parent.right = onlyChild;
            }
        }
        else {
            TreeNode successorParent = temp;
            TreeNode successor = temp.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            // 找到后继的值
            int successorValue = successor.data;
            // 删除后继节点（因为它是有两个子节点的节点）
            delete(successorValue);
            // 用后继的值替换被删除的节点
            temp.data = successorValue;
        }
    }
    public void update(int oldData, int newData) {
            TreeNode temp = root;
            TreeNode parent = null;
            while (temp != null && temp.data != oldData) {
                parent = temp;
                if (oldData < temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (temp == null) {
                System.out.println("Element not found.");
                return;
            }
            temp.data = newData;
    }
    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.data); // 访问根节点
            preOrderTraversal(root.left); // 遍历左子树
            preOrderTraversal(root.right); // 遍历右子树
        }
    }
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left); // 遍历左子树
            System.out.println(root.data); // 访问根节点
            inOrderTraversal(root.right); // 遍历右子树
        }
    }
    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left); // 遍历左子树
            postOrderTraversal(root.right); // 遍历右子树
            System.out.println(root.data); // 访问根节点
        }
    }
}

class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(50);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(10);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(120);
        tree.delete(50);
        tree.update(20,30);
        System.out.println("PreOrder traversal:");
        tree.preOrderTraversal(tree.root); // 先序遍历

        System.out.println("\nInOrder traversal:");
        tree.inOrderTraversal(tree.root); // 中序遍历

        System.out.println("\nPostOrder traversal:");
        tree.postOrderTraversal(tree.root); // 后序遍历
    }
}
