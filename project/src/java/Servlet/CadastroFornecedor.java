/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import DAOclasses.FornecedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eryc
 */
public class CadastroFornecedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        String nomeFantasia = request.getParameter("nomeFantasia");
        String cnpj = request.getParameter("cnpj");
        String nomeRepresentante = request.getParameter("nomeRepresentante");
        String tipoServico = request.getParameter("tipoServico");
        String tipoFornecimento = request.getParameter("tipoFornecimento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String logradouro = request.getParameter("logradouro");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pais = request.getParameter("pais");
        
        Fornecedor fornecedor = new Fornecedor();
        
        PessoaJuridica pj = new PessoaJuridica();
        fornecedor.setPj(pj);
        
        Pessoa pessoa = new Pessoa();
        fornecedor.getPj().setPessoa(pessoa);

        fornecedor.getPj().setNomeFantasia(nomeFantasia);
        fornecedor.getPj().setCNPJ(cnpj);
        fornecedor.setNomeRepresentante(nomeRepresentante);
        fornecedor.setTipoServico(tipoServico);
        fornecedor.setTipoFornecimento(tipoFornecimento);
        fornecedor.getPj().getPessoa().setTelefone(telefone);
        fornecedor.getPj().getPessoa().setEmail(email);
        fornecedor.getPj().getPessoa().setNumero(numero);
        fornecedor.getPj().getPessoa().setLogradouro(logradouro);
        fornecedor.getPj().getPessoa().setComplemento(complemento);
        fornecedor.getPj().getPessoa().setBairro(bairro);
        fornecedor.getPj().getPessoa().setCEP(cep);
        fornecedor.getPj().getPessoa().setCidade(cidade);
        fornecedor.getPj().getPessoa().setEstado(estado);
        fornecedor.getPj().getPessoa().setPais(pais);

        FornecedorDAO fdao = new FornecedorDAO();
        fdao.adiciona(fornecedor);
    
        String contextPath= "http://localhost:8084/livraria_v1";
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
        processRequest(request, response);
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
        processRequest(request, response);
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