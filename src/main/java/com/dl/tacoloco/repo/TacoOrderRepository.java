package com.dl.tacoloco.repo;

import com.dl.tacoloco.entity.TacoOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TacoOrderRepository extends CrudRepository<TacoOrder, String> {
    // public TacoOrder save(TacoOrder tacoOrderRequest);
}
