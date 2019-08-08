package datastructure;


// 实现栈
public class StackApp {

    public static void main(String[] args) {
        StackX stackX = new StackX(10);

        System.out.print("进栈：");
        for (int i = 0; i < 12 ; i++) {
            if(!stackX.isFull()){
                System.out.print(i + " ");
                stackX.push(i);
            }
        }

        System.out.println("\n栈顶数据项：" + stackX.peek());
        System.out.print("\n出栈：");
        for (int j = 0; j < 10 ; j++) {
            if(!stackX.isEmpty()){
                System.out.print(stackX.pop() + " ");
            }
        }
    }
}


// 定义栈结构
class StackX{
    private int maxSize;
    private int[] data;
    private int top;

    public StackX(int size){
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

    public boolean isFull(){
        return (top == maxSize -1);
    }

}
