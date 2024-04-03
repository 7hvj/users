=====================================================Database===========================================================================
// check any constraints

SELECT CONSTRAINT_NAME, CHECK_CLAUSE
FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'table name'
==================================================================
// new request
use users;
ALTER TABLE new_request
ADD CONSTRAINT FK_new_request
FOREIGN KEY (new_request_id) REFERENCES requests(requests_id);
==================================================================
// renew request
use users;
ALTER TABLE renew_request
ADD CONSTRAINT FK_renew_request
FOREIGN KEY (renew_request_id) REFERENCES requests(requests_id);
==================================================================
// repair reqeust
use users;
ALTER TABLE repair_request
ADD CONSTRAINT FK_repair
FOREIGN KEY (repair_request_id) REFERENCES requests(requests_id);
==================================================================
//withdrawal request
use users;
ALTER TABLE withdrawal_request
ADD CONSTRAINT FK_withdrawal
FOREIGN KEY (withdrawal_request_id) REFERENCES requests(requests_id);
===================================================================
//Nominate request
use users;
ALTER TABLE nominate_to_housing
ADD CONSTRAINT FK_nominate
FOREIGN KEY (nominate_to_housing_id) REFERENCES requests(requests_id);
=====================================================postman===========================================================================

//    NewRequest functions:
add NewRequest
http://localhost:8080/api/NewRequest/addRequest

body: {
    "nationalId": 23424234243,
    "nationalIdDate": "2024-06-6",
    "nationalIdSource": "Government ",
    "country": " Country",
    "city": " City",
    "neighborhood": " Neighborhood",
    "phone": "+1234567890"
}

getNewRequestById
http://localhost:8080/api/NewRequest/{id}

Approve NewRequest 
http://localhost:8080/api/NewRequest/ApprovedRequest/{id}

Reject NewRequest 
http://localhost:8080/api/NewRequest/RejectedRequest/{id}

Delete NewRequest
http://localhost:8080/api/NewRequest/Delete/{id}

Get All NewRequest
http://localhost:8080/api/NewRequest/AllRequests

==========================================================================
//    RenewRequest functions:
add RenewRequest
http://localhost:8080/api/renewRequest/addRequest

body:{
    "studentId": 468987,
    "studentName": "ali Doe",
    "college": "iau University",
    "renewDate": "2024-05-26",
    "paymentReceipt": "XYZ123"
}

getRenewRequestById
http://localhost:8080/api/renewRequest/{id}

Approve RenewRequest
http://localhost:8080/api/renewRequest/ApprovedRequest/{id}

Reject RenewRequest 
http://localhost:8080/api/renewRequest/RejectedRequest/{id}

Delete RenewRequest
http://localhost:8080/api/renewRequest/Delete/{id}

Get All RenewRequest
http://localhost:8080/api/renewRequest/AllRequests

==========================================================================
//    RepairRequest functions:
add RepairRequest 
http://localhost:8080/api/repairRequest/addRequest

body:{
    "studentId": 123449,
    "building": "Comp",
    "room": "Study Room B",
    "repair": "air conditioner",
    "description": "The air conditioner in Study Room A is making loud noises and needs to be fixed."
}

getRepairRequestById
http://localhost:8080/api/repairRequest/{id}

Approve RepairRequest 
http://localhost:8080/api/repairRequest/ApprovedRequest/{id}

Reject RepairRequest 
http://localhost:8080/api/repairRequest/RejectedRequest/{id}

Delete RepairRequest 
http://localhost:8080/api/repairRequest/Delete/{id}

Get All RepairRequest 
http://localhost:8080/api/repairRequest/AllRequests

==========================================================================
//    withdrawalRequest functions:
add withdrawalRequest 
http://localhost:8080/api/withdrawalRequest/addRequest
body:{
    "studentId": 321098,
    "studentName": "Emma Wilson",
    "college": "Medicine College",
    "department": "Neurology",
    "building": "Medical Building",
    "room": "Room 601",
    "phone": "123-456-7890",
    "withdrawalReason": "Moving to another city",
    "iban": "MNO345",
    "bankName": "Last Bank"
}
getwithdrawalRequestById
http://localhost:8080/api/withdrawalRequest/{id}

Approve withdrawalRequest 
http://localhost:8080/api/withdrawalRequest/ApprovedRequest/{id}

Reject withdrawalRequest 
http://localhost:8080/api/withdrawalRequest/RejectedRequest/{id}

Delete withdrawalRequest 
http://localhost:8080/api/withdrawalRequest/Delete/{id}

Get All withdrawalRequest 
http://localhost:8080/api/withdrawalRequest/AllRequests

==========================================================================
//    NominateToHousingRequest functions:
add NominateToHousingRequest
http://localhost:8080/api/nominateToHousing/addRequest

body:{
    "nationalId": 654789123,
    "name": "Emma Wilson",
    "city": "Smallville",
    "nationalAddress": "654 Maple Street",
    "schoolName": "Smallville High School",
    "neighborhood": "Rural",
    "graduationCity": "Smallville",
  
getNominateToHousingRequestById
http://localhost:8080/api/nominateToHousing/{id}

Approve NominateToHousingRequest
http://localhost:8080/api/nominateToHousing/ApprovedRequest/{id}

Reject NominateToHousingRequest
http://localhost:8080/api/nominateToHousing/RejectedRequest/{id}

Delete NominateToHousingRequest
http://localhost:8080/api/nominateToHousing/Delete/{id}

Get All NominateToHousingRequest
http://localhost:8080/api/nominateToHousing/AllRequests

==========================================================================
// Get All Requests 
http://localhost:8080/api/requests/import
