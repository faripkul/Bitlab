package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Comment;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    public List<Comment> getComments(Long id){
        return commentRepository.findAllByComment(id);
    }

    public Comment getComment(Long id){
      return commentRepository.findById(id).orElseThrow();
    }

    public Comment addComment(Comment comment, Long placeId){
        comment.setPlaces(placeService.getPlace(placeId));
        comment.setUser(userService.getUser());
        comment.setLocalDateTime(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
