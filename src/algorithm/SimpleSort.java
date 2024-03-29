package algorithm;

import static java.lang.Math.random;

// 实现简单排序（插入，冒泡，选择）
public class SimpleSort {

    public static void main(String[] args) {
        System.out.println("实现简单排序的例子");
        
        int maxSize = 16;
        SimpleSortArr arr = new SimpleSortArr(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long value = (int)(random() * 99);
            arr.insert(value);
        }

        long start,end;
        start = System.currentTimeMillis();
        System.out.println("排序测试");
        arr.display();
        arr.insertSort();
        //arr.insertSort2();
        //arr.bubbleSort();
        //arr.selectSort();
        arr.display();
        end = System.currentTimeMillis();
        System.out.println("排序执行时间："+ (end - start));

    }
}


class SimpleSortArr{
    private long theArray[];
    private int index;

    public SimpleSortArr(int size){
        theArray = new long[size];
        index = 0;
    }

    public void insert(long v){
        theArray[index] = v;
        index++;
    }

    public void display(){

        System.out.print("the array: ");
        // index = theArray.length
        for(int i = 0 ; i < index; i++){
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    // 升序排序（由小到大）
    // 插入排序
    public void insertSort(){

        for(int i = 1; i < index; i++){
            for(int j = i; j > 0; j--){
            if(theArray[j] < theArray[j - 1]){
                swap(j, j - 1);
            }
        }
    }
    }

    /**插入排序应该利用局部有序性，减少交换次数**/
    public void insertSort2(){

        for(int i = 1; i < index; i++){
            long temp = theArray[i];
            int j = i;

            while (j > 0 && theArray[j-1] > temp){
                swap(j, j - 1);
                --j;
            }

            theArray[j] = temp;
        }
    }



    // 冒泡排序,将最小值移动至前
    public void bubbleSort(){
        for(int i = 0; i < index; i++){
            for(int j = index - 1; j > i; j--){
                if(theArray[i] > theArray[j]){
                    swap(i,j);
                }
            }
        }
    }

    // 选择排序，改进冒泡排序，减少交换次数
    public void selectSort(){

        for (int i = 0; i < index ; i++) {
            int mindex = i;

            for (int j = index - 1; j > i ; j--) {

                if(theArray[j] < theArray[mindex]){
                    mindex = j;  // 找出每轮最小值下标
                }
            }
            swap(i, mindex); // 最后与i进行交换，减少交换次数
        }
    }

    private void swap(int index1, int index2) {
        long temp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = temp;
    }
}
