<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.id != null}">
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.id == null}">
                <li class="nav-item">
                    <a class="nav-link" href="login-page">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register-page">Register</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="ad-list-page">Adverts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="section-list-page">Sections</a>
            </li>

            <c:if test="${sessionScope.id != null}">
                <li class="nav-item">
                    <a class="nav-link" href="new-advert-page.jsp">New Avert</a>
                </li>
            </c:if>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <c:if test="${sessionScope.name != null}">
                <a class="nav-link" href="profile-page">
                    <c:out value="${sessionScope.name}"/>
                </a>
            </c:if>
            <c:if test="${sessionScope.name == null}">
                <a class="nav-link" href="profile-page">Profile</a>
            </c:if>
        </form>
    </div>
</nav>