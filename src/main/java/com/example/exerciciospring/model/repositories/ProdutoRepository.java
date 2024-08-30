package com.example.exerciciospring.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.exerciciospring.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>,
        PagingAndSortingRepository<Produto, Integer> {

            public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);


            // findByNomeContaining
            // findByNomeisContaining
            // findByNomeContains

            // findByNomeStartsWith
            // findByNomeEndsWith

            // findByNomeNotContaining

            // @Query("SELECT p FROM Porduto p WHERE p.nome Like %:nome%") // nao funciona
            // public Iterable<Produto> searchByNameLike(@Param("nome")String nome);

}
