package mirrorBinaryTree;

public class MirrorBinaryTree {

	public void Mirror(TreeNode root) {
		// ��Ϊ����
		if (root == null) {
			return;
		}
		//��ֻ�и��ڵ�(Ҳ��Ϊ�ݹ����ֹ��������ʾ��������Ҷ�ӽڵ�)
		if (root.left == null && root.right == null) {
			return;
		}
		
        TreeNode currentNode = root;
        TreeNode tempNode = null;
        // ������ǰ�ڵ�����ҽڵ�
        if (currentNode != null) {
        	tempNode = currentNode.left;
        	currentNode.left = currentNode.right;
        	currentNode.right = tempNode;
		}
        // �ݹ齻������Ҷ�ӽڵ�����ҽڵ�
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