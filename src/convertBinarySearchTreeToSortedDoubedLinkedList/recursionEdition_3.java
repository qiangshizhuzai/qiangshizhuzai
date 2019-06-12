package convertBinarySearchTreeToSortedDoubedLinkedList;

public class recursionEdition_3 {

	/*
	 * �Ľ��ݹ��
	     ����˼·��
	    ˼·�뷽�����еĵݹ��һ�£����Ե�2���еĶ�λ�����޸ģ�����һ��ȫ�ֱ�����¼�����������һ���ڵ㡣
	 */
	
	    // ��¼������������һ���ڵ㣬�ս��ֻ����Ϊֻ���������ķ�Ҷ�ڵ���Ҷ�ڵ�
	    protected TreeNode leftLast = null;
	    public TreeNode Convert(TreeNode root) {
	        if(root==null)
	            return null;
	        if(root.left==null&&root.right==null){
	            leftLast = root;// ����һ���ڵ����Ϊ���Ҳ��Ҷ�ڵ�
	            return root;
	        }
	        // 1.�������������˫��������������ͷ�ڵ�
	        TreeNode left = Convert(root.left);
	        // 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
	        if(left!=null){
	            leftLast.right = root;
	            root.left = leftLast;
	        }
	        leftLast = root;// �����ڵ�ֻ��������ʱ����ø��ڵ�Ϊ���һ���ڵ�
	        // 4.�������������˫��������������ͷ�ڵ�
	        TreeNode right = Convert(root.right);
	        // 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
	        if(right!=null){
	            right.left = root;
	            root.right = right;
	        }
	        return left!=null?left:root;       
	    }
}
