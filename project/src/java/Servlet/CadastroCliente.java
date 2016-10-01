/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Pessoa;
import Classes.PessoaFisica;
import DAOclasses.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eryc
 */
public class CadastroCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
       
        Cliente cliente = new Cliente();
        
        PessoaFisica pf = new PessoaFisica();
        cliente.setPf(pf);
        
        Pessoa pessoa = new Pessoa();
        cliente.getPf().setPessoa(pessoa);
        
        cliente.getPf().getPessoa().setTelefone(request.getParameter("telefone"));
        cliente.getPf().getPessoa().setEmail(request.getParameter("email"));
        cliente.getPf().getPessoa().setCEP(request.getParameter("cep"));
        cliente.getPf().getPessoa().setLogradouro(request.getParameter("logradouro"));
        cliente.getPf().getPessoa().setComplemento(request.getParameter("complemento"));
        cliente.getPf().getPessoa().setNumero(Integer.parseInt(request.getParameter("numero")));
        cliente.getPf().getPessoa().setBairro(request.getParameter("bairro"));
        cliente.getPf().getPessoa().setCidade(request.getParameter("cidade"));
        cliente.getPf().getPessoa().setEstado(request.getParameter("estado"));
        cliente.getPf().getPessoa().setPais(request.getParameter("pais"));
        cliente.getPf().setCPF(request.getParameter("CPF"));
        cliente.getPf().setNome(request.getParameter("nome"));
        cliente.getPf().setSobrenome(request.getParameter("sobrenome"));
        cliente.getPf().setRG(request.getParameter("RG"));
        cliente.getPf().setSexo(request.getParameter("sexo"));     
        
        String dataNasc = request.getParameter("dataNascimento");  
        cliente.getPf().setDataNascimento(dataNasc);
       
        //cliente.setIdCliente(Integer.parseInt(request.getParameter("id")));
        cliente.setFidelidade(Boolean.getBoolean(request.getParameter("fidelidade")));
        cliente.setCodFidelidade(request.getParameter("codFidelidade"));
        
        ClienteDAO dao = new ClienteDAO();
        dao.adiciona(cliente);

        String contextPath= "http://localhost:8084/livraria_v1";
        out.println("Cadastrado!");
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/dashboard.html"));
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
