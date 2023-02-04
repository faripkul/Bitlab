package bootcamp3.security.api;

import bootcamp3.security.model.News;
import bootcamp3.security.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newsService.getNews();

    }
    @GetMapping(value = "/news/{id}")
    public News getNews(@PathVariable("id")Long id){
        return newsService.getNews(id);
    }

    @PostMapping(value = "/news")
    public News addNews(@RequestBody News news){
        return newsService.addNews(news);
    }

    @PutMapping(value = "/news")
    public News updateNews(@RequestBody News news){
        return newsService.updateNews(news);
    }
    @DeleteMapping(value = "/news/{id}")
    public Boolean deleteNews(@PathVariable(name = "id")Long id){
      return newsService.deleteNews(id);
    }
}
