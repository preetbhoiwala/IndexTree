import java.util.HashMap;
import java.util.Map;

public class FindMostCommon {
    public static void main(String[] args) {

    }

    public static char mostCommonChar(String text) {

        Map<Character, Integer> counts = new HashMap<>();

        for (char c : text.toCharArray()) {
            //for each character in string
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
                //
            } else {
                int prevCount = counts.get(c);
                counts.put(c, prevCount + 1);
            }
        }

        int hasMostCount = 0;
        char hasMostCommonLetter = 0;
        // get count of most letter and compare
        for (Character character : counts.keySet()) {
            int count = counts.get(character);

            if (count > hasMostCount) {
                hasMostCount = count;
                hasMostCommonLetter = character;
            }


        }
        return hasMostCommonLetter;

    }
}
