<div id="header" ng-include src="'template/header.jsp'"
	ng-controller="headerController" ng-hide="showHeader"></div>

<div id="contentDiv">
	<div class="row">
		<div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
			ng-controller=contentMenuController ng-hide="showContentMenu"></div>
		<div class="col-md-8">
			<div>
				<h1 class="page-header">
					<font color="#0597F2">Give Feedback</font>
				</h1>
				<div class="well bs-component">
					<form name="emailForm" class="form-horizontal"
						ng-submit="emailCtrl.sendEmail(emailCtrl.email)" novalidate>

						<div class="form-group">
							<label for="to" class="col-lg-2 control-label">To<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="email" name="to" class="form-control"
									ng-maxlength="255" ng-model="emailCtrl.email.to" placeholder="email@example.com" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.to.$dirty && emailForm.to.$invalid"> <span
								class="errorMessage" ng-show="emailForm.to.$error.required">Email
									is required.</span>
							</span>
							<div class="errorMessage" style="color: red"
								ng-show="emailForm.to.$error.maxlength">Input must be less
								than or equal to 255 characters.</div>
						</div>

						<div class="form-group">
							<label for="from" class="col-lg-2 control-label">From<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="email" name="from" class="form-control"
									ng-maxlength="255" ng-model="emailCtrl.email.from" placeholder="email@example.com" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.from.$dirty && emailForm.from.$invalid">
								<span class="errorMessage"
								ng-show="emailForm.from.$error.required">Email is
									required.</span>
							</span>
							<div class="errorMessage" style="color: red"
								ng-show="emailForm.from.$error.maxlength">Input must be
								less than or equal to 255 characters.</div>
						</div>

						<div class="form-group">
							<label for="subject" class="col-lg-2 control-label">Subject<span
								style="color: red">*</span>
							</label>
							<div class="col-lg-10">
								<input type="text" name="subject" class="form-control"
									ng-maxlength="255" ng-model="emailCtrl.email.subject" placeholder="subject" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.subject.$dirty && emailForm.subject.$invalid">
								<span class="errorMessage"
								ng-show="emailForm.subject.$error.required">Subject is
									required.</span>
							</span>
							<div class="errorMessage" style="color: red"
								ng-show="emailForm.subject.$error.maxlength">Input must be
								less than or equal to 255 characters.</div>
						</div>
						<div class="form-group">
							<label for="text" class="col-lg-2 control-label">Message<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="text" name="text" class="form-control"
									ng-maxlength="255" ng-model="emailCtrl.email.text" placeholder="message" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.text.$dirty && emailForm.text.$invalid">
								<span class="errorMessage"
								ng-show="emailForm.text.$error.required">Message is
									required.</span>
							</span>
							<div class="errorMessage" style="color: red"
								ng-show="emailForm.text.$error.maxlength">Input must be
								less than or equal to 255 characters.</div>
						</div>

						<div class="form-group">
							<label for="imageName" class="col-lg-2 control-label">Image</label>
							<div class="col-lg-10">
								<input type="text" name="imageName" accept="image/*"
									class="form-control" ng-maxlength="255" placeholder="E:\\image.jpg"
									ng-model="emailCtrl.email.imageName">
							</div>
							<br></br>
						</div>
						<div class="form-group">
							<label for="attachmentName" class="col-lg-2 control-label">Attachment</label>
							<div class="col-lg-10">
								<input type="text" name="attachmentName" class="form-control" placeholder="E:\\file.txt"
									ng-maxlength="255" ng-model="emailCtrl.email.attachmentName">
							</div>
							<br></br>
						</div>
						<div ng-hide=hideSuccessMessage>
						<div ng-show=submissionSuccess>Your feedback was sent
							successfully!</div></div>
						<br></br>
						<div>
							<button class="btn btn-primary" ng-disabled="!emailForm.$valid"
								type="submit">Send Feedback</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>