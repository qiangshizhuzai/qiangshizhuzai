package printFromTopToBottomUseArrayList;

import java.util.ArrayList;

public class PrintFromTopToBottom {

	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();   // 用于存放层序遍历的树的节点的值
        ArrayList<TreeNode> arrayList2 = new ArrayList<>();  // 用于依次存放层序遍历的所有节点
        ArrayList<TreeNode> arrayList3 = new ArrayList<>();  // 用于临时存放层序遍历的每一层的节点 
        Boolean isLastLevel = false;                         // 初始默认未到树的最上层
        int levelTreeNodeNum = 0;// levelTreeNodeNum用于表示每一次层节点循环时，
                                 // 该层节点在arrayList2中的起始位置
        
        if (root == null) {
			return arrayList1;   // 注意：此处若返回null(空引用)，arrayList1中为null；
			                     // 若返回arraylist1，其结果为动态数组初始化的值[](空的arrayList)。
		}
        
        // 对于根节点
        arrayList2.add(root);
        arrayList3.add(root);
        levelTreeNodeNum += arrayList3.size();   // levelTreeNodeNum = 1
        
        // while循环体，循环条件为：未达到树的最高层
        while (! isLastLevel) {
        	// 对arrayList3中的每一个元素进行遍历
			for (int i = 0; i < arrayList3.size(); i++) {
				if (arrayList3.get(i).left != null) {
					arrayList2.add(arrayList3.get(i).left);
				}
				if (arrayList3.get(i).right != null) {
					arrayList2.add(arrayList3.get(i).right);
				}
			}
			arrayList3.clear();   // 遍历结束后，清空arrayList3，用于下一层节点的存储
			// arrayList3中存放下一层中的所有节点
			arrayList3.addAll(arrayList2.subList(levelTreeNodeNum, arrayList2.size()));
			levelTreeNodeNum += arrayList3.size();// 更新下一层节点在arrayList2中的位置levelTreeNodeNum
			// 若下层节点为空，说明到达了最高层，跳出while循环
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