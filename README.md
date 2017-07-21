# TrakMatic



1. Clone the repo
2. mvn clean install
3. java -Dserver.port=8888 -jar target/TrakMatic-0.1.0.jar

This will start the server at localhost:8888

This would start acting like a proxy to all requests made on localhost:8888/ with GET/POST verbs.

To view the request data query on GET /view?<query_params>

To delete a request data query on GET /delete?<query_params>
[This will be done using POST or DELETE soon]

In the above queries <query_params> would act like a filter to all captured json values.

Sample :

POST to localhost:8888

1st Request - body:

{
foo:"bar",
sherlock: "watson"
}

2nd Request - body:

{
spiderman: "deadpool",
batman: "superman"
}

3rd Request - body:

{
foo: "bar",
joker: "bane"
}

GET /view?foo=bar

Response:

[
    {
        foo:"bar",
        sherlock: "watson"
    },
    {
        foo: "bar",
        joker: "bane"
    }
]

GET /delete?foo=bar&joker=bane

On success - ResponseCode : 200