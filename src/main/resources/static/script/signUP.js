document.getElementById("signupForm").addEventListener("submit", function(event) {
    event.preventDefault();

    //get data from form
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var city = document.getElementById('city').value;
    var password = document.getElementById('password').value;
	// Validate mobile number (10 digits)
	    if (!/^\d{10}$/.test(phone)) {
	        alert("Invalid mobile number. Please enter a 10-digit mobile number.");
	        return;
	    }
	
	    // Validate password (at least 8 characters with specified criteria)
	    if (!/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\S+$).{8,}$/.test(password)) {
	        alert("Invalid password. Password must be at least 8 characters long and include at least one digit, one lowercase letter, one uppercase letter, and one special character.");
	        return;
	    }
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
			  if (response.ok) {
	            alert("Account Created!!");
	            window.location.href = `index.html`;
		      } else {
		          return response.text().then(errorMessage => {
		                 console.error('Error:', errorMessage);
		                 // Display error message to the user
		                 alert(errorMessage);
		          });
		      }
		        //return response.json();
		})
        /*.then(data => {
			alert("Account Created!!");
            // Optionally, you can redirect to another page or show a success message
            window.location.href = `index.html`;
        })*/
        .catch((error) => {
            console.error('Error:', error.message);
            // Handle errors, show an error message, etc.
        });
        
        console.log("fetch")
});