
var submitMessage = document.querySelector('#messageContent')
var userId = parseInt(sessionStorage.getItem('user'), 10)
//const myTimeout = setTimeout(timedRefresh, 3000);
//console.log('xadasdasd',myTimeout)

var user

const myTimeout = setTimeout("location.reload(true);", 5000);

function autoRefreshing() {
	myTimeout
}

function stopRefreshing() {
	clearTimeout(myTimeout);
}

submitMessage.addEventListener('keypress', (e) => {
	if (e.key === 'Enter') {
		setTimeout("location.reload(true);", 800);
		var message = {
			'messageContent': submitMessage.value,
			user: {
				'userId': userId
			}

		}
		if (message.messageContent === '') {
			console.log('message content is empty')
			alert('please type something')
		} else {
			fetch('http://localhost:8080/channels/{channelId}/{userId}', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(message)
			}).then((response) => response.json())

		}

		console.log(message)

	} else {
		stopRefreshing()

	}

})
//function timedRefresh(timeoutPeriod) {
//	setTimeout("location.reload(true);", timeoutPeriod);
//}
if (submitMessage.value = '') {
	setTimeout("location.reload(true);", 800);
}
submitMessage.focus()