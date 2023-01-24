package bootcamp3.security.api;

import bootcamp3.security.model.News;
import bootcamp3.security.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news")
    public List<News> getNews(){
        return newsService.getNews();

    }
}
