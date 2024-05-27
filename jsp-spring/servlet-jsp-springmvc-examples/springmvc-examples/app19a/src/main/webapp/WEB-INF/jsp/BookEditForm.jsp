<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Edit Book Form</title>
    <style>
      @import url("<c:url value="/css/main.css"/>");
    </style>
</head>
<body>
<%--commandName 用 modelAttribute替换--%>
<div id="global">
    <%--@elvariable id="book" type="vip.fairy.app19a.domain.Book"--%>
    <form:form modelAttribute="book" action="${pageContext.request.contextPath}/book_update" method="post">
        <fieldset>
            <legend>Edit a book</legend>
            <form:hidden path="id" />
            <p>
                <label for="category">Category:</label>
                <form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id" />
            </p>
            <p>
                <label for="title">Title:</label>
                <form:input id="title" path="title" />
            </p>
            <p>
                <label for="author">Author:</label>
                <form:input id="author" path="author" />
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input id="isbn" path="isbn" />
            </p>

            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Update Book">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
