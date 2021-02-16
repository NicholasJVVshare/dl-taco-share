package com.dl.tacoloco.repo;

import java.util.List;
import java.util.UUID;

import com.dl.tacoloco.entity.TacoOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TacoOrderRepository extends CrudRepository<TacoOrder, UUID> {
    @Override
    List<TacoOrder> findAll();
}
