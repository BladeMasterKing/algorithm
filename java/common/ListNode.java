package common;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode generate(int[] arrays){
        Map<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i< arrays.length; i++){
            ListNode newNode = new ListNode(arrays[i]);
            map.put(i, newNode);
            ListNode last = map.get(i-1);
            if (last != null){
                last.next = newNode;
            }
        }
        return map.get(0);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        ListNode next = this;
        sb.append(next.val);

        while (next.next != null){
            next = next.next;
            sb.append(next.val);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
