import java.util.HashSet;
import java.util.Set;

public class LeetCode3120 {
//    public int numberOfSpecialChars(String word){
//        int number = 0;
//        Set set = new HashSet<>();
//        for (int index=0; index < word.length(); index++){
//            char current_char = word.charAt(index);
//            // 向后取
//            for (int index_next = index+1; index_next<word.length(); index_next++){
//                char next_char = word.charAt(index_next);
//                if (next_char - current_char == 32 || next_char - current_char==-32){
//                    if(!set.contains(Character.toLowerCase(current_char))){
//                        number += 1;
//                        set.add(Character.toLowerCase(current_char));
//                    }
//                    break;
//                }
//            }
//
//        }
//
//        return number;
//    }

    public int numberOfSpecialChars(String word){
        Set set = new HashSet<>();
        for (char c: word.toCharArray()){
            set.add(c);
        }
        int number = 0;
        for (char c = 'a'; c<='z'; c++){
            if (set.contains(c) && set.contains((char)(c -'a' + 'A'))){
                number += 1;
            }
        }

        return number;
    }

    public static void main(String[] args) {
        LeetCode3120 a = new LeetCode3120();
        String word = "abBCab";
        System.out.println(a.numberOfSpecialChars(word));

    }
}
