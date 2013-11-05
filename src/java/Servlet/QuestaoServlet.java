/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Pesquisa;
import Bean.Questao;
import Dao.PesquisaDao;
import Dao.QuestaoDao;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Henrique
 */
public class QuestaoServlet extends HttpServlet {

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
        String comando = request.getParameter("comando");
        try {
            if ("cadastrar".equalsIgnoreCase(comando)) {
                cadastrarQuestao(request, response);
            } else if ("excluir".equalsIgnoreCase(comando)) {
                excluirQuestao(request, response);
            } else if ("alterar".equalsIgnoreCase(comando)) {
                alterarQuestao(request, response);
            } else if ("novaquestao".equalsIgnoreCase(comando)) {
                novaQuestao(request, response);
            }
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
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

    private void cadastrarQuestao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Questao questao = new Questao();

        questao.setDescricao(request.getParameter("questao.descricao"));
        questao.setTipo(Integer.parseInt(request.getParameter("questao.tipo")));

        Pesquisa pesquisa = new Pesquisa();
        PesquisaDao daopesquisa = new PesquisaDao();

        pesquisa = daopesquisa.find(Integer.parseInt(request.getParameter("pesquisa.id")));
        List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
        pesquisas.add(pesquisa);
        questao.setPesquisas(pesquisas);

        QuestaoDao dao = new QuestaoDao();
        questao = dao.add(questao);

        request.setAttribute("questao", questao);
        request.setAttribute("pesquisa", pesquisa);

        if (questao.getTipo() == 1 || questao.getTipo() == 2) {
            RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/alternativa.jsp");
            disp.forward(request, response);
        } else {
            RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/questao.jsp");
            disp.forward(request, response);
        }

    }

    private void excluirQuestao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestaoDao dao = new QuestaoDao();
        Questao questao = dao.find(Integer.parseInt(request.getParameter("questao.id")));

        Pesquisa pesquisa = new Pesquisa();
        PesquisaDao daopesquisa = new PesquisaDao();
        pesquisa = daopesquisa.find(Integer.parseInt(request.getParameter("pesquisa.id")));

        request.setAttribute("pesquisa", pesquisa);

        if (questao != null) {
                dao.delete(questao);
        }
        
        RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/questao.jsp");
        disp.forward(request, response);

    }

    private void alterarQuestao(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void novaQuestao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pesquisa pesquisa = new Pesquisa();
        PesquisaDao dao = new PesquisaDao();

        pesquisa = dao.find(Integer.parseInt(request.getParameter("pesquisa.id")));

        request.setAttribute("pesquisa", pesquisa);

        RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/questao.jsp");
        disp.forward(request, response);
    }
}
