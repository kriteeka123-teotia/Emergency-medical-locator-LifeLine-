const user = JSON.parse(localStorage.getItem('user'));
if(!user || user.role !== 'PROVIDER') window.location.href = 'login.html';
document.getElementById('pName').innerText = user.name;

async function fetchRequests() {
    try {
        const res = await fetch('http://localhost:8080/api/request/pending');
        const data = await res.json();
        const container = document.getElementById('requestContainer');
        
        if(data.length > 0) {
            container.innerHTML = data.map(req => `
                <div style="padding: 15px; background: #fff5f5; border: 1px solid #ffcdd2; border-radius: 10px; display: flex; justify-content: space-between; align-items: center;">
                    <div>
                        <strong style="color: var(--primary);">${req.resourceType} REQUIRED</strong>
                        <p style="font-size: 12px; color: #666;">Loc: ${req.latitude}, ${req.longitude}</p>
                    </div>
                    <button onclick="accept(${req.id})" class="btn-main" style="padding: 8px 15px;">Accept</button>
                </div>
            `).join('');
        }
    } catch (err) { console.log("Waiting for server..."); }
}

setInterval(fetchRequests, 5000); // Check for new emergencies every 5 seconds