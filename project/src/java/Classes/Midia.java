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
public class Midia {
    private Produto pdt;
    private String artista;
    private String tipoMidia;

    public Produto getPdt() {
        return pdt;
    }

    public void setPdt(Produto pdt) throws Exception {
            this.pdt = Objects.requireNonNull(pdt);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) throws Exception {
        if(artista.isEmpty()){
            throw new Exception("Artista invalido");
        }else if(artista.length() < 45){
            this.artista = artista;
        }else{
            throw new Exception("Artista invalido");
        }
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) throws Exception {
        if(tipoMidia.isEmpty()){
            throw new Exception("Midia invalida");
        }else if(tipoMidia.length()<45){
            this.tipoMidia = tipoMidia;
        }else{
            throw new Exception("Midia invalida");
        }
    }
}
