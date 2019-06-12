package copyComplexList;

public class CopyComplexList {

	// ���η�����Ϊ3����ÿһ����һ�����������Ӧ����
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
			// ����ԭʼ�����ÿ���ڵ㴴����Ӧ���½ڵ�
			cloneNode.label = pNode.label;
			cloneNode.next = pNode.next;
			cloneNode.random  = null;
			// ���½ڵ�������ԭʼ�ڵ�ĺ���
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
		
		// �˴������pNodeΪԭʼ����ĵ�2���ڵ㣬cloneNodeΪ��������ĵ�һ���ڵ�
		while (pNode != null) {
			cloneNode.next = pNode.next;
			cloneNode = cloneNode.next; // ��������ĵ�ǰ�ڵ�����ƶ�һ��
			pNode.next = cloneNode.next;
			pNode = pNode.next;         // ԭʼ����ĵ�ǰ�ڵ�����ƶ�һ��
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