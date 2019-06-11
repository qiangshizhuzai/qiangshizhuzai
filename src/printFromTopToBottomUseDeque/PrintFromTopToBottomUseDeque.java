package printFromTopToBottomUseDeque;

// import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintFromTopToBottomUseDeque {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
		ArrayList<Integer> arrayList = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>(); // LinkedList: 基于链表实现的链式双向队列
		// Deque<TreeNode> deque2 = new ArrayDeque<>(); // ArrayDeque: 基于数组实现的线性双向队列
		
		if (root == null) {
			return arrayList;
		}
		
		deque.addLast(root);
		while (deque.size() != 0) {
			TreeNode currentNode = deque.getFirst();
			deque.pop();
			arrayList.add(currentNode.val);
			if(currentNode.left != null){
                deque.addLast(currentNode.left);
            }
			if(currentNode.right != null){
                deque.addLast(currentNode.right);
            }
		}
		
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