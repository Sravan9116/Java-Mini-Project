document.addEventListener("DOMContentLoaded", function() {
    fetchWaterUsage();
});

// Function to fetch water usage data and update the table
function fetchWaterUsage() {
    fetch("http://localhost:8080/api/water/usage")
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.getElementById("water-data");
            tableBody.innerHTML = ""; // Clear existing data
            data.forEach(item => {
                let row = `<tr>
                    <td>${item.location}</td>
                    <td>${item.waterConsumed}</td>
                    <td>${new Date(item.timestamp).toLocaleString()}</td>
                </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching data:", error));
}

// Function to submit new water usage data
function submitWaterUsage() {
    const location = document.getElementById("location").value;
    const waterConsumed = document.getElementById("waterConsumed").value;

    if (!location || !waterConsumed) {
        alert("Please fill in all fields!");
        return;
    }

    const newUsage = {
        location: location,
        waterConsumed: parseFloat(waterConsumed),
        timestamp: new Date().toISOString() // Auto-generate timestamp
    };

    fetch("http://localhost:8080/api/water/usage", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newUsage)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log("Water usage added:", data);
        fetchWaterUsage(); // Refresh the table
        document.getElementById("location").value = "";
        document.getElementById("waterConsumed").value = "";
    })
    .catch(error => console.error("Error submitting data:", error));
}
