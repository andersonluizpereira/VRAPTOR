<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>T�tulo</title>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
    <link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
</head>
<body>
    <header>
    </header>
    <nav>
        <ul class="nav nav-tabs">
            <li><a href="<c:url value='/' />">Home</a></li>
            <li><a href="<c:url value='/usuario/lista' />">Usuarios</a></li>
            <li><a href="<c:url value='/horaLancada/lista' />">Horas Cadastradas</a></li>
            <li><a href="<c:url value='/horaLancada/form' />">Cadastrar Horas</a></li>
           <li><a href="<c:url value='/horaLancada/relatorioDeHoras' />">Relatorio de Horas</a></li>
           

            <li> <a href="${linkTo[LoginController].desloga()} ">Logout</a></li>
           
<%--               <c:if test="${!usuarioLogado.isLogado()} ">  --%>
<%--              <li> <a href="${linkTo[LoginController].form()} ">Autenticar</a></li>  --%>
<%--             </c:if>  --%>
           
        </ul>
    </nav>
    <div class="container">
        <main class="col-sm-8">