package kz.bitlab.servlets.task2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayNovostei {
    private static ArrayList<News>novosti=new ArrayList<>();
    private static Long id=4L;

    static {
        novosti.add(new News(1L, "KJDO","klstgn", "kdfg;o","sport"));
        novosti.add(new News(2L, "kljg","klstgn", "kdfg;o","culture"));
        novosti.add(new News(3L, "kljg","klstgn", "kdfg;o","culture"));
        novosti.add(new News(3L, "kljg","klstgn", "kdfg;o","sport"));
        novosti.add(new News(3L, "kljg","klstgn", "kdfg;o","cinema"));

    }
    public static ArrayList<News> getNews(){
        return novosti;
    }

    public static ArrayList<News> getOdnucategory(String category){
        ArrayList<News> novieNovosti= new ArrayList<>();
        for (News news : novosti){
            if (news.getCategory().equals(category)){
                novieNovosti.add(news);
            }
        }
        return novieNovosti;
    }
}
