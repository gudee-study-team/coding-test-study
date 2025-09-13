package d250604.b1181;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리
        Set<String> wordSet = new HashSet<>();
        
        for (int i = 0; i < num; i++) {
            wordSet.add(sc.nextLine());
        }
        
        // 로직
        List<String> wordList = new ArrayList<>(wordSet);
        
        // 길이 오름차순 -> 사전순 정렬
        wordList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전순
            } else {
                return Integer.compare(o1.length(), o2.length()); // 길이 오름차순
            }
        });
        
        // 출력
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}