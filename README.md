### prometheus_demo - Client Java ###

As part of research into Prometheus, a project based on Spring Boot and JPA has been created. The project includes:
* Basic Spring Boot code
* JPA libraries and basic code to call the DB

This is part of the exploration of the [Client Java](https://github.com/prometheus/client_java)

There are some exporters and integrators to be used with different DBs. They can be found [here](https://prometheus.io/docs/instrumenting/exporters/)

### Steps we followed ###

Here are the steps we followed that should be repeatable:

```bash
# Compile the application
mvn install

# Run the application
java -jar target/prometheus_demo-0.0.1-SNAPSHOT.jar
```

### Example metrics ###

```
# HELP hibernate_collection_update_total Global number of collections updated (getCollectionUpdateCount)
# TYPE hibernate_collection_update_total counter
hibernate_collection_update_total{unit="myapp",} 0.0
# HELP hibernate_collection_remove_total Global number of collections removed (getCollectionRemoveCount)
# TYPE hibernate_collection_remove_total counter
hibernate_collection_remove_total{unit="myapp",} 0.0
# HELP hibernate_collection_recreate_total Global number of collections recreated (getCollectionRecreateCount)
# TYPE hibernate_collection_recreate_total counter
hibernate_collection_recreate_total{unit="myapp",} 0.0
# HELP hibernate_query_execution_total Global number of executed queries (getQueryExecutionCount)
# TYPE hibernate_query_execution_total counter
hibernate_query_execution_total{unit="myapp",} 0.0
# HELP hibernate_natural_id_query_execution_total The global number of naturalId queries executed against the database (getNaturalIdQueryExecutionCount)
# TYPE hibernate_natural_id_query_execution_total counter
hibernate_natural_id_query_execution_total{unit="myapp",} 0.0
# HELP my_sample_counter A simple Counter to illustrate custom Counters in Spring Boot and Prometheus
# TYPE my_sample_counter counter
# HELP http_requests_total Http Request Total
# TYPE http_requests_total counter
```