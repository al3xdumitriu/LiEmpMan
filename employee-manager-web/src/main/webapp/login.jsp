<script
  src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit"
  async defer>
 </script>

<div>
<div align="center" style= "position: absolute; top :30%;left:40%">
    <h2>Please Login</h2>
    <div ng-show="vm.error" class="alert alert-danger">{{vm.error}}</div>
    <form name="form" " role="form">
        <div class="form-group form-inline" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
            <label for="username">Username: </label>
            <input type="text" name="username" id="username" class="form-control" ng-model="vm.username" required />
            <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
        </div>
        <div class="form-group form-inline" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" class="form-control" ng-model="vm.password" required />
            <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
        </div>
        
        <!--Recaptcha Widget--->
		<div vc-recaptcha key="'6LdjuAoTAAAAAN_VK2hwBJecTvmt8fdk_1EYHdtE'"></div>
		
        <div class="form-actions">
        	<div class="btn-group">
            <button type="submit" ng-disabled="form.$invalid || vm.dataLoading" ng-click="vm.login()" class="btn btn-primary">Login</button>
            <button type="submit" ng-click="vm.register()" class="btn btn-primary">Register</button>
            </div>
            
        </div>
        <div>
        </div>
    </form>
    <div class="text-danger">{{loginFailed}}</div>
</div>


