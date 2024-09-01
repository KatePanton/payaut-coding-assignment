# Payaut Technical Assessment - Kate Panton

### Extent:
This project can:
 - Create a SQLite database instance and populate the following tables:
	 - ProductTypes
	 - Beers & BeerDiscounts
	 - Breads & BreadDiscounts
	 - Vegetables & VegetableDiscounts
 - For Product Types:
	 - Get all productTypes in the ProductTypes Table
	 - Get a productType by name
	 - [Product Type Endpoints](ReadMes/ProductTypeEndpoints.md)
 - For Product Type Beers:
	 - Add a new beer object to the Beers table
	 - Add a new beerDiscount object to the BeerDiscounts table
	 - Get a beer object by its brand name
	 - Get all beers in the Beers Table
	 - Get the discounts applicable for one or more beers
	 - Update an existing beer object in the Beers table
	 - Update an existing beerDiscount object in the BeerDiscounts table
	 - [Beer Endpoints](ReadMes/BeerEndpoints.md)
 - For Product Type Breads:
	 - Get all breads in the Breads Table
	 - Get the discounts applicable for one or more breads
 - For Product Type Vegetables:
	 - Get all vegetables in the Vegetables Table
	 - Get the discounts applicable for one or more vegetables
- For Orders
	- Return an order with a breakdown of each Beer, Bread, and Vegetable items price and discount, as well as the total amount payable for the order.
	- [Order Endpoint](ReadMes/OrderEndpoint.md)

### Technologies, Frameworks, and Dependencies:
**Technologies**
 - Spring Boot v3.3.3
 - Hibernate ORM

**Frameworks**
- Java v21
- Maven
- SQLite
- JPA

**Dependencies:**
- org.springframework
	- spring-webflux
- org.springframework.boot
	- spring-boot-devtools
	- spring-boot-starter-data-jpa
	- spring-boot-starter-jdbc
	- spring-boot-starter-test
	- spring-boot-starter-web
- org.xerial
	- sqlite-jdbc
- org.hibernate.orm
	- hibernate-core
	- hibernate-community-dialects

### Software Used:

 - Code editing: VS Code, Apache NetBeans, Cursor
 - API Testing: Insomnia
 - Database visualisation: SQLiteStudio
 - Version control: Git
 - Planning: Draw.io - [Planning Doc](Payaut.drawio)

### Project Structure
Follows a Repository Pattern.
**Api endpoints** are found in controllers.
**Controllers** call a service.
**Services** are responsible for the bulk of the logic and data manipulation.
Services call a **repository** which returns data from the database.
All of these integrate with **models**. These are the different types of models:

 - **entities**: determine the structure of the database tables and generic object.
   **dtos**: Data Transfer Objects are used to combine results from multiple database tables, or to declare api request structures. The
   "*WithDiscount*" DTOs are also responsible for calculating and
   setting the final discountGiven and AmountPayable.
   **interfaces**: these are used to convert the results of the repository database call into a dto that can be used in the service
   layer.
   **createUpdateDtos**: DTOs specifically for creating new objects or updating exsisting object is database tables.

### Design Decisions
**Why Springboot & Java:** Thought I would try to do the project in the language and framework that I would use at Payaut. I hope to show my willingness to learn new technologies, and that I am able to pick up said technologies fairly quickly.
**Maven vs Gradle:** Maven was the suggested build tool when setting up a new project through Apache Netbeans.
**Why Repository Pattern:** I am familiar and comfotable with this way of structuring my code. One less new thing to try and learn.
**Why SQLite:**  I am familiar and comfotable with SQL. I tried to create a SQL server database but struggled quite a lot with the integration, so I tried SQLite which was easier to get working.
**Why no unit tests:** I tried to make some unit tests - both with the auto-create through NetBeans and the Internet - but I wasnt able to get them working, let alone be actual good tests of the code.

### Challenges
- Learning Java and Springboot.
- Setting up the project and integrating with SQLite.
- Figuring out the repository layer and how to make database calls.
- Figuring out a way to get the models to work between the repo layer and the service layer without having to manually map each DTO.

### Future Improvements
- Unit tests
- Finishing off the rest of the Bread and Vegetable API endpoints (Left them out as the are just repeats of the Beer endpoints).
- Adding a frontend.
