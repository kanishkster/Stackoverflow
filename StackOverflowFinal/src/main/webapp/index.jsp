<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>StackOverFlow for CMAD</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="style.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/custom.css">

  <!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="icon" type="image/png" href="images/favicon.png">


<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body>
	<div class="wrapper">
	<div class="header">
		<h2>StackOverFlow for CMAD</h2>
	</div>
	
	<div class="container">
		<div class="instruction">
	<div id="tabs">
  <ul>
    <li><a href="#login">Login</a></li>
    <li><a href="#register">SignUp</a></li>
  </ul>
  <div id="login">
  	<% 
  	if("Invalid username or password".equalsIgnoreCase((String)session.getAttribute("error"))){ %>
  		<h6> Invalid user name or password. Please try again.</h6>
  	<%} %>
    <form method="post" action="LoginController">
    	<label for="email">Email:</label>
    	<input type="text" name="email" id="email" class="email" placeholder="Your email address"/>
    	<label for="password">Password:</label>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
    	<input type="submit" value="Login">
    </form>
  </div>
  <div id="register">
   	<form method="post" action="RegistrationController">
  		<label for="fullname">Full Name:</label><br/>
    	<input type="text" name="fullname" id="fullname" class="fullname" placeholder="Your full name"/>
    	<br/>
    	<label for="email">Email:</label><br/>
    	<input type="text" name="email" id="email" class="email" placeholder="Your email"/>
    	<br/>

    	<label for="password">Password:</label><br/>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
    	<br/>
 <!--     	<label for="gender">Gender:</label><br/>
    	<select name="gender" id="gender" class="gender">
    		<option value="Male">Male</option>
    		<option value="Male">Female</option>
    	</select>
    	<br/>
   	<label for="birthdate">Birth Date:</label><br/>
    	<input type="text" name="birthdate" id="birthdate" class="birthdate" placeholder="Your birth date"/>
    	<br>
    --> 	
    	<input type="submit" value="Register">
  	</form>
  </div>
</div>
		</div>
	</div>
	
	<div class="footer" align="center">
		&copy; 2015 Kanishk & Chintan. All rights reserved. 
	</div>	
	</div>
</body>
</html>