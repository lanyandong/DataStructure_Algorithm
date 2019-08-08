package others;

import java.util.TreeSet;

import static java.lang.Math.random;

// 随机数排序去重(TreeSet 和 array 两种方法)
public class NotSameRandom {


    public static void main(String[] args) {

        TreeSet<Integer> ts =new TreeSet<Integer>();

        int maxSize = 20;  //随机数个数

        int randSize = 30; // 申请一个随机范围大小的数组空间
        int theArray[] = new int[randSize];

        for (int i = 0; i < maxSize ; i++) {
            int num = (int)(random() * 30);
            ts.add(num);

            // 将数作为下标存入
            theArray[num] = 1;
        }

        // 输出集合
        System.out.print("Set: ");
        for(Integer i : ts){
            System.out.print(i + " ");
        }
        System.out.println();

        // 输出数组
        System.out.print("the array: ");
        for (int i = 0; i < randSize; i++) {
            if(theArray[i] == 1){
                System.out.print(i + " ");
            }
        }
    }
}

