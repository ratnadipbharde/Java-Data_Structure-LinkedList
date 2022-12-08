package org.example;

public class MyLinkList<K> {
    private INode<K> head;
    private INode<K> tail;

    private Integer size=0;

    public Integer getSize(){
        return size;
    }

    public Integer index(K key) {
        INode tempNode = this.head;
        Integer count = 0;
        while (tempNode != null) {
            INode<K> current = tempNode;
            if (key == current.getKey()) {
                break;
            }
            tempNode = current.getNext();
            count++;
        }
        return count;
    }

    public boolean search(K key) {
        INode tempNode = this.head;
        while (tempNode != null) {
            INode<K> current = tempNode;
            if (key == current.getKey()) {
               return true;
            }
            tempNode = current.getNext();
        }
        return false;
    }

    public INode<K> pop() {
        INode<K> tempNode = this.head;
        this.head = head.getNext();
        size--;
        return tempNode;
    }

    public void add(INode<K> newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode<K> tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
        size++;
    }

    public void append(INode<K> newNode) {
        if (this.head == null) {
            this.head = newNode;
        }
        if (this.tail != null) {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        size++;
    }

    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes : ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (tempNode != tail)
                myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    @Override
    public String toString() {
        return "MyLinkList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

