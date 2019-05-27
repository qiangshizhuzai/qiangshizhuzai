package hasSubTreeOrNot;

public class HasSubTreeOrNot {

	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			// �ж���root1Ϊ���ڵ���������Ƿ������root2Ϊ���ڵ����
			if (root1.val == root2.val) {
				result = doesTree1HaveTree2(root1,root2);
			}
			// �ж���root1����ڵ�Ϊ���ڵ���������Ƿ������root2Ϊ���ڵ����
			if (!result) {
				result = hasSubtree(root1.left, root2);
			}
			// �ж���root1���ҽڵ�Ϊ���ڵ���������Ƿ������root2Ϊ���ڵ����
			if (!result) {
				result = hasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {

		// root2Ϊ���ڵ����(Ҳ��Ϊ�ݹ���ֹ����:��root2����Ҷ�ӽڵ�,��root1��������)
		if (root2 == null) {
			return true;
		}
		// root1Ϊ���ڵ����(Ҳ��Ϊ�ݹ���ֹ����:��root1����Ҷ�ӽڵ�,��root1����������)
		if (root1 == null) {
			return false;
		}
		// �ж�root1�����и��ڵ��Ƿ���root2�ж�Ӧ���,������ȣ�����false
		if (root1.val != root2.val) {
			return false;
		}
		// �ݹ��ж�root1�����и��ڵ��Ƿ���root2�ж�Ӧ���,�����ȣ�����true
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