if (sessionStorage.length === 1) {
	alert("there is a user exist already")
} else {
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

sessionStorage.setItem('user', user.userId)
}