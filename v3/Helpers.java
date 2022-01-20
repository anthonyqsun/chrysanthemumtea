// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

import java.util.ArrayList;

public class Helpers {
    public static ArrayList<String> split(String input, String delimiter) {
        ArrayList<String> splits = new ArrayList<>();
        while (input.indexOf(delimiter) != -1) {
            splits.add(input.substring(0, input.indexOf(delimiter)));
            input = input.substring(input.indexOf(delimiter) + 1);
        }
        splits.add(input);
        return splits;
    }
}