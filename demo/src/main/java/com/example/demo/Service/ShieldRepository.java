package com.example.demo.Service;

import com.example.demo.Contracts.WindshieldEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ShieldRepository extends CrudRepository<WindshieldEntity,Integer> {
     WindshieldEntity findById(int id);
     List<WindshieldEntity> findAll();
}
