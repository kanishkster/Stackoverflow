var sval = "";
var clicks = 0;
var postloadedID=0;
var postloadedOwnerID=0;

function getParam ()
{
  var params = location.search.substr(location.search.indexOf("?")+1);
  var sname = 'commentID';
  params = params.split("&");
  // split param and value into individual pieces
  for (var i=0; i<params.length; i++)
       {
         temp = params[i].split("=");
         if ( [temp[0]] == sname ) { 
                sval = temp[1]; 
          }
  } 
 console.log("CommentID is "+sval);
}

function updateClickCount() {
    document.getElementById("clickCount").innerHTML = clicks;
    commitPostVote();
}

function commitPostVote(){
	var votes = clicks;
	var postID = postloadedID;
	var user = postloadedOwnerID;
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

function loadUserComments(){
	var commentCount = 0;
	$.ajax({
		url: 'services/comments?commenterID=' + loggedInUserId,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			for(var index in data){
				var row = "<tr onclick=\"window.location.href='comments_detail.jsp?commentID=" + data[index].commentID + "'\">\n\
	             <td>" + data[index].comment + "</td>\n\
	             <td><img src='images/thumbsup.png' height='20' width='20'></img></td>\n\
	             <td>" + data[index].commentVote + "</td>\n\
	           </tr>";
				$("#answerTable").append(row);
			}
		}
});
	console.log("loadPostCount with postID (sval)- Fired request");
}

function loadPostComments(){
	$.ajax({
		url: 'services/comments?commentID=' + sval,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			console.log(" loadPostComments Sval is :"+sval);
			html = "";
				for(var index in data){
				console.log("loadPostComments postID for this post is"+data[index].postID);	
				loadPost(data[index].postID);
//				clicks2 = data[index].commentVote;
				html+="<p><h6>"+ data[index].comment +"</h6></p>";
 				html+="<div id=commentedBy>";
 				html+="<i><font size ='2'>Answered By: <strong id='whoCommented'></strong></font></i>";
 				html+="&emsp; &emsp; &emsp;";
 				html+="&emsp; &emsp; &emsp;";
 				var date = timeConverter(data[index].commentDate);
 				html+="<font size=2><strong id>"+ date + "</strong></font>";
// 				html+="<img src='images/thumbsup.png' height='15' width='15' onClick='clicks2++;updateClickCountComment();' id='push'></img>";
// 				html+="&emsp;";
// 				html+="<i class='mdi-action-favorite red-text text-lighten-1'></i><strong id='clickCountComment'></strong>";
// 				html+="&emsp;";
// 				html+="<img src='images/thumbsdown.png' height='15' width='15' onClick='clicks2--;updateClickCountComment();' id='push'></img>";
 				html+="</div>";
 				html+="<BR>&nbsp;<BR>";
 				html+="<BR>&nbsp;<BR>";
 				getUserDetailsComment(data[index].commenterID);
			}
			$("#div_post_comments").html(html);
		}
});
	console.log("loadPostComments with postID (sval) - Fired request");
}

function getUserDetailsComment(commenterID){
	return ($.ajax({
		url: 'services/users?UserID=' + commenterID,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			for(var index in data){
				document.getElementById("whoCommented").innerHTML = data[index].fullname; 
			}
		}
	}));
}

function getUserDetailsPost(OwnerID){
	return ($.ajax({
		url: 'services/users?UserID=' + OwnerID,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			for(var index in data){
				document.getElementById("whoAsked").innerHTML = data[index].fullname;
			}
		}
	}));
}

function loadPost(postID){
	$.ajax({
		url: 'services/posts?postID=' + postID,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			for(var index in data){
				document.getElementById("question").innerHTML = data[index].postTitle;
				document.getElementById("postDate").innerHTML = timeConverter(data[index].postDate);
				clicks = data[index].postVote;
				document.getElementById("clickCount").innerHTML = clicks;
				getUserDetailsPost(data[index].ownerID);
				postloadedID = data[index].postID;
				postloadedOwnerID=data[index].ownerID;
				
			}
		}
});
	console.log("loadPost with postID - Fired request");
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

$(document).ready(function() {
	getParam();
	loadUserComments();
	loadPostComments();
});