package ru.billing.stocklist;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;
    @Override
    public void printAll(){
        System.out.printf("ID: %d , Name: %s , price:%5.2f, Categoty: %s, Warranty time: %d\n",
                this.getId(), this.getName(), this.getPrice(), this.getCategory(), warrantyTime);
    }

    public TechnicalItem(String name, float price, Category category, short warrantyTime) {
        super(name, price, category);
        this.warrantyTime = warrantyTime;
    }

    public TechnicalItem(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Override
    public boolean equals(Object o){
        return this == o;
    }
    @Override
    public Object clone(){
        return this;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}
