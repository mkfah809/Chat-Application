
var submitMessage = document.querySelector('#messageContent')
var userId = parseInt(sessionStorage.getItem('user'), 10)

//window.addEventListener('load', () => {
//	setTimeout("window.location.reload();", 100)
//
//})
var user



submitMessage.addEventListener('keypress', (e) => {

	if (e.key === 'Enter') {
		var message = {
			'messageContent': submitMessage.value,
			user: {
				'userId': userId
			}

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

setTimeout("window.location.reload();", 100)
function AutoRefresh(t) {
	setTimeout("location.reload(true);", t);
}

submitMessage.focus()