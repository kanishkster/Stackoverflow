function UpdateUser(){
	var name = $("#fullname").val();
	var pass = $("#password").val();	
	var owner = loggedInUserId;

	var postData = {
					fullname: name,
					password: pass,
					id: owner
					};
var jsonData = JSON.stringify(postData);
	$.ajax({
		url: 'services/users',
		method: 'put',
		data: jsonData,
		headers: { 'Accept': 'application/json', 'Content-type': 'application/json' }, 
		success: function(data) {
			console.log("Add done");
			alert("Details Updated");
			$("#postForm").reset();
			location.reload();
		}
	});
}

$(document).ready(function() {
	loadPostCount();
	loadCommentCount();
});

function loadPostCount(){
	var postCount = 0;
	var voteCount = 0;
	$.ajax({
		url: 'services/posts?OwnerID=' + loggedInUserId,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			for(var index in data){
				postCount ++;
				voteCount = voteCount + data[index].postVote;
			}
			document.getElementById("UserTotalPosts").innerHTML = "<b> Total questions you've asked : </b>" + postCount;
			document.getElementById("UserTotalUpVotes").innerHTML = "<b> Total votes you've accumulated : </b>" +  voteCount;
		}
});
	console.log("loadPostCount with postID (sval)- Fired request");
}

function loadCommentCount(){
	var commentCount = 0;
	$.ajax({
		url: 'services/comments?commenterID=' + loggedInUserId,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			for(var index in data){
				commentCount ++;
			}
			document.getElementById("UserTotalAnswers").innerHTML = "<b> Total questions you've answered : </b>" +  commentCount;			
		}
});
	console.log("loadPostCount with postID (sval)- Fired request");
}
