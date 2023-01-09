package com.example.demo.controller.task1;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<>();
    private static Long id = 4L;

    static {
        items.add(new Items(1L, "dfkgjdk","sekfp[sdko",3.0));
        items.add(new Items(2L, "dfkgjdk","sekfp[sdko",3.0));
        items.add(new Items(3L, "dfkgjdk","sekfp[sdko",3.0));
    }

    public static ArrayList<Items> getItems(){
        return items;
    }

    public static void addItems(Items item){
        item.setId(id);
        items.add(item);
        id++;

    }
}
