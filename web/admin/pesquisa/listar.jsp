
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.PesquisaDao"%>
<%@page import="java.util.List"%>
<%@page import="Bean.Pesquisa"%>
<jsp:include page="../head.jsp">
    <jsp:param name="pagina" value="pesquisa"/>
</jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/admin/pesquisas" var="url"></c:url>


<div class="panel panel-default">
    <div class="panel-heading">Pesquisas</div>
    <div class="panel-body">        
                <div id="container" class="col-md-12">
                    <table class="table">
                        <tr><th>Nome</th><th>Inicio</th><th>Fim</th><th>Status</th><th>Apagar</th><th>Visualizar</th>
                        </tr>
                        <%
                            List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
                            PesquisaDao dao = new PesquisaDao();
                            pesquisas = dao.list();

                            for (Pesquisa pesquisa : pesquisas) {
                        %>  

                        <tr><td><%= pesquisa.getNome()%></td>
                            <td><%= pesquisa.getDataInicioView()%></td>
                            <td><%= pesquisa.getDataFimView()%></td>
                            <td><%= pesquisa.verificaData()%></td>
                            <td><a href="${url}?comando=excluir&pesquisa.id=<%=pesquisa.getId()%>" <button class="btn btn-primary btn-xs">Excluir</button></td>
                            <td><a href="${url}?comando=listar&pesquisa.id=<%=pesquisa.getId()%>" <button class="btn btn-info btn-xs">Visualizar</button></td>
                        </tr>

                        <% }%>

                    </table>

                </div>
            </div>


</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
