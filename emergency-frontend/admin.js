const user = JSON.parse(localStorage.getItem('user'));
if(!user || user.role !== 'ADMIN') window.location.href = 'login.html';

async function loadProviders() {
    try {
        const res = await fetch('http://localhost:8080/api/admin/providers');
        const data = await res.json();
        const body = document.getElementById('adminBody');
        
        body.innerHTML = data.map(p => `
            <tr>
                <td>${p.userId}</td>
                <td>${p.resourceType}</td>
                <td><span class="badge">${p.verificationStatus}</span></td>
                <td><button onclick="verify(${p.id})" class="btn-main" style="padding: 5px 10px; font-size: 11px;">Verify</button></td>
            </tr>
        `).join('');
    } catch (err) { console.log("Admin API not ready"); }
}

loadProviders();