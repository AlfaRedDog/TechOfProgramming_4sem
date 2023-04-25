package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome; // дата производства
    private short expires; // срок годности
    public FoodItem(String name, float price, FoodItem analog, Date date, short expires){
        this.setName(name);
        this.setAnalogItem(analog);
        this.setPrice(price);
        this.dateOfIncome = date;
        this.expires = expires;
    }
    public FoodItem(String name, float price, short expires){
        this(name, price, null, new java.util.Date(), expires);
    }
    public FoodItem(String name){
        this(name, 0.0f, null, new java.util.Date(), (short)0);
    }

    @Override
    public void printAll(){
        System.out.printf("ID: %d , Name: %s , price:%5.2f, Categoty: %s, Date of income: %tD, expires: %d\n",
                            this.getId(), this.getName(), this.getPrice(), this.getCategory(), dateOfIncome, expires);
    }
    @Override
    public boolean equals(Object o){
        return this == o;
    }
    @Override
    public Object clone(){
        return this;
    }
}
