/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Livro;
import Classes.Midia;
import Classes.Produto;
import DAOclasses.LivroDAO;
import DAOclasses.MidiaDAO;
import DAOclasses.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {        
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();

            Produto produto = new Produto();
            produto.setTitulo(request.getParameter("titulo"));
            out.println(produto.getTitulo());
            
            int tipo = Integer.parseInt(request.getParameter("tipoProduto"));
            out.println("TIPO: "+tipo);

            produto.setTipo(tipo);
            produto.setPreco(Float.parseFloat(request.getParameter("desconto")));
            produto.setIdioma(request.getParameter("idioma"));
            produto.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));
            produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.adiciona(produto);

            if(tipo == 1){
                Livro livro = new Livro();
                livro.setPdt(produto);
                livro.setEditora(request.getParameter("editora"));
                livro.setAutor(request.getParameter("autor"));

                LivroDAO ldao = new LivroDAO();

                ldao.adiciona(livro);
            }
            else if(tipo == 2){
                Midia midia = new Midia();
                midia.setPdt(produto);
                midia.setArtista(request.getParameter("artista"));
                midia.setTipoMidia(request.getParameter("tipoMidia"));

                MidiaDAO mdao = new MidiaDAO();
                mdao.adiciona(midia);
            }
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
