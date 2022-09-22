import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {
	public static void main(String[] args){

		// add all the words to the tree
		String fileName = "pg100.txt";
		int linenumber =0;
		IndexTree tree =  new IndexTree();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				linenumber++;
				line = line.replaceAll(",", "");
				String[] words = line.split("\\s+"); //scan each line and turn it into individual words
				for(String word: words) { //for each word in the words list
					//word = word.replaceAll(":", ""); //getting rid of colon
					word = word.replaceAll("[^\\w\\s']", ""); //getting rid of commas
					tree.add(word,linenumber);


				}
			}
			scanner.close();


		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}





		// print out the index
		tree.printIndex();
		tree.delete("zwagger'd");
		tree.printIndex();

		// test removing a word from the index


	}
	// --------------------------------------------------------------------------------------------------

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	//----------------------------------------------------------------------------------------------------
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree() {

		//root of entire tree

	}
	//----------------------------------------------------------------------------------------------------
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(this.root, word, lineNumber);
		//adding word to the root and set up root symmetrically

	}
	//----------------------------------------------------------------------------------------------------

	// your recursive method for add
	// Think about how this is slightly different from the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null) {
			//if root of subtree is null, we found a place to put the node
			IndexNode newnode = new IndexNode(word,lineNumber);
			newnode.list.add(lineNumber);
			return newnode;
		} else {
			//checking duplicates
			int comparison = word.compareTo(root.word);
			if(comparison == 0) {
				root.list.add(lineNumber);
				root.occurences++;
				return root;
			}
			else if(comparison < 0) {
				root.left = this.add(root.left, word, lineNumber);
				return root;

			} else {
				root.right = this.add(root.right, word, lineNumber);
				return root;
			}
		}

	}
	//--------------------------------------------------------------------------------------------------
	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(root, word);
	}


	private boolean contains(IndexNode root, String word) {
		if(root == null) {
			return false;
			//if current node doesn't exist, stop
			// to avoid null point exception

		}

		int comparison = word.compareTo(root.word);
		if(comparison == 0) {
			return true;
		} else if (comparison < 0) {
			//recursively search left tree
			return contains(root.left, word);
		} else {
			////recursively search left tree
			return contains(root.right, word);
		}


	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = this.delete(this.root, word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word) {
		//deleting from tree
		if (root == null) {
			return null;
		}
		int comparison = word.compareTo(root.word);
		if (comparison < 0) {
			root.left = delete(root.left, word);
			return root;
		} else if (comparison > 0) {
			root.right = delete(root.right, word);
			return root;
		} else {
			//checking for leaf (if there is no left or right to it then no children)
			if (root.left == null && root.right == null) {
				return null; //no children --> remove null

			} else if (root.left != null && root.right == null) {
				//if one child (on left)
				return root.left;

			} else if (root.right != null && root.left == null) {
				//if one child (on right)
				return root.right;
			} else {
				IndexNode current = root.left; //
				while (current.right != null) {
					current = current.right;
				}

				root.word = current.word;
				root.occurences = current.occurences;
				root.list = current.list;
				root.left = delete(root.left, root.word);
				return root;

			}

		}
	}
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences

	public void printIndex(){
		printIndex(root);
	}
	// each word and its data gets its own line
	public void printIndex(IndexNode root){
		if(root == null) {
			return;
		}
			printIndex(root.left);
			System.out.println(root);
			printIndex(root.right);

		}


	}
