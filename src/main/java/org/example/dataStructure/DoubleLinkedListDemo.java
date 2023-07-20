package org.example.dataStructure;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("-----------双向链表的测试----------");
        HeroNode2 heroNode1 = new HeroNode2(1,"x", "x");
        HeroNode2 heroNode2 = new HeroNode2(2,"xx","xx");
        HeroNode2 heroNode3 = new HeroNode2(3,"xxx","xxx");
        HeroNode2 heroNode4 = new HeroNode2(4,"xxxx","xxxx");
        HeroNode2 heroNode5 = new HeroNode2(5,"xxxxx","xxxxx");
        HeroNode2 newheroNode = new HeroNode2(2,"xx1","xx1");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.list();
        System.out.println("--------修改过后的节点----------");
        doubleLinkedList.updata(newheroNode);
        doubleLinkedList.list();
        doubleLinkedList.delete(heroNode2.id);
        System.out.println("--------删除后的节点----------");
        doubleLinkedList.list();

    }
}
/**
 * 创建双向链表
 */
class DoubleLinkedList{
    //初始化
    private HeroNode2 head = new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }
    //遍历双向链表的方法
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            return;
        }
        //头节点不能动，所以要创建辅助节点
        HeroNode2 temp = head.next;
        while(true){
            //判断链表是否到最后
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //默认添加到双向链表的结尾
    public void add(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //修改一个结点的内容（和单链表一样）
    public void updata(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //找到需要修改的节点
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//链表已经遍历结束了
            }
            if (temp.id == heroNode2.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;
        } else {
            System.out.println("没有找到这个编号" + heroNode2.id);
        }
    }

    //删除一个节点
    public void delete(int id){
        //遍历列表
        Boolean flag = false;
        HeroNode2 temp = head.next;
        while(true){
            if(temp== null){
                break;
            }
            if (temp.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //未找到该节点
        if(!flag){
            System.out.printf("未找到编号为%d的节点，不能修改",id);
            return;
        }
        //找到了则修改
        temp.pre.next = temp.next;
        //删除最后一个节点时，防止出现空指针异常
        if(temp.next!=null){
            temp.next.pre = temp.pre;
        }
    }
}

/**
 * 双向链表节点类
 */
class HeroNode2{
    //定义节点的私有属性 编号，姓名 外号 和next
    public int id;
    public String name;
    public String nickname;
    public HeroNode2 next;//默认为null
    public HeroNode2 pre;//指向前一个结点，默认为null

    //构造器
    public HeroNode2() {
    }

    public HeroNode2(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    //重写toString 方便显示
    public String toString(){
        return "Heronode [id= "+id+",name="+name+",nickname="+nickname+"]";
    }
}