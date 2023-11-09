// Function to fetch data from the server
    function fetchData(customerId) {
        fetch(`/tests/findbycustId/${customerId}`)
            .then(response => response.json())
            .then(data => displayData(data))
            .catch(error => console.error('Error:', error));
    }

    // Function to display data in the table
    function displayData(tests) {
        const tableBody = document.querySelector('#testTable tbody');

        tests.forEach(test => {
            const row = tableBody.insertRow();

            // Insert data into the row
            row.insertCell(0).textContent = test.test_id;
            row.insertCell(1).textContent = test.testName;
            row.insertCell(2).textContent = test.testDate;
            row.insertCell(3).textContent = test.doctor;

             // Display image
	        const imageCell = row.insertCell(4);
	        const image = new Image();
			//console.log([test.prescriptionImage]);
	       
	        // Set the data URL as the image source
	        image.src = "data:image/png;base64,"+[test.prescriptionImage];
	        //console.log(image.src);
	        image.width = 100; // Set the width as needed
	        image.height = 100; // Set the height as needed
	        
	        imageCell.appendChild(image);
        });
    }

    // Get customerId from URL
    //var urlParams = new URLSearchParams(window.location.search);
    //var customerId = urlParams.get('customerId');
	// Retrieve customerId from sessionStorage
	var customerId = sessionStorage.getItem("customerId");
    // Fetch and display data
    fetchData(customerId);
console.log("hi");