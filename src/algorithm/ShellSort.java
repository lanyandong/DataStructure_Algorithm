package algorithm;

import static java.lang.Math.random;


// 实现shell排序
public class ShellSort {

    public static void main(String[] args) {
        int maxSize = 16;
        ShellSortArr arr = new ShellSortArr(maxSize);

        for (int i = 0; i < maxSize; i++) {
            int value = (int)(random() * 99);
            arr.insert(value);
        }

        arr.display();
        arr.shellSort();
        arr.display();
    }
}


class ShellSortArr{

    private int theArray[];
    private int nElems;

    public ShellSortArr(int size){
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

    public void shellSort(){

        // Knuth 间隔序列 h=h*3+1
        // 间隔取值之后需要等于1
        int h = 1;
        while(h <= nElems/3){
            h = h * 3 + 1;
        }

        // 在插入排序的基础上增加间隔，减少移动次数
        while (h > 0){

            for (int i = h; i < nElems; i++) {
                int temp = theArray[i];
                int j = i;

                while(j > h-1 && theArray[j - h] >= temp ){  // 由小到大排序
                    theArray[j] = theArray[j - h];
                    j = j - h;
                }
                theArray[j] = temp;
            }

            h = (h -1)/3;
        }
    }
}

