var userNamePrompt = window.prompt("What is your name?", "Mina K Fahmy");
var users = []
	if (userNamePrompt != null) {
//		document.getElementById("username")
		var user = {
			'userName': userNamePrompt
		}
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
		console.log("Please refresh the page, the username must not be empty")
	}





