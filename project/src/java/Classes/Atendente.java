/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Time;
import java.util.regex.Pattern;

/**
 *
 * @author Nicholas
 */
public class Atendente{
    private PessoaFisica pf;
    private Time comecoExpediente;
    private Time fimExpediente;
    private String senha;
    private String login;

    public Time getComecoExpediente() {
        return comecoExpediente;
    }

    public Time getFimExpediente() {
        return fimExpediente;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setComecoExpediente(Time comecoExpediente) {
        this.comecoExpediente = comecoExpediente;
    }

    public void setFimExpediente(Time fimExpediente) {
        this.fimExpediente = fimExpediente;
    }

    public void setSenha(String senha) throws Exception{
        if(validaSenha(senha))
            this.senha = senha;
        else
            throw new Exception("Senha Invalida");
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    private boolean validaSenha(String senha) {
        String password_pattern = ("^(?=.*\\d)(?=.*[a-zA-Z]).{6,15}");

        return Pattern.matches(password_pattern, senha);
    }
    
}
