/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Alternativa;
import Bean.Pesquisa;
import Bean.Questao;
import Dao.AlternativaDao;
import Dao.PesquisaDao;
import Dao.QuestaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Henrique
 */
public class AlternativaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = request.getParameter("comando");
        try {
            if ("cadastrar".equalsIgnoreCase(comando)) {
                cadastrarAlternativa(request, response);
            } else if ("listar".equalsIgnoreCase(comando)) {
                listarAlternativa(request, response);
            } else if ("excluir".equalsIgnoreCase(comando)) {
                excluirAlternativa(request, response);
            } else if ("alterar".equalsIgnoreCase(comando)) {
                alterarAlternativa(request, response);
            }
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

    private void cadastrarAlternativa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Alternativa alternativa = new Alternativa();
        AlternativaDao daoAlternativa = new AlternativaDao();
        Questao questao = new Questao();
        QuestaoDao daoQuestao = new QuestaoDao();
        
        Pesquisa pesquisa = new Pesquisa();
        PesquisaDao daoPesquisa = new PesquisaDao();
        
        pesquisa = daoPesquisa.find(Integer.parseInt(request.getParameter("pesquisa.id")));    

        questao = daoQuestao.find(Integer.parseInt(request.getParameter("questao.id")));

        alternativa.setDescricao(request.getParameter("alternativa.descricao"));
        alternativa.setQuestao(questao);

        daoAlternativa.add(alternativa);

        request.setAttribute("questao", questao);
        request.setAttribute("pesquisa", pesquisa);

        RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/alternativa.jsp");

        disp.forward(request, response);

    }

    private void listarAlternativa(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void excluirAlternativa(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void alterarAlternativa(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
