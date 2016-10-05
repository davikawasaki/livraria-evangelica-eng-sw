/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author danilo
 */
public class Produto {
    private int idProduto;
    private String titulo;
    private int tipo;
    private float preco;
    private String idioma;
    private int anoLancamento;
    private int quantidade;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) throws Exception {
        if(idProduto<0){
            throw new Exception("Id invalido");
        }
        this.idProduto = idProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if(titulo.isEmpty()){
            throw new Exception("Titulo invalido");
        }else if(titulo.length() < 45){
            this.titulo = titulo;
        }else{
            throw new Exception("Titulo invalido");
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) throws Exception {
        if(tipo<0 || tipo>3){
            throw new Exception("Tipo invalido");
        }  
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) throws Exception {
        if(preco < 0){
            throw new Exception("Preco invalido");
        }
        this.preco = preco;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) throws Exception {
        if(idioma.isEmpty()){
            throw new Exception("Idioma invalido");
        }else if(idioma.length() < 45){
            this.idioma = idioma;
        }else{
            throw new Exception("Idioma invalido");
        }
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) throws Exception {
        if(anoLancamento<0){
            throw new Exception("Ano invalido");
        }
        this.anoLancamento = anoLancamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        if(quantidade<0){
            throw new Exception("Quantidade invalida");
        }
        this.quantidade = quantidade;
    }  
}
