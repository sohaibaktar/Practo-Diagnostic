function submitLoginForm() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const formData = {
        email: email,
        password: password
    };

    // Make a POST request to your server to validate the login
    fetch('http://your-api-endpoint/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        // Redirect to Dashboard page with customer ID
        window.location.href = `dashboard.html?customerId=${data.customerId}`;
    })
    .catch((error) => {
        console.error('Error:', error);
        // Handle errors, show an error message, etc.
    });
}
