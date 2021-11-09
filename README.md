# About the project
This is a simple REST API wrapper which exposes 5 GET endpoints which take text data and output type as a request parameters.
#### Endpoints
- /api/is-word    
[returns true/false if string is a single word]
- /api/is-number  
[returns true/false if string is a number]
- /api/is-lower   
[returns true/false if string is a lowercase word]
- /api/is-upper   
[returns true/false if string is an uppercase word]
- /api/statistics   
[returns body with statistics containg flags above and number of occurrences of certain character types]
#### Request parameters
- data - any textual data to be processed
- format - desired output format type [available: json, xml, txt]

## Tech stack
- Spring Boot 2.5.5
- Java 11

## Building the project
Clone the project and use Maven to build the app.
```
$ mvn clean install
```

## Examples of use
After you deploy the application (port 8081 by default) you can send requests as follows:

### Example #1
```
GET http://localhost:8081/api/is-word?data=eXAMPLE12$&format=json
```
```
HTTP 200 OK
false
```
### Example #2
```
GET http://localhost:8081/api/is-word?data=eXAMPLE12$&format=xml
```
```
HTTP 200 OK
<Boolean>false</Boolean>
```
### Example #3
```
GET http://localhost:8081/api/statistics?data=eXAMPLE12$&format=json
```
```
HTTP 200 OK
{
    "isWord": false,
    "isNumber": false,
    "isLower": false,
    "isUpper": false,
    "characterCount": 10,
    "letterCount": 7,
    "digitCount": 2,
    "lowercaseLetterCount": 1,
    "uppercaseLetterCount": 6,
    "whitespaceCount": 0,
    "specialCharactersCount": 1
}
```
### Example #4
```
GET http://localhost:8081/api/statistics?data=eXAMPLE12$&format=txt
```
```
HTTP 200 OK
isWord: false
isNumber: false
isLower: false
isUpper: false
characterCount: 10
letterCount: 7
digitCount: 2
lowercaseLetterCount: 1
uppercaseLetterCount: 6
whitespaceCount: 0
specialCharactersCount: 1
```
### Example #5
```
GET http://localhost:8081/api/statistics?data=eXAMPLE12$&format=xml
```
```
HTTP 200 OK
<Statistics>
    <isWord>false</isWord>
    <isNumber>false</isNumber>
    <isLower>false</isLower>
    <isUpper>false</isUpper>
    <characterCount>10</characterCount>
    <letterCount>7</letterCount>
    <digitCount>2</digitCount>
    <lowercaseLetterCount>1</lowercaseLetterCount>
    <uppercaseLetterCount>6</uppercaseLetterCount>
    <whitespaceCount>0</whitespaceCount>
    <specialCharactersCount>1</specialCharactersCount>
</Statistics>
```
### Example #6
```
GET http://localhost:8081/api/statistics?data=eXAMPLE12$&format=Wrong
```
```
400 Bad Request
```
