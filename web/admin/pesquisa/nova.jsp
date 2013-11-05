<jsp:include page="../head.jsp">
    <jsp:param name="pagina" value="novapesquisa"/>
</jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/admin/pesquisas" var="urlcadastrar"></c:url>


    <div class="panel panel-default">
        <div class="panel-heading">Criar Pesquisa</div>
        <div class="panel-body">
            <form action="${urlcadastrar}" method="POST">
            <div class="form-group">
                <div id="container" class="col-md-12">
                    <label for="exampleInputEmail1">Nome:</label>
                    <input type="text" class="form-control" name="pesquisa.nome" placeholder="Nome">
                    </br>
                    <label>Tipo:</label>
                    <select class="form-control" name="pesquisa.tipo">
                        <option value="1">Quantitativa</option>
                        <option value="2">Qualitativa</option>
                    </select>
                    </br>
                    <label>Data Início:</label>
                    <input type="date" class="form-control" name="pesquisa.datainicio" placeholder="Data Inicio">
                    </br>
                    <label>Data Fim:</label>
                    <input type="date" class="form-control" name="pesquisa.datafim" placeholder="Data Fim">
                    </br>
                    <input type="hidden" name="comando" value="cadastrar">
                    <button type="submit" class="btn btn-primary">Criar</button>

                </div>
            </div>

    </div>

</form>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
