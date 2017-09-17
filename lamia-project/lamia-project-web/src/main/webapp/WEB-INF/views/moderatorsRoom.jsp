
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>ModeratorsRoom</title>
    <link href="webContent/CSS/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="webContent/JS/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="webContent/JS/index.js"></script>
    <script type="text/javascript" src="webContent/ckeditor/ckeditor.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/mainElements/header.jsp" %>
        <div id="moderators-news"></div>
        <div id="moderators-menu">
            <form>
            <textarea name="editor1" id="editor1" rows="10" cols="80">
            </textarea>

            </form>
        </div>
    <%@ include file="/WEB-INF/views/mainElements/footer.jsp" %>
</body>
<script>
    CKEDITOR.replace( 'editor1' );
</script>
</html>
