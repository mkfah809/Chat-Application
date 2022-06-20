
var submitMessage = document.querySelector('#messageContent')
var userId = parseInt(sessionStorage.getItem('user'), 10)


var user



submitMessage.addEventListener('keypress', (e) => {

	if (e.key === 'Enter') {
		var message = {
			'messageContent': submitMessage.value,
			user: {
				'userId': userId
			}

		}
		if (message.messageContent === '') {
			console.log("XXXXX", "message content is empty")
			alert('please type something')
		}

		console.log(message)
		fetch('http://localhost:8080/channels/{channelId}/{userId}', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(message)
		}).then((response) => response.json())

		submitMessage.value = ''
	}

})
setTimeout("window.location.reload();", 1000)


submitMessage.focus()