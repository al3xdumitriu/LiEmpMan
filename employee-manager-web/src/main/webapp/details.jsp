<link rel="stylesheet" href="resources/css/profile.css"/>
<div>
	<div >
		<form name="detailsForm">
			<img id="avatar" src="http://www.techrepublic.com/152-fly/bundles/techrepubliccore/images/icons/standard/icon-user-default.png" alt="Avatar">
			<fieldset>
				<h1 class="page-header">
					<font color="#0597F2">My profile</font>
				</h1>
				<div class="well bs-component">
				<div ng-model="employee.id"></div>
				<div>
					<label for="userName">Name:</label><br>

					<div>
						<input type="text" id="userName" ng-model="employee.name" name="name"
							class="form-control" disabled required>
					</div>
						
					<span style="color: red" ng-show="detailsForm.name.$error.required && detailsForm.name.$dirty" class="rightErrMsg">Name is required.</span>
					<br>
				</div>

				<div>
					<label for="phone">Phone:</label><br>
					<div>
						<input type="text" id="phone" ng-model="employee.phone"
							class="form-control" name="phone" disabled required ng-pattern="/^\+?\d{2,4}\s??[- ]?\d{3}[- ]?\d{3}[- ]?\d{0,3}$/">
					</div>
					<span style="color: red" ng-show="detailsForm.phone.$error.required && detailsForm.phone.$dirty" class="rightErrMsg">Phone is required.</span>
					<div class="errorMessage" style="color: red" ng-show="detailsForm.phone.$error.pattern">Invalid phone number.</div>
					<br>
				</div>

				<div>
					<label for="email">Email:</label><br>
					<div>
						<input type="text" id="email" ng-model="employee.email" name="email"
							class="form-control" disabled required>
					</div>
					<span style="color: red" ng-show="detailsForm.email.$error.required && detailsForm.email.$dirty" class="rightErrMsg">Email is required.</span>
					<br>
				</div>

				<div>
					<label for="jobTitle">Job Title:</label><br>
					<div>
						<input type="text" id="jobTitle" ng-model="employee.jobTitle" name="job"
							class="form-control" disabled required>
					</div>
					<span style="color: red" ng-show="detailsForm.job.$error.required && detailsForm.job.$dirty" class="rightErrMsg">Job title is required.</span>
					<br>
				</div>

				<div>
					<label for="expLevel">Experience Level:</label><br>
					<div>
						<input type="text" id="expLevel" name="experience"
							ng-model="employee.experienceLevel" class="form-control" disabled required>
					</div>
				
					<span style="color: red" ng-show="detailsForm.experience.$error.required && detailsForm.experience.$dirty" class="rightErrMsg">Experience level is required.</span>
					<br>
				</div>
				<div ng-hide=hideRaportUpload>
				<br>
				<center>Uploaded Successfully</center>
				</div>
				
				<div ng-hide=hideRaportSave>
				<br>
				<center>Saved Successfully</center>
				</div>
				
				</div>
				<div align="right">
				</br> <input class="btn btn-primary" id="edit" type="button" value="Edit">
				<input class="btn btn-primary" id="save" type="button" value="Save" ng-disabled="!detailsForm.$valid"
					disabled ng-click="saveMethode()"> <input
					class="btn btn-primary" id="cancel" type="button" value="Cancel"
					disabled>
					<input class="btn btn-primary" id="edit" type="button"  ng-click="serialize()" value="Upload to Amazon">
					</div>
					</fieldset>
					</form>
					
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