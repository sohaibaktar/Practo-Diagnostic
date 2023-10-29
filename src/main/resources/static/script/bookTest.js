function submitTestForm() {
    const testName = document.getElementById('testName').value;
    const testDate = document.getElementById('testDate').value;
    
    // Assuming you have a function to get the customer ID after login
    const customerId = getCustomerId();

    const formData = {
        testName: testName,
        testDate: testDate,
        customerId: customerId
    };

    // Make a POST request to your server to save the test booking
    fetch('/tests', {
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
    })
    .catch((error) => {
        console.error('Error:', error);
        // Handle errors, show an error message, etc.
    });
}

function getCustomerId() {
    // Implement this function to retrieve the customer ID after login
    // For example, you can use a global variable or fetch it from the server
    return 'customer123'; // Replace with the actual customer ID
}
