package org.example.dataStructure;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.showList();
    }
}

/**
 * 创建链表
 */
class SingleLinkedList{
    // 初始化头节点
    private HeroNode head = new HeroNode(0,"","");

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
                ", nickname='" + nickname + '\'';
    }
}
