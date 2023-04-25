package ru.itmo;

public class  WorkArray <T extends Number> {
    T[] arrNums;

    public WorkArray(T[] arrP) {
        this.arrNums = arrP;
    }
    public double sum(){
        double doubleWork = 0;
        for (int i = 0; i < arrNums.length; i++){
            doubleWork += arrNums[i].doubleValue();
        }
        return doubleWork;
    }
}
