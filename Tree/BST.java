package Tree;
import Tree.TreeTraversal.*;
public class BST {
    static BinaryTree btree = new BinaryTree();
    public static Node insert(Node root, int val){
        Node node = new Node(val);
        if(root == null) return node;
        if(root.data > val) root.left = insert(root.left, val);
        else if(root.data < val) root.right = insert(root.right, val);
        return root;
    }
    static Node buildBST(int[] arr){
        Node root = null;
        for(int i = 0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }
        return root;
    }

    static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.data == key) return true;

        if(root.data < key) return search(root.right, key);
        else return search(root.left, key);
    }
    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2,7};
        Node root = buildBST(arr);

        btree.inOrder(root);
        System.out.println();
        System.out.println(search(root, 8));
    }
}
