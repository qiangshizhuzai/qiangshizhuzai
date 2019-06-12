package convertBinarySearchTreeToSortedDoubedLinkedList;

import java.util.ArrayList;

public class recursionEdition_1 {

	public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode doubleLinkedListHead = null;
        ArrayList<TreeNode> arrayList = new ArrayList<>(); // ����½���������ڵ�
        ArrayList<TreeNode> arr = new ArrayList<>();       // ���ڴ����������õ�����ڵ�
        if (pRootOfTree == null) {
			return null;
		}
        
        arr =  inOrderTraverse(arrayList,pRootOfTree);
        /*
         *  ˫�����������ָ�뷽����
         */
        
        // ������ָ�붨��
        for (int i = 0; i < arr.size() - 1; i++) {
			arr.get(i).right = arr.get(i + 1) ;
		}
        // ��ǰ�����ָ�붨��
        for (int i = arr.size() - 1; i > 0; i--) {
			arr.get(i).left = arr.get(i - 1);
		}

        // ˫�������ͷ��㣬Ҳ���Ƕ�̬����ĵ�һ���ڵ�
        doubleLinkedListHead = arr.get(0);
        return doubleLinkedListHead;
    }

	// ע��˴���������ĵݹ�д�����β���arrayList�ĳ�ʼֵΪ[],������Ϊ0�Ķ�̬����
	private ArrayList<TreeNode> inOrderTraverse(ArrayList<TreeNode> arrayList, TreeNode pRootOfTree) {

		// ���ڴ�������Ϊ�������������Σ�Ҳ��Ϊ�ݹ�Ľ�������
        if (pRootOfTree == null) {
            return arrayList;
        }
        inOrderTraverse(arrayList,pRootOfTree.left); // ����������
        arrayList.add(pRootOfTree);                  // ��Ӹ��ڵ�
        inOrderTraverse(arrayList,pRootOfTree.right);// ����������
        return arrayList;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}