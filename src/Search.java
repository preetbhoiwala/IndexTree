public class Search {
    public static void main(String[] args) {

    }



    public static int search(IndexNode tree, int value, IndexNode root) {

        //if null return 0
        if(tree == null) {
            return 0;
        }


        if(tree.value == value) {

            if(tree.left != null && tree.right != null){
                search(1 + (tree.left), search(tree.middle), search(tree.right));
            } else {
                search((tree.left, value), search(tree.middle, value) + search(tree.right));

            }
        }




        //Return 1 + search(tree.left, value) + search(tree.middle, value) + search(tree.right, value);
        //Else
        //Return search(tree.left, value) + search(tree.middle, value) + search(tree.right, value);
        //
    }
}
