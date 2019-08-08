package others;



// 数字求和，利用Stack结构实现
public class SumOfNumbers {
    static int sum;
    static int num;


    public static void main(String args[]){
        num = 10;
        stackAdd();
        System.out.println("sum = " + sum);
    }


    public static void stackAdd(){
        Stack stack = new Stack(1000);

        sum = 0;
        while (num > 0){
            stack.push(num);
            num--;
        }

        while(!stack.isEmpty()){
            int num2 = stack.pop();
            sum = sum + num2;  // 出栈求和
        }
    }
}

// 定义一个 stack 结构
class Stack{

    private int maxSize;
    private int[] data;
    private int top;

    public Stack(int size){
        maxSize = size;
        data = new int[maxSize];
        top = -1;
    }

    public void push(int p){
        data[++top] = p;
    }

    public int pop(){
        return data[top--];
    }

    public int peek(){
        return data[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}