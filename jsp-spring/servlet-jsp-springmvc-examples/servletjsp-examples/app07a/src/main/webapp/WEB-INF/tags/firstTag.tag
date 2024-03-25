<%@ tag import="java.util.Date" import="java.text.DateFormat"%>
<%
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    Date now = new Date(System.currentTimeMillis());
    out.println(dateFormat.format(now));
%>
