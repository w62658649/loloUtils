<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function gozip(){
	var a ="${pageContext.request.contextPath}/go/zip";
	window.location.href=a; 
}
</script>
<title>LoLo工具页</title>
</head>
<body>
<h3>功能列表</h3>
<br>
<button id="gozip" name="gozip" onclick="gozip();">进行内容压缩加密</button>
</body>
</html>