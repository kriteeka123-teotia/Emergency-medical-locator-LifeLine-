const API_URL = "http://localhost:8080/api/auth";

async function loginUser(event) {
    event.preventDefault();
    console.log("Login button clicked..."); // DEBUG

    const loginRequest = {
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    try {
        const res = await fetch(`${API_URL}/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(loginRequest)
        });

        console.log("Response Status:", res.status); // DEBUG

        if (res.ok) {
            const user = await res.json();
            console.log("User received from backend:", user); // DEBUG
            
            localStorage.setItem('user', JSON.stringify(user));
            
            // Ensure the role exists and is trimmed of spaces
            if (!user.role) {
                alert("User has no role assigned in database!");
                return;
            }

            const role = user.role.toUpperCase().trim(); 
            console.log("Navigating to role:", role); // DEBUG

            if (role === "USER") window.location.href = "user-dashboard.html";
            else if (role === "PROVIDER") window.location.href = "provider-dashboard.html";
            else if (role === "ADMIN") window.location.href = "admin-dashboard.html";
            else alert("Role not recognized: " + role);

        } else {
            const errorText = await res.text();
            alert("Login Failed: " + errorText);
        }
    } catch (err) {
        console.error("Fetch Error:", err);
        alert("CRITICAL ERROR: Check if Spring Boot is actually running on port 8080.");
    }
} 

async function registerUser(event) {
    // 1. STOP the page from reloading
    event.preventDefault(); 
    
    console.log("Registering process started...");

    const user = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        password: document.getElementById('password').value,
        role: document.getElementById('role').value
    };

    try {
        const res = await fetch(`${API_URL}/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user)
        });

        if (res.ok) {
            console.log("Registration successful!");
            alert("Registration Successful! Redirecting to Login...");
            // 2. MANUALLY move to the login page
            window.location.href = "login.html"; 
        } else {
            const errorMsg = await res.text();
            alert("Registration Failed: " + errorMsg);
        }
    } catch (err) {
        console.error("Connection Error:", err);
        alert("Cannot connect to the server. Is Spring Boot running?");
    }
}