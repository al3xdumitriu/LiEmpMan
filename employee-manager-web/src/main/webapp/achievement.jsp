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
					 <b>Title:</b> <input type="text" ng-model="achievementTest.name"
						class="form-control"><br> 
						<b>Description:</b><br> 

					<textarea rows="4" cols="40" ng-model="achievementTest.description"  class="form-control" ></textarea><br> 
					
					<div ng-if="achievementTest.name!=''">

						<button ng-click="postAchiev()" class="btn btn-primary">Save</button>

					</div>
				</form>
			</div>
			<div ng-hide=hideRaport class="well bs-component">
				<center>Changes were made successfully</center>
			</div>
		</div>
	</div>
</div>
