document.addEventListener("DOMContentLoaded", function () {
  // Wait for the DOM content to be fully loaded

  // Get the userId from the URL
  var urlParams = new URLSearchParams(window.location.search);
  var userId = urlParams.get('id');

  // Now you can use the userId variable as needed on the Dashboard page
  console.log("User ID on Dashboard: " + userId);
// Display the userId in the HTML
//  var userIdDisplay = document.getElementById('userIdDisplay');
//  userIdDisplay.textContent = "User ID: " + userId;
  
  // ... (other Dashboard page logic)
  
  // JavaScript function to update the hidden input value when a selection is made
	// dropdown menu
	function updateSelectedValue(fieldName) {
    var selectedValue = document.getElementById(fieldName).value;

    if (fieldName === 'department') {
        document.getElementById('selectedDepartment').value = selectedValue;
    } else if (fieldName === 'doctor') {
        document.getElementById('selectedDoctor').value = selectedValue;
    }
}
	  
  
  
  console.log("Hello, World!");
   const testForm = document.getElementById("testForm");

  testForm.addEventListener("submit", function (event) {
    event.preventDefault();
  
   // Get other form data
    const formData = new FormData(testForm);
    
    // Append prescription image file to FormData
    //const prescriptionImage = document.querySelector('input[name="prescriptionImage"]').files[0];
    //formData.append('prescriptionImage', prescriptionImage);

   // Add userId as customerId in the form data
   formData.append('customer', userId);
   
   // Format the date before sending it to the server
     var dateInput = formData.get('testDate');
     var formattedDate = new Date(dateInput).toISOString().split('T')[0];
     formData.set('testDate', formattedDate);
   
  	console.log(formattedDate);
  	var dept = formData.get('department');
  	console.log(dept);
  	var pre = formData.get('prescriptionImage');
  	console.log(pre);
  	// Perform POST request to the Spring Boot API
    fetch("/tests", {
      method: "POST",
      body: formData,
    })
      .then(response => {
			 if(response.ok){ 
			  return response.json();	
			 }else{
				document.getElementById("info").innerText = "Invalid email or password";
			 }
		})
      .then(data => {
		  // Update the HTML with the customerId.
	        var userIdElement = document.getElementById("info");
	        userIdElement.innerHTML = "Your booking is Confirmed";
	        console.log("Success:", data);
	        alert("Success");
        // Handle success (redirect, show a success message, etc.)
      })
      .catch(error => {
        console.error("Error:", error);
        // Handle error (show an error message, etc.)
      });
  });
  
  // ... (other Dashboard page logic)
});
