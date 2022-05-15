var submitMessage = document.querySelector('#messageContent')

var message = {
	'messageContent': submitMessage.value
}

str = JSON.stringify(message);
console.log(str)


submitMessage.addEventListener('keypress', (e) => {
	if (e.key == 'Enter') {
		fetch('http://localhost:8080/channels/{channelId}', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(message)
		}).then((response) => response.json())
	}
})