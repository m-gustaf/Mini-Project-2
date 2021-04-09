package com.blocketlight.BlocketLight;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Item, Integer> {

    @Query(value = "SELECT * FROM Item WHERE Description LIKE %?1%", nativeQuery = true)
    Iterable<Item> findByKeyword(String keyword);

}
