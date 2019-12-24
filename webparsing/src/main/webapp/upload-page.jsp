<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<body>
${message}
<form action="upload-info" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <p>
        <select name="parser" id="parser">
            <c:forEach items="${parsers}" var="value">
                <option name ="${value}">${value}</option>
            </c:forEach>
        </select>
    </p>
    <input type="submit" />
</form>
</body>
</html>
