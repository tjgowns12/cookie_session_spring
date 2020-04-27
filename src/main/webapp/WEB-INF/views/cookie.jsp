<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function popup(){
		if("${cook}" == ""){
			window.open("popup","","width=300,height=200,top=500,left=500");
		}
	}
</script>
</head>
<body onload="popup()">
cookie 페이지 입니다.
${cookie }




</body>
</html>