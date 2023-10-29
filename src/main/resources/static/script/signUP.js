function submitForm() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const city = document.getElementById('city').value;
    const password = document.getElementById('password').value;

    const formData = {
        name: name,
        email: email,
        phone: phone,
        city: city,
        password: password
    };

    // Make a POST request to your Spring Boot API endpoint
    fetch('/patients', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Optionally, you can redirect to another page or show a success message
            window.location.href = `dashboard.html?customerId=${data.customerId}`;
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle errors, show an error message, etc.
        });
}
