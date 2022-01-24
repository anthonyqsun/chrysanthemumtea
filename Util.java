// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

import java.util.ArrayList;

public class Util {
    public static ArrayList<String> split(String input, String delimiter) {
        ArrayList<String> splits = new ArrayList<>();
        while (input.indexOf(delimiter) != -1) {
            splits.add(input.substring(0, input.indexOf(delimiter)));
            input = input.substring(input.indexOf(delimiter) + 1);
        }
        splits.add(input);
        return splits;
    }

    public static String wrap(String string, int maxLength, String initial_indent, String subsequent_indent) {
        ArrayList<String> words = split(string, " ");

        String wrappedString = "";
        String curLine = initial_indent;

        for (String word : words) {
            if (curLine.length() + word.length() + 1 < maxLength) {
                curLine = curLine + word + " ";
            } else {
                wrappedString = wrappedString + curLine + "\n";
                curLine = subsequent_indent + word + " ";
            }
        }

        wrappedString += curLine;

        return wrappedString;
    }

    public static boolean contains(String input, String target) {
        for (int i = 0; i < input.length()-target.length()+1; i++) {
            if (input.substring(i, i+target.length()).equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static long currentTimeEST() {
        return (System.currentTimeMillis()-18_000_000) % Long.parseLong("86400000"); // 18 million millis in 5 hours: UTC -> EST
    }
}
