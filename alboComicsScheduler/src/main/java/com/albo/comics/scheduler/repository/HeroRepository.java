package com.albo.comics.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.albo.comics.scheduler.model.Hero;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
