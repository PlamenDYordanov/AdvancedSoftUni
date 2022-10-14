package Advanced.Exam_February_2022_03;



import java.util.*;

public class P01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> foodMap = new LinkedHashMap<>();
        foodMap.put("pear", new ArrayList<>());
        foodMap.put("flour", new ArrayList<>());
        foodMap.put("pork", new ArrayList<>());
        foodMap.put("olive", new ArrayList<>());

        for (Map.Entry<String, List<String>> entry : foodMap.entrySet()) {
            String[] key = entry.getKey().split("");
            for (int food = 0; food < entry.getKey().length(); food++) {
                entry.getValue().add(key[food]);
            }
        }

        String[] vowel = scanner.nextLine().split("\\s+");
        String[] consonant = scanner.nextLine().split("\\s+");
        ArrayDeque<String> vowelQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantStack = new ArrayDeque<>();

        for (String letter : vowel) {
            vowelQueue.offer(letter);
        }
        for (String letter : consonant) {
            consonantStack.push(letter);
        }
        while (!vowelQueue.isEmpty() && !consonantStack.isEmpty()) {

            String currentVowel = vowelQueue.poll();
            String currentConsonant = consonantStack.pop();
            for (Map.Entry<String, List<String>> entry : foodMap.entrySet()) {
                if (entry.getValue().contains(currentConsonant)) {
                    entry.getValue().remove(currentConsonant);
                }
                if (entry.getValue().contains(currentVowel)) {

                    entry.getValue().remove(currentVowel);
                }
            }
            vowelQueue.addLast(currentVowel);
        }
        int size = 0;
        List<String> food = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : foodMap.entrySet()) {
            if (entry.getValue().size()==0){
                size++;
                food.add(entry.getKey());
            }
        }
        System.out.printf("Words found: %d%n", size);
        for (String curFood : food) {
            System.out.println(curFood);
        }

    }
}
