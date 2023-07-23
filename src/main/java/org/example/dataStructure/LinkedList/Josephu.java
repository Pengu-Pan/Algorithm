package org.example.dataStructure.LinkedList;


/**
 * 环形链表
 */
public class Josephu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(5);// 加入5个小孩节点
        circleSingleLinkedList.showNode();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countNode(1,2,5); // 2->4->1->5->3
    }
}

class CircleSingleLinkedList{
    // first节点
    public Node first = null;

    /**
     * 添加节点，构成一个环形链表
     */
    public void addNode(int num){
        // 对添加的数量进行一个校验
        if (num < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Node curNode = null; // 辅助变量
        // 添加
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i);
            // 如果是第一个节点
            if (i==1){
                first = node;
                first.next = first;
                curNode = first;
            }else{
            // 否则
            curNode.next = node;
            node.next = first;
            curNode = node;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void showNode(){
        // 判断非空
    if (first == null){
        System.out.println("没有任何小孩~~");
        return;
    }
    Node curNode = first;
    while(true){
        System.out.printf("节点的编号 %d \n", curNode.no);
        if (curNode.next == first) {// 说明已经遍历完毕
            break;
        }
        curNode = curNode.next;
    }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countNode(int startNo, int countNum, int nums){
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建辅助变量helper，并让其指向最后一个节点
        Node helper = first;
        while(true){
            if(helper.next == first){
                break;
            }
            helper = helper.next;
        }
        // 将环形链表移动到第一个报数的小孩节点上
        for (int j = 0; j <  startNo - 1; j++) {
            first = first.next;
            helper = helper.next;
        }
        while(true){
            if(helper == first){
                break; // 环形链表中只有一个节点
            }
            // 移动 countNum -1 下
            for (int k = 0; k < countNum -1 ; k++) {
                first = first.next;
                helper = helper.next;
            }
            // 将该节点移除
            System.out.printf("节点%d出圈\n", first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在圈中的节点编号%d \n", first.no);
    }
}
class Node{
    public int no;// 编号
    public Node next; // 指向下一个节点,默认null

    public Node(int no) {
        this.no = no;
    }
}