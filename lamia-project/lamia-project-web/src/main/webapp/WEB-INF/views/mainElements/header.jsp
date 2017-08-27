<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/Tags.tld" prefix="m"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="header">
        <div id="overlay">
            <div id="overlay-buttons">
                <a id="overlay-link1" class="overlay-link" href="index.jsp">Главная</a>
            </div>
        </div>
    <core:if test="${Autorization != true}">
		<input type="button" id="button-window-autorization" value="Авторизация"> </input>
		<div id="wrap"></div>
		<div id="window">
			<form id="autorization-form" action="Autorization" method="POST">
				<label class="autorization-label content-autorization"> Авторизация </label>
				<input id="autorization-login" name="autorization-login" class="content-autorization" placeholder="Введите логин" required> </input>
				<input id="autorization-password" name="autorization-password" type="password" class="content-autorization" placeholder="Введите пароль" required> </input>
				<input id="button-autorization" type="submit" class="content-autorization" value="Авторизироваться"> </input>
			</form>
			<form id="registration-form" action="Registration" method="POST">
				<label class="autorization-label content-registration">Регистрация </label> 
				<input id="registration-login" name="registration-login" class="content-registration" placeholder="Введите логин" required> </input>
				<input id="registration-password" name="registration-password" type="password" class="content-registration" placeholder="Введите пароль" required> </input>
				<input id="registration-second-password" name="registration-second-password" type="password" class="content-registration" placeholder="Повторите пароль" required> </input>
				<input id="registration-email" name="registration-email" type="email" class="content-registration" placeholder="Введите e-mail" required> </input>
				<input id="button-registration" type="submit" class="content-registration" value="Зарегистрироваться"> </input>
				<m:Registration/>
			</form>
		</div>
    </core:if>
        <core:if test="${Autorization == true && Role == 0}">
            <form id="personal-room" action="PersonalRoom" method="POST">
                <input type="submit" id="button-personal-room" name="button-personal-room" value="Личный кабинет" > </input>
            </form>
        </core:if>
	</div>
</body>
</html>