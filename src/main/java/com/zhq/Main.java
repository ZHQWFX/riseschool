package com.zhq;

import java.util.Scanner;

public class Main {
    static int count11;
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] last = new int[num];
        int[] in = new int[num];
        for (int i = 0; i < num; i++) {
            last[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            in[i] = scanner.nextInt();
        }
        count11 = in[num-1];
        System.out.print("Preorder:");
        preOrder(last, in, num);
    }
    static int[] last1 = new int[10];
    static int[] in1 = new int[10];

    public static void preOrder(int[] last, int[] in, int num){
        if (num>0){
            System.out.print(" " + last[num-1] );
            if (last[num-1]==count11){
                return;
            }
            int i;
            for (i = 0; last[num-1] != in[i]; i++);
            preOrder(last,in,i);
            int count = 0;
            for (int j = i; j < last.length; j++) {
                last1[count++] = last[j];
            }
            count = 0;
            for (int j = i+1; j < last.length; j++) {
                in1[count++] = in[j];
            }

            preOrder(last1,in1,num-i-1);

        }
    }
}


