package algorithm.program.helixarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int [][] matrix){

        List<Integer> list = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int size = height*width;

        int [] dirx = {0,1,0,-1};
        int [] diry = {1,0,-1,0};

        int x = 0,y=-1,direction=0;
        for(int step,i=0;i<size;i=i+step){
            if (direction ==0 || direction ==2){
                step = width;
                height--;

            }else {
                step = height;
                width--;
            }

            for(int j=0;j<step;j++){
                x=x+dirx[direction];
                y=y+diry[direction];
                list.add(matrix[x][y]);
            }

            direction=++direction%4;

        }

        return list;

    }

    public static void main(String[] args) {

        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new Solution().spiralOrder(arr);
        list.stream().forEach(val-> System.out.println(val));
    }
}
