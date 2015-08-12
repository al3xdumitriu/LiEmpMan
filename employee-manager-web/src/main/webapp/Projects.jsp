<div id="header" ng-include src="'template/header.jsp'"
     ng-controller="headerController" ng-hide="showHeader"></div>

<div id="contentDiv">
    <div class="row">
        <div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
             ng-controller=contentMenuController ng-hide="showContentMenu"></div>

        <div class="col-md-8">
            <h1 class="page-header">
                <font color="#0597F2">Projects</font>
            </h1>

            <div class="well bs-component">
                <div class="row">
                    <div class="col-md-4">
                        <b>Project Name</b>
                    </div>
                    <div class="col-md-4">
                        <b>Description</b>
                    </div>
                    <div class="col-md-4">
                        <b>Status</b>
                    </div>
                </div>
                <br/>
                <div ng-repeat="project in projects">
                    <div class="row">
                        <div class="col-md-4">
                            <p>{{project.name}}</p>
                        </div>
                        <div class="col-md-4">
                            <p>{{project.description}}</p>
                        </div>
                        <div class="col-md-4">
                            <p>{{project.status}}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>