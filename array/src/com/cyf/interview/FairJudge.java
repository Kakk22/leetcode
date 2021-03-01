package com.cyf.interview;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

/**
 * 题目:
 * 有100张参赛图片,有10个评委对其进行评分 分数为 1-100
 * 每张图片除掉最高分和最低分得出平均分
 * grade[100][10]为图片数据
 * grade[3][1] 表示2号评委对4号图片的评分
 * <p>
 * 1、输出每张照片所得的分数
 * 2、找出最公平的评委编号。(评委所评分数与该图片的平均分相差最小)
 *
 * @author 陈一锋
 * @date 2021/3/1 11:03
 **/
public class FairJudge {

    public static void main(String[] args) {
        int[][] grade = getGrade();

        int[] avgGrade = doComputeAvg(grade);
        System.out.println(Arrays.toString(avgGrade));

        int id = doGetFairJudge(grade, avgGrade);

        System.out.println("偏差最小的是"+id+"号裁判");
    }

    /**
     * 获取最公平的裁判(离平均分最小)
     *
     * @param grade    原始数据
     * @param avgGrade 平均分数
     * @return /
     */
    private static int doGetFairJudge(int[][] grade, int[] avgGrade) {
        //存放所有裁判对照片平均值的差距结果
        int[] resultDiff = new int[grade[0].length];

        for (int i = 0; i < grade[0].length; i++) {
            int result = 0;
            for (int j = 0; j < grade.length; j++) {
                int diff = avgGrade[j] - grade[j][i];
                diff = diff >= 0 ? diff : -diff;
                result += diff;
            }
            System.out.println("第" + i + "个裁判100张照片的与平均值的偏差为:" + result);
            resultDiff[i] = result / avgGrade.length;
        }
        System.out.println(Arrays.toString(resultDiff));
        return getMinIndex(resultDiff);
    }


    //获取最大值的下标
    private static int getMinIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    /**
     * 计算平均得分
     *
     * @param grade 目标数据
     * @return 评分结果
     */
    private static int[] doComputeAvg(int[][] grade) {
        int[] avgGrade = new int[grade.length];
        for (int i = 0; i < grade.length; i++) {

            int max = 0;
            int min = 0;
            //获取最大最小值
            for (int j = 0; j < grade[i].length; j++) {
                max = Math.max(grade[i][j], max);
                min = Math.min(grade[i][j], min);
            }

            int sum = 0;
            for (int j = 0; j < grade[i].length; j++) {
                if (grade[i][j] == max || grade[i][j] == min) {
                    continue;
                }
                sum += grade[i][j];
            }
            int avg = sum / (grade[i].length - 2);
            System.out.println("第" + i + "张照片评分为:" + avg);
            avgGrade[i] = avg;
        }
        return avgGrade;
    }


    /**
     * 获取数据源
     *
     * @return /
     */
    private static int[][] getGrade() {
        Random random = new Random();
        int[][] grade = new int[100][10];
        System.out.println(grade.length);
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                grade[i][j] = random.nextInt(100) + 1;
            }
        }
        System.out.println(Arrays.deepToString(grade));
        return grade;
    }

}
