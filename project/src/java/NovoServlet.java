/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import DAOclasses.FornecedorDAO;
import DAOclasses.PessoaDAO;
import DAOclasses.PessoaJuridicaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucasfranco
 */
public class NovoServlet extends HttpServlet {

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
       
        Fornecedor fornecedor = new Fornecedor();
        
        PessoaJuridica pj = new PessoaJuridica();
        fornecedor.setPj(pj);
        
        Pessoa pessoa = new Pessoa();
        fornecedor.getPj().setPessoa(pessoa);
        
        fornecedor.getPj().getPessoa().setTelefone(request.getParameter("telefone"));
        fornecedor.getPj().getPessoa().setEmail(request.getParameter("email"));
        fornecedor.getPj().getPessoa().setCEP(request.getParameter("cep"));
        fornecedor.getPj().getPessoa().setLogradouro(request.getParameter("logradouro"));
        fornecedor.getPj().getPessoa().setComplemento(request.getParameter("complemento"));
        fornecedor.getPj().getPessoa().setNumero(Integer.parseInt(request.getParameter("numero")));
        fornecedor.getPj().getPessoa().setBairro(request.getParameter("bairro"));
        fornecedor.getPj().getPessoa().setCidade(request.getParameter("cidade"));
        fornecedor.getPj().getPessoa().setEstado(request.getParameter("estado"));
        fornecedor.getPj().getPessoa().setPais(request.getParameter("pais"));
        fornecedor.getPj().setNomeFantasia(request.getParameter("nomeFantasia"));
        fornecedor.getPj().setCNPJ(request.getParameter("CNPJ"));
        fornecedor.setTipoServico(request.getParameter("tipoServico"));
        fornecedor.setTipoFornecimento(request.getParameter("tipoFornecimento"));
        fornecedor.setNomeRepresentante(request.getParameter("nomeRepresentante"));

        FornecedorDAO dao = new FornecedorDAO();
        dao.adiciona(fornecedor);
  
        out.println("Fornecedor cadastrada com sucesso!");
        out.close();
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
