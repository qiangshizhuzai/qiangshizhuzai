package findCertainPathInBinaryTreeUseVector;

import java.util.ArrayList;

public class FindCertainPathInBinaryTreeUseVector {

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// ���ڵ�Ϊ�յ����
		if (root == null) {
			System.out.println(arrayList);
			return arrayList;
		}
		
		ArrayList<Integer> path = new ArrayList<>();  // ����vectorʵ������ջ�Ĺ��ܣ�Ҳ������ArrayList
		int currentSum = 0;
		
		findPath(arrayList,root, target, path, currentSum);
		/*
		  * ������·�������е�·���������鳤�������ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ��
		  */
		 sort(arrayList);
		 System.out.println(arrayList);
	     return arrayList;
	}
	
	private void findPath(ArrayList<ArrayList<Integer>> arrayList, 
			TreeNode root, int target, ArrayList<Integer> path, int currentSum) {
		currentSum += root.val;
		path.add(root.val);
		/*
		 *  1.�����Ҷ�ӽڵ㣬����·���Ͻڵ�ĺ͵�������ֵ���򽫴�·������·������arrayList�У�����ʲôҲ������
		 *  2.��� �ýڵ㲻��Ҷ�ӽڵ㣬������ݹ���������ӽڵ㣻
		 *  3.��ǰ�ڵ���ʽ����󣬵ݹ麯�����Զ��ص����ĸ��ڵ㣻
		 *  4.�ں����Ƴ�֮ǰ���� �ӵ�ǰ��currentSum�м�ȥ��Ҷ�ӽڵ��ֵ������·����ɾ���ýڵ�    
		 */
		boolean isLeaf = root.left == null && root.right == null;
		if (currentSum == target && isLeaf) {
			// ע��˴����������
			/*
			 *  java��������������ǲ���ֵ���á�Ҳ����˵�������õ��������в���ֵ��һ��������
			 *  �ر��ǣ����������޸Ĵ��ݸ������κβ�������������
			 */
			arrayList.add(new ArrayList<Integer>(path));
			// arrayList.add(path);
		}	
		// ��������Ҷ�ӽڵ㣬����������ӽڵ�
		if (root.left != null) {
			findPath(arrayList, root.left, target, path, currentSum);
		}
		if (root.right != null) {
			findPath(arrayList, root.right, target, path, currentSum);
		}
		// �ڷ��ظ��ڵ�ǰ����·����ɾ���ýڵ㣬����ȥ��ǰ�ڵ��ֵ
		currentSum -= root.val;
		path.remove(path.size() - 1);
				
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