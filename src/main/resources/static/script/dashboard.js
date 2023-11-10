document.addEventListener("DOMContentLoaded", function () {
  // Wait for the DOM content to be fully loaded

  // Get the userId from the URL
  //var urlParams = new URLSearchParams(window.location.search);
  //var userId = urlParams.get('id');
  // Retrieve customerId from sessionStorage
	var customerId  = sessionStorage.getItem("customerId");
	
	//pass to bookingHistory
	//const bookingHistoryLink = document.querySelector('#bookingHistoryLink');
    //bookingHistoryLink.href = `bookingHistory.html?customerId=${customerId }`;
  // Now you can use the userId variable as needed on the Dashboard page
  console.log("User ID on Dashboard: " + customerId +" type"+typeof(customerId ));

  console.log("Hello, World!");
   const testForm = document.getElementById("testForm");

  testForm.addEventListener("submit", function (event) {
    event.preventDefault();
   
   // Get other form data
    var formData = new FormData(testForm);
    // take file from user and data as json
    var fileInput = document.querySelector('input[name="prescriptionImage"]');
    var data = {
        testName: document.getElementById('selectedDepartment').value,
        doctor: document.getElementById('selectedDoctor').value,
        testDate: document.querySelector('input[name="testDate"]').value,
        customerId:customerId ,
    };
   console.log(document.querySelector('input[name="testDate"]').value);
   // Append  formData file and json
    formData.append('file', fileInput.files[0]);
    formData.append('data', JSON.stringify(data));
   
  	// Perform POST request to the Spring Boot API
    fetch("/tests", {
      method: "POST",
      body: formData,
    })
     	.then(response => {
		   console.log('Response from server:', response);
		   return response.text();
		})
        .then(data => {
			console.log("data: "+data);
			 // Update the HTML with the customerId.
	        var userIdElement = document.getElementById("info");
	        userIdElement.innerHTML = "Your booking is Confirmed";
	        alert("Success");
			document.getElementById("testForm").reset();
			// Manually reset dropdown values
	        document.getElementById('selectedDepartment').value = '';
	        document.getElementById('selectedDoctor').value = '';
	       
		})
        .catch(error => console.error('Error:', error));
  });
  
  
});
//outsode theDOM cause dropdown select
function updateSelectedValue(fieldName) {
    var selectedValue = document.getElementById(fieldName).value;
    document.getElementById('selected' + fieldName.charAt(0).toUpperCase() + fieldName.slice(1)).value = selectedValue;
}