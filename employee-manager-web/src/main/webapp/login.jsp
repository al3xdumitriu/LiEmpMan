<div class="col-md-8 col-md-offset-3">
    <h2>Login</h2>
    <div ng-show="vm.error" class="alert alert-danger">{{vm.error}}</div>
    <form name="form" ng-submit="vm.login()" role="form">
        <div class="form-group" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" class="form-control" ng-model="vm.username" required />
            <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" ng-model="vm.password" required />
            <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
        </div>
        <div class="form-actions">
        	<div class="btn-group">
            <button type="submit" ng-disabled="form.$invalid || vm.dataLoading" class="btn btn-primary">Login</button>
            <button type="submit" ng-disabled="form.$invalid || vm.dataLoading" class="btn btn-primary">Register</button>
            </div>
            
        </div>
    </form>
</div>