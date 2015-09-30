<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common.jsp" %>
</head>

  <body>
    <section class="header">
      <h5 class="title" >StackOverFlow for CMAD</h5>
    </section>  
    
    <div class="login-card">
    <h1>Register</h1><br>
 	<div id="register">
   	<form method="post" action="RegistrationController">
    	<input type="text" name="fullname" id="fullname" class="text" placeholder="Your full name"/>
    	<input type="text" name="email" id="email" class="email" placeholder="Your email"/>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
    
 <!--    	
    	<select name="gender" id="gender" class="select">
    		<option value="Male">Male</option>
    		<option value="Male">Female</option>
    	</select> <br/> <br/>
  -->
 <!--    	<input type="text" name="birthdate" id="birthdate" class="date" placeholder="Your birth date"/> <br/> <br/>
  -->
    	<input class="button-primary" value="Register" type="submit"> 
    	<!-- <input type="submit" value="Register"> -->
  	</form>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->
     
	<div class="footer" align="center">
		&copy; 2015 Kanishk & Chintan. All rights reserved. 
	</div>	     
      
  </body>
</html>
