<div id="header" ng-include src="'template/header.jsp'"
	ng-controller="headerController" ng-hide="showHeader"></div>

<div id="contentDiv">
	<div class="row">
		<div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
			ng-controller=contentMenuController ng-hide="showContentMenu"></div>
		<div class="col-md-8">
			<div>
				<h2>Give Feedback</h2>
				<div class="well bs-component">
					<form name="emailForm" class="form-horizontal"
						ng-submit="emailCtrl.sendEmail(emailCtrl.email)" novalidate>
						<div class="form-group">
							<label for="to" class="col-lg-2 control-label">To<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="email" name="to" class="form-control"
									ng-model="emailCtrl.email.to" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.to.$dirty && emailForm.to.$invalid"> <span
								ng-show="emailForm.to.$error.required">Email is required.</span>
							</span> <br></br>
						</div>
						<div class="form-group">
							<label for="from" class="col-lg-2 control-label">From<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="email" name="from" class="form-control"
									ng-model="emailCtrl.email.from" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.from.$dirty && emailForm.from.$invalid">
								<span ng-show="emailForm.from.$error.required">Email is
									required.</span>
							</span> <br></br>
						</div>
						<div class="form-group">
							<label for="subject" class="col-lg-2 control-label">Subject<span
								style="color: red">*</span>
							</label>
							<div class="col-lg-10">
								<input type="text" name="subject" class="form-control"
									ng-model="emailCtrl.email.subject" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.subject.$dirty && emailForm.subject.$invalid">
								<span ng-show="emailForm.subject.$error.required">Subject
									is required.</span>
							</span> <br></br>
						</div>
						<div class="form-group">
							<label for="text" class="col-lg-2 control-label">Message<span
								style="color: red">*</span></label>
							<div class="col-lg-10">
								<input type="text" name="text" class="form-control"
									ng-model="emailCtrl.email.text" required>
							</div>
							<span style="color: red"
								ng-show="emailForm.text.$dirty && emailForm.text.$invalid">
								<span ng-show="emailForm.text.$error.required">Message is
									required.</span>
							</span> <br></br>
						</div>
						<div class="form-group">
							<label for="imageName" class="col-lg-2 control-label">Image</label>
							<div class="col-lg-10">
								<input type="text" name="imageName" accept="image/*"
									class="form-control" ng-model="emailCtrl.email.imageName">
							</div>
							<br></br>
						</div>
						<div class="form-group">
							<label for="attachmentName" class="col-lg-2 control-label">Attachment</label>
							<div class="col-lg-10">
								<input type="text" name="attachmentName" class="form-control"
									ng-model="emailCtrl.email.attachmentName">
							</div>
							<br></br>
						</div>
						<div ng-show=submissionSuccess>Your feedback was sent
							successfully!</div>
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