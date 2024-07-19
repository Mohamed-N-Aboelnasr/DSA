package Tree;

public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode{

        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int val){
        root = insert(root,val);
    }


    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(val < root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public TreeNode search(int key){
        return search(root,key);
    }

    public TreeNode search(TreeNode root, int key){
        if(root == null || root.data == key)
            return root;
        else if(key < root.data)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public boolean isValid(TreeNode root){
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Long min, Long max){
        if(root == null)
            return true;
        if(root.data >= max || root.data <= min)
            return false;
        boolean left = isValid(root.left, min, (long)root.data);
        if(left){
            boolean right = isValid(root.right, (long)root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);
        System.out.println(bst.root.data);
        bst.inOrder(bst.root);
        System.out.println(bst.isValid(bst.root));
    }
}
