<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<div align="center">
	<div style="width: 300px;">
		<!-- 	  <div ng-view></div>   -->
		<div>
			<h1>Achievements</h1>

			<br>

			<div
				ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id' ">
				<p>

					<b>{{achievement.name}} </b>
				</p>
				<textarea rows="4" cols="50" disabled>
			{{achievement.description}} 
			</textarea>
			</div>
			<br>
			<button ng-click="add()">Show More!</button>

		</div>


	</div>
</div>
