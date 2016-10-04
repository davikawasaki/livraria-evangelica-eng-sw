/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Nicholas
 */
public class Atendente{
    private PessoaFisica pf;
    private Date comecoExpediente;
    private Date fimExpediente;
    private String senha;
    private String login;
    
    // Instância para validações de senha e e-mail
    Validacoes valida = new Validacoes();

    public Date getComecoExpediente() {
        return comecoExpediente;
    }

    public Date getFimExpediente() {
        return fimExpediente;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setComecoExpediente(Date comecoExpediente) throws Exception {
        Date dt = new Date();
        if(comecoExpediente.before(dt))
            throw new Exception("Horario Invalido");
        else
            this.comecoExpediente = comecoExpediente;
    }

    public void setFimExpediente(Date fimExpediente) throws Exception {
        Date dt = new Date();
        if(fimExpediente.after(dt))
            throw new Exception("Horario Invalido");
        else
            this.fimExpediente = fimExpediente;
    }

    public void setSenha(String senha) throws Exception{
        if(valida.validaSenha(senha))
            this.senha = senha;
        else
            throw new Exception("Senha Invalida");
    }

    public void setLogin(String login) throws Exception {
        if(login.isEmpty())
            throw new Exception("Login Invalido");
        else if((login.length() >= 5) && (login.length() < 45))
            this.login = login;
        else if(login.length() < 5)
            throw new Exception("Login menor que 5 caracteres");
        else
            throw new Exception("Login maior que 45 caracteres");
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }   
}
