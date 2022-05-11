var user = {
	'userName': userNamePrompt,
}
if(user == null) {
var userNamePrompt = window.prompt('What is your name?', 'Mina K Fahmy');	
} else {
	sessionStorage.setItem('user', JSON.stringify(user));



fetch('http://localhost:8080/welcome', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(user)
}).then((response) => response.json())
	
}









