package org.example.dataStructure;

import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
/*        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.showList();*/
        //顺序创建链表
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(heroNode1);
        singleLinkedList2.addByOrder(heroNode4);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode3);
        singleLinkedList2.showList();
        //修改测试
/*        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList2.update(newHeroNode);
        System.out.println("修改后的链表情况~~");
        singleLinkedList2.showList();*/
        //删除测试
        //测试修改节点的代码
/*        singleLinkedList2.delete(2);
        System.out.println("删除后的链表情况~~");
        singleLinkedList2.showList();*/
        //测试一下 求单链表中有效节点的个数
//        System.out.println("有效的节点个数=" + singleLinkedList2.getLength());
        //测试一下看看是否得到了倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList2, 3);
//        System.out.println("res=" + res);
        //测试反转链表
//        System.out.println("反转单链表~~");
//		reversetListNew(singleLinkedList2);
//        singleLinkedList2.showList();
        //测试逆序打印
//        reversePrint(singleLinkedList2);
        //测试链表合并
        HeroNode heroNode6 = new HeroNode(6, "秦明", "霹雳火");
        HeroNode heroNode22 = new HeroNode(2, "卢俊义", "玉麒麟");
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.addByOrder(heroNode22);
        singleLinkedList3.addByOrder(heroNode6);
        singleLinkedList3.showList();
        System.out.println("链表合并结果：");
        mergeLinkedList(singleLinkedList2,singleLinkedList3).showList();

    }

    //查找单链表中的倒数第k个结点 【新浪面试题】
    public static HeroNode findLastIndexNode(SingleLinkedList singleLinkedList, int index) {
        //判断如果链表为空，返回null
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null) {
            return null;//没有找到
        }
        //计算长度
        int length = singleLinkedList.getLength();
        //判断如果链表为空，返回null
        if (index <= 0 || index > length) {
            return null;
        }
        //遍历寻找
        HeroNode cur = head.next; //3 // 3 - 1 = 2
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 获取正数第index个节点
    public static HeroNode findIndexNode(SingleLinkedList singleLinkedList, int index) {
        //判断如果链表为空，返回null
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null) {
            return null;//没有找到
        }
        HeroNode temp = head.next;
        int i = 1;
        while (temp != null) {
            if (i == index) {
                return temp;
            }
            i++;
            temp = temp.next;
        }
        System.out.println("找出寻找范围，未找到");
        return null;
    }

    //将单链表反转【腾讯面试题】
    //自己的方法：循环嵌套循环，效率较低。反思：对于单链表来说，尽量避免反向遍历。
    public static void reversetList(SingleLinkedList singleLinkedList) {
        //判断如果链表为空，返回null
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null || head.next.next == null) {
            System.out.println("链表为空或只有一个元素，无需反转");
            return;//没有找到
        }
        //获取长度
        int length = singleLinkedList.getLength();
        //初始化第一个节点
        HeroNode first = null;
        //从倒数第二个节点进行遍历，并修改next
        for (int i = length - 1; i >= 0; i--) {
            if (i == 0) {
                head.next.next = null;
                break;
            }
            HeroNode cur = SingleLinkedListDemo.findIndexNode(singleLinkedList, i);
            if (i == length - 1) {
                first = cur.next;
            }
            cur.next.next = cur;
        }
        //换头节点
        head.next = first;
    }

    //将单链表反转【腾讯面试题】
    //老师的方法：遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
    //单向链表，正向遍历比反向遍历效率高得多
    public static void reversetListNew(SingleLinkedList singleLinkedList) {
        //判断如果链表为空，返回null
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null || head.next.next == null) {
            System.out.println("链表为空或只有一个元素，无需反转");
            return;//没有找到
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        //换头节点
        head.next = reverseHead.next;
    }

    //逆序打印单链表【百度面试题】
    //方式一：先将单链表进行反转操作，然后再遍历即可，这样的做的问题是会破坏原来的单链表的结构，不建议；
    //方式二：可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点。Java自带栈的util包
    public static void reversePrint(SingleLinkedList singleLinkedList) {
        //判断如果链表为空，返回null
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null) {
            System.out.println("链表为空，无需反转");
        }
        //如果只有一个元素
        if (head.next.next == null) {
            System.out.printf("逆序后的链表为%s", head.next);
        }
        //如果不是上述情况，通过栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        //出栈打印
        System.out.println("逆序后的链表为:");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    //将两个有序链表合并，合并后的链表依旧有序
    //自己的思路，以较长的链表为基础，遍历较短链表，将其插入长链表
    //存在的问题是：两个链表的节点关系需要保持一致，不能出现链表1：2>4>6，链表2:2>6这种。
    public static SingleLinkedList mergeLinkedList(SingleLinkedList singleLinkedList1, SingleLinkedList singleLinkedList2) {
        // 判断两个链表是否都为空或其中一个为空
        HeroNode head1 = singleLinkedList1.getHead();
        HeroNode head2 = singleLinkedList2.getHead();
        if (head1.next == null && head2.next == null) {
            return singleLinkedList1;
        }
        if (head1.next == null) {
            return singleLinkedList2;
        }
        if (head2.next == null) {
            return singleLinkedList1;
        }
        // 新建头节点，指向较长链表
        int length1 = singleLinkedList1.getLength();
        int length2 = singleLinkedList2.getLength();
        SingleLinkedList newSingleLinkedList = new SingleLinkedList();
        HeroNode head = newSingleLinkedList.getHead();
        head.next = length1 >= length2? head1.next : head2.next;
        HeroNode longTemp = head;
        HeroNode loopTemp = length1 >= length2? head2.next : head1.next;
//        Boolean existFlag = false;
        // 遍历短链表，并将其顺序插入长链表。若长链表中已存在节点，则不插入该节点
        while (loopTemp !=null){
            HeroNode shortTemp = loopTemp;
            loopTemp = loopTemp.next;
            while (longTemp.next != null){
                if (shortTemp.id <= longTemp.next.id){
                    break;
                }
//                if (shortTemp.id == longTemp.next.id){
//                    // 不插入该节点
//                    existFlag = true;
//                    break;
//                }
                longTemp = longTemp.next;
            }
//            if (!existFlag){
                // 插入
            shortTemp.next = longTemp.next;
            longTemp.next = shortTemp;
//            }

        }
        // 输出长链表
        return newSingleLinkedList;
    }
}



/**
 * 创建链表
 */
class SingleLinkedList{
    // 初始化头节点
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }
    //设置头节点
    public void setHead(HeroNode head){
        this.head = head;
    }

    // 添加节点，当不考虑编号的顺序时，找到当前链表的最后节点，将最后这个节点测next指向新节点
    public void add(HeroNode heroNode){
        HeroNode temp = head; // 引入临时变量
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        // 如果遍历到了末尾，则将末尾变量指向新增节点
        temp.next = heroNode;
    }

    // 按照顺序添加节点（根据节点id）
    public void addByOrder(HeroNode heroNode){
        //找到要添加的节点位置,引入临时变量
        HeroNode temp = head;
        //判断是否已存在的标志
        Boolean existFlag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(heroNode.id < temp.next.id){
                break;
            }
            if (heroNode.id == temp.next.id) {
                existFlag = true;
                break;
            }
            temp = temp.next;
        }
        //判断是否已存在，插入
        if(existFlag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.id);
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    // 修改节点, 根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //遍历
        //是否找到标志
        Boolean flag = false;
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.id == newHeroNode.id){
                //修改
                flag = true;
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;

            }
            temp = temp.next;
        }
        if(!flag){
            System.out.printf("未找到编号为%d的节点，不能修改",newHeroNode.id);
            return;
        }
    }

    //删除节点
    public void delete(int id){
        //遍历列表
        //是否找到标志
        Boolean flag = false;
        HeroNode temp = head;
        while(true){
            if(temp.next== null){
                break;
            }
            if(id == temp.next.id){
                flag = true;
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        //未找到该节点
        if(!flag){
            System.out.printf("未找到编号为%d的节点，不能修改",id);
            return;
        }
    }


    // 显示链表
    public void showList(){
        //先判断链表是否为空
        if (head.next == null){
            return;
        }
        //如果不为空则进行遍历
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 获取节点个数（如果是带头结点的链表，需求不统计头节点）
    public int getLength(){
        if (head.next == null){
            return 0;
        }
        HeroNode temp = head.next;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
/**
 * 创建节点类
 */

class HeroNode{
    public int id;//编号
    public String name;//姓名
    public String nickname; //昵称
    public HeroNode next; //下一节点

    public HeroNode(int id,String name,String nickname){
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+"}";
    }
}
