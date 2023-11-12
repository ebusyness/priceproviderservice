# Constraints
## Organizational Constraints

Convey's Law emphasizes the correlation between a system's design and the communication structure of the organization developing it.
In the context of the price provider service, this organization consists of a single person with specific skills and interests, which already defines a certain technology stack.
This also results in strong restrictions in terms of effort and costs, which limit the feature scope and project objectives.

### Starter Template
The Pricing Provider Service is designed to serve as a _starter template_ with an emphasis on simplicity and easy extensibility.
This design philosophy suits the one-person development team and enables manageable implementation effort. 
It offers an open platform for later individual extensions, adjustments and optimization.

## Technical  Constraints
## Technology Stack
Given the organizational context, the technology stack is constrained to Java and the Spring Boot Framework. This selection aligns with the individual's expertise and ensures a cohesive development environment.
Other necessary technological decisions will be made and documented based on the results of required research and analysis tasks. (see [Architectural Decision Records](030-architectural-decision-records.md))

## Resource and Infrastructure Constraints
Implementation is bound by the availability of only low-cost infrastructure. This constraint shapes the architectural decisions, influencing scalability, and limiting the incorporation of certain desirable features, particularly those associated with non-functional and operational aspects.
However, the _starter template_ design philosophy allows consumers of the template to make extensions and customizations as needed.

## Limitations on Feature Implementation and Testing
The constraints outlined above imply that not all desired features, especially those focused on non-functional and operational aspects, can be fully implemented and tested. 
The emphasis is on delivering a functional and expandable solution that can be created with manageble effort and at low cost (according to the specified context and limitations).