<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Self-Eval Table</title>
<script src="table.js"></script>
<script src="index.html"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.9/angular.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body ng-app="myApp">
	<div ng-controller="myController">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Java</th>
					<th>Web Apps</th>
					<th>AngularJS</th>
					<th>Bootstrap</th>
					<th>JUnit</th>
					<th>Mockito</th>
					<th>Jenkins</th>
					<th>PCF</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="person in group">
					<td>{{person.name}}</td>
					<td>{{person.java}}</td>
					<td>{{person.webApps}}</td>
					<td>{{person.ajs}}</td>
					<td>{{person.bstrp}}</td>
					<td>{{person.junit}}</td>
					<td>{{person.mockito}}</td>
					<td>{{person.jenkins}}</td>
					<td>{{person.pcf}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>