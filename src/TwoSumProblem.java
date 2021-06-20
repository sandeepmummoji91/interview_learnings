import java.util.*;

public class TwoSumProblem {

    static int[] numbersArray = {2, 4, 1, 5, 9, 6, 3};
    static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) {
        int target = 7;
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i = 0; i < numbersArray.length; i++) {
            if (storage.containsKey(target - numbersArray[i])) {
                result.put(numbersArray[i], numbersArray[storage.get(target - numbersArray[i])]); // Gives values
            }
            storage.put(numbersArray[i], i);
        }
        result.entrySet().forEach(System.out::println);
    }

}
