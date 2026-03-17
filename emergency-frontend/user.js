const loggedUser = JSON.parse(localStorage.getItem('user'));
if(!loggedUser) window.location.href = "login.html";

document.getElementById('welcome').innerText = "Welcome, " + loggedUser.name;

function send() {
    alert("Emergency alert broadcasted to nearby providers!");
}

function getLocation() {
    navigator.geolocation.getCurrentPosition(pos => {
        document.getElementById('lat').value = pos.coords.latitude.toFixed(6);
        document.getElementById('lng').value = pos.coords.longitude.toFixed(6);
    });
}

async function sendRequest() {
    const payload = {
        userId: user.userId,
        resourceType: document.getElementById('resourceType').value,
        latitude: document.getElementById('lat').value,
        longitude: document.getElementById('lng').value,
        status: "PENDING",
        priority: "HIGH"
    };

    const res = await fetch('http://localhost:8080/api/request/create', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });

    if(res.ok) alert("Request Broadcasted Successfully!");
}