/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Objects;

/**
 *
 * @author danilo
 */
public class Livro {
    private Produto pdt;
    private String editora;
    private String autor;

    public Produto getPdt() {
        return pdt;
    }

    public void setPdt(Produto pdt) throws Exception {
        this.pdt = Objects.requireNonNull(pdt);
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) throws Exception {
        if(editora.isEmpty()){
            throw new Exception("Editora invalida");
        }else if(editora.length()<45){
            this.editora = editora;
        }else{
            throw new Exception("Editora invalida");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        if(autor.isEmpty()){
            throw new Exception("Autor invalido");
        }else if(autor.length()<45){
            this.autor = autor;
        }else{
            throw new Exception("Autor invalido");
        }
    }
}
