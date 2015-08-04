<div>
	<div>
		<div>
			<br>
			<div class="well bs-component">
				<h1 class="page-header">
					<font color="#0597F2">Events</font>

				</h1>
				<div
					ng-repeat="event in events | limitTo:limit  
					">

					<p>

						<b>{{event.name}} </b>
					</p>

					<!-- <button ng-click="incearcaVideo()"
						class="btn btn-primary">Arata Video</button> -->


					<div ng-if="event.video!=null">
						<iframe width="420" height="315" ng-src="{{event.video}}">
						</iframe>
					</div>
					<div ng-if="event.coordinates!=null">
						<button ng-click="arataLocatia(event.id,event.coordinates)"
							class="btn btn-primary">Arataa Locatia</button>
						<div id="{{event.id}}" class="map-canvas"></div>
					</div>
					<textarea rows="4" cols="40" class="form-control" disabled>
			{{event.description}}
			</textarea>

				</div>
				<br>
			</div>
			<button ng-click="add()" class="btn btn-primary">Show More!</button>
			<button ng-click="arata()" class="btn btn-primary">Add
				Event!</button>
			<div ng-hide=ascunde class="well bs-component">
				<form name="eventForm">
					<br> 	Title: <input type="text" ng-model="eventTest.name" class="form-control"><br> 
					<br>	Description:<br> <input type="text" ng-model="eventTest.description" class="form-control">
					<br>	Url:<br> <input type="text" ng-model="eventTest.video" class="form-control">
					<br>	Coordinates:<br> <input type="text" ng-model="eventTest.coordinates" class="form-control">
					<br> <br>
					<div ng-if="eventTest.name!=''">

						<button ng-click="incearcaPost()" class="btn btn-primary">posteaza!</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
