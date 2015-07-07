<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Zip Page</title>


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.min.js"></script>  

<!-- 简单绿色 -->
<style type="text/css">
.smart-green {
	margin-left: auto;
	margin-right: auto;
	max-width: 500px;
	background: #F8F8F8;
	padding: 30px 30px 20px 30px;
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

.smart-green h1 {
	font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
	padding: 20px 0px 20px 40px;
	display: block;
	margin: -30px -30px 10px -30px;
	color: #FFF;
	background: #9DC45F;
	text-shadow: 1px 1px 1px #949494;
	border-radius: 5px 5px 0px 0px;
	-webkit-border-radius: 5px 5px 0px 0px;
	-moz-border-radius: 5px 5px 0px 0px;
	border-bottom: 1px solid #89AF4C;
}

.smart-green h1>span {
	display: block;
	font-size: 11px;
	color: #FFF;
}

.smart-green label {
	display: block;
	margin: 0px 0px 5px;
}

.smart-green label>span {
	float: left;
	margin-top: 10px;
	color: #5E5E5E;
}

.smart-green input[type="text"], .smart-green input[type="email"],
	.smart-green textarea, .smart-green select {
	color: #555;
	height: 30px;
	line-height: 15px;
	width: 100%;
	padding: 0px 0px 0px 10px;
	margin-top: 2px;
	border: 1px solid #E5E5E5;
	background: #FBFBFB;
	outline: 0;
	-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
	box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
	font: normal 14px/14px Arial, Helvetica, sans-serif;
}

.smart-green textarea {
	height: 100px;
	padding-top: 10px;
}

.smart-green select {
	background: url('down-arrow.png') no-repeat right,
		-moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
	background: url('down-arrow.png') no-repeat right,
		-webkit-gradient(linear, left top, left bottom, color-stop(0%, #FBFBFB),
		color-stop(100%, #E9E9E9));
	appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	text-indent: 0.01px;
	text-overflow: '';
	width: 100%;
	height: 30px;
}

.smart-green .button {
	background-color: #9DC45F;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-border-radius: 5px;
	border: none;
	padding: 10px 25px 10px 25px;
	color: #FFF;
	text-shadow: 1px 1px 1px #949494;
}

.smart-green .button:hover {
	background-color: #80A24A;
}
</style>

<script type="text/javascript">
	function changeStyle() {
		var form = document.getElementById("messageForm");
		form.className = "elegant-aero";
	}
	
	function jqTest() {
		var value = $("#content").val();
		alert(value);
	}
	
	function convertZip() {
		var value = $("#content").val();
		$.ajax( {   
		    type : "POST",   
		    url : "${pageContext.request.contextPath}/utils/zip", 
		    data : {
		      'content' : value
		     },  
		    dataType: "json",   
		    success : function(data) {   
		        if(data.success){
		            $("#code").empty();
		            $("#code").val(data.data);
		        }   
		        else{   
		            alert("设置失败！");   
		        }   
		    },   
		    error :function(){   
		        alert("网络连接出错！");   
		    }   
		});   
		
	}
	
	function convertGZip() {
		var value = $("#content").val();
		$.ajax( {   
		    type : "POST",   
		    url : "${pageContext.request.contextPath}/utils/gzip", 
		    data : {
		      'content' : value
		     },  
		    dataType: "json",   
		    success : function(data) {   
		        if(data.success){
		            $("#code").empty();
		            $("#code").val(data.data);
		        }   
		        else{   
		            alert("设置失败！");   
		        }   
		    },   
		    error :function(){   
		        alert("网络连接出错！");   
		    }   
		});   
		
	}
	
	function convertBase64() {
		var value = $("#content").val();
		$.ajax( {   
		    type : "POST",   
		    url : "${pageContext.request.contextPath}/utils/base64", 
		    data : {
		      'content' : value
		     },  
		    dataType: "json",   
		    success : function(data) {   
		        if(data.success){
		            $("#code").empty();
		            $("#code").val(data.data);
		        }   
		        else{   
		            alert("设置失败！");   
		        }   
		    },   
		    error :function(){   
		        alert("网络连接出错！");   
		    }   
		});   
		
	}
	
</script>



</head>
<body>
<!-- 
	<button onclick="changeStyle()">简单绿</button>
	<button onclick="changeStyle()">基本灰</button>
	<button onclick="changeStyle()">优雅蓝</button>
	<button onclick="jqTest()">JqueryTest</button>
	 -->
	 
	<form id="messageForm" action="" method="post" class="smart-green">
		<h1>
			Message To Zip and Base64 <span>Please fill the texts in the
				fields.</span>
		</h1>
		<label> <span>Message :</span> <textarea id="content"
				name="content" placeholder="Your Message to Us"></textarea>
		</label> 
		<label>
			<span>&nbsp;</span> 
			<input type="button"
			class="button" value="Convert(Zip+Base64)" onclick="convertZip()"/>
		</label> 
		<label>
			<span>&nbsp;</span> 
			<input type="button"
			class="button" value="Convert(GZip+Base64)" onclick="convertGZip()"/>
		</label> 
		<label>
			<span>&nbsp;</span> 
			<input type="button"
			class="button" value="Convert(Base64)" onclick="convertBase64()"/>
		</label> 
		<label> <textarea id="code" name="code"></textarea>
		</label>
	</form>
</body>
</html>