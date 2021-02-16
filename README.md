# Taco Loco order service
## Quick Start
### Build & Run the app
> **`./gradlew clean build bootRun`**

### Run the unit tests
> **`./gradlew test`**

### Run API/integration tests with newman
if you don't have npm, get [Node](https://nodejs.org/en/).  Then, with the app running in your IDE or another terminal, do:
>  1. **`npm install`** 
>  2. **`npm run test`**

## API 
### request example
The client can include as many groups of tacos as desired and the service will total them all up.

For example, if there are two objects with `{ "type": "veggie" ...}`, the service will add both groups to the total.

Prices are up to the client under the assumption that they may want to adjust for different sales, coupons, Taco Tuesday etc.
(meaning: the service will still total everything up if a veggie taco price is $2.25 or a chorizo $2.49)
```
{
    "customerId": "Ms. Taco Lover",
    "tacos": [
        {
            "type": "veggie",
            "count": 3,
            "price": 2.5
        },
        {
            "type": "chicken",
            "count": 1,
            "price": 3
        },
        {
            "type": "beef",
            "count": 1,
            "price": 3
        },
        {
            "type": "chorizo",
            "count": 2,
            "price": 3.5
        }
    ]
}
```
### response example
```
{
    "orderId": "69123b0a-a438-4774-8994-c9b468fffc57",
    "customerId": "Ms. Taco Lover",
    "total": 16.40
}
```
Notes:  
- Orders are stored in the in-memory database. The unique `orderId` is generated in the save process and returned in the response.
- [Postman](https://www.postman.com/downloads/) API tests are included in the `/newman` folder. 
- Import the test collection `"Taco-Loco...json"` into Postman to run them on your own, or
- You can also run the API tests automagically with the [Newman](https://www.npmjs.com/package/newman) test runner using the npm command above
- Headers are standard Postman JSON:  `Content-Type: application/json, Accept: */*`

Other than that, hopefully the code explains itself :)  Please reach out if anything is unclear.

---

## See saved orders in the local in-mem H2 database:
`localhost:8080/h2-console/`

Login-Connection values should be populated the same as in src/main/resources/application.properties, but if not, copy them over from there.

1. Click Connect
2. Click TACO_ORDER to populate a quick SQL Select, 
3. Click Run. 
You should see any orders you sent.

---
Developed in VS Code on a Macbook Pro running Mojave

Started with [Spring Initializr](https://start.spring.io/)

You can also init right inside VS Code with Spring extensions!

#### Java version on my dev machine:
Java(TM) SE Runtime Environment (build 15.0.2+7-27)

Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)
