<div>
	<h2>Create Account</h2>
	<div>
		<form name="accountForm"
			ng-submit="accountCtrl.addAccount(accountCtrl.account)" novalidate>
			<div>
				<label for="name">Name<span style="color: red">*</span></label> <input
					type="text" name="name"
					ng-model="accountCtrl.account.employeeId.name" required> <span
					style="color: red"
					ng-show="accountForm.name.$dirty && accountForm.name.$invalid">
					<span ng-show="accountForm.name.$error.required">Name is
						required.</span>
				</span> <br></br>
			</div>
			<div>
				<label for="email">Email<span style="color: red">*</span></label> <input
					type="text" name="email"
					ng-model="accountCtrl.account.employeeId.email" required><span
					style="color: red"
					ng-show="accountForm.email.$dirty && accountForm.email.$invalid">
					<span ng-show="accountForm.email.$error.required">Email is
						required.</span>
				</span> <br></br>
			</div>
			<div>
				<label for="phone">Phone Number<span style="color: red">*</span></label>
				<input type="text" name="phone"
					ng-model="accountCtrl.account.employeeId.phone" required><span
					style="color: red"
					ng-show="accountForm.phone.$dirty && accountForm.phone.$invalid">
					<span ng-show="accountForm.phone.$error.required">Phone
						number is required.</span>
				</span> <br></br>
			</div>
			<div>
				<label for="username">Username<span style="color: red">*</span></label>
				<input type="text" name="username"
					ng-model="accountCtrl.account.username" required> <span
					style="color: red"
					ng-show="accountForm.username.$dirty && accountForm.username.$invalid">
					<span ng-show="accountForm.username.$error.required">Username
						is required.</span>
				</span> <br></br>
			</div>
			<div>
				<label for="password">Password<span style="color: red">*</span></label>
				<input type="password" name="password"
					ng-model="accountCtrl.account.password" ng-minlength="6" required><span
					style="color: red"
					ng-show="accountForm.password.$dirty && accountForm.password.$invalid">
					<span ng-show="accountForm.password.$error.required">Password
						is required.</span>
				</span> <br></br>
			</div>
			<div>
				<input type="password" name="confirmPassword"
					ng-model="accountCtrl.account.confirmPassword"
					validation-check="accountCtrl.account.password == accountCtrl.account.confirmPassword"
					required><span style="color: red"
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
			<button ng-disabled="!accountForm.$valid" type="submit">Create
				Account</button>
	</div>
	</form>
</div>
</div>