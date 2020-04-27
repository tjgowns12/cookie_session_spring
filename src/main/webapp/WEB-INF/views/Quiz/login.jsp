<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
function pop(){
	if("${cook}" == ""){
		window.open("pop","","width=300,height=200,top=500,left=500");
	}
}

</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="pop()">cookie 페이지 입니다<br>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${sessionScope.id eq null}">
<form action="chk">
<input type="text" name="id" placeholder="아이디"><br>
<input type="password" name="pwd" placeholder="비밀번호"><br>
<input type="submit" value="로그인">
</form>
</c:when>
<c:otherwise>
${user }님 로그인 상태 입니다.
<a href="main">main 이동</a>
</c:otherwise>

</c:choose>
</body>
</html>