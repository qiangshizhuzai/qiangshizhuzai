package reverseList;

public class ReverseList {

	   public static ListNode reverseList(ListNode head) {

		   ListNode newHead = null;
		   ListNode preNode = null;
		   ListNode pNode = head;
		   
		   if (head == null) {
			   return null;
		   }
		   
		   while (pNode != null) {
			
			   ListNode pNext = pNode.next;// pNext�洢ԭ˳����pNode����һ���ڵ�
			   if (pNext == null) {
				   newHead = pNode;
			   }
			   pNode.next = preNode; // ָ�뷴ת��pNode����һ���ڵ��Ϊ����ǰһ���ڵ�
			   preNode = pNode;      // preNode����ƶ�һ���ڵ�
			   pNode = pNext;        // pNode����ƶ�һ���ڵ�
		   }
		   return newHead;
	   }

	   // ���Գ���
	   public static ListNode test(ListNode head) {
		   System.out.println("The original list is: ");
		   ListNode pNode = head;
		   while (pNode != null) {
			
			   System.out.println(pNode.val);
			   pNode = pNode.next;
		   }
		   ListNode pReversedHead = reverseList(head);
		   System.out.println("The reverseList is: ");
		   ListNode p_Node = pReversedHead;
		   while (p_Node != null) {
			   System.out.println(p_Node.val);
			   p_Node = p_Node.next;
		   }
		   return pReversedHead;
	   }
	   
	   // ���ڵ����
	   public static void test1() {
		   ListNode pNode1 = new ListNode(1);
		   test(pNode1);
	   }
	   
	   // ��ڵ����
	   public static void test2() {
		   ListNode pNode1 = new ListNode(1);
		   ListNode pNode2 = new ListNode(2);
		   ListNode pNode3 = new ListNode(3);
		   ListNode pNode4 = new ListNode(4);
		   ListNode pNode5 = new ListNode(5);
		   
		   pNode1.next = pNode2;
		   pNode2.next = pNode3;
		   pNode3.next = pNode4;
		   pNode4.next = pNode5;
		   pNode5.next = null;
		   
		   test(pNode1);
		   
	   }
	   
	   // �սڵ�����
	   public static void test3() {
		   test(null);
	   }
	   
	   public static void main(String[] args) {
		   test1();
		   System.out.println("--------------------------------------------------------");
		   test2();
		   System.out.println("--------------------------------------------------------");
		   test3();

	   }
	   
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}