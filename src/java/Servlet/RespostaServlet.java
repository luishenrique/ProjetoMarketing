/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Alternativa;
import Bean.Pesquisa;
import Bean.Questao;
import Bean.Resposta;
import Dao.AlternativaDao;
import Dao.PesquisaDao;
import Dao.QuestaoDao;
import Dao.RespostaDao;
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
public class RespostaServlet extends HttpServlet {

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
                cadastrarResposta(request, response);
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

    private void cadastrarResposta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PesquisaDao daoPesquisa = new PesquisaDao();
        Pesquisa pesquisa = daoPesquisa.find(Integer.parseInt(request.getParameter("pesquisa.id")));

        String questoes[] = request.getParameterValues("questao.id");

        for (int i = 0; i < questoes.length; i++) {
            System.out.println(i);
            Questao questao = new Questao();
            QuestaoDao daoQuestao = new QuestaoDao();
            questao = daoQuestao.find(Integer.parseInt(questoes[i]));
            Resposta resposta = new Resposta();
            RespostaDao daoResposta = new RespostaDao();

            resposta.setIdade(Integer.parseInt(request.getParameter("idade")));
            resposta.setSexo(request.getParameter("sexo"));
            resposta.setQuestao(questao);
            resposta.setPesquisa(pesquisa);

            if (questao.getTipo() == 1 || questao.getTipo() == 2) {
                String alternativasString[] = request.getParameterValues("alternativa[" + questoes[i] + "].id");
                List<Alternativa> alternativas = new ArrayList<Alternativa>();
                for (String a : alternativasString) {
                    AlternativaDao daoAlternativa = new AlternativaDao();
                    Alternativa alternativa = daoAlternativa.find(Integer.parseInt(a));
                    alternativas.add(alternativa);
                    resposta.setAlternativas(alternativas);                    
                }
            } else {
                resposta.setComentario(request.getParameter("comentario"));

            }
            daoResposta.add(resposta);
        }

        RequestDispatcher disp = request.getRequestDispatcher("/user/fim.jsp");
        disp.forward(request, response);

    }
}