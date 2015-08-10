
<div ng-controller="StarCtrl" class="well bs-component">
	<h1>
		<font color="#0597F2">Skills</font>
	</h1>
   <div class=" thumbnail">
   <!-- For Display -->
   <form class="form-horizontal" role="form" name="evaluationForm">
   		<span ng-repeat="skill in skills">
   			<div class="form-group">
				<label class="col-sm-2">{{skill.name}} - </label>
				<div class="col-sm-2" star-rating rating-value="skill.rating" max="5">
				</div>
			</div> 
    	</span>
    </form>
    
    <!-- Chart -->
    <div fusioncharts
      width="600"
      height="400"
      type="column2d"
      dataSource="{{myDataSource}}" >
 	</div>
 	
    <!-- For Add -->
       <button ng-click="showSkill()" class="btn btn-primary">Add Skill</button><p></p>
       <div ng-show=show class="well bs-component">
			<form name="skillForm">
				<br><b> Name: </b><input type="text" ng-model="skill.name" class="form-control">
				<br><b> Description: </b><br> <input type="text" ng-model="skill.description" class="form-control"> 
				<br><b> Experience: </b><br> <input type="text" ng-model="skill.experience" class="form-control"> 
				<br> <br>
				<div ng-if="skill.name!=''">

					<button ng-click="save()" class="btn btn-primary">Save</button>

				</div>
			</form>
		</div>
	</div>
</div>
