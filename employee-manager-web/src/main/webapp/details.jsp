<div>
	<div>
		<form>
			<img ng-src="{{profileImage}}" alt="Profile image">
			<fieldset>
				<legend>My profile</legend>

				<div ng-model="employee.id"></div>
				<div>
					<label for="userName">Username:</label><br>

					<div>
						<input type="text" id="userName" ng-model="employee.name" disabled>
					</div>
				</div>

				<div>
					<label for="phone">Phone:</label><br>
					<div>
						<input type="text" id="phone" ng-model="employee.phone" disabled>
					</div>
				</div>

				<div>
					<label for="email">Email:</label><br>
					<div>
						<input type="text" id="email" ng-model="employee.email" disabled>
					</div>
				</div>

				<div>
					<label for="jobTitle">Job Title:</label><br>
					<div>
						<input type="text" id="jobTitle" ng-model="employee.jobTitle"
							disabled>
					</div>
				</div>

				<div>
					<label for="expLevel">Experience Level:</label><br>
					<div>
						<input type="text" id="expLevel"
							ng-model="employee.experienceLevel" disabled>
					</div>
				</div>
				</br> <input class="btn btn-primary" id="edit" type="button" value="Edit">
				<input class="btn btn-primary" id="save" type="button" value="Save"
					disabled ng-click="saveMethode()"> <input class="btn btn-primary"
					id="cancel" type="button" value="Cancel" disabled>
	</div>
</div>
<script>
	$('#edit').click(
			function() {
				$('#expLevel').prop('disabled', false), $('#jobTitle').prop(
						'disabled', false);
				$('#email').prop('disabled', false);
				$('#phone').prop('disabled', false);
				$('#userName').prop('disabled', false);
				$('#save').prop('disabled', false);
				$('#cancel').prop('disabled', false);
			});

	$('#cancel').click(
			function() {
				$('#expLevel').prop('disabled', true), $('#jobTitle').prop(
						'disabled', true);
				$('#email').prop('disabled', true);
				$('#phone').prop('disabled', true);
				$('#userName').prop('disabled', true);
				$('#save').prop('disabled', true);
				$('#cancel').prop('disabled', true);
			});
	$('#save').click(
			function() {
				$('#expLevel').prop('disabled', true), $('#jobTitle').prop(
						'disabled', true);
				$('#email').prop('disabled', true);
				$('#phone').prop('disabled', true);
				$('#userName').prop('disabled', true);
				$('#save').prop('disabled', true);
				$('#cancel').prop('disabled', true);
			});
</script>