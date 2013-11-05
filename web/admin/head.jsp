<%-- 
    Document   : index
    Created on : 01/10/2013, 12:22:07
    Author     : Luis Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/css/bootstrap.min.css" var="urlcss"></c:url>
<c:url value="/img/logo.png" var="urlimg"></c:url>
<c:url value="/admin" var="home"></c:url>
<c:url value="/admin/pesquisa/listar.jsp" var="pesquisa"></c:url>
<c:url value="/admin/pesquisa/nova.jsp" var="novapesquisa"></c:url>

    <!DOCTYPE html>
    <html>
        <head>
            <title>Projeto Marketing</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- Bootstrap -->
            <link href="${urlcss}" rel="stylesheet" medxia="screen">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <img src="${urlimg}" />
            </div>
            <nav class="navbar navbar-inverse" role="navigation">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li ${param.pagina == 'home' ? 'class="active"' : '' }><a href="${home}">Home</a></li>                         
                        <li ${param.pagina == 'pesquisa' ? 'class="active"' : '' }><a href="${pesquisa}">Listar Pesquisas</a></li>
                        <li ${param.pagina == 'novapesquisa' ? 'class="active"' : '' }><a href="${novapesquisa}">Cadastrar Pesquisa</a></li>
                    </ul>
                    </ul>
                </div>
            </nav>


