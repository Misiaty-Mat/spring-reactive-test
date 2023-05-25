package com.springfamework.mateusz.spring6reactiveexamples.repositories;

import com.springfamework.mateusz.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class PersonRepositoryImpl implements PersonRepository {

    Person alex = Person.builder().id(1).firstName("Alex").lastName("Smith").build();
    Person pierre = Person.builder().id(2).firstName("Pierre").lastName("Ferrari").build();
    Person michael = Person.builder().id(3).firstName("Michael").lastName("Petro").build();
    Person steve = Person.builder().id(4).firstName("Steve").lastName("Kowalski").build();

    @Override
    public Mono<Person> getById(final Integer id) {
        return findAll().filter(person -> Objects.equals(person.getId(), id)).next();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(alex, pierre, michael, steve);
    }
}
