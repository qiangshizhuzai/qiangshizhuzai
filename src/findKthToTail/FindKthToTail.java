package findKthToTail;

public class FindKthToTail {

	public ListNode findKthToTail(ListNode head,int k) {
		ListNode KthToTailNode = null;
		ListNode currentNode = head;
		int count = 1;
		
		if (head == null) {
			return null;
		}
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			count++;
		}

		if (count < k) {
			KthToTailNode = null;
		}else {
			currentNode = head;
			for (int i = 0; i < count - k; i++) {
				currentNode = currentNode.next;
			}
			KthToTailNode = currentNode;
		}
		return KthToTailNode;
    }
	
	
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}