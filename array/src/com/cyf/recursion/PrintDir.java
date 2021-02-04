package com.cyf.recursion;

import java.io.File;
import java.util.Scanner;

/**
 * 递归打印文件夹
 *
 * @author 陈一锋
 * @date 2021/2/4 11:09
 **/
public class PrintDir {
    public static void main(String[] args) {
        System.out.println("请输入查找的文件夹名");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        File file = new File(filename);
        printDir(file);
    }

    private static void printDir(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getAbsolutePath());
            } else {
                printDir(f);
            }
        }
    }
}
