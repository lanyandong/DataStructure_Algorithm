package others;


import static java.lang.Math.random;

// 递归调用例子实现
public class Recursion {


    public static void main(String[] args) {

        System.out.println("4的阶乘等于: " + factorial(4));

        System.out.println("查看fibonacci递归调用过程：");
        fibonacci(5);

        System.out.println("测试使用递归实现的二分查找算法");
        int maxSize = 10;
        OrderArr theArray = new OrderArr(maxSize);
        for (int i = 0; i < maxSize; i++) {

            theArray.insert((int)(random() * 10));
        }

        theArray.display();
        int key = 5; // 查找5
        if(theArray.find(key) != -1){
            System.out.println("Find " + key );
        }
        else{
            System.out.println("Can't find " + key);
        }
    }

    // 递归计算阶乘
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * factorial(n - 1);
        }
    }

    // Fibonacci: 1、1、2、3、5、8、13、21、34
    // 查看 fibonacci 递归调用过程
    public static int fibonacci(int n) {
        System.out.println("Entering n is " + n);
        if (n == 1 || n == 2) {
            System.out.println("Returning 1");
            return 1;
        }
        else{
            int temp = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

}

// 分治算法一般要使用递归
// 二分查找，使用递归实现
class OrderArr{

    private int nElems; // number of data items
    private int[] data;

    public OrderArr(int size){
        data = new int[size];
        nElems = 0;
    }

    // 有序数组
    public void insert(int value){

        int i;
        for (i = 0; i < nElems ; i++) {
            if(data[i] > value)
                break;
        }
        // 向后移动，插入value
        for (int j = nElems; j > i; j--){
            data[j] = data[j-1];
        }
        data[i] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int find(int key){
        return recfind(key, 0 , nElems-1);
    }


    public int recfind(int key, int lower, int upper) {

        int curIn;
        curIn = (lower + upper)/2;

        if(data[curIn] == key){
            return curIn;       // 找到返回下标
        }
        else if(lower > upper){
            return -1;        // 未找到返回-1
        }
        else{

            if(data[curIn] < key){
                return recfind(key, curIn + 1 , upper);
            }
            else{
                return recfind(key, lower , curIn - 1);
            }
        }
    }
}

