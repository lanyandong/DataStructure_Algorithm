package datastructure;


import static java.lang.Math.random;

// 基于线性探测的hashTable的实现
// 没有hashTable是否满的情况(在测试时避免)
// 装填因子：a=n/m  其中n 为关键字个数，m为表长。

public class HashApp {

    public static void main(String[] args) {

        DataItems aDataItem;
        int size = 20;   // hashtable的大小
        int n = 8;       // 数据项数目
        int key;

        HashTable theHashTable = new HashTable(size);

        for (int i = 0; i < n; i++) {
            key = (int)(random() * 99);
            aDataItem = new DataItems(key); // 随机生成数据项

            theHashTable.insert(aDataItem);
        }

        theHashTable.displayTable();

        // 插入数据项
        theHashTable.insert(new DataItems(666));
        theHashTable.displayTable();

        // 查找数据
        DataItems find = theHashTable.find(666);
        if(find != null){
            System.out.println("Find with key");
        }
        else
            System.out.println("Can't find");

        // 删除数据项
        theHashTable.delete(666);
        theHashTable.displayTable();
    }
}


class DataItems{
    private int iData;

    public DataItems(int id){
        iData = id;
    }

    public int getKey(){
        return iData;
    }
}

class HashTable{

    private DataItems[] hashArray;
    private int arraySize;
    private DataItems noItems;

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItems[arraySize];
        noItems = new DataItems(-1);
    }

    public void displayTable(){
        System.out.print("Table: ");
        for (int i = 0; i < arraySize; i++) {

            if(hashArray[i] != null){
                System.out.print(hashArray[i].getKey() + " ");
            }
            else
                System.out.print("** ");
        }
        System.out.println();
    }


    public int hashFunc(int key){

        return key % arraySize;  // hash 函数

    }

    public void insert(DataItems item){
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;

    }

    public DataItems delete(int key){
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){

                DataItems temp = hashArray[hashVal];
                hashArray[hashVal] = noItems;  // 删除置为-1

                return temp;

            }
            ++hashVal;
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItems find(int key){
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null){

            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }

            ++hashVal;
            hashVal %= arraySize;
        }

        return null;

    }
}
