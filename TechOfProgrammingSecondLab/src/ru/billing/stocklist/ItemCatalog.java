package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.GenericItem;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private int size = 0;
    private HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer,GenericItem>();
    private ArrayList<GenericItem> ALCatalog =
            new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if(catalog.containsKey(item.getId()))
            throw new ItemAlreadyExistsException("Item Already exist");
        size++;
        catalog.put(item.getId(), item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }
    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }
    public GenericItem findItemByID(int id){
        return catalog.getOrDefault(id, null);
    }
    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.getId() == id) return i;
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
