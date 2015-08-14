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
					
					<br> 	<label>Title:</label> <input type="text" name="titleEventPost" ng-model="eventTest.name" class="form-control" ng-maxlength="255"> 
					<div align="right" style="color: red"
						ng-show="eventForm.titleEventPost.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
					<br> 	<label>Organizer Name:</label> <input type="text" ng-model="eventTest.organizatorName" name="orgNamePost" class="form-control" ng-maxlength="255"> 
										<div align="right" style="color: red"
						ng-show="eventForm.orgNamePost.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
					<br>	<label>Description:</label><br>
						<textarea  ng-model="eventTest.description" rows="4" cols="40" name="descriptionEventPost" class="form-control noresize" ng-maxlength="1000">
{{event.description}}
						</textarea>
							<div align="right" style="color: red"
						ng-show="eventForm.descriptionEventPost.$error.maxlength">Input must be
						less than or equal to 1000 characters.</div>
					<br>	<label>URL:</label><br> <input type="text" name="urlEventPost" ng-model="eventTest.video" class="form-control" ng-maxlength="255">
					<div align="right" style="color: red"
						ng-show="eventForm.urlEventPost.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
					<br>	<label>Coordinates/Address:</label><br> <input type="text" name="coordAddrPost" ng-model="eventTest.coordinates" class="form-control" ng-maxlength="255">
					<div align="right" style="color: red"
						ng-show="eventForm.coordAddrPost.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
					<br>	<label>Start Date:</label><br> <input type="text" placeholder="YYYY-MM-DD" ng-model="startDatee" class="form-control">
					<br>	<label>End Date:</label><br> <input type="text" placeholder="YYYY-MM-DD" ng-model="endDatee" class="form-control">
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
					
					
						<br>    <label>Title:</label><input id="titlu{{event.id}}" type="text" ng-model="event.name" name="titleEvent" class="form-control" ng-maxlength="255">
											<div align="right" style="color: red"
						ng-show="eventFormmm.titleEvent.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
						
						<br>    <label>Organizer Name:</label><input id="oName{{event.id}}" type="text" ng-model="event.organizatorName" name="orgEvent" class="form-control" ng-maxlength="255">
																	<div align="right" style="color: red"
						ng-show="eventFormmm.orgEvent.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
						<br>	<label>Start Date:</label><br> <input id="sDate{{event.id}}" type="text" ng-value="event.startDate |  date:'yyyy-MM-dd'" class="form-control" >
						<br>	<label>End Date:</label><br> <input id="fDate{{event.id}}" type="text" ng-value="event.endDate | date:'yyyy-MM-dd'" class="form-control" >
						<br>	<label>Description:</label><br>
						<textarea id="descr{{event.id}}" ng-model="event.description"  rows="4" cols="40" name="descrEvent" class="form-control noresize" ng-maxlength="1000"></textarea>
																	<div align="right" style="color: red"
						ng-show="eventFormmm.descrEvent.$error.maxlength">Input must be
						less than or equal to 1000 characters.</div>
						<br>	<label>URL:</label><br> <input id="uri{{event.id}}" type="text" ng-model="event.video" name="url" class="form-control" ng-maxlength="255">
																	<div align="right" style="color: red"
						ng-show="eventFormmm.url.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
					
					

					<center><div ng-if="event.video!=null">
						<iframe id="video{{event.id}}" width="420" height="315" ng-src="{{parseazaLink(event.video)}}">
						</iframe>
					</div>
					</center>
					<br>	<label>Coordinates/Address:</label><br> <input id="coord{{event.id}}" type="text" name="coordAddrEvent" ng-model="event.coordinates" class="form-control" ng-maxlength="255">
																	<div align="right" style="color: red"
						ng-show="eventFormmm.coordAddrEvent.$error.maxlength">Input must be
						less than or equal to 255 characters.</div>
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