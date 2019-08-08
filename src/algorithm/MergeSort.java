package algorithm;

import static java.lang.Math.random;

// 实现归并排序
public class MergeSort {

    public static void main(String[] args) {

        int maxSize = 16;
        MergeSortArr arr = new MergeSortArr(maxSize);

        for(int i = 0; i < maxSize; i++){
            int value = (int)(random() * 99);
            arr.insert(value);
        }

        arr.display();

        arr.mergeSort();

        arr.display();
    }
}

// 基于数组构造类，实现归并排序方法
class MergeSortArr{

    private int theArray[];
    private int nElems;

    public MergeSortArr(int size){
        theArray = new int[size];
        nElems = 0;
    }

    public void insert(int value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){

        System.out.print("theArray: ");
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort(){
        int arr[] = new int[nElems];  // 辅助数组
        recMergeSort(arr, 0 , nElems-1);
    }


    public void recMergeSort(int arr[], int start, int end){
        if(start < end){
            int mid = (start + end)/2;

            recMergeSort(arr, start, mid);      // 前半部分
            recMergeSort(arr, mid+1, end); // 后半部分

            merge(arr, start, mid, end);  // 合并
        }
    }


    private void merge(int[] temp, int left, int mid, int right) {

        int tempPtr = left; // 存放

        int leftPtr = left; // 检测
        int midPtr = mid + 1;

        while (leftPtr <= mid && midPtr <= right){
            if(theArray[leftPtr] <= theArray[midPtr]){
                temp[tempPtr++] = theArray[leftPtr++];
            }
            else
                temp[tempPtr++] = theArray[midPtr++];
        }

        while(leftPtr <= mid){
            temp[tempPtr++] = theArray[leftPtr++];
        }

        while (midPtr <= right){
            temp[tempPtr++] = theArray[midPtr++];
        }

        // 存回
        for (int i = left; i <= right ; i++) {
            theArray[i] = temp[i];
        }
    }
}
