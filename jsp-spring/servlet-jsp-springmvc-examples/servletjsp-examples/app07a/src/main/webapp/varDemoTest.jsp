<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Today's date:</p>
	<tags:varDemo>
    In long format: ${longDate}
    <br />
    In short format: ${shortDate}
</tags:varDemo>

</body>
</html>