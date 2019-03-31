<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>

    </head>
    <body>

        <div>Spis:</div>
        <c:forEach items="${values}" var="item">
            <div>

                <c:out value="${item.name}   " />
                <c:if test="${item.number == 1}">
                    - Pierwszy
                </c:if>

            </div>
        </c:forEach>

    </body>
</html>