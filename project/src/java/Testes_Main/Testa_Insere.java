/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import Classes.Livro;
import Classes.Pessoa;
import Classes.Produto;
import DAOclasses.LivroDAO;
import DAOclasses.PessoaDAO;
import DAOclasses.ProdutoDAO;

/**
 *
 * @author lucasfranco
 */
public class Testa_Insere {
    public static void main(String[] args) {
        Produto produto = new Produto();
        Livro livro = new Livro();
        
        produto.setTitulo("Porra de Cavalo");
        produto.setTipo(1);
        produto.setPreco((float) 24.51);
        produto.setIdioma("Ingres");
        produto.setAnoLancamento(2029);
        produto.setQuantidade(121);
        livro.setAutor("Danilão");
        livro.setEditora("Eita carai");
        livro.setPdt(produto);
        
        ProdutoDAO pdao = new ProdutoDAO();
        LivroDAO ldao = new LivroDAO();
        
        ldao.adiciona(livro);
        
        System.out.println("Gravado!");
    }
}
