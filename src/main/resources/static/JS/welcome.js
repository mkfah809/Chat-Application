var userNamePrompt = window.prompt('What is your name?', 'Mina K Fahmy');




var user = {
	'userName': userNamePrompt
}

console.log(user)

sessionStorage.setItem('user', JSON.stringify(user));


fetch('http://localhost:8080/welcome', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(user)
}).then((response) => response.json())











