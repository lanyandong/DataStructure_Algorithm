package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

// 实现基数排序
public class RedixSort {

    public static void main(String[] args) {

        int[] arr = new int[] { 16, 13, 21, 4, 7, 11, 35, 66};
        System.out.println("未排序的数组：" + Arrays.toString(arr));

        redixSort(arr);

        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }


    public static void redixSort(int arr[]){

        int max = arr[0];  // 算出最大数的位数
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int maxDigit = 0;
        while(max != 0){
            max /= 10;
            maxDigit++;
        }

        // 桶表（链表+数组）
        ArrayList<ArrayList<Integer>> bucketList = new
                ArrayList<ArrayList<Integer>>();

        // 10个链表
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());

        int mod = 10;
        int div = 1;

        for (int i = 0; i < maxDigit; i++) {

            // LSD 由地位到高位
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;  // 取出对应位
                bucketList.get(num).add(arr[j]);
            }
            
            int index = 0;
            for (int j = 0; j < bucketList.size() ; j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    arr[index++] = bucketList.get(j).get(k); // 从桶表中取值

                bucketList.get(j).clear();
            }

            mod = mod * 10;  // 为了取位改变因子
            div = div * 10;
        }
    }
}
