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
public class Livro {
    private Produto pdt;
    private String editora;
    private String autor;

    public Produto getPdt() {
        return pdt;
    }

    public void setPdt(Produto pdt) {
        this.pdt = pdt;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
