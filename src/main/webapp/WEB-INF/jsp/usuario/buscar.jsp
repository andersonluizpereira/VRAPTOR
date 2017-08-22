<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="horas" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[UsuarioController].alterar}" method="post">
  <input type="hidden" name="usuario.id" id="id" class="form-control" value="${usuariosed.id}" />
  <label for="nome">Nome:</label>
  <input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuariosed.nome}" />
   <horas:validationMessage name="usuario.nome"/>
     <label for="email">E-mail:</label>
  <input type="text" name="usuario.email" id="email" class="form-control" value="${usuariosed.email}" />
   <horas:validationMessage name="usuario.email"/>

  <label for="login">Login:</label>
  <input type="text" name="usuario.login" id="login" class="form-control" value="${usuariosed.login}" />
   <horas:validationMessage name="usuario.login"/>

  <label for="senha">Senha:</label>
  <input type="password" name="usuario.senha" id="senha" class="form-control" value="${usuariosed.senha}"  />
   <horas:validationMessage name="usuario.senha"/>


<input type="submit" value="Alterar" class="btn" />

</form>

<%-- <a href="${linkTo[UsuarioController].form()}">Novo usuário</a> --%>
<c:import url="/WEB-INF/jsp/footer.jsp" />