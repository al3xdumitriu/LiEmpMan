

<div id="registerContent">
	<div class="col-lg-6">
		<h1 align="center">Register</h1>
		<div class="well bs-component" style="padding-top: 35px;">
			<form name="accountForm" class="form-horizontal"
				ng-submit="accountCtrl.signup()" novalidate>

				<div class="form-group">
					<label for="name" class="accountLabel">Name<span
						style="color: red">*</span></label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="text" name="name" class="form-control"
								ng-model="accountCtrl.account.employeeId.name"
								ng-maxlength="255" style="width: 390px;" required>
						</div>
					</div>
					<span style="color: red"
						ng-show="accountForm.name.$dirty && accountForm.name.$invalid"><br></br>
						<span class="errorMessage"
						ng-show="accountForm.name.$error.required">Name is
							required.</span> </span> <br></br>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.name.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
				</div>

				<div class="form-group">
					<label for="email" class="accountLabel">Email<span
						style="color: red">*</span></label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="email" name="email" class="form-control"
								ng-model="accountCtrl.account.employeeId.email"
								ng-maxlength="255" style="width: 390px;" required>
						</div>
					</div>
					<span style="color: red"
						ng-show="accountForm.email.$dirty && accountForm.email.$invalid">
						<br></br> <span class="errorMessage"
						ng-show="accountForm.email.$error.required">Email is
							required.</span> <br></br>
					</span> <span class="errorMessage" style="color: red"
						ng-show="accountForm.email.$error.email">Email is not
						valid.</span> <br></br>
					</span>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.email.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
				</div>

				<div class="form-group">
					<label for="phone" class="accountLabel">Phone Number<span
						style="color: red">*</span>
					</label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="text" name="phone" class="form-control"
								ng-model="accountCtrl.account.employeeId.phone"
								ng-maxlength="255" style="width: 390px;" required>
						</div>
					</div>
					<span style="color: red"
						ng-show="accountForm.phone.$dirty && accountForm.phone.$invalid"><br></br>
						<span class="errorMessage"
						ng-show="accountForm.phone.$error.required">Phone number is
							required.</span> </span> <br></br>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.phone.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
				</div>

				<div class="form-group">
					<label for="username" class="accountLabel">Username<span
						style="color: red">*</span></label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="text" name="username" class="form-control"
								ng-model="accountCtrl.account.username" ng-maxlength="255"
								style="width: 390px;" required>
						</div>
					</div>
					<span style="color: red"
						ng-show="accountForm.username.$dirty && accountForm.username.$invalid"><br></br>
						<span class="errorMessage"
						ng-show="accountForm.username.$error.required">Username is
							required.</span> </span> <br></br>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.username.$error.maxlength">Input must
						be less than or equal to 255 characters.</div>
				</div>

				<div class="form-group">
					<label for="password" class="accountLabel">Password<span
						style="color: red">*</span></label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="password" name="password" class="form-control"
								ng-model="accountCtrl.account.password" ng-minlength="6"
								ng-maxlength="255" style="width: 390px;" required>
						</div>
					</div>
					<span style="color: red"
						ng-show="accountForm.password.$dirty && accountForm.password.$invalid"><br></br>
						<span class="errorMessage"
						ng-show="accountForm.password.$error.required">Password is
							required.</span> </span> <br></br>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.password.$error.minlength">Must be at
						least 6 characters.</div>
					<div class="errorMessage" style="color: red"
						ng-show="accountForm.password.$error.maxlength">Input must
						be less than or equal to 255 characters.</div>
				</div>

				<div class="form-group">
					<label for="confirmPassword" class="accountLabel">Password
						confirmation<span style="color: red">*</span>
					</label>
					<div class="accountInput">
						<div class="col-lg-7">
							<input type="password" name="confirmPassword"
								class="form-control"
								ng-model="accountCtrl.account.confirmPassword"
								validation-check="accountCtrl.account.password == accountCtrl.account.confirmPassword"
								ng-maxlength="255" style="width: 390px;" required>
						</div>
					</div>
					<span class="errorMessage" style="color: red"
						ng-show="accountForm.confirmPassword.$dirty && accountForm.confirmPassword.$invalid"><br></br>
						<span ng-show="accountForm.confirmPassword.$error.required">Password
							confirmation is required.</span> </span> <br></br>
				</div>

				<span class="errorMessage" style="color: red; padding-right: 5px;"
					ng-show="!accountForm.confirmPassword.$valid && accountForm.confirmPassword.$dirty">Passwords
					don't match.</span>
				<div align="center" ng-show=submissionSuccess>Your account was
					created successfully!</div>
				<div class="errorMessage" style="color: red; padding-right: 5px;"
					ng-show=usernameExists>This username already exists!</div>
				<br></br>
				<!--Recaptcha Widget--->
				<div class="recaptcha" vc-recaptcha key="accountCtrl.publicKey"></div>
				<br></br> <br></br> <br></br>
				<div class="registerButton">
					<button class="btn btn-primary" ng-disabled="!accountForm.$valid"
						type="submit">Register</button>
				</div>
				<div class="registerButton">
					<button class="btn btn-primary" type="submit"
						onclick="window.history.back()" style="width: 71px;">Back</button>
				</div>
				<br></br> <br></br>
			</form>
		</div>
	</div>
</div>