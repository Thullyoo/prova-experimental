package br.thullyo.provaexperimental.controller;

import br.thullyo.provaexperimental.domain.ProdutoDTO;
import br.thullyo.provaexperimental.domain.ProdutoListagemDTO;
import br.thullyo.provaexperimental.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<List<ProdutoListagemDTO>> registrar(@RequestBody ProdutoDTO produtoDTO){
        return ResponseEntity.ok().body(produtoService.registrar(produtoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoListagemDTO>> listar(){
        return ResponseEntity.ok().body(produtoService.listar());
    }

}
