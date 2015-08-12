<script>
  function maxLengthCheck(object)
  {
    if (object.value.length > object.maxLength)
      object.value = object.value.slice(0, object.maxLength)
  }
</script>

<h1>
	<legend>Evaluation</legend>
</h1>
<div ng-controller="EvaluationCtrl" class="well bs-component">
    Chose Employee for evaluation:
    <select ng-model="employee" ng-options="employee.name for employee in employees"></select>
    
    
    <div align="right">
    	<button ng-click="giveEvaluation()" class="btn btn-primary">Give Evaluation</button> <p></p>
    </div>
    
    <div ng-show="showEvaluation">
		<form class="form-horizontal" role="form" name="evaluationForm">
			<label>Please give marks from 1 to 5.</label> </br>
			<span ng-repeat="skill in skills">
				<div class="form-group">
    				<label class="col-sm-2">{{skill.name}} </label>
    				<div class="col-sm-2">
     		 			<input type="number" name="grade" ng-model="evaluation[$index].grade" class="form-control" min="1" max="5" pattern="[1-5]" maxlength="1"
     		 				onkeypress='return event.charCode >= 49 && event.charCode <= 53' oninput="maxLengthCheck(this)">
    				</div>
				</div>
 				</span>
 				<div align="right">
 				</br><button ng-click="submitEvaluation(skills)" class="btn btn-primary">Submit</button> </br>
 				</div>
 				<div ng-show="savedSuccessfully">Saved Successfully.</div>
      		</form>
	</div>
</div>