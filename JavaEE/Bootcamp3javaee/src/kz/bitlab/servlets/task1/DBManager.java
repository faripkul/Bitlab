package kz.bitlab.servlets.task1;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items>items=new ArrayList<>();
    private static Long id = 2L;


static {
    items.add(new Items(1L, "dvks;","k.djg", 1654, 454));


}
public static void addItem(Items item){
    item.setId(id);
    items.add(item);
    id++;
}

public static ArrayList<Items> getItems(){
    return items;
}
public static Items getItem(Long id){
    for(Items it:items){
        if (it.getId()==id) {
            return it;
        }
    }
    return null;
}
}
