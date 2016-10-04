/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
public class NovoProduto extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        Produto produto = new Produto();
        produto.setTitulo(request.getParameter("titulo"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        
        produto.setPreco(Float.parseFloat(request.getParameter("desconto")));
        produto.setIdioma(request.getParameter("idioma"));
        produto.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        
        //Converte para Date para buscar o caixa correspondente no banco de dados
        try {        
           /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataStr = sdf.format(dataDeHoje);
            Date data = new java.sql.Date(sdf.parse(dataStr).getTime());
        
            CaixaDiaDAO caixadao = new CaixaDiaDAO();
            
            CaixaDia caixa = caixadao.buscaCaixa(data);
            if(caixa == null){
                caixa = new CaixaDia();
                caixa.setSaldoInicial(50);
                caixa.setEntradaBruto(100);
                caixa.setEntradaReal(100);
                caixa.setSaldoLiquido(100);
                caixa.setSaldoReal(100);
                caixa.setSaidaTotal(100);
                caixa.setData(data);
                caixadao.adiciona(caixa);
            }
            
            PagamentoDAO pdao = new PagamentoDAO();              
            pdao.adiciona(pag, caixa.getIdCaixa());
            
            if(tipo.equals("cartao")){
                Cartao card = new Cartao();
                card.setTipo(request.getParameter("tipoPagCartao"));
                card.setNumeroParcelas(Integer.parseInt(request.getParameter("parcelas")));
                card.setIdPagamento(pag.getIdPagamento());
                
                CartaoDAO cardDAO = new CartaoDAO();
                cardDAO.adiciona(card);
            }            
            */
            String contextPath= "http://localhost:8084/livraria_v1/dashboard.html";
            response.sendRedirect(response.encodeRedirectURL(contextPath));
       
        } 
        catch (Exception ex) {
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
