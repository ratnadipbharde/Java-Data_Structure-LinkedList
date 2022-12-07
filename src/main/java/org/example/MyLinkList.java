package org.example;

public class MyLinkList<K> {
    public INode<K> head;
    public INode<K> tail;

    public K search(K key) {
        INode head = this.head;
        while (head != null) {
            INode<K> current = head;
            if (key == current.getKey()) {
                System.out.println("Element found");
                return current.getKey();
            }
            head = current.getNext();
        }
        System.out.println("Element Not Found");
        return null;
    }

    public INode<K> pop() {
        INode<K> tempNode = this.head;
        this.head = head.getNext();
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
    }

    public void append(INode<K> newNode) {
        if (this.head == null) {
            this.head = newNode;
        }
        if (this.tail != null) {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
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

