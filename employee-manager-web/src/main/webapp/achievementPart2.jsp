<!-- <script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script> -->
<div align="center">
		<div style="width: 300px;">
			<!-- 	  <div ng-view></div>   -->
			<div>
				<h1>Achievements</h1>

				<br>

				<div
					ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id' ">
					<p>

						<b>{{achievement.name}} </b>
					</p>
					<textarea rows="4" cols="50" disabled>
			{{achievement.description}} 
			</textarea>
				</div>
				<br>
				<button ng-click="add()">Show More!</button>
				<button ng-click="arata()">Add Achievement!</button>
				<div ng-hide=ascunde>
					<form name="achievementForm" ">
						<br> Title: <input type="text" ng-model="achievementTest.name"><br>
						Description:<br> <input type="text"
							ng-model="achievementTest.description"> <br> <br>
						<div ng-if="achievementTest.name!=''">
						
						<button ng-click="incearcaPost()">posteaza!</button>
						
						</div>
					</form>
				</div>
				
				
				
			</div>


		</div>
</div>
