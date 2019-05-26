
##Problem Statement:
Implement following REST API operations for User resource<br>
Create new User<br>
verify, that there is no active user with the same email id. If it does, <br>return appropriate Http error back.
if successful, a new user Id should be returned<br>
Update existing User (based on User id)<br>
can only update pincode and birthDate<br>
Delete existing User (based on User id)<br>
do not delete record, only deactivate user<br>
Get list of users - whose birthday falls in current month<br>
Get monthwise counts of birthdays<br>
e.g. January - count 4<br>
February - count 2
March - count 0...
Use https://cloud.google.com/apis/design/resource_names for defining endpoints and Http response codes
Store data into ElasticSearch (preferable) / MongoDB / Collections
Apply validation on input requests
Verify mandatory fields exist as per Create/Update/Delete operations
Verify that the birthDate is in the right date format and not a future date
Implement minimum 2 sample Junit Test Cases.

###POST MAN:

##1. Create User
http://localhost:8085/api/add-user

requestBody:
****
Method: POST
****

{<br>

	"fName":"Pakkurthi",<br>
	"lName":"Dorababu",<br>
	"email":"test2@test.com",<br>
	"pinCode":531060,<br>
	"birthDate": "22-MAY-2007"<br>
}<br>

****

response Positive:
****
{

    "id": "5ceae9d2fb64d71930f51a00"
}
****
response Negative:<br>
{

    "timestamp": "2019-05-26T19:32:00.634+0000",
    "status": 409,
    "error": "Conflict",
    "message": "User already exist",
    "path": "/api/add-user"
}
***
{

    "timestamp": "2019-05-26T20:04:37.594+0000",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "codes": [
                "NotEmpty.user.fName",
                "NotEmpty.fName",
                "NotEmpty.java.lang.String",
                "NotEmpty"
            ],
            "arguments": [
                {
                    "codes": [
                        "user.fName",
                        "fName"
                    ],
                    "arguments": null,
                    "defaultMessage": "fName",
                    "code": "fName"
                }
            ],
            "defaultMessage": "must not be empty",
            "objectName": "user",
            "field": "fName",
            "rejectedValue": "",
            "bindingFailure": false,
            "code": "NotEmpty"
        }
    ],
    "message": "Validation failed for object='user'. Error count: 1",
    "path": "/api/add-user"
}
*************

## Update User
Request;<br>
http://localhost:8085/api/update-user/5ceae9d2fb64d71930f51a00<br>

method:PUT<br>

response Positive:<br>

{

    "timestamp": "2019-05-26T20:04:37.594+0000",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "codes": [
                "NotEmpty.user.fName",
                "NotEmpty.fName",
                "NotEmpty.java.lang.String",
                "NotEmpty"
            ],
            "arguments": [
                {
                    "codes": [
                        "user.fName",
                        "fName"
                    ],
                    "arguments": null,
                    "defaultMessage": "fName",
                    "code": "fName"
                }
            ],
            "defaultMessage": "must not be empty",
            "objectName": "user",
            "field": "fName",
            "rejectedValue": "",
            "bindingFailure": false,
            "code": "NotEmpty"
        }
    ],
    "message": "Validation failed for object='user'. Error count: 1",
    "path": "/api/update-user"
}
*********


## Delete User

http://localhost:8085/api/delete-user/5ceae9d2fb64d71930f51a00

method: DELETE

response Positive:
{

	"id:"5ceae9d2fb64d71930f51a00"
	"fName":"Pakkurthi",
	"lName":"Dorababu",
	"email":"test3@test.com",
	"pinCode":531060,
	"birthDate": "22-MAY-2007"
}

response negative:

{

    "timestamp": "2019-05-26T19:43:57.320+0000",
    "status": 404,
    "error": "Not Found",
    "message": "User not found",
    "path": "/api/delete-user/5ceae9d2fb64d71930f51a0"
}



## Current Month Birthdays

http://localhost:8085/api/current-month/birthdays

response :
[

    {
        "id": "5ceade10fb64d70d008f0558",
        "fName": "Pakkurthi",
        "lName": "Dorababu",
        "email": "test2@test.com",
        "pinCode": 531060,
        "birthDate": "22-May-2007"
    }
]


## Count By Month

http://localhost:8085/api/count/MAY

response:

{

    "count": 2
}

