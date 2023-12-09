package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourcerNotFoundException;

@Repository

public class ProdutoRepository {
    // simulado um banco de dados.
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * metodo para retorna uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
      return produtos;
    }

    /**
     * metodo que retorna o produto encontrado pelo seu id.
     * @param id do produto que sera localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional <Produto> obterPorId(Integer id){
      return produtos
                    .stream()
                    .filter(produto -> produto.getId() == id)
                    .findFirst();
    }

    /**
     * metodo para adicionar na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adcionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar( Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @return retorna o produto depois de atualizar.
     */
    public Produto atualiza( Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()){
            throw new ResourcerNotFoundException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);
        return produto;
    }
  
}
