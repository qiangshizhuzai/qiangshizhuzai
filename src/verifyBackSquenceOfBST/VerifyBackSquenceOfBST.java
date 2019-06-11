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
		isOrNot = verifySquenceOfBST(sequence,length); // �����·��������ڵݹ����
		// ��෽������ʵֻ�����ڽ��дӵݹ鷽����true��false��Yes��No��ת��
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
		
		// �ڶ������������������ڵ��ֵС�ڸ��ڵ��ֵ
		int i = 0;
		for (; i < length - 1; i++) {
			if (sequence[i] > root) {
				break;     // if������������˵���±�i֮ǰ��Ԫ��Ϊ������
			}
		}
		
		// �ڶ������������������ڵ��ֵ���ڸ��ڵ��ֵ
		int j = i;
		for (; j < length - 1; j++) {
			if (sequence[j] < root) {
				return false; // if������������˵���������г���С�ڸ��ڵ��Ԫ�أ��������Ƕ���������
			}
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean left = true;
		if (i > 0) {
			int[] leftSequence = new int[i];
			for(int k = 0;k < i; k ++) {
				leftSequence[k] = sequence[k];
			}
			left = verifySquenceOfBST(leftSequence, i);
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean right = true;
		if (i < length - 1) {
			int[] rightSequence = new int[length - i - 1];
			for (int k = 0; k < rightSequence.length; k++) {
				rightSequence[k] = sequence[i + k];
			}
			right = verifySquenceOfBST(rightSequence, length - i - 1);
		}
		return left && right;  // ֻ�������������Ƕ����������������ſ����Ƕ��������� 
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
