<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common.jsp" %>
<script type="text/javascript">
</script>
<script type="text/javascript" src="scripts/comments.js"></script>
</head>
<body>
	<div id="Home">	
 <% User user2 = (User)session.getAttribute("user"); 
 if(user2!=null)
	  {%>
       	<div class="docs-section" id="div_post_content">
				<h4 id="question"></h4> 
				<div id="askedby"><i>
					Asked By: <strong id="whoAsked"></strong></i>
					&emsp; &emsp; &emsp;
					<strong id="postDate"></strong>
					&emsp; &emsp; &emsp;
					<img src="images/thumbsup.png" height="25" width="25" onClick="clicks++;updateClickCount();" id="push"></img>
					 &emsp;
					<i class="mdi-action-favorite red-text text-lighten-1"></i><strong id="clickCount"></strong>
					&emsp;
					<img src="images/thumbsdown.png" height="25" width="25" onClick="clicks--;updateClickCount();" id="push"></img>					
				</div>
			</div>
			
	   	<div class="docs-section" id="div_post_comments">	
					
		</div>
	</div>			

	<table id = commentTable></table>
	
		<form id="commentPostForm">
			<textarea  id="comment" name="commentTitle" class="u-full-width" placeholder="Know the answer? Post it here ..."></textarea>
		    <input class="button-primary" type="button" value="Submit" type="submit" onclick="addComment()"></input>
  		</form>
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
