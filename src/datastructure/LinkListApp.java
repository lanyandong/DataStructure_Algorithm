package datastructure;


// 链表的实现
public class LinkListApp {

    public static void main(String[] args) {

        LinkList theList = new LinkList();
        theList.insertFirst(1, 10);
        theList.insertFirst(2, 11);
        theList.insertFirst(3, 12.0);
        theList.insertFirst(4, 13.3);

        theList.displayLink();


        Link f = theList.find(2);
        if(f != null){
            System.out.println("find link with key:" + f.kData);

            System.out.println("delete link with key");
            theList.delete(2);
        }
        else
            System.out.println("cant find the link");


        theList.displayLink();


        while(!theList.isEmpty()){
            Link alink = theList.deleteFirst();
            System.out.print("delete:");
            alink.displayLink();
        }
    }
}


// 链节点
class Link{

    public int kData;    // 头指针
    public double dData; // 数据项
    public Link next;    // 下个节点

    public Link(int kd, double dd){
        kData = kd;
        dData = dd;
    }

    public void displayLink(){
        System.out.println("{" + kData + "," + dData+ "}");
    }
}

// 单端链表，只往头插入节点
class LinkList{
    private Link first;

    public LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int kd, double dd){

        Link newlink = new Link(kd,dd);
        newlink.next = first;   // newlink--->old first
        first = newlink;        // first--->newlink
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;

        return temp;
    }


    // 查找链节点
    public Link find(int key){
        Link current = first;

        while (current.kData != key){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }

        return current;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;

        while(current.kData != key){
            if(current.next == null){
                return null;
            }
            else{
                previous = current;
                current = current.next;
            }
        }

        // 如果是第一个，则first-->first.next;
        // 否则的话，就是前一个的后一个指向当前的下一个
        if(current == first){
            first = first.next;
        }
        else {
            previous.next = current.next;
        }

        return current;

    }

    public void displayLink(){

        System.out.println("Link(first--->last)");
        Link current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}



