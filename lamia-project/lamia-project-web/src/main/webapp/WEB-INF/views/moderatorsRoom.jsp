
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>ModeratorsRoom</title>
    <link href="CSS/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="JS/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="JS/index.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/mainElements/header.jsp" %>
    <div id="menu">
        <div id="moderators-news"></div>
        <div id="moderators-menu">
            <label id="moderators-news-label" class="moderators-label"> Добавить новость </label>
            <input id="moderators-news-topic-text" name="moderators-news-topic-text" class="content-moderators" placeholder="Введите заголовок новости" required/>
            <input id="moderators-news-main-text" name="moderators-news-main-text" class="content-moderators" type="text" placeholder="Введите текст новости" required/>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/mainElements/footer.jsp" %>
</body>
</html>
