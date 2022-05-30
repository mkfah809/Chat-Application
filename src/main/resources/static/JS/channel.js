var submitMessage = document.querySelector('#messageContent')

async function postMessage() {

	submitMessage.addEventListener('keypress', (e) => {

		if (e.key === 'Enter') {
			var message = {
				'messageContent': submitMessage.value,
				user: {
					'userName': sessionStorage.getItem('user')
				}
			}

			console.log(message)
			fetch('http://localhost:8080/channels/{channelId}', {
						method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(message)
			}).then((response) => response.json())
			setTimeout("window.location.reload();", 100)

		} else {
			console.log("didn't press enter'")
		}


	})
}

postMessage();
window.setTimeout(function() {
	window.location.reload();
}, 5000);
submitMessage.focus()
