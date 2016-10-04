/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Atendente;
import Classes.Pessoa;
import Classes.PessoaFisica;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasfranco
 */
public class AtendenteDAOTest {

    @Test
    public void atendenteDAOadicionaSucesso() throws Exception {
        System.out.println("adiciona");
        Atendente atendente = new Atendente();
        AtendenteDAO adao = new AtendenteDAO();
        Pessoa pessoa = new Pessoa();
        PessoaFisica pf = new PessoaFisica();
        
        atendente.setPf(pf);
        atendente.getPf().setPessoa(pessoa);
        atendente.setLogin("atendente123");
        
        String login = "atendente123";
        adao.adiciona(atendente);
        assertEquals(login, atendente.getLogin());
       
    }
    
}
