package bootcamp.spring.trello.Services;

import bootcamp.spring.trello.Classes.*;
import bootcamp.spring.trello.Repository.CommentsRepository;
import bootcamp.spring.trello.Repository.TaskCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private TaskCategoriesRepository categoriesRepository;

    public List<BitlabComments> getComments(BitlabTasks tasks){
        return commentsRepository.findAllByTaskOrderByIdDesc(tasks);
    }

    public List<BitlabTaskCategories> getCategories(){
        return categoriesRepository.findAll();
    }
}
