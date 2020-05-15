package algorithm.program.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zj on 2019-11-01
 */
public class TestList {
    public static void main(String[] args) {
        int [] arr = new int[10];
        System.out.println("请输入10个数");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<10;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
    }
}
