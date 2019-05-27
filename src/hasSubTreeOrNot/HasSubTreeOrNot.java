package hasSubTreeOrNot;

public class HasSubTreeOrNot {

	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			// 判断以root1为根节点的子树中是否包含以root2为根节点的树
			if (root1.val == root2.val) {
				result = doesTree1HaveTree2(root1,root2);
			}
			// 判断以root1的左节点为根节点的子树中是否包含以root2为根节点的树
			if (!result) {
				result = hasSubtree(root1.left, root2);
			}
			// 判断以root1的右节点为根节点的子树中是否包含以root2为根节点的树
			if (!result) {
				result = hasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {

		// root2为单节点情况(也作为递归终止条件:树root2到达叶子节点,即root1包含子树)
		if (root2 == null) {
			return true;
		}
		// root1为单节点情况(也作为递归终止条件:树root1到达叶子节点,即root1不包含子树)
		if (root1 == null) {
			return false;
		}
		// 判断root1子树中根节点是否与root2中对应相等,如果不等，返回false
		if (root1.val != root2.val) {
			return false;
		}
		// 递归判断root1子树中根节点是否与root2中对应相等,如果相等，返回true
		return doesTree1HaveTree2(root1.left, root2.left) && 
				doesTree1HaveTree2(root1.right, root2.right);
	}
}
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = val;
	}
}