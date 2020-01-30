<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>List Of Ads</title>
</head>
<head>
    <%@ include file="head_styles_scripts.jsp" %>
    <link href="static/css/starter.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="header.jsp" %>
</body>
<body>
<div class="container">
    <h2>Adverts</h2>
    <form action="ad" method="post" id="advertForm" role="form" >
        <c:choose>
            <c:when test="${not empty advertList}">
                <table  class="table table-striped">
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>Text</td>
                        <td>Title</td>

                    </tr>
                    </thead>
                    <c:forEach var="ad" items="${advertList}">
                        <c:set var="classSucess" value=""/>
                        <c:if test ="${idAdvert == ad.id}">
                            <c:set var="classSucess" value="info"/>
                        </c:if>
                        <tr class="${classSucess}">
                            <td>${ad.id}</td>
                            <td>${ad.text}</td>
                            <td>
                                <a href="ad-view-page?id=${ad.id}">${ad.title}</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </form>
</div>
</body>
</html>
