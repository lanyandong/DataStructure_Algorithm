package algorithm;

import static java.lang.Math.random;

/**
 * 实现快速排序
 */
public class QuickSort {

    public static void main(String args[]){

        System.out.println("快速排序例子");
        int maxSize = 16;
        QuickSortArr arr = new QuickSortArr(maxSize);

        for(int i = 0; i < maxSize; i++){
            long value = (int)(random() * 99);
            arr.insert(value);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}


class QuickSortArr{

    private long theArray[];
    private int index;

    public QuickSortArr(int size){
        theArray = new long[size];
        index = 0;
    }

    public void insert(long v){
        theArray[index] = v;
        index++;
    }

    public void display(){

        System.out.print("the array: ");
        for(int i = 0; i < theArray.length; i++){
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void quickSort(){
        recQuickSort(0, index - 1);
    }

    private void recQuickSort(int left, int right) {
        if(right - left <= 0){
            return;
        }
        else {
            long flag = theArray[right]; // 选最右的为flag
            int ptt = partitionIt(left, right, flag);

            recQuickSort(left, ptt - 1 );
            recQuickSort(ptt + 1, right);
        }
    }

    private int partitionIt(int left, int right, long flag) {
        int leftPtr = left - 1;  // 数组下标指针
        int rightPtr = right;

        while(true){
            // 左移/右移，找到不满足条件的(先运算在比较)
            while (theArray[++leftPtr] < flag);

            while (theArray[--rightPtr] > flag && rightPtr > 0);
            // 交换
            if(leftPtr < rightPtr){
                swap(leftPtr,rightPtr);

            }
            else
                break;
        }

        swap(leftPtr, right); // 将flag值移动到leftPtr的位置,并返回下标
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = temp;
    }

}