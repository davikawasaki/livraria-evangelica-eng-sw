/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Nicholas
 */
public class Reserva {
    private int idReserva;
    private int tempoDias;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) throws Exception {
        if(idReserva < 0)
            throw new Exception("Id invalido");
        this.idReserva = idReserva;
    }

    public int getTempoDias() {
        return tempoDias;
    }

    public void setTempoDias(int tempoDias) throws Exception {
        if(tempoDias <= 0)
            throw new Exception("Os dias devem ser maiores do que zero.");
        else if(tempoDias > 100)
            throw new Exception("Os dias devem ser menores do que 100.");
        this.tempoDias = tempoDias;
    }
    
}
