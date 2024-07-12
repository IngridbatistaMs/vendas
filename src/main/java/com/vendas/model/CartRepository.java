package com.vendas.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{


    @Query("SELECT c FROM Cart c WHERE c.closed = :closed ORDER BY c.id DESC")
    Iterable<Cart> findAllByClosed(@Param("closed") boolean closed);
}
