package com.Pessoa.apicrudpessoa.controllers;


import com.Pessoa.apicrudpessoa.models.PessoaModel;
import com.Pessoa.apicrudpessoa.repositorys.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;


    @PostMapping(value = "/" , produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoaModel){
        PessoaModel pessoa = pessoaRepository.save(pessoaModel);
        return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPessoa}", produces = "application/json")
    public ResponseEntity<PessoaModel> mostraPessoaId(@PathVariable(value = "idPessoa") Long idPessoa){
        PessoaModel pessoa = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<PessoaModel>> listar(){
        List<PessoaModel> pessoa = pessoaRepository.findAll();
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarnome/{nomePessoa}", produces = "application/json")
    public ResponseEntity<List<PessoaModel>> buscarNome(@PathVariable(value = "nomePessoa") String nomePessoa){
        List<PessoaModel> pessoa = pessoaRepository.buscaNome(nomePessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar(@RequestBody PessoaModel pessoaModel){
        PessoaModel pessoa = pessoaRepository.save(pessoaModel);
        return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public  ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Pessoal deletada com sucesso!!", HttpStatus.OK);
    }
}
