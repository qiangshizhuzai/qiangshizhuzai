package verifyBackSquenceOfBST;

import java.util.Scanner;

public class VerifyBackSquenceOfBST {

	public boolean verifySquenceOfBST(int [] sequence) {
		boolean isOrNot = true;
		if (sequence == null || sequence.length <= 0) {
			System.out.println("No");
			return false;
		}
		int length = sequence.length;
		isOrNot = verifySquenceOfBST(sequence,length); // 定义新方法，用于递归操作
		// 外侧方法，其实只是用于进行从递归方法的true和false到Yes和No的转化
		if (isOrNot) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		return isOrNot;
	}

	private boolean verifySquenceOfBST(int[] sequence, int length) {
		// TODO Auto-generated method stub
		int root = sequence[length - 1];
		
		// 在二叉搜索树中左子树节点的值小于根节点的值
		int i = 0;
		for (; i < length - 1; i++) {
			if (sequence[i] > root) {
				break;     // if条件成立，则说明下标i之前的元素为左子树
			}
		}
		
		// 在二叉搜索树中右子树节点的值大于根节点的值
		int j = i;
		for (; j < length - 1; j++) {
			if (sequence[j] < root) {
				return false; // if条件成立，则说明右子树中出现小于根节点的元素，该树不是二叉搜索树
			}
		}
		
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (i > 0) {
			int[] leftSequence = new int[i];
			for(int k = 0;k < i; k ++) {
				leftSequence[k] = sequence[k];
			}
			left = verifySquenceOfBST(leftSequence, i);
		}
		
		// 判断右子树是不是二叉搜索树
		boolean right = true;
		if (i < length - 1) {
			int[] rightSequence = new int[length - i - 1];
			for (int k = 0; k < rightSequence.length; k++) {
				rightSequence[k] = sequence[i + k];
			}
			right = verifySquenceOfBST(rightSequence, length - i - 1);
		}
		return left && right;  // 只有左右子树均是二叉搜索树，该树才可能是二叉搜索树 
	} 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] sequence = new int[n];
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = scanner.nextInt();
		}
		scanner.close();
		VerifyBackSquenceOfBST verifyBackSquenceOfBST = new VerifyBackSquenceOfBST();
		verifyBackSquenceOfBST.verifySquenceOfBST(sequence);
	}
}
