package ru.billing.sync;

public class BankThread extends Thread {
    Bank bankWork;
    int intTrans;
    long lngSleep;

    public BankThread(Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }
    public void run(){
        try {
            bankWork.calc(intTrans,lngSleep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
