
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Questao"%>
<%@page import="Bean.Alternativa"%>
<%@page import="Bean.Pesquisa"%>
<jsp:include page="head.jsp">
    <jsp:param name="pagina" value="home"/>
</jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/user/fim.jsp" var="fim"></c:url>

<%
    Pesquisa pesquisa = (Pesquisa) request.getAttribute("pesquisa");
%>

<div class="panel panel-default">
    <div class="panel-heading"><h1><%= pesquisa.getNome()%></h1></div>
    <div class="panel-body">

        <form class="form-group" action="${fim}" method="POST">

            <h3>Quantos anos você tem?</h3>
            <input type="text" class="input-group" name="idade"></p>
            <br>

            <h3>Sexo:</h3>
            <select class="form-group" name="sexo">
                <option value="0">Selecione</option>
                <option value="M">Masculino</option>
                <option value="F">Feminino</option>
            </select>

            <%
                List<Questao> questoes = new ArrayList<Questao>();
                questoes = pesquisa.getQuestoes();
                for (Questao questao : questoes) {
            %>
            </br>            
            <h3><%= questao.getDescricao()%></h3>

            <%
                if (questao.getTipo() == 3) {
            %>
            <textarea name="comentario" cols="80" rows="8"></textarea>
            <%}
                List<Alternativa> alternativas = new ArrayList<Alternativa>();
                alternativas = questao.getAlternativas();
                if (alternativas != null) {
                    for (Alternativa alternativa : alternativas) {
                        if (questao.getTipo() == 1) {
            %>
            <input class="checkbox-inline" type="checkbox" name="alternativa.id" value="<%= alternativa.getId()%>">  <%= alternativa.getDescricao()%><br>
            <%        }
                if (questao.getTipo() == 2) {
            %>
            <input class="radio-inline" type="radio" name="alternativa.<%= questao.getId()%>" value="<%= alternativa.getId()%>">  <%= alternativa.getDescricao()%><br>

            <%     }
                }
            } else {
            %>
            <p> Nao ha questoes</p>
            <%        }

                }
            %>
            </br>
            </br>
            
            <button type="submit" class="btn btn-primary">Salvar</button>

        </form>


    </div>
</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
