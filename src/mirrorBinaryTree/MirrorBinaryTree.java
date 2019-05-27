package mirrorBinaryTree;

public class MirrorBinaryTree {

	public void Mirror(TreeNode root) {
		// 树为空树
		if (root == null) {
			return;
		}
		//树只有根节点(也作为递归的终止条件，表示遍历到了叶子节点)
		if (root.left == null && root.right == null) {
			return;
		}
		
        TreeNode currentNode = root;
        TreeNode tempNode = null;
        // 交换当前节点的左右节点
        if (currentNode != null) {
        	tempNode = currentNode.left;
        	currentNode.left = currentNode.right;
        	currentNode.right = tempNode;
		}
        // 递归交换各非叶子节点的左右节点
        if (root.left != null) {
        	Mirror(root.left);
		}
        if (root.right != null) {
        	Mirror(root.right);
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