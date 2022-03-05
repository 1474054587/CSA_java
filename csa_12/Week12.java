package csa_12;

import java.util.Stack;

public class Week12{
    public static void main(String[] args) {
        new Week12().test();
    }
    public void test() {
        //之前写过链表，就直接拿来用了
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer>.MyIterator iterator;
        System.out.println("第一题-----------------");
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        reverseLinkedList(list);
        iterator = list.iterator();
        System.out.print(iterator.get());
        while (iterator.hasNext()) {
            System.out.print(" -> " + iterator.next());
        }
        System.out.println();
        System.out.println("第二题-----------------");
        list.clear();
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list2.add(1);
        list2.add(3);
        list2.add(4);
        mergeLinkedList(list1,list2);
        iterator = list1.iterator();
        System.out.print(iterator.get());
        while (iterator.hasNext()) {
            System.out.print(" -> " + iterator.next());
        }
        System.out.println();
        System.out.println("第三题-----------------");
        list.clear();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(huiwen(list));
    }
    public void reverseLinkedList(MyLinkedList<Integer> list){}
    public void mergeLinkedList(MyLinkedList<Integer> list1,MyLinkedList<Integer> list2){
        MyLinkedList<Integer>.MyIterator iterator1 = list1.iterator();
        MyLinkedList<Integer>.MyIterator iterator2 = list2.iterator();
        int index = 0;
        while (iterator2.hasNext()) {
            if (iterator2.get() > iterator1.get()) {
                index++;
                iterator1.next();
            } else {
                list1.add(iterator2.get(),index);
                index++;
                iterator2.next();
            }
        }
        int end = iterator2.get();
        while (iterator1.hasNext()) {
            if (end > iterator1.get()) {
                index++;
                iterator1.next();
            } else {
                list1.add(end,index);
                index = -1;
                break;
            }
        }
        if (index != -1) {
            list1.add(end);
        }
    }
    public boolean huiwen(MyLinkedList<Integer> list){
        Stack<Integer> stack = new Stack<>();
        MyLinkedList<Integer>.MyIterator iterator = list.iterator();
        stack.add(iterator.get());
        for (int i = 1; i < list.getSize(); i++) {
            stack.add(iterator.next());
        }
        iterator.reset();
        if (iterator.get() != stack.pop()) {
            return false;
        }
        for (int i = 1; i < list.getSize(); i++) {
            if (iterator.next() != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
