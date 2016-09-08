package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;

/**
 *
 * @author Nicholas
 */
public class PessoaFisica extends Pessoa{
    
    private int CPF;
    private String nome;
    private String sobrenome;
    private int RG;
    private String sexo;
    private Date dataAniversario;

    public int getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getRG() {
        return RG;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setCPF(int cpf) {
        this.CPF = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setRG(int rg) {
        this.RG = rg;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
