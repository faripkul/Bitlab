package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
