<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common.jsp" %>
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
       	
		<form id="postForm">
  			<textarea  id="title" name="postTitle" class="u-full-width" placeholder="Post your question here ..."></textarea>
		    <input class="button-primary" type="button" value="Submit" type="submit" onclick="addPost()"></input>
  		</form>
    	
      		<h5>These questions are yet to be answered</h5>
  			<table id="userTableUA"></table>   	
  			</div>		
		    <% }else{ %> 
		    	<h5>You've been logged out. Please click below to go to login page.</h5>
		    	<h5><a href="index.jsp" align="center">Login/Register</a></h5>
		    <% } %> 
	</div>


	<div class="footer" align="center">
		&copy; 2015 Kanishk & Chintan. All rights reserved. 
	</div>	
</body>
</html>
