package printFromTopToBottomUseArrayList;

import java.util.ArrayList;

public class PrintFromTopToBottom {

	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();   // ���ڴ�Ų�����������Ľڵ��ֵ
        ArrayList<TreeNode> arrayList2 = new ArrayList<>();  // �������δ�Ų�����������нڵ�
        ArrayList<TreeNode> arrayList3 = new ArrayList<>();  // ������ʱ��Ų��������ÿһ��Ľڵ� 
        Boolean isLastLevel = false;                         // ��ʼĬ��δ���������ϲ�
        int levelTreeNodeNum = 0;// levelTreeNodeNum���ڱ�ʾÿһ�β�ڵ�ѭ��ʱ��
                                 // �ò�ڵ���arrayList2�е���ʼλ��
        
        if (root == null) {
			return arrayList1;   // ע�⣺�˴�������null(������)��arrayList1��Ϊnull��
			                     // ������arraylist1������Ϊ��̬�����ʼ����ֵ[](�յ�arrayList)��
		}
        
        // ���ڸ��ڵ�
        arrayList2.add(root);
        arrayList3.add(root);
        levelTreeNodeNum += arrayList3.size();   // levelTreeNodeNum = 1
        
        // whileѭ���壬ѭ������Ϊ��δ�ﵽ������߲�
        while (! isLastLevel) {
        	// ��arrayList3�е�ÿһ��Ԫ�ؽ��б���
			for (int i = 0; i < arrayList3.size(); i++) {
				if (arrayList3.get(i).left != null) {
					arrayList2.add(arrayList3.get(i).left);
				}
				if (arrayList3.get(i).right != null) {
					arrayList2.add(arrayList3.get(i).right);
				}
			}
			arrayList3.clear();   // �������������arrayList3��������һ��ڵ�Ĵ洢
			// arrayList3�д����һ���е����нڵ�
			arrayList3.addAll(arrayList2.subList(levelTreeNodeNum, arrayList2.size()));
			levelTreeNodeNum += arrayList3.size();// ������һ��ڵ���arrayList2�е�λ��levelTreeNodeNum
			// ���²�ڵ�Ϊ�գ�˵����������߲㣬����whileѭ��
			if (arrayList3.isEmpty()) {
				isLastLevel = true;
			}
		}
        
        for (int i = 0; i < arrayList2.size(); i++) {
			arrayList1.add(arrayList2.get(i).val);
		}

        return arrayList1;
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