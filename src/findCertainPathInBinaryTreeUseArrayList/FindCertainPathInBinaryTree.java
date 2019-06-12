package findCertainPathInBinaryTreeUseArrayList;

import java.util.ArrayList;

public class FindCertainPathInBinaryTree {

	/*
	 * 1.ʹ�õݹ�ķ��������ۿսڵ㣬һ�����ڵ㣬���ڵ�ֻ�������������ڵ�ֻ����������
	 *   ���ڵ���������������������Ķ������
	 * 2.ע��˴�����ArrayList<ArrayList<Integer>>
	 */
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// ���ڵ�Ϊ�յ����
		 if (root == null) {
			 System.out.println(arrayList);
			return arrayList;
		}
		 
		 // ���ڵ�ǿ�
		 ArrayList<Integer> tempArrayList = new ArrayList<>(); // ���ڴ���ڲ��·��
		 tempArrayList.add(root.val);       // ���ڵ�ǿգ�·���м�����ڵ�
		 // ��ֻ�и��ڵ㣬�����ڵ��������ӽڵ�
		 if(root.left == null && root.right == null) {
			if (root.val == target) {
				arrayList.add(tempArrayList);   // ���ڵ��ֵǡ�õ��ڸ���������ֵtarget
				System.out.println(arrayList);
				return arrayList;
			}else {
				System.out.println(arrayList);  // ���ڵ��ֵ�����ڸ���������ֵtarget
				return arrayList;
			}
		}
		// �ظ��ڵ��������������������·���ļ���
		 ArrayList<ArrayList<Integer>> arrayListOfLeft = new ArrayList<>(); 
		// �ظ��ڵ��������������������·���ļ���
		 ArrayList<ArrayList<Integer>> arrayListOfRight = new ArrayList<>();
		 
		 // ���۸��ڵ�������Ϊnull��3�������ʹ�õݹ�
		 if (root.left != null && root.right != null) {
			 /* 1.ʹ��forѭ�����γ��Ը��ڵ�����ӽڵ�root.leftΪ���ڵ㣬
			  *   target - root.valΪ����ֵ�ݹ�õ���·�����ϣ�
			  * 2.�ڸü����е�ÿһ��·��ǰ��������ڵ��ֵroot.val,
			  *   �γ���rootΪ���ڵ㡢targetΪ����ֵ�ķ��������·�����ϡ�
			  */
			 
			 for (int i = 0; i < FindPath(root.left, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.left, target - root.val).get(i))) {
					 arrayListOfLeft.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			 
			 /* 1.ʹ��forѭ�����γ��Ը��ڵ�����ӽڵ�root.rightΪ���ڵ㣬
			  *   target - root.valΪ����ֵ�ݹ�õ���·�����ϣ�
			  * 2.�ڸü����е�ÿһ��·��ǰ��������ڵ��ֵroot.val,
			  *   �γ���rootΪ���ڵ㡢targetΪ����ֵ�ķ��������·�����ϡ�
			  */
			 for (int i = 0; i < FindPath(root.right, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.right, target - root.val).get(i))) {
					 arrayListOfRight.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
		/*
		 * ���ظ��ڵ��������������������·���ļ��Ϻ��ظ��ڵ��������������������·���ļ�����ϣ�
		 * �γ����յļ���
		 */
			arrayListOfLeft.addAll(arrayListOfRight);  
			arrayList = arrayListOfLeft;
		}else if (root.left != null && root.right == null) {
			for (int i = 0; i < FindPath(root.left, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.left, target - root.val).get(i))) {
					 arrayListOfLeft.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			arrayList = arrayListOfLeft;
		}else if (root.left == null && root.right != null) {
			for (int i = 0; i < FindPath(root.right, target - root.val).size(); i++) {
				 if (tempArrayList.addAll(FindPath(root.right, target - root.val).get(i))) {
					 arrayListOfRight.add(tempArrayList);
					 tempArrayList = new ArrayList<>();
					 tempArrayList.add(root.val);
				}	 
			}
			arrayList = arrayListOfRight;
		} 
		 /*
		  * ������·�������е�·���������鳤�������ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ��
		  */
		 sort(arrayList);
		 System.out.println(arrayList);
	     return  arrayList;
	 }
	 // ʹ��ֱ�Ӳ�����������
	 public void sort(ArrayList<ArrayList<Integer>> arrayList) {
		
		for (int i = 1; i < arrayList.size(); i++) {
			ArrayList<Integer> arrayList2 = arrayList.get(i);
			int j;
			for (j  = i - 1; j >= 0; j--) {
				if (arrayList.get(j).size() < arrayList2.size()) {
					arrayList.set(j + 1, arrayList.get(j));
					
				}else {
					break;
				}
			}
			arrayList.set(j + 1, arrayList2);
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