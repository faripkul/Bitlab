package bootcamp3.security.services;

import bootcamp3.security.model.News;
import bootcamp3.security.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    private UserService userService;
    public News addNews(News news){
        news.setUser(userService.getUser());
        news.setPostDate(LocalDateTime.now());
        return newsRepository.save(news);
    }

    public List<News> getNews(){
      return newsRepository.findAll();
    }
    public News getNews(Long id){
        return newsRepository.findById(id).orElseThrow();
    }
}
