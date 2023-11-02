document.getElementById("signupForm").addEventListener("submit", function(event) {
    event.preventDefault();

    //get data from form
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var city = document.getElementById('city').value;
    var password = document.getElementById('password').value;

     var formData = {
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
        .then(response => {
			alert("Account Created!!");
			return response.json();
			
		})
        .then(data => {
            // Optionally, you can redirect to another page or show a success message
            window.location.href = `index.html?customerId=${data.customerId}`;
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle errors, show an error message, etc.
        });
        
        console.log("fetch")
});