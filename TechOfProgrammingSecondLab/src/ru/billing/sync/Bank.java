package ru.billing.sync;

public class Bank {
    private int intTo;
    private int intFrom = 220;
    public synchronized void calc(int intTransaction, long lngTimeout) throws Exception {
        System.out.printf("BEFORE: IntTo: %d; IntFrom: %d; Thread: %s\n",
                intTo, intFrom, Thread.currentThread().getName());
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        }
        catch (InterruptedException e){
            throw new InterruptedException("Timeout error");
        }
        intTo += intTransaction;
        System.out.printf("AFTER: IntTo: %d; IntFrom: %d; Thread: %s\n",
                intTo, intFrom, Thread.currentThread().getName());
    }
}
