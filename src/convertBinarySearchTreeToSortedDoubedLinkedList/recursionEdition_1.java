package convertBinarySearchTreeToSortedDoubedLinkedList;

import java.util.ArrayList;

public class recursionEdition_1 {

	public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode doubleLinkedListHead = null;
        ArrayList<TreeNode> arrayList = new ArrayList<>(); // 用于陆续存放有序节点
        ArrayList<TreeNode> arr = new ArrayList<>();       // 用于存放最终排序好的有序节点
        if (pRootOfTree == null) {
			return null;
		}
        
        arr =  inOrderTraverse(arrayList,pRootOfTree);
        /*
         *  双向有序链表的指针方向定义
         */
        
        // 向后方向的指针定义
        for (int i = 0; i < arr.size() - 1; i++) {
			arr.get(i).right = arr.get(i + 1) ;
		}
        // 向前方向的指针定义
        for (int i = arr.size() - 1; i > 0; i--) {
			arr.get(i).left = arr.get(i - 1);
		}

        // 双向链表的头结点，也就是动态数组的第一个节点
        doubleLinkedListHead = arr.get(0);
        return doubleLinkedListHead;
    }

	// 注意此处中序遍历的递归写法，形参中arrayList的初始值为[],即长度为0的动态数组
	private ArrayList<TreeNode> inOrderTraverse(ArrayList<TreeNode> arrayList, TreeNode pRootOfTree) {

		// 用于处理输入为空树的特殊情形，也作为递归的结束条件
        if (pRootOfTree == null) {
            return arrayList;
        }
        inOrderTraverse(arrayList,pRootOfTree.left); // 遍历左子树
        arrayList.add(pRootOfTree);                  // 添加根节点
        inOrderTraverse(arrayList,pRootOfTree.right);// 遍历右子树
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