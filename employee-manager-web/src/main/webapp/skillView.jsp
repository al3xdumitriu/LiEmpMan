
<div ng-controller="StarCtrl"> 
   <div class=" thumbnail">
   <h1>Skills</h1>
   <!-- For Display -->
   	<span ng-repeat="skill in skills">
   			{{skill.name}} : {{skill.rating}} 
       		<div star-rating rating-value="skill.rating" max="5" ></div>
    </span>
    
    <!-- Chart -->
    <div fusioncharts
      width="600"
      height="400"
      type="column2d"
      dataSource="{{myDataSource}}" >
 	</div>
 	
    <!-- For Add -->
       <button ng-click="showSkill()" class="btn btn-primary">Add Skill</button>
       <div ng-show=show class="well bs-component">
			<form name="skillForm">
				<br> Name: <input type="text" ng-model="skill.name" class="form-control">
				<br> Description:<br> <input type="text" ng-model="skill.description" class="form-control"> 
				<br> Experience:<br> <input type="text" ng-model="skill.experience" class="form-control"> 
				<br> <br>
				<div ng-if="skill.name!=''">

					<button ng-click="save()" class="btn btn-primary">Save</button>

				</div>
			</form>
		</div>
	</div>
</div>
