import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Mapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, Integer> wordCount = new TreeMap<>();
        for (String word : text.split(" "))
        {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);
    }
}
