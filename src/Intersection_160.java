public class Intersection_160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 0, lenB = 0;
        ListNode temp = headA;
        while (temp != null) {
            ++lenA;
            temp = temp.next;
        }


        temp = headB;
        while (temp != null) {
            ++lenB;
            temp = temp.next;
        }

        int diff;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            diff = lenB - lenA;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }


        while (headA != null && headB != null) {
            if(headA==headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
