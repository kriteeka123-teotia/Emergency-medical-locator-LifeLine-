EMERGENCY RESOURCE LOCATOR SYSTEM
API ENDPOINT DESIGN

AUTHENTICATION

POST /api/auth/register
Registers a new user.

POST /api/auth/login
User login.


USERS

GET /api/users/profile
Fetch logged-in user profile.


PROVIDERS

POST /api/provider/register
Register hospital/ambulance/blood bank.

POST /api/provider/update-availability
Update resource availability.

GET /api/providers/nearby
Find nearby providers.


EMERGENCY REQUESTS

POST /api/request/create
Create emergency request.

POST /api/request/accept
Provider accepts request.

POST /api/request/complete
Mark request as completed.

GET /api/request/status
Check request status.


ADMIN

GET /api/admin/providers/pending
List providers awaiting verification.

POST /api/admin/verify-provider
Approve provider.

DELETE /api/admin/remove-provider
Remove provider from system.