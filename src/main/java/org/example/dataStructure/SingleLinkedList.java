package org.example.dataStructure;

public class SingleLinkedList {


}

/**
 * 创建节点类
 */

class HeroNode{
    public int id;//编号
    public String name;//姓名
    public String nickname; //昵称
    public HeroNode next; //下一节点

    public HeroNode(int id,String name,String nickname,HeroNode next){
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
