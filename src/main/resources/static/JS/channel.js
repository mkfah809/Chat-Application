var submitMessage = document.querySelector('#messageContent')



submitMessage.addEventListener('keypress', (e) => {

		var message = {
			'messageContent': submitMessage.value
		}
		
		
		str = JSON.stringify(message);
		console.log(str)

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