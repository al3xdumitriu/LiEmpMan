<script>
  function maxLengthCheck(object)
  {
    if (object.value.length > object.maxLength)
      object.value = object.value.slice(0, object.maxLength)
  }
</script>

<div ng-controller="EvaluationCtrl">
	<div class=" thumbnail">
	   <h1>Evaluation</h1>
	    Chose Employee for evaluation: <input type="text" ng-model="employeeId" class="form-control"> </br>
	    <button ng-click="giveEvaluation()" class="btn btn-primary">Give Evaluation</button> </br>
	    
	    <div ng-show="showEvaluation" class="well bs-component">
			<form class="form-horizontal" role="form" name="evaluationForm">
				<label>Please give marks from 1 to 5.</label> </br>
				<span ng-repeat="skill in skills">
					<div class="form-group">
	    				<label class="col-sm-1">{{skill.name}} - </label>
	    				<div class="col-sm-1">
	     		 			<input type="number" name="grade" ng-model="evaluation[$index].grade" class="form-control" min="1" max="5" pattern="[1-5]" maxlength="1"
	     		 				onkeypress='return event.charCode >= 49 && event.charCode <= 53' oninput="maxLengthCheck(this)">
	    				</div>
				</span>
	  				</div> 
  				</span>
  				
  				</br><button ng-click="submitEvaluation(skills)" class="btn btn-primary">Submit</button> </br>
       		</form>
		</div>
       	
       </span>
	</div>
</div>