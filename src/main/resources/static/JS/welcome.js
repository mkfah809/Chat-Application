
var userNamePrompt = prompt('What is your name?', 'Mina K Fahmy');
console.log(userNamePrompt)
var user = {
	'userName': userNamePrompt
}
console.log("XXX",user)
sessionStorage.setItem('user', userNamePrompt);


fetch('http://localhost:8080/welcome', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(user)
}).then((response) => response.json())

