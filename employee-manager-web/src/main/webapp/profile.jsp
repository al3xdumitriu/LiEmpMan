<div id="header" ng-include src="'template/header.jsp'"
     ng-controller="headerController" ng-hide="showHeader"></div>

<div id="contentDiv">
    <div class="row">
        <div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
             ng-controller=contentMenuController ng-hide="showContentMenu"></div>
        <div class="col-md-8">
            <div ng-include="'details.jsp'"></div>
            <div ng-include="'achievement.jsp'" ng-controller="myCtrlAchievEmp"/>
	    </br>
	    <div ng-include="'skillView.jsp'"/>
	    <div ng-include="'evaluation.jsp'" />
        </div>
    </div>
</div>
