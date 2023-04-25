package ru.itmo;

public class Main {

    public static void main(String[] args) {
    Integer[] intArr = {10, 20, 15};
    Float[] floatArr = new Float[5];
    for(int i = 0; i < 5; i++){
        floatArr[i] = (float)Math.random() * 10;
    }
    WorkArray<Float> floatWorkArray = new WorkArray<>(floatArr);
	WorkArray<Integer> integerWorkArray = new WorkArray<>(intArr);
    System.out.println(floatWorkArray.sum());
    System.out.println(integerWorkArray.sum());

    }
}
