package reconstructBinaryTree;

import java.util.Arrays;
import java.util.Scanner;

public class ReconstructBinaryTree {
	
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reconstructBinaryTree(pre, in);
		return root;
	}
	public static TreeNode reconstructBinaryTree(int[] pre, int[] in) {
		System.out.println("pre = " + Arrays.toString(pre));
		System.out.println("in = " + Arrays.toString(in));
		
		TreeNode treeNode = new TreeNode(pre[0]);
		System.out.println("root.val = " + treeNode.val);
		
		int rootootValIndexOfIn = 0;
		int i;
		for (i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				rootootValIndexOfIn = i;
				break;
			}
		}
		System.out.println("rootootValIndexOfIn = " + rootootValIndexOfIn);
		
		if (pre.length == 1 && in.length == 1) {
			treeNode.left = null;
			treeNode.right = null;
		}else {
			int[] tempPre = pre;
			int[] tempIn = in;
			System.out.println("temPre = " + Arrays.toString(tempPre));
			System.out.println("temIn = " + Arrays.toString(tempIn));
	

			int[] preLeft = Arrays.copyOfRange(pre, 1, rootootValIndexOfIn + 1);
			int[] inLeft = Arrays.copyOfRange(in, 0, rootootValIndexOfIn);
			int[] preRight = Arrays.copyOfRange(tempPre, rootootValIndexOfIn + 1, tempPre.length);
			int[] inRight = Arrays.copyOfRange(tempIn, rootootValIndexOfIn + 1, tempIn.length);	
			System.out.println("preLeft = " + Arrays.toString(preLeft));
			System.out.println("inLeft = " + Arrays.toString(inLeft));
			System.out.println("preRight = " + Arrays.toString(preRight));
			System.out.println("inRight = " + Arrays.toString(inRight));
			
			// 重建左子树
			if (preLeft.length > 0 && inLeft.length > 0) {
				treeNode.left = reconstructBinaryTree(preLeft, inLeft);
			}
			
			// 重建右子树
			if (preRight.length > 0 && inRight.length > 0) {
				treeNode.right = reconstructBinaryTree(preRight, inRight);
			}
		}
		
		return treeNode;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] pre = new int[m];
		int[] in = new int[m];
		
		for (int i = 0; i < pre.length; i++) {
			pre[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < in.length; i++) {
			in[i] = scanner.nextInt();
		}
		scanner.close();
		reconstructBinaryTree(pre, in);
	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		this.val = x;
	}
}