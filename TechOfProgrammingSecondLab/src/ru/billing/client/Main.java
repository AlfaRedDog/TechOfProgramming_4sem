package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;
import ru.billing.stocklist.*;
import ru.billing.sync.Bank;
import ru.billing.sync.BankThread;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {
        GenericItem genericItem1 = new GenericItem("oreo", 131.99f, Category.FOOD);
        GenericItem genericItem2 = new GenericItem("milka", 169.99f, Category.FOOD);
        GenericItem genericItem3 = new GenericItem("Lubyatovo", 41.99f, Category.FOOD);
        genericItem1.printAll();
        genericItem2.printAll();
        genericItem3.printAll();

        GenericItem[] arr = {null, null, null};
        FoodItem b = new FoodItem("double oreo", 160.30f, null, new java.util.Date(), (short) 15);
        b.setCategory(Category.FOOD);
        arr[0] = b;
        
        FoodItem c = new FoodItem("double milka", 161.30f, b, new java.util.Date(), (short) 8);
        c.setCategory(Category.FOOD);
        arr[1] = c;

        TechnicalItem a = new TechnicalItem("double lyubytovo",162.30f,Category.GENERAL, (short)15);
        arr[2] = a;

        for (int i = 0; i < 3; i++){
            arr[i].printAll();
        }


        String line = "Конфеты;45;120";
        String[] item_fld = line.split(";");
        FoodItem foodItem1 = new FoodItem(item_fld[0],new Float(item_fld[1]), Short.parseShort(item_fld[2]));
        foodItem1.printAll();
        System.out.println(foodItem1.equals(c));
        System.out.println(foodItem1.equals(foodItem1.clone()));

        ItemCatalog itemCatalog = new ItemCatalog();
        itemCatalog.addItem(genericItem1);
        itemCatalog.addItem(genericItem2);
        itemCatalog.addItem(genericItem3);
        itemCatalog.addItem(b);
        itemCatalog.addItem(a);
        itemCatalog.addItem(c);
        itemCatalog.addItem(foodItem1);

        long begin = System.currentTimeMillis(), end = 0;
        for(int i = 0; i < 1000000; i++) {
            itemCatalog.findItemByID(i);
        }
        end = System.currentTimeMillis();
        System.out.println("In HashMap: " + (end - begin)); //16, 16, 15

        long begin1 = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            itemCatalog.findItemByIDAL(i);
        long end1 = System.currentTimeMillis();
        System.out.println("In ArrayList: " + (end1 - begin1));//31, 16, 32


        CatalogLoader loader = new CatalogStubLoader();
        loader.load(itemCatalog);
        System.out.println(itemCatalog.findItemByID(7).getName());
        System.out.println(itemCatalog.findItemByID(8).getName());
        CatalogLoader loader1 = new CatalogFileLoader("C:\\Users\\mikhail\\Desktop\\TechOfProgrammingSecondLab\\src\\ru\\billing\\client\\items.lst");
        loader1.load(itemCatalog);
        for(int i = 0; i < itemCatalog.getSize(); i++){
            itemCatalog.findItemByID(i).printAll();
        }

        Bank bank = new Bank();
        BankThread threadOne = new BankThread(bank, 100, 2000);
        threadOne.setName("bankThreadOne");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        BankThread threadTwo = new BankThread(bank, 50, 300);
        threadTwo.setName("bankThreadTwo");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        //String str = "sd";
        //System.out.println(str instanceof Integer);
        BigDecimal first = new BigDecimal(15);
        BigDecimal second = new BigDecimal(15);
        System.out.println(first.equals(second));
        //Если вы создадите два объекта с помощью ключевого слова new ,
        //они никогда не будут указывать на одну и ту же ячейку памяти.
        first.add(second);
        first.multiply(second);
        first.divide(second);
        System.out.println(first); // не добавилось, не умножилось
        //first += second;
        //first *= second;
        //first /= second;
        System.out.println(first);
    }
}
