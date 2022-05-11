var submitMessage = document.querySelector('#messageContent')
var user = sessionStorage.getItem
console.log(`The user is {user}`)

submitMessage.addEventListener('keypress', () => {
	fetch('http://localhost:8080/channels/{channelId}', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	}).then((response) => response.json())
})