package datastructure;

import java.util.Stack;


// 实现二叉搜索树
public class TreeApp {

    public static void main(String[] args) {

        Tree theTree = new Tree();

        theTree.insert(13, 11);
        theTree.insert(1, 2.3);
        theTree.insert(4,5.7);
        theTree.insert(21, 2.3);
        theTree.insert(41,5.7);
        theTree.insert(3, 11);

        System.out.println("展示：");
        theTree.displayTree();

        System.out.println("查找：");
        int value = 21;
        Node found = theTree.find(value);
        if(found != null){
            System.out.print("Found: ");
            found.displayNode();
            System.out.println();
        }
        else
            System.out.println("No Found");


        System.out.println("遍历：(1:前序，2：中序，3：中序)");
        theTree.traverse(1);
        theTree.traverse(2);
        theTree.traverse(3);


        System.out.println("删除：");
        boolean delete = theTree.delete(value);
        if(delete){
            System.out.println("Delete: "  + value);
        }
        else
            System.out.println("Can't delete");


        System.out.println("展示：");
        theTree.displayTree();

    }
}


class Node{

    public int iData;    // 树节点的数据结构
    public double dData;

    public Node leftChild;
    public Node rightChild;


    public void displayNode(){

        System.out.println("{" + iData + "," + dData + "}");
    }
}

class Tree{
    public Node root;

    public Tree(){
        root = null;
    }


    public Node find(int key){
        Node current  = root;

        while(current.iData != key){

            if(key < current.iData){
                current = current.leftChild;
            }
            else
                current =current.rightChild;

            if(current == null){
                return null;
            }
        }
        return current;
    }


    public void insert(int id, double dd){

        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;

            while(true){

                parent = current;  // 先将当前节点保存为父亲节点

                if(id < current.iData){
                    current = current.leftChild;

                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;

                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    // 删除节点，考虑的情况比较多

    public boolean delete(int key){

        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        // 寻找节点
        while(current.iData != key){
            parent = current;

            if(key < current.iData){
                isLeftChild = true;
                current = current.leftChild;
            }
            else{
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null){
                return false;
            }
        }


        // 没有子节点(是root？isLeftChild？)
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }
            else if(isLeftChild){
                parent.leftChild = null;
            }
            else {
                parent.rightChild = null;
            }
        }
        else if(current.rightChild == null){
            // 没有右子节点
            if(current == root){
                root = current.leftChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }
            else
                parent.rightChild = current.leftChild;
        }
        else if(current.leftChild == null){
            // 没有左子节点
            if (current == root){
                root = current.rightChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }
            else
                parent.rightChild = current.rightChild;
        }

        else{
            // 既有左子节点，又有右子节点
            // 中序后继代替，找出后继节点
            Node successor = getSuccessor(current);

            if(current == root){
                root = current;
            }
            else if(isLeftChild){
                current.leftChild = successor;
            }
            else
                current.rightChild =successor;

            // 把当前节点的左子节点，设置为后继节点的左子节点
            successor.leftChild = current.leftChild;
        }

        return true;
    }


    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // 查找删除节点的右子树

        while (current != null){
            successorParent = successor; // 保存后继节点

            successor = current;
            current = current.leftChild; // 找左子节点
        }

        if(successor != delNode.rightChild){
            // 后继节点为左子节点
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;

        }
        return successor; // 返回后继节点
    }

    // 树的遍历(前序，中序，后序)
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.println("前序遍历：");
                preOrder(root);
                break;

            case 2:
                System.out.println("中序遍历：");
                inOrder(root);
                break;

            case 3:
                System.out.println("后序遍历：");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    // 前序遍历
    // 1.访问节点，2.调用自身遍历该节点的左子树，3.调用自身遍历该节点的右子树
    private void preOrder(Node localRoot) {
        if (localRoot != null){

            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }

    }

    private void inOrder(Node localRoot) {

        if (localRoot != null){

            preOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.rightChild);
        }

    }

    private void postOrder(Node localRoot) {
        if (localRoot != null){

            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }


    public void displayTree(){


        java.util.Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(".............................................");
        while (isRowEmpty == false){

            java.util.Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks ; i++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false){
                Node temp = (Node)globalStack.pop();

                if(temp != null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }
                else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks * 2 - 2; j++ ){
                    System.out.print(' ');
                }
            }
            System.out.println();

            nBlanks /= 2;

            while (localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }
        }

        System.out.println(".............................................");
    }
}
