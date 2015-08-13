<div>
    <h1>
        <legend>Projects</legend>
    </h1>
    <div class="well bs-component" ng-controller="ProjectController">
        <div ng-repeat="project in projects">
            <div class="row">
                <div class="col-md-4">
                    <b>{{project.name}}</b>
                </div>
                <div class="col-md-4" star-rating rating-value="getRatingsAverage(project)" max="5"></div>
                <div class="col-md-4"><b>{{hoursAllocated(project)}}h/week</b></div>
            </div>
        </div>
    </div>
</div>