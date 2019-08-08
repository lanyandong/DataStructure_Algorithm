package datastructure;

// 队列的实现
public class QueueApp {

    public static void main(String[] args) {

        Queue queue = new Queue(10);

        System.out.print("插入队列：");
        for (int i = 0; i < 10; i++) {
            if (!queue.isFull()){
                System.out.print(i + " ");
                queue.insert(i);
            }
        }

        System.out.println("\n队列长度：" + queue.size());
        System.out.println("队列头元素： " + queue.peekFront());

        System.out.print("\n移除队列：");
        while (!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }

        System.out.println("\n队列长度：" + queue.size());
    }
}


class Queue{
    private int maxSize;
    private int[] data;
    private int front;
    private int rear;
    private int index;

    public Queue(int size){
        maxSize = size;
        data = new int[maxSize];
        front = 0;
        rear = -1;
        index = 0;
    }

    public void insert(int value){
        if(rear == maxSize -1){
            rear = -1;
        }
        data[++rear] = value; // 尾位置填数据
        index++;
    }

    public int remove(){
        int temp = data[front++]; // 头位置取数据
        if(front == maxSize){
            front = 0;
        }

        index--;
        return temp;
    }

    public int peekFront(){
        return data[front];
    }

    public boolean isEmpty(){
        return (index == 0);
    }

    public boolean isFull(){
        return (index == maxSize);

    }

    public int size(){
        return index;
    }
}