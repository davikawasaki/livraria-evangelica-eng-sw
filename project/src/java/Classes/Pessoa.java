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
public class Pessoa{
    private int id;
    private String telefone;
    private String email;
    private String CEP;
    private String logradouro;
    private String complemento;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    
    // Instância para validações de senha e e-mail
    Validacoes valida = new Validacoes();

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id >= 0)
            this.id = id;
        else
            throw new Exception("ID Invalido");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        telefone = telefone.replaceAll("\\D+","");
        if((telefone.length() == 10) || (telefone.length() == 11))
            this.telefone = telefone;
        else
            throw new Exception("Telefone Invalido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(valida.validaEmail(email)){
            this.email = email;
        }
        else
            throw new Exception("E-mail Invalido");
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) throws Exception {
        CEP = CEP.replaceAll("\\D+","");
        if(CEP.length() == 8)
            this.CEP = CEP;
        else
            throw new Exception("CEP Invalido");
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws Exception {
        if(logradouro.isEmpty())
            throw new Exception("Logradouro Invalido");
        else if(logradouro.length() < 45)
            this.logradouro = logradouro;
        else
            throw new Exception("Logradouro maior que 45 caracteres");
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws Exception {
        if(complemento.isEmpty() || complemento.length() < 45)
            this.complemento = complemento;
        else
            throw new Exception("Complemento maior que 45 caracteres");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if(numero > 0)
            this.numero = numero;
        else
            throw new Exception("Numero Invalido");
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        if(bairro.isEmpty())
            throw new Exception("Bairro Invalido");
        else if(bairro.length() < 45)
            this.bairro = bairro;
        else
            throw new Exception("Bairro maior que 45 caracteres");
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if(cidade.isEmpty())
            throw new Exception("Cidade Invalida");
        else if(cidade.length() < 45)
            this.cidade = cidade;
        else
            throw new Exception("Cidade maior que 45 caracteres");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if(estado.isEmpty())
            throw new Exception("Estado Invalido");
        else if(estado.length() < 45)
            this.estado = estado;
        else
            throw new Exception("Estado maior que 45 caracteres");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws Exception {
        if(pais.isEmpty())
            throw new Exception("País Invalido");
        else if(pais.length() < 45)
            this.pais = pais;
        else
            throw new Exception("País maior que 45 caracteres");
    }

}