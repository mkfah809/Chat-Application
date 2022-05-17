var submitMessage = document.querySelector('#messageContent')

var userName = sessionStorage.getItem('user')

console.log(userName)

submitMessage.addEventListener('keypress', (e) => {
	
	var message = {
		'messageContent': submitMessage
	}

	if (e.key === 'Enter') {
		fetch('http://localhost:8080/channels/{channelId}', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(message)
		}).then((response) => response.json())

	} else {
		console.log("didn't press enter'")
	}
	


	
})