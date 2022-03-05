package csa_12;

import java.util.Iterator;

/**
 * 自定义链表
 * 实现了基本的增删查改
 * 实现了 Iterator 迭代器
 * @param <T> 泛型输入
 */
public class MyLinkedList<T>{
    //链表内部类
    private class Link  {
        private T data;
        private Link next;
        public Link(T t, Link next){
            data = t;
            this.next = next;
        }
        public Link(T t){
            this(t,null);
        }
    }
    //迭代器内部类
    public class MyIterator implements Iterator<T> {
        private Link iterator;
        private MyLinkedList<T> myLinkedList;
        //构造方法，参数由外部类传入
        public MyIterator(MyLinkedList<T> linkedList) {
            this.iterator = linkedList.head;
            this.myLinkedList = linkedList;
            reset();
        }
        //初始化节点
        public void reset() {
            iterator = myLinkedList.getLink(0);
        }
        //获取当前节点
        public T get() {
            return iterator.data;
        }
        //迭代
        public T next() {
            iterator = iterator.next;
            return iterator.data;
        }
        //获取是否有下一节点
        public boolean hasNext() {
            if (iterator.next != null) {
                return true;
            } else {
                return false;
            }
        }
        //获取是否为最后一个节点
        public boolean atEnd() {
            if (iterator != null && iterator.next == null) {
                return true;
            } else {
                return false;
            }
        }
    }
    //构造表头
    private Link head;
    //构造元素个数
    private int size;
    //无参构造
    public MyLinkedList(){
        this.head = null;
        this.size = 0;
    }
    //构造迭代器
    public MyLinkedList<T>.MyIterator iterator(){
        return new MyLinkedList<T>.MyIterator(this);
    }
    //获取元素个数
    public int getSize(){
        return size;
    }
    //判空
    public boolean isEmpty(){
        return this.size == 0;
    }
    //清空
    public void clear(){
        this.head = null;
        this.size = 0;
    }
    //头部添加元素
    public void addFirst(T t){
        this.head = new Link(t,head);
        this.size++;
    }
    //按索引添加元素,索引从 0 开始
    public void add(T t,int index){
        if (index == 0) {
            this.addFirst(t);
        } else {
            Link add = new Link(t);
            //getLink 时会判断 index 是否异常
            Link pre = this.getLink(index-1);
            add.next = pre.next;
            pre.next = add;
            this.size++;
        }
    }
    //无索引添加元素，自动添加至最后
    public void add(T t){
        this.add(t,this.size);
    }
    //删除第一个元素
    public void removeFirst(){
        if (size == 0) {
            throw new IndexOutOfBoundsException("this ArrayList is empty");
        } else {
            head = head.next;
        }
        this.size--;
    }
    //删除特定元素，如有多个，将删除第一个
    public void remove(T t){
        if (size == 0) {
            throw new IndexOutOfBoundsException("this ArrayList is empty");
        } else if (head.data.equals(t)) {
            head =head.next;
            this.size--;
        } else {
            Link pre = this.head;
            while (pre != null && pre.next != null) {
                if (pre.next.data.equals(t)) {
                    pre.next = pre.next.next;
                    this.size--;
                } else {
                    pre = pre.next;
                }
            }
        }
    }
    //根据索引删除
    public void remove(int index){
        if (index == 0) {
            this.removeFirst();
        } else {
            Link pre = this.getLink(index-1);
            pre.next = pre.next.next;
            this.size--;
        }
    }
    //无参删除元素，删除最后一个元素
    public void remove(){
        this.remove(size-1);
    }
    //按索引获取对应链表
    public Link getLink(int index){
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("the LinkedList is empty");
        } else if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("index " + index + " is out of bound " + size);
        }
        Link temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    //按索引获取元素
    public T get(int index) {
        return this.getLink(index).data;
    }
    //获取 t 的索引，如有多个 t，获取第一个
    public int getIndex(T t){
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("this ArrayList is empty");
        }
        Link temp = this.head;
        int index = 0;
        while (temp != null && temp.next != null) {
            if (temp.data.equals(t)) {
                return index;
            } else {
                temp = temp.next;
                index++;
            }
        }
        throw new IllegalArgumentException("no such element");
    }
    //按索引修改元素
    public void set(T t,int index){
        Link temp = this.getLink(index);
        Link set = new Link(t);
        set.next = temp.next;
        temp = set;
    }
}
