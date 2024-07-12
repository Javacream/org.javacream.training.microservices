### Microservices 
 
* Topic: (Initial) Configuration of Microservices 
  * Which options exist to provide an initial configuration for a microservice (i.e. to populate an internal db with data) File based (yaml, json, csv, ...)?  
  * Internal config through Microservice Logic vs external Config through API? 
* Topic: Persistence and migration 
  * Scenario: Upgrading of a Microservice in Production with existing Persistence 
  * Best practices, etc. 
 
* Topic: Versioning 
  * Handling of breaking changes in newer versions when MS is widely used 
 
### Event Bus 
* Topic: Payload of events when pushing them to an Event Bus (e.g. Kafka) 
  * Options: 
    * A: Book with Id 54 has changed 
    * B: Book B_54 changed its title to "How (not) to build a microservice" 
    * C: ??? 
    * Pros and cons of the Options 
* How to handle API versions for Option B? 
* Best practices for topic structure? 
