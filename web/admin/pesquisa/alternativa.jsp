<%@page import="Bean.Pesquisa"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.AlternativaDao"%>
<%@page import="Bean.Alternativa"%>
<%@page import="Bean.Questao"%>

<jsp:include page="../head.jsp">
    <jsp:param name="pagina" value="questao"/>
</jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/admin/pesquisa/listar.jsp" var="pesquisa"></c:url>
<c:url value="/admin/pesquisa/questao.jsp" var="urlnovaquestao"></c:url>
<c:url value="/admin/alternativas" var="urlcadastrar"></c:url>
<c:url value="/admin/questoes" var="urlnovaquestao"></c:url>

<%
    Questao questao = (Questao) request.getAttribute("questao");
    Pesquisa pesquisa = (Pesquisa) request.getAttribute("pesquisa");
%>

<h2>Criar Alternativas para Questão: <%= questao.getDescricao()%></h2>

<div class="panel panel-default">
    <div class="panel-heading">Alternativas</div>
    <div class="panel-body">
        <form action="${urlcadastrar}" method="POST">

            <%
                List<Alternativa> alternativas = new ArrayList<Alternativa>();
                AlternativaDao dao = new AlternativaDao();
                alternativas = dao.list(questao.getId());

                for (Alternativa alternativa : alternativas) {
            %>  

            <p> <%= alternativa.getDescricao()%> </p>

            <% }%>

            <input type="text" class="form-control" name="alternativa.descricao" placeholder="Alternativa">            </br>
            <input type="hidden" value="<%= questao.getId()%>" name="questao.id">
            <input type="hidden" value="<%= pesquisa.getId() %>" name="pesquisa.id">
            <input type="hidden" name="comando" value="cadastrar">
            
            <button type="submit" class="btn btn-primary">Salvar Alternativa</button>
        </form>
        </br>
        
    </div>

</div>
    <form action="${urlnovaquestao}" method="POST">
            <input type="hidden" value="<%= pesquisa.getId() %>" name="pesquisa.id">
            <input type="hidden" name="comando" value="novaquestao">
            <button type="submit" class="btn btn-info">Criar nova Questão</button>
        </form>
            </br>
        <a href="${pesquisa}"><button class="btn btn-success">Finalizar Pesquisa</button></a>
    
</div>






<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>