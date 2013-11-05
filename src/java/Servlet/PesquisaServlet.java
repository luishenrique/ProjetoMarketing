/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Pesquisa;
import Dao.PesquisaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.text.ParseException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Henrique
 */
public class PesquisaServlet extends HttpServlet {

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
                cadastrarPesquisa(request, response);
            } else if ("listar".equalsIgnoreCase(comando)) {
                listarPesquisa(request, response);
            } else if ("excluir".equalsIgnoreCase(comando)) {
                excluirPesquisa(request, response);
            } else if ("alterar".equalsIgnoreCase(comando)) {
                alterarPesquisa(request, response);
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

    private void cadastrarPesquisa(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        Pesquisa pesquisa = new Pesquisa();

        pesquisa.setNome(request.getParameter("pesquisa.nome"));
        pesquisa.setTipo(Integer.parseInt(request.getParameter("pesquisa.tipo")));
        pesquisa.setDataInicio(request.getParameter("pesquisa.datainicio"));
        pesquisa.setDataFim(request.getParameter("pesquisa.datafim"));

        PesquisaDao dao = new PesquisaDao();
        pesquisa = dao.add(pesquisa);

        request.setAttribute("pesquisa", pesquisa);

        RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/questao.jsp");

        disp.forward(request, response);
    }

    private void listarPesquisa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Pesquisa pesquisa = new Pesquisa();
        PesquisaDao daopesquisa = new PesquisaDao();
        pesquisa = daopesquisa.find(Integer.parseInt(request.getParameter("pesquisa.id")));

        request.setAttribute("pesquisa", pesquisa);
        RequestDispatcher disp = request.getRequestDispatcher("/user/index.jsp");
        disp.forward(request, response);
    }

    private void excluirPesquisa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PesquisaDao dao = new PesquisaDao();
        Pesquisa pesquisa = dao.find(Integer.parseInt(request.getParameter("pesquisa.id")));

        if (pesquisa != null) {
            dao.delete(pesquisa);
            RequestDispatcher disp = request.getRequestDispatcher("/admin/pesquisa/listar.jsp");
            disp.forward(request, response);
        }
    }

    private void alterarPesquisa(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
