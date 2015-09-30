var sval = "";
var clicks = "";
var postOwnerID=0;


function getParam ()
{
  var params = location.search.substr(location.search.indexOf("?")+1);
  var sname = 'postID';
  params = params.split("&");
  // split param and value into individual pieces
  for (var i=0; i<params.length; i++)
       {
         temp = params[i].split("=");
         if ( [temp[0]] == sname ) { 
                sval = temp[1]; 
          }
  } 
}

function loadPost(){
	$.ajax({
		url: 'services/posts?postID=' + sval,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			for(var index in data){
				document.getElementById("question").innerHTML = data[index].postTitle;
//				document.getElementById("question").innerHTML = getUserDetails(data[index].ownerID);
				document.getElementById("postDate").innerHTML = timeConverter(data[index].postDate);
				clicks = data[index].postVote;
				postOwnerID = data[index].ownerID;
				getUserDetails(data[index].ownerID);
				document.getElementById("clickCount").innerHTML = clicks;
			}
		}
});
	console.log("loadPost with postID (sval)- Fired request");
}

function loadPostComments(){
	$.ajax({
		url: 'services/comments?postID=' + sval,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			count = 0;
			console.log("Data arrived");
			console.log(" loadPostComments Sval is :"+sval);
			html = "";
				for(var index in data){
				count ++;	
//				clicks2 = data[index].commentVote;
				html+="<h7>Answer : "+ count+"</h7>";	
				html+="<p><h6>"+ data[index].comment +"</h6></p>";
 				html+="<div id=commentedBy>";
 				html+="<i><font size ='2'>Answered By: <strong id='whoCommented'></strong></font></i>";
 				html+="&emsp; &emsp; &emsp;";				
 				html+="<img src='images/thumbsup.png' height='15' width='15' onClick='clicks2++;updateClickCountComment();' id='push'></img>";
 				html+="&emsp;";
 				html+="<i class='mdi-action-favorite red-text text-lighten-1'></i><strong id='clickCountComment'></strong>";
 				html+="&emsp;";
 				html+="<img src='images/thumbsdown.png' height='15' width='15' onClick='clicks2--;updateClickCountComment();' id='push'></img>";
// 				html+="</div>";
 				html+="<BR>&nbsp;<BR>";
 				html+="<BR>&nbsp;<BR>";
// 				document.getElementById("whoCommented").innerHTML = getUserName(data[index].commenterID);
// 				document.getElementById("clickCountComment").innerHTML = data[index].commentVote;
			}
			$("#div_post_comments").html(html);
		}
});
	console.log("loadPostComments with postID (sval) - Fired request");
}


function timeConverter(UNIX_timestamp){
console.log(UNIX_timestamp);	
  var a = new Date(UNIX_timestamp);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var hour = a.getHours();
  var min = a.getMinutes() < 10 ? '0' + a.getMinutes() : a.getMinutes();
  var sec = a.getSeconds() < 10 ? '0' + a.getSeconds() : a.getSeconds();
  var time = 'On '  + month + ' ' + date + ', ' + year + ' at ' + hour + ':' + min;
  return time;
}


//function getUserDB(){
//	return ($.ajax({
//		url: 'services/users?',
//		method: 'get',
//		headers: { 'Accept': 'application/json' }, 
//		success: function(data) {
//			console.log ("getUserDB got the user data");
//				UserDB = JSON.stringify(data);
//				UserDBObj = JSON.parse(UserDB);
//			}
//	}));
//}

//function getUserName(ID){
//	var username;
//	console.log(" getUserName called");
//	for(var index in UserDBObj){
//		if (UserDBObj[index] == ID)
//	 	{
//	 		username = UserDBObj[index].fullname;
//	 		console.log("Got username : "+ username);
//	 	}
//	 }
//	return username;
//}
	

function getUserDetails(OwnerID){
return ($.ajax({
	url: 'services/users?UserID=' + OwnerID,
	method: 'get',
	headers: { 'Accept': 'application/json' }, 
	success: function(data) {
		console.log("Posts.js getUserDetails() data arrived");
		for(var index in data){
			document.getElementById("whoAsked").innerHTML = data[index].fullname; 
		}
	}
}));
}

//function getCommenterDetails(commenterID){
//	return ($.ajax({
//		url: 'services/users?UserID=' + commenterID,
//		method: 'get',
//		headers: { 'Accept': 'application/json' }, 
//		success: function(data) {
//			console.log("Data arrived");
//			for(var index in data){
//				document.getElementById("whoCommented").innerHTML = data[index].fullname; 
//			}
//		}
//	}));
//}

function updateClickCount() {
    document.getElementById("clickCount").innerHTML = clicks;
    commitPostVote();
}

//function updateClickCountComment(commentID) {
//    document.getElementById("clickCountComment").innerHTML = clicks2;
////    commitCommentVote(commentID);
////}

function commitPostVote(){
	var votes = clicks;
	var postID = sval;
	var user = postOwnerID;
	var postData = {
					postID: postID,
					postVote: votes,
					ownerID: user
					};
var jsonData = JSON.stringify(postData);
	$.ajax({
		url: 'services/posts',
		method: 'put',
		data: jsonData,
		headers: { 'Accept': 'application/json', 'Content-type': 'application/json' }, 
		success: function(data) {
			console.log("Votes updated");
		}
	});
}

//function commitCommentVote(commentID){
//	var votes = clicks2;
//	var cID = commentID;
//	var postData = {
//					commentID: cID,
//					postVote: votes,
//					};
//var jsonData = JSON.stringify(postData);
//	$.ajax({
//		url: 'services/posts',
//		method: 'put',
//		data: jsonData,
//		headers: { 'Accept': 'application/json', 'Content-type': 'application/json' }, 
//		success: function(data) {
//			console.log("Votes updated");
//		}
//	});
//}

$(document).ready(function() {
	getParam();
//	getUserDB();
	loadPost();
	loadPostComments();
});

function addComment(){
	var title = $("#comment").val();
	var owner = loggedInUserId;
	var postID = sval;
	var postData = {
					comment: title,
					commenterID: owner,
					postID: postID
					};
var jsonData = JSON.stringify(postData);
	$.ajax({
		url: 'services/comments',
		method: 'post',
		data: jsonData,
		headers: { 'Accept': 'application/json', 'Content-type': 'application/json' }, 
		success: function(data) {
			console.log("Add done");
			$("#commentPostForm")[0].reset();
			alert("Thanks for posting your answer");
		}
	});
}