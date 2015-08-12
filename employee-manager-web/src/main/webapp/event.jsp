<link rel="stylesheet" href="resources/css/event.css"/>
<div id="header" ng-include src="'template/header.jsp'"
     ng-controller="headerController" ng-hide="showHeader"></div>

<div id="contentDiv">
 <div class="row">
 <div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
             ng-controller=contentMenuController ng-hide="showContentMenu"></div>

<div class="col-md-8">
			<h1 class="page-header">
				<font color="#0597F2">Events</font>

			</h1>
			<div>
		<div>
			<br>
			<div >
				<div align="right">
				<button ng-click="showForm()" class="btn btn-primary">Add
				Event</button>
				</div>
				<br>
			<div ng-hide=hide class="well bs-component">
				
				<form name="eventForm">
					
					<br> 	<label>Title:</label> <input type="text" ng-model="eventTest.name" class="form-control" ng-maxlength="255"><br> 
					<br> 	<label>Organizer Name:</label> <input type="text" ng-model="eventTest.organizatorName" class="form-control" ng-maxlength="255"><br> 
					<br>	<label>Description:</label><br>
						<textarea  ng-model="eventTest.description" rows="4" cols="40" class="form-control noresize" ng-maxlength="1000">
{{event.description}}
						</textarea>
					<br>	<label>URL:</label><br> <input type="text" ng-model="eventTest.video" class="form-control" ng-maxlength="255">
					<br>	<label>Coordinates/Address:</label><br> <input type="text" ng-model="eventTest.coordinates" class="form-control" ng-maxlength="255">
					<br>	<label>Start Date:</label><br> <input type="datetime-local" ng-model="eventTest.startDate" class="form-control">
					<br>	<label>End Date:</label><br> <input type="datetime-local" ng-model="eventTest.endDate" class="form-control">
					<br> 	<br>
					<div align="right" ng-if="eventTest.name!=null">
						<button ng-click="postEvent()" ng-disabled="!eventForm.$valid"  class="btn btn-primary">Save</button>

					</div>
				</form>
			</div>
			<div ng-hide=hideRaportPost class="well bs-component">
				<center>Changes were made successfully</center>
			</div>
				
				<div
					ng-repeat="event in events | limitTo:limit  
					" class="well bs-component">
					<form name="eventFormmm">
					
					
						<br>    <label>Title:</label><input id="titlu{{event.id}}" type="text" ng-model="event.name" class="form-control" ng-maxlength="255">
						<br>    <label>Organizer Name:</label><input id="oName{{event.id}}" type="text" ng-model="event.organizatorName" class="form-control" ng-maxlength="255">
						<br>	<label>Start Date:</label><br> <input id="sDate{{event.id}}" type="text" ng-value="event.startDate |  date:'mm/dd/yyyy hh:mm a'" class="form-control" >
						<br>	<label>End Date:</label><br> <input id="fDate{{event.id}}" type="text" ng-value="event.endDate | date:'mm/dd/yyyy hh:mm a'" class="form-control" >
						<br>	<label>Description:</label><br>
						<textarea id="descr{{event.id}}" ng-model="event.description"  rows="4" cols="40" class="form-control noresize" ng-maxlength="1000"></textarea>
						<br>	<label>URL:</label><br> <input id="uri{{event.id}}" type="text" ng-model="event.video" class="form-control" ng-maxlength="255">
						
					
					

					<center><div ng-if="event.video!=null">
						<iframe id="video{{event.id}}" width="420" height="315" ng-src="{{parseazaLink(event.video)}}">
						</iframe>
					</div>
					</center>
					<br>	<label>Coordinates/Address:</label><br> <input id="coord{{event.id}}" type="text" ng-model="event.coordinates" class="form-control" ng-maxlength="255">
						<br>
					<div ng-hide=hideRaport >
				<center>Changes were made successfully</center>
			</div>
					<div align="right">
					
					<span ng-if="event.coordinates!=null">
					<span ng-if="event.coordinates!=''">
						
						<center><div ng-if="arrayCoordinations[event.id]!=null" id="{{event.id}}" class="map-canvas"></div></center>
						<br>
						<button ng-click="showLocation(event.id,event.coordinates)"
							class="btn btn-primary">Show Directions</button>

					</span>
					</span>
					<button ng-click="editEvent(event.id)" ng-disabled="!eventFormmm.$valid" class="btn btn-primary">Save</button>
					</div>
					</form>
					
				</div>
				
			</div>
			<div align="right">
			<span ng-if=areMoreEvents()>
			<button ng-click="add()" class="btn btn-primary">Show More</button>
			</span>
			</div>
			
			
		</div>
	</div>
</div>
</div>
</div>