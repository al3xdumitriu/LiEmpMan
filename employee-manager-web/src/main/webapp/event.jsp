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
<br>
						<br>    <label>Title:</label><input id="titlu{{event.id}}" type="text" value="{{event.name}}" class="form-control">
						<br>    <label>Organizator Name:</label><input id="oName{{event.id}}" type="text" value="{{event.organizatorName}}" class="form-control">
						<br>	<label>StartDate:</label><br> <input id="sDate{{event.id}}" type="text" ng-value="event.startDate |  date:'mm/dd/yyyy hh:mm a'" class="form-control" >
						<br>	<label>EndDate:</label><br> <input id="fDate{{event.id}}" type="text" ng-value="event.endDate | date:'mm/dd/yyyy hh:mm a'" class="form-control" >
						<br>	<label>Description:</label><br>
						<textarea id="descr{{event.id}}"  rows="4" cols="40" class="form-control" >
						{{event.description}}
						</textarea>
						<br>	<label>Coordinates/Adress:</label><br> <input id="coord{{event.id}}" type="text" ng-model="event.coordinates" class="form-control">
						<br>	<label>URI:</label><br> <input id="uri{{event.id}}" type="text" ng-model="event.video" class="form-control">
						
					</p>

					<div ng-if="event.video!=null">
						<iframe id="video{{event.id}}" width="420" height="315" ng-src="{{parseazaLink(event.video)}}">
						</iframe>
					</div>
					<button ng-click="editEvent(event.id)"
							class="btn btn-primary">Edit</button>
					<div ng-if="event.coordinates!=null">
					<div ng-if="event.coordinates!=''">
						<button ng-click="arataLocatia(event.id,event.coordinates)"
							class="btn btn-primary">Arata Locatia</button>
						<div id="{{event.id}}" class="map-canvas"></div>
					</div>
					</div>
					

				</div>
				<br>
			</div>
			<button ng-click="add()" class="btn btn-primary">Show More!</button>
			<button ng-click="arata()" class="btn btn-primary">Add
				Event!</button>
			<div ng-hide=ascunde class="well bs-component">
				<form name="eventForm">
					
					<br> 	<label>Title:</label> <input type="text" ng-model="eventTest.name" class="form-control"><br> 
					<br> 	<label>Organizator Name:</label> <input type="text" ng-model="eventTest.organizatorName" class="form-control"><br> 
					<br>	<label>Description:</label><br> <input type="text" ng-model="eventTest.description" class="form-control">
					<br>	<label>Url:</label><br> <input type="text" ng-model="eventTest.video" class="form-control">
					<br>	<label>Coordinates/Adress:</label><br> <input type="text" ng-model="eventTest.coordinates" class="form-control">
					<br>	<label>StartDate:</label><br> <input type="datetime-local" ng-model="eventTest.startDate" class="form-control">
					<br>	<label>EndDate:</label><br> <input type="datetime-local" ng-model="eventTest.endDate" class="form-control">
					<br> <br>
					<div ng-if="eventTest.name!=null">

						<button ng-click="incearcaPost()" class="btn btn-primary">posteaza!</button>

					</div>
					
				</form>
			</div>
			
			<button ng-click="incarcaTot()" class="btn btn-primary">incarcaMape!!!</button>
			
		</div>
	</div>
</div>
