<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="horas" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
  <label for="nome">Nome:</label>
  <input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuario.nome}" />
   <horas:validationMessage name="usuario.nome"/>

  <label for="email">E-mail:</label>
  <input type="text" name="usuario.email" id="email" class="form-control" value="${usuario.email}" />
   <horas:validationMessage name="usuario.email"/>

  <label for="login">Login:</label>
  <input type="text" name="usuario.login" id="login" class="form-control" value="${usuario.login}" />
   <horas:validationMessage name="usuario.login"/>

  <label for="senha">Senha:</label>
  <input type="password" name="usuario.senha" id="senha" class="form-control" />
   <horas:validationMessage name="usuario.senha"/>


<input type="submit" value="Cadastrar" class="btn" />

</form>

<%-- <a href="${linkTo[UsuarioController].form()}">Novo usuário</a> --%>
<c:import url="/WEB-INF/jsp/footer.jsp" />