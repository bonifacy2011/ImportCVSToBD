<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>


<h3>Список контактов </h3>
<table border="1px" cellpadding="5" cellspacing="5">
	<tr>
		<th width="150px">Id</th>
		<th width="150px">Name</th>
		<th width="150px">Surname</th>
		<th width="150px">Email</th>
		<th width="150px">Login</th>
		<th width="150px">Password</th>
	</tr>

	<c:forEach var="contact" items="${contactList}">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.name}</td>

            </tr>
        </c:forEach>
	</table>


    <c:if test="${currentPage != 1}">
        <td><a href="contactServ.do?page=${currentPage - 1}">Предыдущая</a></td>
    </c:if>



    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="contactServ.do?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     



    <c:if test="${currentPage lt noOfPages}">
        <td><a href="contactServ.do?page=${currentPage + 1}">Следующая</a></td>
    </c:if>
    
    
<p><a href="contact.do">Назад</a> 
</body>
</html>