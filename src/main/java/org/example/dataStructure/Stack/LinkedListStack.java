package org.example.dataStructure.Stack;

import java.util.Scanner;

public class LinkedListStack {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}

class Stack{
    private int maxSize; // 栈的大小
    private Node head; // head总是指向栈顶
    private int top = -1;// top用于表示栈顶的位置，初始化为-1,最大为maxSize -1

    // 构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        head = null;
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        Node node = new Node(value);
        node.next = head.next;
        head.next = node;
        top++;
    }

    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = head.next.value;
        head.next = head.next.next;
        top--;
        return value;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        Node temp = head.next;
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, temp.value);
            temp = temp.next;
        }
    }
}

/**
 * 创建节点类
 */

class Node {
    public int value;//编号

    public Node next; //下一节点

    public Node(int value) {
        this.value = value;
    }

}