import java.util.Scanner;

public class CheckHeight {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }
    public static int getSize(IndexNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getSize((root.left)), getSize(root.right) + 1);
//        int leftCount = 0;
//        int rightCount = 0;
//        if(root != null) {
//            if(root.left != null) {
//                leftCount += 1;
//
//            } if (root.right != null) {
//                rightCount += 1;
//            }
//
//
//        }
//        return leftCount + rightCount;


    }



    public static int getHeight(IndexNode root) {
        if(root == null) {
            return 0;

       }

        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);

//        if(leftHeight > rightHeight) {
//            System.out.println(leftHeight);
//    } else {
//            System.out.println(rightHeight);
//        }
//
   }
    public static boolean isBalanced(IndexNode root) {
        if(root == null){
            return true;
            //if only root exists tree is balanced
        }
        int leftHeight =getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // get height of the left and right subtrees
        //check if height are equal and return
        return ((leftHeight - rightHeight) < 2) && ((rightHeight - leftHeight) < 2);
    }




}
