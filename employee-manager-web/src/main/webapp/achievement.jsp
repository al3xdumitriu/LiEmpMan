
<div>
	<div>
		<div>
			

			<br>
			<div class="well bs-component">
				<h1 class="page-header"><font color="#0597F2">Achievements</font></h1>
				<div
					ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id' 
					">

					<p>

						<b>{{achievement.name}} </b>
					</p>
					<textarea rows="4" cols="40" class="form-control" disabled>
			{{achievement.description}} 
			</textarea>
				</div>
				<br>
			</div>
			<button ng-click="add()" class="btn btn-primary">Show More!</button>
			<button ng-click="arata()" class="btn btn-primary">Add
				Achievement!</button>
			<div ng-hide=ascunde class="well bs-component">
				<form name="achievementForm">
					<br> Title: <input type="text" ng-model="achievementTest.name" class="form-control"><br>
					Description:<br> <input type="text"
						ng-model="achievementTest.description" class="form-control"> <br> <br>
					<div ng-if="achievementTest.name!=''">

						<button ng-click="incearcaPost()" class="btn btn-primary">posteaza!</button>

					</div>
				</form>
			</div>



		</div>


	</div>
</div>
