package bootcamp3.finalProject.api;

import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final UserService userService;

//    @GetMapping
//        public List<Places> getPlaces(){
//            return userService.getAllUserPLaces();
//        }


}
