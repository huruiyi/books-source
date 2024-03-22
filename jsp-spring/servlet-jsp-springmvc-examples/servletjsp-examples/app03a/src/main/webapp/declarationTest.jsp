<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%!public String getTodaysDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}%>
<html>
<head>
<title>Declarations</title>
</head>
<body>
	Today is
	<%=getTodaysDate()%>
</body>
</html>