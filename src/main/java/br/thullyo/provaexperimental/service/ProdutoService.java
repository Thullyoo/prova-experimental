package br.thullyo.provaexperimental.service;

import br.thullyo.provaexperimental.domain.Produto;
import br.thullyo.provaexperimental.domain.ProdutoDTO;
import br.thullyo.provaexperimental.domain.ProdutoListagemDTO;
import br.thullyo.provaexperimental.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoListagemDTO> registrar(ProdutoDTO produtoDTO){
        produtoRepository.save(new Produto(produtoDTO));
        return this.listar();
    }

    public List<ProdutoListagemDTO> listar(){
        return produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "valor")).stream()
                .map(this::toListagem)
                .toList();
    }

    public ProdutoListagemDTO toListagem(Produto p){
        return new ProdutoListagemDTO(p.getNome(),p.getValor());
    }

}
