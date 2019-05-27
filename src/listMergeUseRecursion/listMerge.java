package listMergeUseRecursion;

public class listMerge {

	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode listNodeMerge = null;

		if (list1 == null && list2 == null) {
			listNodeMerge = null;
		}else if (list1 != null && list2 == null) {
			listNodeMerge = list1;
		}else if (list1 == null && list2 != null) {
			listNodeMerge = list2;
		}else {
			if (list1.val <= list2.val) {
				listNodeMerge = list1;
				listNodeMerge.next = Merge(list1.next, list2);
						
			} else {

				listNodeMerge = list2;
				listNodeMerge.next = Merge(list1, list2.next);
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

