# predix-jpa-cf
Predix Labs Java example on how to run websocket server, Database and Redis cache services.


##Project structure

   ``` 
├── README.md
├── manifest.yml
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── ge
    │   │           └── predix
    │   │               └── labs
    │   │                   └── data
    │   │                       └── jpa
    │   │                           ├── Application.java
    │   │                           ├── config
    │   │                           │   ├── CloudFoundryDataSourceConfiguration.java
    │   │                           │   └── ServicesConfiguration.java
    │   │                           ├── domain
    │   │                           │   └── Customer.java
    │   │                           ├── service
    │   │                           │   └── CustomerService.java
    │   │                           │   └── PredixWebSocketServerEndPoint.java
    │   │                           └── web
    │   │                               ├── CacheController.java
    │   │                               └── CustomerApiController.java
    │   └── resources
    │       └── initialCustomers.sql
    └── test
   ``` 
## Websocket client 
   ```  
wss://dragonfly.run.aws-usw02-pr.ice.predix.io/wss/messages
 {
      "nodeId":1,
      "messageId":123
   }
   
   ```  
      
 Log:
 
    ```  
                                            *** Websocket Message :  {
2016-09-20T15:37:08.74-0700 [App/0]      OUT       "nodeId":1,

2016-09-20T15:37:08.74-0700 [App/0]      OUT       "messageId":123

2016-09-20T15:37:08.74-0700 [App/0]      OUT    }

2016-09-20T15:37:08.74-0700 [App/0]      OUT *** Open Connection

2016-09-20T15:37:08.75-0700 [App/0]      OUT 2016-09-20 22:37:08.757  INFO 29 --- [io-63562-exec-4] 

o.s.c.s.r.PooledDataSourceCreator        : Found Tomcat high-performance connection pool on the classpath. Using it for DataSource connection pooling.

2016-09-20T15:37:08.75-0700 [App/0]      OUT 2016-09-20 22:37:08.759  WARN 29 --- [io-63562-exec-4] 

o.a.tomcat.jdbc.pool.ConnectionPool      : maxIdle is larger than maxActive, setting maxIdle to: 4

2016-09-20T15:37:08.76-0700 [App/0]      OUT *** Open Connection Done: {ApplicationName=}

2016-09-20T15:37:08.76-0700 [App/0]      OUT *** run statement

2016-09-20T15:37:08.76-0700 [App/0]      OUT INSERT INTO customer(id, name, phone, tstamp) 

values( nextval( 'hibernate_sequence') , 'TestJDBC','(123)-123-4567', NOW())

2016-09-20T15:37:08.76-0700 [App/0]      OUT *** Record is inserted into Customer table!
    ```  
   
## Use a browser to test app's REST: 

 [https://dragonfly.run.aws-usw02-pr.ice.predix.io/customers] (https://dragonfly.run.aws-usw02-pr.ice.predix.io/customers/customers)
   ```  
 returns json list of customer from resources/initialCustomers.sql
[{"id":1,"name":"Sam","phone":"(925)-123-4567","tstamp":1474410518488},
{"id":2,"name":"Sergey","phone":"(925)-223-4567","tstamp":1474410518491},
{"id":3,"name":"Robert","phone":"(925)-423-4567","tstamp":1474410518496},
{"id":4,"name":"Alex","phone":"(925)-523-4567","tstamp":1474410518498},
{"id":5,"name":"Savva","phone":"(925)-623-4567","tstamp":1474410518506},
{"id":6,"name":"Josh","phone":"(925)-723-4567","tstamp":1474410518508},
{"id":7,"name":"Patrick","phone":"(925)-823-4567","tstamp":1474410518510},
{"id":8,"name":"Andy","phone":"(925)-923-4567","tstamp":1474410518512},
{"id":9,"name":"Eric","phone":"(925)-013-4567","tstamp":1474410518515},
{"id":10,"name":"Chris","phone":"(925)-023-4567","tstamp":1474410518517},
{"id":11,"name":"Raj","phone":"(925)-033-4567","tstamp":1474410518519},
{"id":12,"name":"Vic","phone":"(925)-043-4567","tstamp":1474410518521},
{"id":13,"name":"Rich","phone":"(925)-053-4567","tstamp":1474410518523},
{"id":14,"name":"Mark","phone":"(925)-063-4567","tstamp":1474410518526},
{"id":15,"name":"TestJDBC","phone":"(123)-123-4567","tstamp":1474411028767}]


 https://dragonfly.run.aws-usw02-pr.ice.predix.io/customers/{id}
 returns customer by id number 
 {"id":785001,"name":"Sam","phone":"(925)-123-4567","tstamp":1447719635998}
    ```
 [https://dragonfly.run.aws-usw02-pr.ice.predix.io/search?q=J] (https://dragonfly.run.aws-usw02-pr.ice.predix.io/search?q=J)
    ```
 returns all customers containing letter "J" 
 [{"id":785006,"name":"Josh","phone":"(925)-723-4567","tstamp":1447719636022},
 {"id":785011,"name":"Raj","phone":"(925)-033-4567","tstamp":1447719636034}]
    ```
 [https://dragonfly.run.aws-usw02-pr.ice.predix.io/cache] (https://dragonfly.run.aws-usw02-pr.ice.predix.io/cache)
    ```
 returns 
 customers - Cache contains records: 

 785001:Name:Sam:Phone:(925)-123-4567
 
   ```  
