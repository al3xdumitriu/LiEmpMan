<header ng-include="'template/header.jsp'" ng-controller="headerController"></header>
<div ng-include="'details.jsp'"></div>
<div ng-include="'achievement.jsp'" ng-controller="myCtrlAchievEmp"/>
<div ng-include="'skill-view.jsp'"/>
<footer ng-include="'template/footer.jsp'" ng-controller="footerController"></footer>
<script>
	$('#edit').click(
			function() {
				$('#expLevel').prop('disabled', false), $('#jobTitle').prop(
						'disabled', false);
				$('#email').prop('disabled', false);
				$('#phone').prop('disabled', false);
				$('#userName').prop('disabled', false);
				$('#save').prop('disabled', false);
				$('#cancel').prop('disabled', false);
			});
</script>
<script>
	$('#cancel').click(
			function() {
				$('#expLevel').prop('disabled', true), $('#jobTitle').prop(
						'disabled', true);
				$('#email').prop('disabled', true);
				$('#phone').prop('disabled', true);
				$('#userName').prop('disabled', true);
				$('#save').prop('disabled', true);
				$('#cancel').prop('disabled', true);
			});
</script>
