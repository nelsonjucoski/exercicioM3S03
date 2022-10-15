package com.Pessoa.apicrudpessoa.repositorys;

import com.Pessoa.apicrudpessoa.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    @Query(value = "select p from PessoaModel p where p.nome like %?1%")
    List<PessoaModel>buscaNome(String name);
}
