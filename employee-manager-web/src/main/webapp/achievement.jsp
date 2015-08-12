<link rel="stylesheet" href="resources/css/achievement.css"/>
<div>
	<div>
		<div>
			<br>
			<legend>Achievements</legend>
			<div class="well bs-component">
				
				<div
					ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id' 
					">

					
						<br>
						<b>{{achievement.name}} </b>
					
					<textarea rows="4" cols="40" class="form-control" disabled>{{achievement.description}}</textarea>
				</div>
				<br>
			</div>
			<div align="right">
			<span ng-if=areMoreAchievements()>
			<button ng-click="add()" class="btn btn-primary">Show More</button>
			</span>
			<button ng-click="arata()" class="btn btn-primary">Add
				Achievement</button>
				</div>
			<br>	
			<div ng-hide=ascunde class="well bs-component">
				
				<form name="achievementForm">
					 <b>Title:</b> <input type="text" ng-model="achievementTest.name" name="title"
						class="form-control" ng-maxlength="255">
						
						<div align="right" style="color: red"
						ng-show="achievementForm.title.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
			
						<br> 
						<b>Description:</b><br> 

					<textarea rows="4" cols="40" ng-model="achievementTest.description" name="description" class="form-control" ng-maxlength="1000"></textarea><br> 
					
					<div align="right" style="color: red"
						ng-show="achievementForm.description.$error.maxlength">Input must be
						less than or equal to 1000 characters.</div>
					
					<div ng-if="achievementTest.name!=''">

						<button ng-click="postAchiev()" class="btn btn-primary" ng-disabled="!achievementForm.$valid">Save</button>

					</div>
				</form>
			</div>
			<div ng-hide=hideRaport class="well bs-component">
				<center>Changes were made successfully</center>
			</div>
		</div>
	</div>
</div>
