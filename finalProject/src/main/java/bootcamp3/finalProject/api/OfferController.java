package bootcamp3.finalProject.api;

import bootcamp3.finalProject.model.Comment;
import bootcamp3.finalProject.model.Offer;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.services.CommentService;
import bootcamp3.finalProject.services.OfferService;
import bootcamp3.finalProject.services.PlaceService;
import bootcamp3.finalProject.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;


    @PostMapping
    public Offer addOffer(@RequestBody Offer text){
        return offerService.addOffer(text);
    }

}
