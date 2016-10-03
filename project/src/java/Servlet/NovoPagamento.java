/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.CaixaDia;
import Classes.Cartao;
import Classes.Pagamento;
import DAOclasses.CaixaDiaDAO;
import DAOclasses.PagamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class NovoPagamento extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        Pagamento pag = new Pagamento();
        
        pag.setValorTotal(Integer.parseInt(request.getParameter("valorTotal")));
        
        String tipo = request.getParameter("tipoPagamento");

        Cartao card = new Cartao();
        card.setTipo(request.getParameter("tipoPagCartao"));
        card.setNumeroParcelas(Integer.parseInt(request.getParameter("parcelas")));
        pag.setTipo(tipo);
        pag.setDesconto(Float.parseFloat(request.getParameter("desconto")));
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String dataStr = sdf.format(dataDeHoje);
        //out.println(dataStr);
        
        
        
        java.sql.Date data;
        try {
            data = new java.sql.Date(sdf.parse(dataStr).getTime());
        //    out.println(data);
        
        pag.setHorario(dataDeHoje);
        
        CaixaDia caixa = new CaixaDia();
        caixa.getData();
        CaixaDiaDAO caixadao = new CaixaDiaDAO();
        caixadao.adiciona(caixa);
        try {
        //    out.println("abaixo");
            out.println();
            
            if(caixadao.buscaCaixa(data)){
                

            }
        } catch (Exception ex) {
            Logger.getLogger(NovoPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PagamentoDAO dao = new PagamentoDAO();
        
        
        dao.adiciona(pag);
        out.println("Cadastrado!");
    
    } catch (ParseException ex) {
            Logger.getLogger(NovoPagamento.class.getName()).log(Level.SEVERE, null, ex);
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
