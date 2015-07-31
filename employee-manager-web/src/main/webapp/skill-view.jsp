<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="js/bootstrap-3.3.5-dist/css/star.css"/>
</head>

<body ng-app="starApp">
    <div ng-controller="StarCtrl"> 
    <div class=" thumbnail">
    <h1>Skills</h1>
    	<span ng-repeat="skill in skills">
    			{{skill.name}} : {{skill.rating}} 
        		<div star-rating rating-value="skill.rating" max="5" ></div>
        
        	
        </span>
	</div>
    </div>
</body>

</html>