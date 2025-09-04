public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode dummy = new ListNode(0);
        ListNode current0 = dummy;
        ListNode current1 = list1;
        ListNode current2 = list2;
        if (list1 == null && list2 != null){
            return list2;
        }
        if (list1 != null && list2 == null ) {
            return list1;
        }
        while (current1 != null && current2 != null){
            if (current1.val >= current2.val){
                current0.next = new ListNode(current2.val);
                current0 = current0.next;
                current2 = current2.next;
            }
            else {
                current0.next =  new ListNode(current1.val);
                current0 = current0.next;
                current1 = current1.next;
            }
        }


        return dummy.next;
    }
}