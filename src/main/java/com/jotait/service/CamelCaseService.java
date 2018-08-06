package com.jotait.service;

import com.jotait.model.CamelCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CamelCaseService implements CrudRepository<CamelCase, Long> {


    @Override
    public <S extends CamelCase> S save(S s) {
        return null;
    }

    @Override
    public <S extends CamelCase> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public CamelCase findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CamelCase> findAll() {
        return null;
    }

    @Override
    public Iterable<CamelCase> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(CamelCase camelCase) {

    }

    @Override
    public void delete(Iterable<? extends CamelCase> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
