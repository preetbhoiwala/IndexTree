public class IsFull {

    public static void main(String[] args) {


    }


    public static boolean isFull(IndexNode root) {
        int occur = 0;
        if(root == null) {
            //if empty tree
            return true;

        }  else if (root.left == null && root.right == null) {
            //if leaf nodes
            return true;
        } else if(root.left != null && root.right != null) {
            //if both left and right side full
            return true;
        } else {
            return false;
        }
    }


    //balanced



}



