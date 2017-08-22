<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<a href="${linkTo[UsuarioController].form()}">Novo usuário</a>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Login</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${usuarios}" var="u">
            <tr>
                             
                <td> <a href="${linkTo[UsuarioController].buscar}?id=${u.id}" style="cursor:pointer;">  ${u.id}  </a></td>
                <td><a href="${linkTo[UsuarioController].buscar}?id=${u.id}" style="cursor:pointer;">${u.nome}</a></td>
                <td><a href="${linkTo[UsuarioController].buscar}?id=${u.id}" style="cursor:pointer;">${u.email}</a></td>
                <td><a href="${linkTo[UsuarioController].buscar}?id=${u.id}" style="cursor:pointer;">${u.login}</a></td>
              
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:import url="/WEB-INF/jsp/footer.jsp"/>