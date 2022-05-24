var submitMessage = document.querySelector('#messageContent')

submitMessage.addEventListener('keypress', (e) => {

	if (e.key === 'Enter') {
		var message = {
			'messageContent': submitMessage.value,
//			'user': sessionStorage.getItem('user')
		}

		console.log(message)
		fetch('http://localhost:8080/channels/{channelId}', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(message)
		}).then((response) => response.json())
		setTimeout("location.reload();", 90)

	} else {
		console.log("didn't press enter'")
	}
	submitMessage.focus()
})
