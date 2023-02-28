package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Offer;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.repository.CategoryRepository;
import bootcamp3.finalProject.repository.OfferRepository;
import bootcamp3.finalProject.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    public Offer addOffer(Offer offer){
        offer.setLocalDateTime(LocalDateTime.now());
        return offerRepository.save(offer);
    }

    public List<Offer> getOffers(){
    return offerRepository.findAll();
    }


    public void delOffer(Long id){
        offerRepository.deleteById(id);
    }
}
