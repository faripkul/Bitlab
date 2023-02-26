package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Offer;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.repository.CategoryRepository;
import bootcamp3.finalProject.repository.OfferRepository;
import bootcamp3.finalProject.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Autowired
    OfferRepository offerRepository;


    public List<Region> getAllRegions(){
        return regionRepository.findAll();
    }

    public Region addRegion(Region region){
        return regionRepository.save(region);
    }

    public Region getRegion(Long id){
        return regionRepository.findById(id).orElseThrow();
    }

    public Offer addOffer(Offer offer){
        return offerRepository.save(offer);
    }
}
