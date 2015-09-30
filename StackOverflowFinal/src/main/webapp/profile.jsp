<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common.jsp" %>
<script type="text/javascript" src="scripts/profile.js"></script>
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
            <BR></BR>
            <h5>Here is your Profile:</h5>


		<h6 id="UserFullName"></h6><br/>
    	<h6 id="UserEmail"></h6><br/>
    	<h6 id="UserTotalPosts"></h6><br/>
    	<h6 id="UserTotalAnswers"></h6><br/>
    	<h6 id="UserTotalUpVotes"></h6><br/>
    	
    	<script>
    	document.getElementById("UserEmail").innerHTML = "<b> Your Email/Login ID : </b>" + loggedInUserEmail;
    	document.getElementById("UserFullName").innerHTML = "<b> Your Name : </b>" + loggedInUserName;
    	</script>
<form id="postForm">    	
    	<h5>You may update your details here:</h5>
    	<input type="text" name="fullname" id="fullname" class="fullname" placeholder="Your full name"/>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
	    <input class="button-primary" type="button" value="Update" type="submit" onclick="UpdateUser()"></input>
</form>
		    <% }else{ %> 
		    	<h5>You've been logged out. Please click below to go to login page.</h5>
		    	<h5><a href="index.jsp" align="center">Login/Register</a></h5>
		    <% } %> 
	</div>
  </div>
	</div>
  </div>
</div> 
	<div class="footer" align="center">
		&copy; 2015 Kanishk & Chintan. All rights reserved. 
	</div>	
</div>
</div> 
</body>
</html>
