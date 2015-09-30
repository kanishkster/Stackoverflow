<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common.jsp" %>
<script type="text/javascript" src="scripts/answers.js"></script>
</head>
<body>
	<div id="Home">	
	<div class="docs-section">
 <% User user2 = (User)session.getAttribute("user"); 
 if(user2!=null)
	  {%>		
		    <i><h6 style="float: Left;" id="UserName"></h6></i>
		    <script>
			document.getElementById("UserName").innerHTML = "<b>Hello "+loggedInUserName+" !!</b>";
			</script>
            <h6><a style="float: right;" href="LoginController?query=logout">Logout</a></h6>
            <BR>&nbsp;</BR>
      		<h5>Here are the answers, you've contributed</h5>
  			<table id="answerTable"></table>   			
		    <% }else{ %> 
		    	<h5>You've been logged out. Please click below to go to login page.</h5>
		    	<h5><a href="index.jsp" align="center">Login/Register</a></h5>
		    <% } %> 
	</div>
  </div>

	<div class="footer" align="center">
		&copy; 2015 Kanishk & Chintan. All rights reserved. 
	</div>	
</body>
</html>
