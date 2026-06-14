import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2130 {
    public int pairSum(ListNode head) {
        List list = new ArrayList();
        list.add(head.val);
        while (head.next != null){
            head = head.next;
            list.add(head.val);
        }
        int sum = 0;
        for (int i=0;i< list.size()/2;i++){
            int s = (int)list.get(i) + (int)list.get(list.size()-1-i);
            sum = Math.max(s, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arrays = {4,2,2,3};
        ListNode head = new ListNode().generate(arrays);
        System.out.println(head);


        LeetCode2130 o = new LeetCode2130();
        System.out.println(o.pairSum(head));
    }
}
