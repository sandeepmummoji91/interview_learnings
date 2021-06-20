import java.util.*;

public class TwoSumProblem {

    Map<Integer, Integer> storage = new HashMap<>();
    Map<Integer, Integer> result = new HashMap<>();

    public Map<Integer, Integer> getAll(int[] numbersArray, int target) {
        for (int i = 0; i < numbersArray.length; i++) {
            if (storage.containsKey(target - numbersArray[i])) {
                // result.put(i, storage.get(target - numbersArray[i])); // returns indexes
                result.put(numbersArray[i], numbersArray[storage.get(target - numbersArray[i])]); // returns values
            }
            storage.put(numbersArray[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] problemArray = {3, 4, 1, 5, 9, 6, 2};
        TwoSumProblem ts = new TwoSumProblem();
        ts.getAll(problemArray, 7).entrySet().forEach(System.out::println);
    }

}
