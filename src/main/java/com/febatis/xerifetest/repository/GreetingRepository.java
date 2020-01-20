package com.febatis.xerifetest.repository;

import com.febatis.xerifetest.entity.Greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long>{}