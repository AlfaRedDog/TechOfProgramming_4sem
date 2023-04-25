package ru.itmo;


import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //exercise one
        System.out.println("Starting project");
        //exercise two
        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';//кавычки
        int v_int = 65999;
        long v_long = 4294967;
        float v_float = 0.334234243f; // буква f на конце
        double v_double = 0.3333333333333333;
        boolean v_bool = true;
        System.out.println(v_byte);
        System.out.println(v_short);
        System.out.println(v_char);
        System.out.println(v_int);
        System.out.println(v_long);
        System.out.println(v_float);
        System.out.println(v_double);
        System.out.println(v_bool);
        //exercise three
        for (char a = 'a'; a <= 'z'; a++) {
            System.out.println(a);
        }

        int i = 0;
        long begin = new java.util.Date().getTime(), end = 0;
        while (i < 100000000) {
            i++;
            end = new java.util.Date().getTime();
        }
        System.out.println(end - begin);//значение с int 399, 370, 353 ; с long 382, 360, 418
        //exercize five-one
        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        System.out.println(Arrays.stream(mas).max().getAsInt());
        //exercise five-two
        int n = 3;
        int[][] arr = new int[3][3];
        for (i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = (int) Math.round(Math.random() * 10);

        int[][] temp = new int[3][3];
        for (i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                temp[j][i] = arr[i][j];

    }
}
