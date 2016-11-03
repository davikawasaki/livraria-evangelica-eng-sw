/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAOclasses.ClienteDAO;
import Classes.Pessoa;
import Classes.PessoaFisica;
import Classes.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davikawasaki
 */
public class EditaCliente extends HttpServlet {

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
    throws ServletException, IOException, Exception {
      try {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String idCliente = request.getParameter("idCliente");
        String codFidelidade = request.getParameter("codFidelidade");
        String fidelidade = request.getParameter("fidelidade");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("CPF");
        String rg = request.getParameter("RG");
        String dataNasc = request.getParameter("dataNascimento");
        String sexo = request.getParameter("sexo");
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

        Cliente cliente = new Cliente();

        PessoaFisica pf = new PessoaFisica();
        cliente.setPf(pf);

        Pessoa pessoa = new Pessoa();
        cliente.getPf().setPessoa(pessoa);
        cliente.setIdCliente(Integer.parseInt(idCliente));
        System.out.println(cliente.getIdCliente());
        cliente.setFidelidade(Boolean.parseBoolean(fidelidade));
        cliente.setCodFidelidade(codFidelidade);
        cliente.getPf().setNome(nome);
        cliente.getPf().setSobrenome(sobrenome);
        cliente.getPf().setCPF(cpf);
        cliente.getPf().setRG(rg);
        cliente.getPf().setSexo(sexo);
        
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date = new java.sql.Date(formatoData.parse(dataNasc).getTime());
        cliente.getPf().setDataNascimento(date);
        
        cliente.getPf().getPessoa().setTelefone(telefone);
        cliente.getPf().getPessoa().setEmail(email);
        cliente.getPf().getPessoa().setNumero(numero);
        cliente.getPf().getPessoa().setLogradouro(logradouro);
        cliente.getPf().getPessoa().setComplemento(complemento);
        cliente.getPf().getPessoa().setBairro(bairro);
        cliente.getPf().getPessoa().setCEP(cep);
        cliente.getPf().getPessoa().setCidade(cidade);
        cliente.getPf().getPessoa().setEstado(estado);
        cliente.getPf().getPessoa().setPais(pais);

        ClienteDAO cdao = new ClienteDAO();
        cdao.altera(cliente);

        String contextPath= "http://localhost:8084/livraria_v1";
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/dashboard.html"));
      } catch (Exception ex) {
        Logger.getLogger(EditaCliente.class.getName()).log(Level.SEVERE, null, ex);
      }

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
        } catch (Exception ex) {
            Logger.getLogger(DeletaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(DeletaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
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
