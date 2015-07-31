<div class=" thumbnail">
	<div class="caption">
		<h3>{{employee.name}}</h3>
		<div align="center">
			<div style="width: 200px;">
				<div class="row">
					<div class="col-sm-6 col-lg-6 col-md-6 text-info">Phone</div>
					<div class="col-sm-6 col-lg-6 col-md-6">{{employee.phone}}</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-lg-6 col-md-6 text-info">Email</div>
					<div class="col-sm-6 col-lg-6 col-md-6">{{employee.email}}</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="skill-view.jsp"/>
	</div>
</div>