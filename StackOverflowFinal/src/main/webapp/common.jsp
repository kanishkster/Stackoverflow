<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 	import = "com.cmad.database.User"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
<body>
  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>StackOverFlow for CMAD</title>
  <meta name="description" content="">
  <meta name="Chintan and Kanishk" content="">

  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
	<!--script src="scripts/jquery-1.11.3.min.js"></script-->
	<!-- script src="scripts/jquery.mobile-1.4.5.min.js"></script -->

    <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/custom.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  
  <!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="icon" type="image/png" href="images/favicon.png">
<link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">  
  <body>

  <!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <div class="container">
    <section class="header">
      <h2 class="title">StackOverFlow for CMAD</h2>
    </section>
    <nav class="navbar" align="center">
    	<div class="container">
    		<ul class="navbar-list">
    			<li class="navbar-item">
    				<a class="navbar-link" href="posts.jsp">Ask a Question</a>
    			</li>
    			<li class="navbar-item">
    				<a class="navbar-link" href=profile.jsp>Profile</a>
    			</li>
    			<li class="navbar-item">
    				<a class="navbar-link" href="posts_user.jsp">Questions by Me</a>
    			</li>
    			<li class="navbar-item">
    				<a class="navbar-link" href="comments_user.jsp">Answered by Me</a>
    			</li>
    			<li class="navbar-item">
    				<a class="navbar-link" href="unanswered_posts.jsp">Unanswered Questions</a>
    			</li>
    		</ul>		
    	</div>
    </nav>
  
 <script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<script type="text/javascript" src="scripts/posts.js"></script>  
<script type="text/javascript">
 <% User user = (User)session.getAttribute("user");
  if(user!=null)
	  {%>
	  	var loggedInUserId = <%=(user.getId())%>;
	  	var loggedInUserName = "<%=(user.getFullname())%>";
	  	var loggedInUserEmail = "<%=(user.getEmail())%>";
	 <% }%>
</script>

</body>
</html>