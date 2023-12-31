# Introduction and Goals
## What and Why
What is a price? A number and a currency symbol, right? Generally speaking, yes. But without the context, it's not entirely clear what it refers to. To which specific amount and unit is it designated? Is the price valid for a specific period of time only? Does the price refer to a promotion or a negotiated contract with a customer? Is VAT already included or not?
As you can see, a price is always embedded in a quite complex context and requires a solution that takes these aspects into account.
This microservice based on the Spring Boot Framework would like to provide a first draft solution as a starting point and template for further requirements.

## Functional Features
| id    | Feature                         | Description                                                                                                                     |
|-------|---------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| FF-01 | RESTful API headless for prices | Prices of a product can be stored, updated and queried via RESTful API                                                          |
| FF-02 | multi currency support          | Prices can be provided and queried for different currencies                                                                     |
| FF-03 | net and gross prices            | Prices can be provided as net or gross prices                                                                                   |
| FF-04 | quantity related prices         | Prices can be provided and queried for different quantities                                                                     |
| FF-05 | prices valid in time ranges     | Prices can be provided and queried in the context of in specific time ranges (validFrom, validFrom & validTo, the newest wins) |
| FF-06 | customers prices                | Prices can be provided as customer prices, price queries can executed in customer context                                       |
| FF-07 | prices for promotion groups     | Prices can be provided and queried in promotion group context                                                                   |

## Non-Functional Features
| id    | Feature                                            | Description                                                                                                                          |
|-------|----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| NF-01 | Template for a cloud native price provider service | The project provides a working solution as a starting point and template for a price provider service that can be easily be adapted. |
| NF-02 | Prepared for cloud usage                           | The service is prepared for cloud usage and comes with a Docker file and Helmcharts.                                                 |
| NF-03 | Prepared for scaling via sharding                  | The service is prepared for databases with sharding capabilities and can be easily adapated.                                         |
| NF-04 | Non secured and secured access                     | Only authentifcated and authorized users or applications may access customer related prices.                                         |

## Quality Goals
| id    | Quality Category | Description                                                                                                           |
|-------|------------------|-----------------------------------------------------------------------------------------------------------------------|
| QG-01 | Correctness      | Always provide correct (at least the best fit) query results.                                                         |
| QG-02 | Performance      | Horizontal scaling capabilities to meet growing data volume and traffic requirements.                                 |
| QG-03 | Robustness       | The system shall work reliable under operating conditions especially under operating conditions. (Kubernets and Pods) |


## Personal Goals and Motivation
### Skills Enhancement and Exploration of new Technologies, Approaches, and Concepts
One of the primary motivations behind the development of the Price Provider Service is to enhance my proficiency in my current technology stack, centered around Java and the Spring Boot Framework.
By actively working on the design and implementation of this microservice, I want to deepen my understanding of the selected technologies especially the operational technology aspects (e.g. Docker & Kubernetes). I would like to further deepen my skills by carrying out analyses, the technical implementation as well as test installations and setups of selected integration scenarios.

The Price Provider Service serves as a platform for me to explore and experiment with novel technologies, innovative approaches, and cutting-edge concepts.
This exploration extends beyond the familiar boundaries of the current technology stack, allowing for the incorporation of new tools and methodologies that can contribute to the evolution and enrichment of the microservice architecture.

Beyond its immediate objectives, the Price Provider Service stands as a testament to continuous learning. It is not just a microservice but a template for ongoing improvement and adaptation.