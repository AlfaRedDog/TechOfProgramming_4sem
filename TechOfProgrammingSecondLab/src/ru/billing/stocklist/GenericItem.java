package ru.billing.stocklist;

public class GenericItem {
    private int id;
    private String name;
    private float price;
    private Category category = Category.GENERAL;
    private GenericItem analogItem = null;
    private static int currentId = 0;

    public GenericItem(String name, float price, Category category) {
        this.category = category;
        this.id = GenericItem.currentId++;
        this.name = name;
        this.price = price;
    }
    public GenericItem(String name, float price, GenericItem analogItem) {
        this.id = GenericItem.currentId++;
        this.name = name;
        this.price = price;
        this.analogItem = analogItem;
    }
    public GenericItem() {
        this.id = GenericItem.currentId++;
        this.name = null;
        this.price = 0;
    }
    public void printAll(){
        System.out.printf("ID: %d , Name: %s , price:%5.2f, Categoty: %s\n",
                        id, name, price, category);
    }
    @Override
    public boolean equals(Object o){
        return this == o;
    }
    @Override
    public Object clone(){
        return this;
        //return this.analogItem; //Optional
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public GenericItem getAnalogItem() {
        return analogItem;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAnalogItem(GenericItem analogItem) {
        this.analogItem = analogItem;
    }

}
