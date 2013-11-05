<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Dao.QuestaoDao"%>
<%@page import="Bean.Questao"%>
<%@page import="Bean.Pesquisa"%>
<jsp:include page="../head.jsp">
    <jsp:param name="pagina" value="questao"/>
</jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/admin/questoes" var="urlcadastrar"></c:url>
<c:url value="/admin/pesquisa/listar.jsp" var="pesquisa"></c:url>

<%
    Pesquisa pesquisa = (Pesquisa) request.getAttribute("pesquisa");
%>

<h2>Criar Quest�es para Pesquisa: <%= pesquisa.getNome()%></h2>

<div class="panel panel-default">
    <div class="panel-heading">Quest�o</div>
    <div class="panel-body">

        <form action="${urlcadastrar}" method="POST">
            <input type="text" class="form-control" name="questao.descricao" placeholder="Quest�o">
            </br>
            <p>Tipo de Quest�o: <select name="questao.tipo" class="form-control">
                    <option value="0" selected>Selecione</option>
                    <option value="1">V�rias Alternativas</option>
                    <option value="2">�nica Alternativa</option>
                    <option value="3">Coment�rio</option>
                </select></p>
            <input type="hidden" name="comando" value="cadastrar">
            <input type="hidden" name="pesquisa.id" value="<%= pesquisa.getId()%>">
            <button type="submit" class="btn btn-primary">Criar</button>
        </form>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">Quest�es desta Pesquisa</div>
    <div class="panel-body">

        <table class="table">
            <tr><th>Quest�o</th><th>Tipo</th><th>Excluir</th>
            </tr>            

            <%
                List<Questao> questoes = new ArrayList<Questao>();
                questoes = pesquisa.getQuestoes();
                if (questoes != null) {
                    String tipo = null;
                    for (Questao questao : questoes) {
                        if (questao.getTipo() == 1) {
                            tipo = "V�rias Alternativas";
                        }
                        if (questao.getTipo() == 2) {
                            tipo = "�nica Alternativa";
                        }
                        if (questao.getTipo() == 3) {
                            tipo = "Coment�rio";
                        }
            %>  

            <tr><td><%= questao.getDescricao()%></td><td><%= tipo%></td>
                <td><a href="${urlcadastrar}?comando=excluir&pesquisa.id=<%=pesquisa.getId()%>&questao.id=<%=questao.getId()%>"<button class="btn btn-primary btn-xs">Excluir</button></td></tr>
            <% }
                }%>

        </table>
    </div>
</div>
                <a href="${pesquisa}"><button class="btn btn-success">Finalizar Pesquisa</button></a>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>