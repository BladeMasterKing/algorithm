import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode3121 {
//    public int numberOfSpecialChars(String word){
//        Set set = new HashSet();
//        for (char c: word.toCharArray()){
//            set.add(Character.toLowerCase(c));
//        }
//        Iterator iterator = set.iterator();
//        for (; iterator.hasNext();) {
//            char current_char = (char)iterator.next();
//            System.out.print(current_char + " ");
//
//            int last_lower_index = -1;
//            int first_upper_index = -1;
//            for (int i=0;i<word.length();i++){
//                char c = word.charAt(i);
//                if (c == current_char){
//                    last_lower_index = i;
//                    continue;
//                }
//                if ((int)c == (int)(current_char - 32) && first_upper_index == -1){
//                    first_upper_index = i;
//                }
//            }
//            System.out.println("last_lower_index: " + last_lower_index + " first_upper_index: " +first_upper_index);
//            if(last_lower_index >= first_upper_index || last_lower_index == -1 || first_upper_index == -1){
//                iterator.remove();
//            }
//        }
//        System.out.println("删除后的集合：" + set);
//        return set.size();
//    }

    public int numberOfSpecialChars(String word){
        int number = 0;
        for (char c = 'a'; c <= 'z'; c++){
            int u = word.indexOf(Character.toUpperCase(c));
            int l = word.lastIndexOf(c);
            System.out.println(c + " upper: "+ u + " lower: "+ l);
            if (l < u && u != -1 && l != -1){
                number ++;
            }
        }
        return number;
    }
    public static void main(String[] args) {
        LeetCode3121 o = new LeetCode3121();
        int number = o.numberOfSpecialChars("AbBCab");
        System.out.println(number);
//        char a = 'A';
//        System.out.println((int)a);
    }
}
