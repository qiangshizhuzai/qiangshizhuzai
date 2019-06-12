package copyComplexList;

public class CopyComplexList {

	// 分治法，分为3步，每一步用一个函数完成相应功能
	public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode cloneHead = null;
        cloneNodes(pHead);
        cloneSiblingNodes(pHead);
        cloneHead = splitAndReconnectNodes(pHead);
        return cloneHead;
    }

	private void cloneNodes(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode cloneNode = new RandomListNode(0);
			// 根据原始链表的每个节点创建对应的新节点
			cloneNode.label = pNode.label;
			cloneNode.next = pNode.next;
			cloneNode.random  = null;
			// 将新节点链接在原始节点的后面
			pNode.next = cloneNode;
			pNode = cloneNode.next;
		}
	}
	
	private void cloneSiblingNodes(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode cloneNode = pNode.next;
			if (pNode.random != null) {
				cloneNode.random = pNode.random.next;
			}
			pNode = cloneNode.next;
		}
	}
	
	private RandomListNode splitAndReconnectNodes(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode pNode = pHead;
		RandomListNode cloneNode = null;
		RandomListNode cloneHead = null;
		
		if(pNode != null) {
			cloneHead = cloneNode = pNode.next;
			pNode.next = cloneNode.next;
			pNode = pNode.next;
			
		}
		
		// 此处的入口pNode为原始链表的第2个节点，cloneNode为复制链表的第一个节点
		while (pNode != null) {
			cloneNode.next = pNode.next;
			cloneNode = cloneNode.next; // 复制链表的当前节点向后移动一个
			pNode.next = cloneNode.next;
			pNode = pNode.next;         // 原始链表的当前节点向后移动一个
		}
		return cloneHead;
	}
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}