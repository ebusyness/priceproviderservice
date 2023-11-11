# Price Provider Service
## What and Why
What is a price? A number and a currency symbol, right? Generally speaking, yes. But without the context, it's not entirely clear what it refers to. To which specific amount and unit is it designated? Is the price valid for a specific period of time only? Does the price refer to a promotion or a negotiated contract with a customer? Is VAT already included or not?
As you can see, a price is always embedded in a quite complex context and requires a solution that takes these aspects into account.
This microservice based on the Spring Boot Framework would like to provide a first draft solution as a starting point and template for further requirements.

## Feature Scope
- multi currency
- net and gross prices
- quantity related prices (bulk prices) 
- prices valid in specific time ranges (validFrom, validFrom & validTo, the newest wins)
- prices for customers
- prices for customer or promotion groups

## Implementation and General Concepts
### Layering
Dividing data access, services (domain and business logic), DTO conversion, and controllers into distinct layers helps to maintain a well-structured codebase and ensures clear separation of concerns.
The price provider service therefore follows this structure.

| layer             | package names                                                                                                                                                                     | class names                                                                                         |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Data Access Layer | de.ebusyness.priceproviderservice.dataaccess<br/>de.ebusyness.priceproviderservice.dataaccess.\<entiyname\><br/>de.ebusyness.priceproviderservice.dataaccess.\<entiyname\>.entity | <br/>\<EntityName>Repository.java<br/>\<EntityName>.java                                            |
| Service Layer     | de.ebusyness.priceproviderservice.service<br/>de.ebusyness.priceproviderservice.service.\<entiyname\>                                                                             | <br/>\<EntityName\>DomainService.java, \<BusinessLogic\>Service.java, \<BusinessLogic\>Job.java,... |
| Facade Layer      | de.ebusyness.priceproviderservice.facade<br/>de.ebusyness.priceproviderservice.facade.\<entiyname\><br/>de.ebusyness.priceproviderservice.facade.\<entiyname\>.dto                | <br/>\<EntityName\>Facade.java<br/>\<EntityName\>DTO.java                                           |
| Controller Layer  | de.ebusyness.priceproviderservice.controller<br/>de.ebusyness.priceproviderservice.controller.\<entiyname\>                                                                       | <br/>\<EntityName\>Controller.java, <br/>\<EntityName\>Validator.java,..                            |


#### Data Access Layer
Contains entity classes and their corresponding repository interfaces or implementations.
#### Service Layer:
##### DomainService
Holds domain-specific logic related to entities.
##### BusinessService
Orchestrates and contains broader business logic, potentially integrating various domain services. It encompasses the broader business rules, orchestration, and interactions between multiple domain entities.
##### Job / Scheduler
Scheduled jobs are used to perform bulk processing or automated maintenance tasks. 
#### Facade Layer
The facade layer acts as an intermediary between the service and controller layers, employing Data Transfer Objects (DTOs) and Converters for data exchange. DTOs streamline communication by reflecting the data, while Converters facilitate seamless transformation between Entity objects and DTOs.
#### Controller Layer
Controllers deal with DTOs for input and output, and the service layer is responsible for converting between DTOs and domain objects (entities).