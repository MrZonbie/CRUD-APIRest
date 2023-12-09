package com.teste.primeiroexemplo.services;

// import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * metodo para retornar uma lista de produtos.
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * metodo que retorna o produto encontrado pelo seu id.
     * @param id do produto que sera localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * metodo para adicionar na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adcionado na lista.
     */
    public Produto adicionar(Produto produto){
       return produtoRepository.adicionar(produto);
    }

    /**
     * metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar( Integer id){
        produtoRepository.deletar(id);
    }

    /**
     * metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @param id do produto
     * @return retorna o produto depois de atualizar.
     */
    public Produto atualiza(Integer id, Produto produto){
        produto.setId(id);
        
        return produtoRepository.atualiza(produto);
    }

}
