if (sessionStorage.length === 1) {
	console.log("there is a user exist already")
} else {
	var userName = prompt('To make your time on this website better', 'please enter your name.');
	var userId = document.querySelector("#userId");
	var user = {
		'userId': userId.value,
		'userName': userName
	}
	console.log('userId is ', userId.value)
	console.log('userName is ', userName)
	fetch('http://localhost:8080/welcome', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	}).then((response) => response.json())

sessionStorage.setItem('user', user.userId)

console.log(sessionStorage.length)

}