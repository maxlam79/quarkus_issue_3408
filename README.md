# Reproducer for Quarkus Issue 3408
This is related to: [https://github.com/quarkusio/quarkus/issues/3408](https://github.com/quarkusio/quarkus/issues/3408)

## Database Initialization
Database used is MariaDB 10.3, dbname is default to "quarkus_issue_3408"

1. Edit the src/resources/application.properties file to make sure the quarkus.datasource.url and other parameters are correct. 
2. Run the dbinit.sql to setup the database, the tables and the data.

## Running The App
Do a simple quarkus:dev run:
```
./mvnw clean compile quarkus:dev

```

## Calling the REST Resource End-Point
To call the REST Resource end-point in question, just perform and see the result
```
curl -XGET -H "Content-type: application/json" 'http://localhost:8080/geo-states/?geoCountryCode=MY'

``` 

## The Expected Result
```
[
  {
    "stateCode": "MY-01",
    "stateName": "Johor",
    "uuid": "b507ace7-41dc-4aa8-99ed-1f2a3b49d369"
  },
  {
    "stateCode": "MY-02",
    "stateName": "Kedah",
    "uuid": "d2d59643-4a6b-465a-abec-6c1c04a4cac3"
  },
  {
    "stateCode": "MY-03",
    "stateName": "Kelantan",
    "uuid": "19898257-e170-499c-a992-d21fa03469c3"
  },
  ...
]

```