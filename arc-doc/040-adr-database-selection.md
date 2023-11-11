# ADR: Database Selection and Scalability for Price Provider Service
## Context
The Price Provider service requires a robust and scalable database solution capable of managing a high volume of price-related data. 
As the service experiences increasing traffic and concurrent requests, a standard database setup faces challenges related to throughput and performance. 
To address these limitations, database options offering advanced features for handling large datasets, high import performance, and accommodating high traffic demands efficiently need to be explored.

## Problem Statement
The standard database setups may face limitations in handling the escalating transaction per second (TPS) and concurrent access. To ensure optimal performance, it is imperative to select a database solution that can efficiently manage a high volume of price data and seamlessly handle the increasing traffic demands while maintaining high import performance.

## Required Database Capabilities
A database solution is needed that offers features for effective handling of high traffic and massive data loads.
* **Sharding:** Sharding enables distributing large datasets across multiple shards, ensuring efficient data management and scalability.
* **Readwrite Splitting:** By segregating read and write operations, the database can better handle high concurrent read requests and optimize performance.
* **Replicas Support:** Replicas play a vital role in offloading read operations, contributing to improved query performance and overall system efficiency.
* **Scalability and Elasticity:** The ability of the database to scale both vertically (increasing resources within a server) and horizontally (scaling across multiple servers) is crucial. Elasticity ensures the database can dynamically adjust resources based on demand.
* **Failover and Disaster Recovery:** Redundancy and failover mechanisms ensure that the system remains available even in the event of hardware failures or outages. Robust disaster recovery options are crucial for data safety and business continuity.

## Constraints
The Price Provider Service follows the goal to be a starter application template designed to remain simple and easily extendable.
This constraint implies that the application, based on standard Spring Boot capabilities, aims to provide and support functionalities within its inherent framework.
The selected database solution is expected to encompass the necessary complexities, allowing the application to leverage its features within the scope of standard Spring Boot functionalities.
That approach emphasizes that the chosen database must bear the complexity associated with desired features (sharding, readwrite-splitting, and replica management), while the application maintains flexibility within the boundaries of standard Spring Boot features.





------

## Features / Capabilities of database
The desired features/capabilities of the database are the following:
* sharding, auto-balanced resharding
* readwrite-splitting & Replicas
>"Database throughput has faced the bottleneck with increasing TPS. For the application with massive concurrence read but less write in the same time, we can divide the database into a primary database and a replica database. The primary database is responsible for the insert, delete and update of transactions, while the replica database is responsible for queries. It can significantly improve the query performance of the whole system by effectively avoiding row locks."
https://shardingsphere.apache.org/document/current/en/features/readwrite-splitting/



### MongoDB
technology: document based database (nosql), sharding capabilities incl. auto-balancing/resharding, self managed or managed service
website:
webinar: https://www.youtube.com/watch?v=8sk75-6W0ik - Demystifying Sharding in MongoDB
- early planning of sharding, vertical scaling has its limits, Mongo Router, Auto-Balanced
    
### ShardingSphere
ShardingSphere is an open-source distributed database middleware that provides a variety of sharding features, including database sharding, distributed transaction, read/write splitting, high availability, data migration, query federation, data encryption, and shadow database for full-link online load testing scenarios. ShardingSphere can be used with a variety of relational databases, including MySQL, PostgreSQL, and Oracle.
technology: middleware (ShardingSphere-Proxy) in front of relational (sql) database
website: https://shardingsphere.apache.org/

### Vitess
Vitess is an open-source horizontal sharding solution for MySQL. Vitess provides a variety of features, including automatic sharding, distributed transactions, and a SQL query router. Vitess is used by a number of large companies, including YouTube and Airbnb.
technology: middleware in front of relational (sql) database

licence: test

website: https://vitess.io/, https://vitess.io/docs/18.0/overview/whatisvitess/, https://vitess.io/docs/18.0/overview/architecture/

webinar: https://www.youtube.com/watch?v=E6H4bgJ3Z6c&t=2s - Webinar: Vitess: Sharded MySQL on Kubernetes
- Vitess is a sharding middleware for MySQL
- resharding? / rebalancing?
- kubernetes 

 

### CockroachDB
CockroachDB is a distributed SQL database that supports horizontal sharding. CockroachDB is designed to be highly scalable and reliable, and it offers a number of features that make it well-suited for microservices architectures, such as strong consistency and geo-replication.

### Google Cloud Spanner
Spanner is a fully managed, mission-critical, relational database service that offers transactional consistency at global scale, schemas, SQL, and automatic, synchronous replication for high availability. Spanner can be used to shard data across multiple regions and zones, and it offers a number of features that make it well-suited for microservices architectures, such as automatic schema changes and SQL queries that can span multiple regions.