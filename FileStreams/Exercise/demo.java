package Advanced.FileStreams.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int count = Integer.parseInt(scanner.nextLine());
        int index = 0;
        while (participants.size() > 1) {

            for (int i = 0; i < count; i++) {
                if (index == participants.size()) {
                    index = 0;
                }
                index++;

            }
            System.out.println(participants.remove(index - 1));
            if (index > participants.size()) {
                index = 0;
            } else {
                index--;
            }
        }
    }
}
