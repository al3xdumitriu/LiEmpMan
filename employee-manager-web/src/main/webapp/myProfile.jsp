

<header ng-include="'template/header.jsp'" ng-controller="headerController"></header>

	<div class=" thumbnail">
		<div class="caption">
			<!--  
			<img ng-src="{{profileImage}}" alt="Profile image" />
			<h3>My profile</h3>
			<div align="center">
				<div style="width: 200px;">
					<form action="">
						Username:<br> <input type="text" name="userName"
							ng-model="employee.name" required> <br> Phone:<br>
						<input type="text" name="phone" ng-model="employee.phone" required>
						<br> Email:<br> <input type="email" name="email"
							ng-model="employee.email" required> <br> Job Title:<br>
						<input type="text" name="jobTitle" ng-model="employee.jobTitle"
							required> <br> Experience Level:<br> <input
							type="text" name="expLevel" ng-model="employee.experienceLevel"
							required> <br> <input type="submit" disabled
							value="Save"> <input type="submit" disabled
							value="Cancel">
					</form>
				</div>
			</div>
-->
			<form class="form-horizontal">
				<img ng-src="{{profileImage}}" alt="Profile image"
					class="img-thumbnail">
				<fieldset>
					<legend>My profile</legend>
					<div class="form-group">
						<label for="userName">Username:</label><br>

						<div class="col-lg-12">
							<input type="text" class="form-control" id="userName"
								ng-model="employee.name" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="phone">Phone:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="phonne"
								ng-model="employee.phone" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="email">Email:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="email"
								ng-model="employee.email" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="jobTitle">Job Title:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="jobTitle"
								ng-model="employee.jobTitle" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="expLevel">Experience Level:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="expLevel"
								ng-model="employee.experienceLevel" disabled>
						</div>
					</div>

					<input class="btn btn-default" type="button" value="Save" disabled>
					<input class="btn btn-default" type="button" value="Cancel"
						disabled>
		</div>
	</div>
<footer ng-include="'template/footer.jsp'" ng-controller="footerController"></footer>