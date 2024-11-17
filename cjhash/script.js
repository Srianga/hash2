document.getElementById('hashForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Get the input string from the form
    const inputString = document.getElementById('inputString').value;

    // Perform the API call
    fetch('http://localhost:8080/generateHash', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(inputString)
    })
    .then(response => response.text()) // Get the response as text (the hash)
    .then(hash => {
        // Display the generated hash
        document.getElementById('generatedHash').textContent = hash;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
