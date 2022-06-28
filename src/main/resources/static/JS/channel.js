
var submitMessage = document.querySelector('#messageContent')


var user

const myTimeout = setTimeout("location.reload(true);", 500);

function stopRefreshing() {
	clearTimeout(myTimeout);
}

submitMessage.addEventListener('keypress', (e) => {
	if (e.key === 'Enter') {
		setTimeout("location.reload(true);", 800);
		var message = {
			'messageContent': submitMessage.value,
			user: {
				'userId': parseInt(sessionStorage.getItem('user'), 10)
			}

		}
		if (message.messageContent === '') {
			alert('message content is empty')
		} else {
			fetch('http://localhost:8080/channels/{channelId}/{userId}', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(message)
			}).then((response) => response.json())

		}
	} else {
		stopRefreshing()

	}

})
if (submitMessage.value = '') {
	setTimeout("location.reload(true);", 800);
}
submitMessage.focus()