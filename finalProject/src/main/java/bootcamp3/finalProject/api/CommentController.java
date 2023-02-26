package bootcamp3.finalProject.api;

import bootcamp3.finalProject.model.Comment;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.services.CommentService;
import bootcamp3.finalProject.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/{id}")
  public List<Comment> getComment(@PathVariable("id")Long id){
    return commentService.getComments(id);
  }

  @PostMapping("/{id}")
  public Comment addComment(@RequestBody Comment comment,
                            @PathVariable ("id") Long id){
    return commentService.addComment(comment, id);
  }
}
