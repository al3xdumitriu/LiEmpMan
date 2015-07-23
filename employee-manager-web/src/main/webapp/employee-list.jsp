

<input placeholder="search employee" class="form-control"
	ng-model="query">
<div align="left">
	<div class="list-group">
		<a href="#/employee/{{employee.id}}" class="list-group-item"
			ng-repeat="employee in employees | filter:query">
			{{employee.name}} </a>
	</div>
</div>
