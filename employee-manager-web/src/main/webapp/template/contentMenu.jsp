<ul ng-controller="menuActive" class="nav nav-pills nav-stacked">
    <li ng-class="{ active: isActive('/profile')}"><a href="#/profile/">My
        Profile</a></li>
    <li ng-class="{ active: isActive('/projects')}"> <a href="#/projects">Projects</a></li>
    <li ng-class="{ active: isActive('/event')}"><a href="#/event">Events</a></li>
   <!--  <li><a href=""
           data-toggle="dropdown">Evaluations<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="">Received</a></li>
            <li><a href="">Given</a></li>
        </ul>
    </li> -->
    <li ng-class="{ active: isActive('/email')}"><a href="#/email">Give Feedback</a></li>
</ul>
