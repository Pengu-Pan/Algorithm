package org.example.dataStructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class Queue8 {
    static int[][] map = new int[8][8];
    static int cnt = 0; // 记录方案数量
    static int judgeCount = 0; // 记录判断次数
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.put(map,0);
        System.out.printf("一共有%d解法", cnt);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);
    }

    public void put(int[][] map, int i) {
        if (i == 8) {
            cnt++;
            return;
        }
        List<Integer> record = new ArrayList<>();
        // 1.选位置 遍历所有列向
        for (int j = 0; j < 8; j++) {
            map[i][j] = 1;
            if (feasible(map, i, j)) {
                put(map, i + 1);
            }
            map[i][j] = 0;
        }
    }


    public Boolean feasible(int[][] map,int i0,int j0){
        judgeCount ++;
        for (int i = 0; i < i0; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if ( map[i][j] == 0){
                    continue;
                }
                if (j == j0){
                    return false;
                }
                if (Math.abs(j-j0)== Math.abs(i-i0)){
                    return false;
                }
            }
        }
        return true;
    }
    }
