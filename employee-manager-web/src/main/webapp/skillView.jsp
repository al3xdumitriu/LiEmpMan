
<div ng-controller="StarCtrl">
	<div class=" thumbnail">
		<h1>Skills</h1>
		<span ng-repeat="skill in skills"> {{skill.name}} :
			{{skill.rating}}
			<div star-rating rating-value="skill.rating" max="5"></div>
		</span>
	</div>
</div>
