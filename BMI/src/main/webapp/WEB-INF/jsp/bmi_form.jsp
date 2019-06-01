<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>计算BMI</title>
</head>
<body>
	<form action="bmi.do" method="post">
		<p>体重(kg)：<input type="text" name="weight" /></p>
		<p>身高(m) ：<input type="text" name="height" /></p>
		<p><input type="submit" value="GO"></p>
	</form>
</body>
</html>