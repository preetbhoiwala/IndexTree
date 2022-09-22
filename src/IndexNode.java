import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list;
	
	IndexNode left;
	IndexNode right;
	IndexNode data;

	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int lineNumber) {
		this.list = new ArrayList<>();
		this.occurences = 1;
		this.word = word;
	}
	//occurences





	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){

		return this.word + " " + occurences + " "  + list;
	}

	
	
	
}
