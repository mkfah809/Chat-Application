//window.addEventListener('DOMContentLoaded', () => {
//if (sessionStorage === 0) {
	var userName = prompt('To make your time on this website better', 'please enter your name.');
	var userId = document.querySelector("#userId");
	var user = {
		'userId': userId.value,
		'userName': userName
	}

	fetch('http://localhost:8080/welcome', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	}).then((response) => response.json())
	console.log(userId)
	console.log(userName)
	sessionStorage.setItem("user", JSON.stringify(user))
//}
//});
























//if (sessionStorage.length === 0) {
//
//
//	var userNamePrompt = prompt('To make your time on this website better', 'please enter your name.');
//
//	console.log(userNamePrompt)
//	var user = {
//
//		'userName': userNamePrompt
//	}
//	console.log("XXX", user)
//	sessionStorage.setItem('user', JSON.stringify(user));
//
//
//
//	fetch('http://localhost:8080/welcome', {
//		method: 'POST',
//		headers: {
//			'Content-Type': 'application/json'
//		},
//		body: JSON.stringify(user)
//	}).then((response) => response.json())
//
//
//}
//window.setTimeout(function() {
//		window.location.reload();
//	}, 5000);



