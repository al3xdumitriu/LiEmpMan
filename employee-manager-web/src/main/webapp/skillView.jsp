<h1>
	<legend>Skills</legend>
</h1>
<div ng-controller="StarCtrl" class="well bs-component">   
   <!-- For Display -->
   <form class="form-horizontal" role="form" name="evaluationForm">
   		<span ng-repeat="skill in skills">
   			<div class="form-group">
				<label class="col-sm-2">{{skill.name}}</label>
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
    	<div align="right">
    	<p></p><button ng-click="showSkill()" class="btn btn-primary">Add Skill</button><p></p>
    	</div>
       <div ng-show=show >
			<form name="skillForm">
				<br><b> Name: </b><input type="text" ng-model="skill.name" class="form-control">
				<br><b> Description: </b><br> <input type="text" ng-model="skill.description" class="form-control"> 
				<br><b> Experience: </b><br> <input type="text" ng-model="skill.experience" class="form-control"> 
				<br> <br>
				<div ng-if="skill.name!=''" align="right">
					<button ng-click="save()" class="btn btn-primary">Save</button>
				</div>
				<span ng-show="savedSuccessfully">Saved successfully.</span>
			</form>
		</div>
	
</div>
