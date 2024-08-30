package com.example.exerciciospring.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.exerciciospring.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>,
        PagingAndSortingRepository<Produto, Integer> {

}
