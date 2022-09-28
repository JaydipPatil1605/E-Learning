package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer> {

}
