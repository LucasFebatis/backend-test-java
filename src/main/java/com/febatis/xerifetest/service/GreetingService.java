package com.febatis.xerifetest.service;

import java.util.List;

import com.febatis.xerifetest.entity.Greeting;
import com.febatis.xerifetest.repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService{

    @Autowired
    private GreetingRepository greetingRepository;

    public List<Greeting> findAll() {
        return greetingRepository.findAll();
    }

    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

}