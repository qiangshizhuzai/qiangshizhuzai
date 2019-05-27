package printMatrixClockwisely;

import java.util.ArrayList;

public class PrintMatrixClockwisely {

	public ArrayList<Integer> printMatrixClockwisely(int[][] matrix) {
		
		ArrayList<Integer> result = new ArrayList<>();
		if (matrix.length == 0) {
			return result;
		}
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		
		while (columns > 2 * start && rows > 2 * start) {
			// ʹ��arrayList��addAll(Collection<? extends E> c)����
			result.addAll(traverseMatrixInCircle(matrix, start));
			// ��ʹ��arrayList��add()��������ֻ�������һ�ε�arrayList��ӽ��
			// result = traverseMatrixInCircle(matrix, start);
			start ++;
		}
		return result;
		
	}

	private ArrayList<Integer> traverseMatrixInCircle(int[][] matrix1, int start) {
		int rows = matrix1.length;
		int columns = matrix1[0].length;
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		// �����ұ���һ�У�˳�����arrayList
		for (int i = start; i <= endX; i ++) {
			arrayList.add(matrix1[start][i]);
		}
		// ���ϵ��±���һ��(�������)��˳�����arrayList
		if (endY > start) {
			for (int i = start + 1; i <= endY; i ++) {
				arrayList.add(matrix1[i][endX]);
			}
		}
		// �����������һ��(�������)��˳�����arrayList
		if (endX > start && endY > start) {
			for (int i = endX - 1; i >= start; i --) {
				arrayList.add(matrix1[endY][i]);
			}
		}
		// ���µ��ϱ���һ��(�������)��˳�����arrayList
		if (endX > start && endY > start + 1) {
			for (int i = endY - 1; i >= start + 1; i --) {
				arrayList.add(matrix1[i][start]);
			}
		}
		return arrayList;
	}
}
