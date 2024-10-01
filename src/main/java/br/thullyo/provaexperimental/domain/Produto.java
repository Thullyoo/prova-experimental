package br.thullyo.provaexperimental.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PRODUTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String descricao;

    private Double valor;

    private boolean disponivel;

    public Produto(ProdutoDTO produtoDTO){
        this.nome = produtoDTO.nome();
        this.valor = produtoDTO.valor();
        this.descricao = produtoDTO.descricao();
        this.disponivel = produtoDTO.disponivel();
    }
}
