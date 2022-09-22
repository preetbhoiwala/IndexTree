//import javax.swing.tree.TreeNode;
//import java.util.LinkedList;
//
//public class Gudsq {
//
//    public static void main(String[] args) {
//
//    }
//    private static class Node<E> {
//       IndexNode left;
//        IndexNode right;
//        IndexNode data;
//
//
//
//
//
//        //Write a method that takes the root of a binary search tree or subtree and returns a Linked List
//        // containing all the data stored in the tree in in-order.
//
//        public static <E> LinkedList<E> gudsq(IndexNode root, LinkedList<E> inOrderList) {
//            LinkedList<E> emptyList = new LinkedList<E>();
//
//            if(root == null) {
//                return emptyList;
//            } else {
//                gudsq(root.left, inOrderList);
//                inOrderList.add(root.data);
//                gudsq(root.right, inOrderList);
//                inOrderList.add(root.data);
//
//
//            }
//            return inOrderList;
//
//
//
//        }
//
//
//
//
//
//
//
////gudsq(root, list);
////Return list;
////}
////
////Private static <E> void gudsq(TreeNode<E> root, LinkedList<E> list){
////if(root != null){
////gudsq(root.left, list);
////list.add(root.data);
////gudsq(root.right, list);
////}
