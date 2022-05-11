var userNamePrompt = window.prompt('What is your name?', 'Mina K Fahmy');
//var userIdTextbox = document.querySelector('#userId')
var users = []



if (userNamePrompt != null) {
	var user = {
		'userName': userNamePrompt,
 	}


	sessionStorage.setItem('user', JSON.stringify(user));
	users.push(user)
	console.log(users)
	
	
	fetch('http://localhost:8080/welcome', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	}).then((response) => response.json())

} else {
	console.log('Please refresh the page, the username must not be empty')
}




