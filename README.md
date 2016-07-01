# 3DMatrixSummation
In this repository is submitted a attempt to solve the Cube Summation challenge in https://www.hackerrank.com/challenges/cube-summation

### Frameworks and Technologies ###
* Java v 1.8
* Dropwizard
* Hibernate validator
* Maven v 3.3

### How to use ###

* Go to cube summation api folder (cd cubesummation )
* Compile the application typing: _mvn clean install_
* After that, you can run the application. Type: _java -jar target/cubesummation-1.0.jar server cube-summation-configuration.yml_
* Use a REST client application such as Postman. Then, do the following POST operation:  

POST [http://localhost:9000/cubesummation](http://localhost:9000/cubesummation)  
Content-Type:application/json  
```javascript
{
  "cubeSummationTests" : [                                                  // The number of test cases which will be executed
      {
          "numberOfBlocksPerDimension":4,                                   // The number of block per dimension in each test case
          "operations":[                                                    // The operations to execute in each test case
              "UPDATE 2 2 2 4","QUERY 1 1 1 3 3 3","UPDATE 1 1 1 23","QUERY 2 2 2 4 4 4","QUERY 1 1 1 3 3 3"]
      },
      {
          "numberOfBlocksPerDimension":2,
          "operations":["UPDATE 2 2 2 1","QUERY 1 1 1 1 1 1","QUERY 1 1 1 2 2 2","QUERY 2 2 2 2 2 2"]
      }
  ]
}  
```
* It is returned a JSON with the following structure:
```javascript
{
  "messageStatus": 200,                                                       // HTTP status code
  "messageDescription": "Successfully Executed!",                             // The description about the status code
  "cubeSummationTestResults": [                                               // The result of the executed test cases
    {
      "operationResults": [                                                   // The result of each test case
        {
          "operation": "UPDATE 2 2 2 4",                                      // The executed opeartion in each test case
          "result": "Operation successfully executed!"                        // The result of the executed operation
        },
        {
          "operation": "QUERY 1 1 1 3 3 3",
          "result": "4"
        },
        {
          "operation": "UPDATE 1 1 1 23",
          "result": "Operation successfully executed!"
        },
        {
          "operation": "QUERY 2 2 2 4 4 4",
          "result": "4"
        },
        {
          "operation": "QUERY 1 1 1 3 3 3",
          "result": "27"
        }
      ]
    },
    {
      "operationResults": [
        {
          "operation": "UPDATE 2 2 2 1",
          "result": "Operation successfully executed!"
        },
        {
          "operation": "QUERY 1 1 1 1 1 1",
          "result": "0"
        },
        {
          "operation": "QUERY 1 1 1 2 2 2",
          "result": "1"
        },
        {
          "operation": "QUERY 2 2 2 2 2 2",
          "result": "1"
        }
      ]
    }
  ]
}
```
