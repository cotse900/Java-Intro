/**********************************************
 Workshop 9
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 5 Apr 2023
 **********************************************/
package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Find out edit distance
 */
public class EditDistance {
    /**
     * Constructor
     */
    public EditDistance(){}
    /**
     * main
     * @param args  args
     */
    public static void main(String[] args) {
        //read file
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program uses a dictionary to compute the edit distances between pairs of words.\n");
        System.out.print("What is the dictionary file? ");
        String dictionaryFile = scanner.nextLine();

        Set<String> dictionary = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        //input first word and second word
        while (true) {
            System.out.println("\nLet's find an edit distance between words.");
            System.out.print("\tfirst word (enter to quit)? ");
            String start = scanner.nextLine().toLowerCase();
            if (start.isEmpty()) {
                break;
            }
            if (!dictionary.contains(start)) {
                System.out.println(start + " is not in the dictionary");
                continue;
            }
            System.out.print("\tsecond word? ");
            String end = scanner.nextLine().toLowerCase();
            if (!dictionary.contains(end)) {
                System.out.println(end + " is not in the dictionary");
                continue;
            }
            //initialize WordList (word, leading word)
            Map<String, String> WordList = new HashMap<>();
            WordList.put(start, null);
            //queue to hold words
            Queue<String> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                String current = queue.remove();
                if (current.equals(end)) {
                    break;
                }
                //obtain intermediate words for each current word
                for (String NextWord : GetIntermediate(current, dictionary)) {
                    if (!WordList.containsKey(NextWord)) {
                        WordList.put(NextWord, current);
                        queue.add(NextWord);
                    }
                }
            }

            if (!WordList.containsKey(end)) {
                System.out.println("No path found between " + start + " and " + end);
            }
            else {//if path found, print it and report edit distance
                List<String> path = new ArrayList<>();
                for (String current = end; current != null; current = WordList.get(current)) {
                    path.add(current);
                }
                Collections.reverse(path);
                System.out.println(String.join(", ", path));
                System.out.println("Edit distance = " + (path.size() - 1));
            }
        }
    }

    /**
     * get intermediate
     * @param word      word
     * @param source    dictionary
     * @return          neighbours
     */
    private static List<String> GetIntermediate(String word, Set<String> source) {
        List<String> neighbours = new ArrayList<>();
        for (int n = 0; n < word.length(); n++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String neighbour = word.substring(0, n) + c + word.substring(n + 1);
                if (source.contains(neighbour) && !neighbour.equals(word)) {
                    neighbours.add(neighbour);
                }
            }
        }
        return neighbours;
    }
}
