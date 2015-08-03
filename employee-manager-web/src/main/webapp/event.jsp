<div>
	<div>
		<div>
			<br>
			<div class="well bs-component">
				<h1 class="page-header">
					<font color="#0597F2">Events</font>
					
				</h1>
				<div
					ng-repeat="event in events | limitTo:limit |orderBy :'id' 
					">

					<p>

						<b>{{event.name}} </b>{{event.coordinates}}
					</p>
					
					<iframe width="420" height="315"
src="http://www.youtube.com/embed/XGSy3_Czz8k?autoplay=0">
</iframe>
<button ng-click="arataLocatia(event.id,event.coordinates)" class="btn btn-primary">Arataa Locatia</button>
<div id="{{event.id}}" class="map-canvas">



</div>
					
					<textarea rows="4" cols="40" class="form-control" disabled>
			descriere
			</textarea>
				</div>
				<br>
			</div>
			<button ng-click="add()" class="btn btn-primary">Show More!</button>
			<button ng-click="arata()" class="btn btn-primary">Add
				Achievement!</button>
			<div ng-hide=ascunde class="well bs-component">
				<form name="achievementForm">
					<br> Title: <input type="text" ng-model="achievementTest.name"
						class="form-control"><br> Description:<br> <input
						type="text" ng-model="achievementTest.description"
						class="form-control"> <br> <br>
					<div ng-if="achievementTest.name!=''">

						<button ng-click="incearcaPost()" class="btn btn-primary">posteaza!</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
