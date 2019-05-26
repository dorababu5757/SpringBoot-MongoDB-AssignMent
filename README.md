###POST MAN:

##1. Create User
http://localhost:8085/api/add-user

requestBody:
****
Method: POST
****

{
	"fName":"Pakkurthi",
	"lName":"Dorababu",
	"email":"test2@test.com",
	"pinCode":531060,
	"birthDate": "22-MAY-2007"
}

****

response Positive:
****
{
    "id": "5ceae9d2fb64d71930f51a00"
}
****
response Negative:
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
Request;
http://localhost:8085/api/update-user/5ceae9d2fb64d71930f51a00

method:PUT

response Positive:

{
    "id": "5ceae9d2fb64d71930f51a00",
    "fName": "Pakkurthi",
    "lName": "Dorababu",
    "email": "test3@test.com",
    "pinCode": 531060,
    "birthDate": "22-May-2007"
}

response Negtive:

{
    "timestamp": "2019-05-26T19:41:44.891+0000",
    "status": 404,
    "error": "Not Found",
    "message": "User not found",
    "path": "/api/update-user/5ceae9d2fb64d71930f51a0"
}
****
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
*********


## Delete User

http://localhost:8085/api/delete-user/5ceae9d2fb64d71930f51a00

method: DELETE

response Positive:
{
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

