package qingWaJumpFloor2;

public class QingWaJumpFloor2 {
	
	public int JumpFloor2(int target) {
        int methodNumber = 0;
        
        if (target == 0) {
			methodNumber = 0;
		}else if (target == 1) {
			methodNumber = 1;
		}else if (target >= 2) {
			for (int i = 0; i < target; i++) {
				methodNumber += fibonacci2(i);
			}
		}
        return methodNumber;
    }

	private int fibonacci2(int i) {
		int result = 0;
		if (i == 0) {
			result = 1;
		}else if (i == 1) {
			result = 1;
		}else if (i >= 2) {
			for (int j = 0; j < i; j++) {
				result += fibonacci2(j);
			}
		}
		return result;
	}
}
