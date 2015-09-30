function loadUserPosts(){
	$.ajax({
		url: 'services/posts?OwnerID='+loggedInUserId,
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			html="";
			for(var index in data){
				var row = "<tr onclick=\"window.location.href='posts_detail.jsp?postID=" + data[index].postID + "'\">\n\
	             <td>" + data[index].postTitle + "</td>\n\
	             <td><img src='images/thumbsup.png' height='20' width='20'></img></td>\n\
	             <td>" + data[index].postVote + "</td>\n\
	           </tr>";
				$("#currentUserTable").append(row);
			}
		}
});
	console.log("loadUserPosts - Fired request");
}

function loadAllUsersPosts(){
	$.ajax({
		url: 'services/posts?',
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			for(var index in data){
				var row = "<tr onclick=\"window.location.href='posts_detail.jsp?postID=" + data[index].postID + "'\">\n\
	             <td>" + data[index].postTitle + "</td>\n\
	             <td><img src='images/thumbsup.png' height='20' width='20'></img></td>\n\
	             <td>" + data[index].postVote + "</td>\n\
	           </tr>";
				$("#userTableAll").append(row);
			}
		}
});
	console.log("loadAllUsersPosts - Fired request");
}


function loadAllUsersUAPosts(){
	$.ajax({
		url: 'services/posts?UA=1',
		method: 'get',
		headers: { 'Accept': 'application/json' }, 
		success: function(data) {
			console.log("Data arrived");
			for(var index in data){
				var row = "<tr onclick=\"window.location.href='posts_detail.jsp?postID=" + data[index].postID + "'\">\n\
	             <td>" + data[index].postTitle + "</td>\n\
	             <td><img src='images/thumbsup.png' height='20' width='20'></img></td>\n\
	             <td>" + data[index].postVote + "</td>\n\
	           </tr>";
				$("#userTableUA").append(row);
			}
		}
});
	console.log("loadAllUsersPosts - Fired request");
}

$(document).ready(function() {
	loadUserPosts();
	loadAllUsersPosts();
	loadAllUsersUAPosts();
});


function addPost(){
var title = $("#title").val();
var owner = loggedInUserId;
var postData = {
					postTitle: title,
					ownerID: owner
					};
var jsonData = JSON.stringify(postData);
	$.ajax({
		url: 'services/posts',
		method: 'post',
		data: jsonData,
		headers: { 'Accept': 'application/json', 'Content-type': 'application/json' }, 
		success: function(data) {
			console.log("Post successfully added done");
			alert("Your question has been posted !!");
			$("#postForm")[0].reset();
			location.reload();
//			$("#userForm").hide();
			var row = "<tr><td>"+data[index].postTitle+"</td><td>"+data[index].postVote+"</td></tr>";
			$("#userTable").append(row);
		}
	});
console.log("loadUserPosts - Fired request");
}
