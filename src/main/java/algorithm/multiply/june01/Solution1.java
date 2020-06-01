package algorithm.multiply.june01;

public class Solution1 {
    public int RectCover(int target) {
        if(target<3)return target;
        return RectCover(target-2)+RectCover(target-1);
    }
}
