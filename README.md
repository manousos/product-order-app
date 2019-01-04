# product-order-app
For storage solution is needed a mysql database.

To create the schema for application please execute the sql script that located at 
>../src/main/resources/db/createDB.sql

To run the application execute the following command on app root folder
>mvn spring-boot:run

To read the api documentation see at 
>http://localhost:8080/swagger-ui.html

Application Assignment
Web Service
Create a RESTful web service in Java using Spring Boot (RestController).
It should have an API supporting the basic CRUD operations for products:
● Create a new product
● Retrieve a list of all products
● Update a product
Each product should have a name and a price.
We’ll also introduce the concept of orders, meaning that your API should also support:
● Placing an order
● Retrieving all orders within a given time period
Each order should have a list of products. It should also have a unique id, the buyer’s e-mail, and the time
the order was placed. At any time it should be possible to (re)calculate the total order amount, based on
the price of the individual products.
It should be possible to change a product’s price, but this shouldn’t affect the calculation of the total
order amount for orders which have already been placed.
Requirements
● Implement your solution according to the above specification.
● You do not need to add authentication to your web service.
● Provide unit tests.
● Provide a README on how to build and run the application locally.
● Document the endpoints of your API either in Swagger or in your README file.
● Provide a storage solution for persisting the web service’s data.
