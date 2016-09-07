/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.servlet;

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
public class OiMundo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      
    @Override
    protected void service  (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        super.service(request, response); //To change body of generated methods, choose Tools | Templates.
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Primeira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Oi mundo Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @WebServlet("/adicionaContato")
    public class AdicionaContatoServlet extends HttpServlet {
        protected void service(HttpServletRequest request,  HttpServletResponse response) 
                throws IOException, ServletException {
    PrintWriter out = response.getWriter();
    // pegando os parâmetros do request
    String nome = request.getParameter("nome");
    String endereco = request.getParameter("endereco");
    String email = request.getParameter("email");
    String dataEmTexto = request.getParameter("dataNascimento");
    Calendar dataNascimento = null;
     // fazendo a conversão da data
    try {
    Date date = new SimpleDateFormat("dd/MM/yyyy")
    .parse(dataEmTexto);
    dataNascimento = Calendar.getInstance();
    dataNascimento.setTime(date);
    } catch (ParseException e) {
    out.println("Erro de conversão da data");
    return; //para a execução do método
    }
    // monta um objeto contato
    Contato contato = new Contato();
    contato.setNome(nome);
    contato.setEndereco(endereco);
    contato.setEmail(email);
    contato.setDataNascimento(dataNascimento);
    // salva o contato
    ContatoDao dao = new ContatoDao();
    dao.adiciona(contato);
    // imprime o nome do contato que foi adicionado
    out.println("<html>");
    out.println("<body>");
    out.println("Contato " + contato.getNome() +
    " adicionado com sucesso");
    out.println("</body>");
    out.println("</html>");
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
