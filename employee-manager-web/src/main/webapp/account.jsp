<script
  src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit"
  async defer>
 </script>
 

<div class="col-lg-6">
	<h2>Create Account</h2>
	<div class="well bs-component">
		<form name="accountForm" class="form-horizontal"
			ng-submit="accountCtrl.signup()" novalidate>
			
			<div class="form-group">
				<label for="name" class="col-lg-2 control-label">Name<span
					style="color: red">*</span></label>
				<div class="col-lg-10">
					<input type="text" name="name" class="form-control"
						ng-model="accountCtrl.account.employeeId.name" required>
				</div>
				<span style="color: red"
					ng-show="accountForm.name.$dirty && accountForm.name.$invalid">
					<span ng-show="accountForm.name.$error.required">Name is
						required.</span>
				</span> <br></br>
			</div>
			<div class="form-group">
				<label for="email" class="col-lg-2 control-label">Email<span
					style="color: red">*</span></label>
				<div class="col-lg-10">
					<input type="text" name="email" class="form-control"
						ng-model="accountCtrl.account.employeeId.email" required>
				</div>
				<span style="color: red"
					ng-show="accountForm.email.$dirty && accountForm.email.$invalid">
					<span ng-show="accountForm.email.$error.required">Email is
						required.</span>
				</span> <br></br>
			</div>
			<div class="form-group">
				<label for="phone" class="col-lg-2 control-label">Phone
					Number<span style="color: red">*</span>
				</label>
				<div class="col-lg-10">
					<input type="text" name="phone" class="form-control"
						ng-model="accountCtrl.account.employeeId.phone" required>
				</div>
				<span style="color: red"
					ng-show="accountForm.phone.$dirty && accountForm.phone.$invalid">
					<span ng-show="accountForm.phone.$error.required">Phone
						number is required.</span>
				</span> <br></br>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">Username<span
					style="color: red">*</span></label>
				<div class="col-lg-10">
					<input type="text" name="username" class="form-control"
						ng-model="accountCtrl.account.username" required>
				</div>
				<span style="color: red"
					ng-show="accountForm.username.$dirty && accountForm.username.$invalid">
					<span ng-show="accountForm.username.$error.required">Username
						is required.</span>
				</span> <br></br>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">Password<span
					style="color: red">*</span></label>
				<div class="col-lg-10">
					<input type="password" name="password" class="form-control"
						ng-model="accountCtrl.account.password" ng-minlength="6" required>
				</div>
				<span style="color: red"
					ng-show="accountForm.password.$dirty && accountForm.password.$invalid">
					<span ng-show="accountForm.password.$error.required">Password
						is required.</span>
				</span> <br></br>
			</div>
			<div class="form-group">
			<label for="confirmPassword" class="col-lg-2 control-label">Password confirmation<span
					style="color: red">*</span></label>
				<div class="col-lg-10">
					<input type="password" name="confirmPassword" class="form-control"
						ng-model="accountCtrl.account.confirmPassword"
						validation-check="accountCtrl.account.password == accountCtrl.account.confirmPassword"
						required>
				</div>
				<span style="color: red"
					ng-show="accountForm.confirmPassword.$dirty && accountForm.confirmPassword.$invalid">
					<span ng-show="accountForm.confirmPassword.$error.required">Password
						confirmation is required.</span>
				</span> <br></br>
			</div>
			<div ng-show="accountForm.password.$error.minlength">Must be at
				least 6 characters.</div>
			<div
				ng-show="!accountForm.confirmPassword.$valid && accountForm.confirmPassword.$dirty">Passwords
				don't match.</div>
			<div ng-show=submissionSuccess>Your account was created
				successfully!</div>
			<br></br>
			<!--Recaptcha Widget--->
				<div vc-recaptcha key="accountCtrl.publicKey"></div>
			<div>
			<button class="btn btn-primary"  type="submit">Create
				Account</button>
	</div>
	
	</form>
</div>
</div>