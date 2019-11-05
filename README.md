# microservices-poc-consul-discovery
This is POC for microservices pattern.

This consists of :

1. config-server(acts as Centralized configuration server)

2. zuul-gateway (acts as api gateway)

3. demoMongoDb (springboot application which performs CRUD operations on mongodb)


Steps to start the setup:

1. make one docker container of mongodb running

    command to use ---    docker run --name mongo -p 27107:27107 mongo
  
2. navigate to config-server ( cd config-server)
  
    --> package the application (use command --- mvn clean compile package -DskipTests)
  
    --> run the application (use command --- mvn spring-boot:run)

3. make consul service discovery up (run as docker container)

      command to use ---  docker run --name consul -p 8500:8500 consul
      
      Once it is running, open http://localhost:8500 in browser(we can see dashboard of consul)
  
4. navigate to demoMongoDb

    --> package the application (use command --- mvn clean compile package -DskipTests)
  
    --> run the application (use command --- mvn spring-boot:run)
    
    (you can observe that it is fetching propeties from github,
      
      since this service is registered with consul and can be seen in services tab of consul dashboard)
  
5. naviagte to zuul-gateway

   --> package the application (use command --- mvn clean compile package -DskipTests)
  
   --> run the application (use command --- mvn spring-boot:run)
  
  
Now all services are up and running


Steps to test the services:


1)   open localhost:8500 in browser, then you can see consul dashboard and two services(zuul-gateway & demo-mongo) are            
     registered and status is UP.

2)   now test springboot demoMongoDb application 
  
     perform create operation using the url in browser
  
     localhost:8080/create?firstName=firstnamedemo&lastName=lastnamedemo&age=25
  
     you can check by using url (to get all persons) --- 
  
     localhost:8080/getAll
  
3)   now test api gateway 

     use url -- localhost:8092/demo-mongo/getAll
   
     it will route to localhost:8080/getAll and get you all persons details
