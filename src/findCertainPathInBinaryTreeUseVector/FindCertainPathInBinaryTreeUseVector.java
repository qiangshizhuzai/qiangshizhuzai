package findCertainPathInBinaryTreeUseVector;

import java.util.ArrayList;

public class FindCertainPathInBinaryTreeUseVector {

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// 根节点为空的情况
		if (root == null) {
			System.out.println(arrayList);
			return arrayList;
		}
		
		ArrayList<Integer> path = new ArrayList<>();  // 创建vector实现类似栈的功能，也可以用ArrayList
		int currentSum = 0;
		
		findPath(arrayList,root, target, path, currentSum);
		/*
		  * 对最终路径集合中的路径按照数组长度排序（在返回值的list中，数组长度大的数组靠前）
		  */
		 sort(arrayList);
		 System.out.println(arrayList);
	     return arrayList;
	}
	
	private void findPath(ArrayList<ArrayList<Integer>> arrayList, 
			TreeNode root, int target, ArrayList<Integer> path, int currentSum) {
		currentSum += root.val;
		path.add(root.val);
		/*
		 *  1.如果是叶子节点，并且路径上节点的和等于输入值，则将此路径加入路径集合arrayList中；否则什么也不做；
		 *  2.如果 该节点不是叶子节点，则继续递归访问它的子节点；
		 *  3.当前节点访问结束后，递归函数将自动回到它的父节点；
		 *  4.在函数推出之前，需 从当前和currentSum中减去该叶子节点的值，并从路径中删除该节点    
		 */
		boolean isLeaf = root.left == null && root.right == null;
		if (currentSum == target && isLeaf) {
			// 注意此处两句的区别
			/*
			 *  java程序设计语言总是采用值调用。也就是说，方法得到的是所有参数值的一个拷贝，
			 *  特别是，方法不能修改传递给它的任何参数变量的内容
			 */
			arrayList.add(new ArrayList<Integer>(path));
			// arrayList.add(path);
		}	
		// 若果不是叶子节点，则遍历它的子节点
		if (root.left != null) {
			findPath(arrayList, root.left, target, path, currentSum);
		}
		if (root.right != null) {
			findPath(arrayList, root.right, target, path, currentSum);
		}
		// 在返回父节点前，在路径上删除该节点，并减去当前节点的值
		currentSum -= root.val;
		path.remove(path.size() - 1);
				
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