package com.example.demo.controller.task2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional //работа без параллельного вмешательства
public interface ItemRepository extends JpaRepository <BitlabItems, Long> {
//    List<BitlabItems> findAllByPriceGreaterThanEqual(double price);
//    List<BitlabItems> findAllByPriceGreaterThanEqualAAndPriceLessThanEqual(double from, double to);
//    List<BitlabItems> findAllByPriceBetweenOOrderByNameAsc(double from, double to);
  //  BitlabItems findByIdAndAndPriceBetween(Long id, double from, double to);

  //  @Query(value = "SELECT pff FROM BitlabItems pff WHERE pff.price BETWEEN :fromPrice AND :toPrice")
 //   List<BitlabItems>getBestPrice(@Param("fromPrice")double from,@Param("toPrice")double to);

    @Query(value = "SELECT item FROM BitlabItems item WHERE LOWER(item.name) LIKE :nameParam ORDER BY item.price ASC")
    List<BitlabItems> searchItemsAsc(String nameParam);

    @Query(value = "SELECT item FROM BitlabItems item WHERE LOWER(item.name) LIKE :nameParam ORDER BY item.price DESC")
    List<BitlabItems> searchItemsDesk(String nameParam);
}
