package findCertainPathInBinaryTreeUseArrayList;

import java.util.ArrayList;

public class FindCertainPathInBinaryTree {

	/*
	 * 1.使用递归的方法，讨论空节点，一个根节点，根节点只有左子树，根节点只有右子树，
	 *   根节点既有左子树又有右子树的多种情况
	 * 2.注意此处泛型ArrayList<ArrayList<Integer>>
	 */
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// 根节点为空的情况
		 if (root == null) {
			 System.out.println(arrayList);
			return arrayList;
		}
		 
		 // 根节点非空
		 ArrayList<Integer> tempArrayList = new ArrayList<>(); // 用于存放内层的路径
		 tempArrayList.add(root.val);       // 根节点非空，路径中加入根节点
		 // 若只有根节点，而根节点无左右子节点
		 if(root.left == null && root.right == null) {
			if (root.val == target) {
				arrayList.add(tempArrayList);   // 根节点的值恰好等于给定的整数值target
				System.out.println(arrayList);
				return arrayList;
			}else {
				System.out.println(arrayList);  // 根节点的值不等于给定的整数值target
				return arrayList;
			}
		}
		// 沿根节点左子树可能满足题意的路径的集合
		 ArrayList<ArrayList<Integer>> arrayListOfLeft = new ArrayList<>(); 
		// 沿根节点右子树可能满足题意的路径的集合
		 ArrayList<ArrayList<Integer>> arrayListOfRight = new ArrayList<>();
		 
		 // 讨论根节点子树不为null的3种情况，使用递归
		 if (root.left != null && root.right != null) {
			 /* 1.使用for循环，形成以根节点的左子节点root.left为根节点，
			  *   target - root.val为给定值递归得到的路径集合；
			  * 2.在该集合中的每一条路径前，插入根节点的值root.val,
			  *   形成以root为根节点、target为给定值的符合题意的路径集合。
			  */
			 
			 for (int i = 0; i < FindPath(root.left, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.left, target - root.val).get(i))) {
					 arrayListOfLeft.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			 
			 /* 1.使用for循环，形成以根节点的右子节点root.right为根节点，
			  *   target - root.val为给定值递归得到的路径集合；
			  * 2.在该集合中的每一条路径前，插入根节点的值root.val,
			  *   形成以root为根节点、target为给定值的符合题意的路径集合。
			  */
			 for (int i = 0; i < FindPath(root.right, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.right, target - root.val).get(i))) {
					 arrayListOfRight.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
		/*
		 * 将沿根节点左子树方向满足题意的路径的集合和沿根节点右子树方向满足题意的路径的集合组合，
		 * 形成最终的集合
		 */
			arrayListOfLeft.addAll(arrayListOfRight);  
			arrayList = arrayListOfLeft;
		}else if (root.left != null && root.right == null) {
			for (int i = 0; i < FindPath(root.left, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.left, target - root.val).get(i))) {
					 arrayListOfLeft.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			arrayList = arrayListOfLeft;
		}else if (root.left == null && root.right != null) {
			for (int i = 0; i < FindPath(root.right, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.right, target - root.val).get(i))) {
					 arrayListOfRight.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			arrayList = arrayListOfRight;
		} 
		 /*
		  * 对最终路径集合中的路径按照数组长度排序（在返回值的list中，数组长度大的数组靠前）
		  */
		 sort(arrayList);
		 System.out.println(arrayList);
	     return  arrayList;
	 }
	 // 使用直接插入排序法排序
	 public void sort(ArrayList<ArrayList<Integer>> arrayList) {
		
		for (int i = 1; i < arrayList.size(); i++) {
			ArrayList<Integer> arrayList2 = arrayList.get(i);
			int j;
			for (j  = i - 1; j >= 0; j--) {
				if (arrayList.get(j).size() < arrayList2.size()) {
					arrayList.set(j + 1, arrayList.get(j));
					
				}else {
					break;
				}
			}
			arrayList.set(j + 1, arrayList2);
		}
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