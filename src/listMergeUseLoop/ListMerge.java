package listMergeUseLoop;

public class ListMerge {

	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode listNodeMerge = null;
		ListNode currentNode = null;
		if (list1 == null && list2 == null) {
			listNodeMerge = null;
		}else if (list1 != null && list2 == null) {
			listNodeMerge = list1;
		}else if (list1 == null && list2 != null) {
			listNodeMerge = list2;
		}else {
			do {
				if (list1.val <= list2.val) {
					if (listNodeMerge == null) {
						currentNode = list1;
						listNodeMerge = currentNode;
					}else {
						currentNode.next = list1;
						currentNode = currentNode.next;
					}
					list1 = list1.next;
				}else {
					if (listNodeMerge == null) {
						currentNode = list2;
						listNodeMerge = currentNode;
					}else {
						currentNode.next = list2;
						currentNode = currentNode.next;
					}
					list2 = list2.next;
				}
			} while (list1 != null && list2 != null);
			
			if (list1 == null) {
				currentNode.next = list2;
			}else {
				currentNode.next = list1;
			}
		}
		
		return listNodeMerge;
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}