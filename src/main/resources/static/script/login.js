document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Get the email and password from the form
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Create an object to represent the user input
    var userInput = {
        email: email,
        password: password
    };

    // Send a POST request to the login API
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userInput),
    })
    .then(response => {
        if (response.ok) {
			alert("Login Successfull");
            // Redirect to the dashboard after successful login
            //var customerId = response.customerId;
            console.log("Hello, World!");
            return response.json(); 
            //window.location.href = '/dashboard.html';
        } else {
            // Display an error message
            
            document.getElementById("errorText").innerText = "Invalid email or password";
            throw new Error('Invalid email or password');
        }
    })
    .then(function(data) {
        // Update the HTML with the customerId.
        var userIdElement = document.getElementById("userId");
        //userIdElement.innerHTML = "User ID: " + data.customerId;

        // Redirect the user to the dashboard if needed.
         window.location.href = "/dashboard.html?id=" + data.customerId;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

console.log("bairee!");
