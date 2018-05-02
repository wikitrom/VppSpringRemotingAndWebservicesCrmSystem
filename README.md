# For Personal EDU only! #

VPP Spring Remoting and Webservices - chapter 14-28, using REST

**Notes**: 
 - The exercise use a server-client application setup.
 - This repo holds the server-side app.
 - Need the tomcat server up and running with provided /mywebbapp/ application started.
 - Related client-side app is in repo: TBA

**Chapter summary**:
- Ch. 14 Part 3: REST Warmup (28 m 52 s) :: As a prelude to part 3, we
	start by reviewing the HTTP Verbs. If you know these already, you
	can skip to the next chapter.
- Ch. 15 Introducing REST (18 m 16 s) :: What is REST? Is it a standard? We
define REST using "4 core principles". In this chapter we explore the
first two of these.

- Ch. 16 Representations and URIs (39 m 12 s) :: We'll start by building some
REST representations and assigning them URIs.

- Ch. 17 REST Clients (31 m 1 s) :: Of course, we also need to be able to call
our REST service, so we look at what a REST client might look like,
both in Java and in Spring.

- Ch. 18 Content Negotiation (60 m 42 s) :: We'll learn how the HTTP headers
contain information about the type of data the client would like to
receive.

- Ch. 19 Error Handling (49 m 16 s) :: Learning the HTTP Status codes is
important as a REST developer.

- Ch. 20 Client Side Errors (40 m 57 s) :: The RESTTemplate is a bit weak at
detecting errors. We show how to extend the template to make it more
robust.

- Ch. 21 Collections and Ranges (49 m 10 s) :: How to return representations
of multiple objects.

- Ch. 22 Full HTTP Operations (62 m 53 s) :: The third of the four core
principles of REST is that the HTTP Verbs should be wisely used.

- Ch. 23 Editing Conflicts (optional) (40 m 25 s) :: This advanced chapter
shows how you can implement optimistic locking for PUT operations by
returning HTTP 409.

- Ch. 24 Partial Updates with PATCH (optional) (29 m 8 s) :: PATCH is a new
(proposed) HTTP Verb and can be used for partial updates. Its a good
idea but client support is patchy (pun not intended).

- Ch. 25 HATEOAS (62 m 39 s) :: Perhaps the worst acronym in our industry,
this hides an important concept that is slowly becoming more important
in REST. We start with the basics...

- Ch. 26 More HATEOAS (45 m 59 s) :: ... and then we expand to use more features, including the Spring HATEOAS plugin.		

- Ch. 27 Validation (39 m 26 s) :: How to use standard Spring-MVC to trap for
errors in the representations.

- Ch. 28 Practical Session (92 m 23 s) :: A major practical. Before starting,
we talk about ISO8601 dates, and also why REST isn't CRUD.
---------------------------------------
---------------------------------------
antlr-2.7.7.jar
aopalliance-1.0.jar
aspectjweaver-1.8.0.M1.jar
commons-dbcp-1.2.2.jar
commons-logging-1.1.1.jar
commons-pool-1.4.jar
dom4j-1.6.1.jar
hamcrest-core-1.3.jar
hessian-4.0.37.jar
hibernate-commons-annotations-4.0.1.Final.jar
hibernate-core-4.1.4.Final.jar
hibernate-ehcache-4.1.4.Final.jar
hibernate-entitymanager-4.1.4.Final.jar
hibernate-jpa-2.0-api-1.0.1.Final.jar
hibernate-validator-5.1.3.Final.jar
hsqldb.jar
jackson-annotations-2.4.3.jar
jackson-core-2.4.3.jar
jackson-databind-2.4.3.jar
javassist-3.15.0-GA.jar
javax.inject.jar
javax.servlet-api.jar
jboss-logging-3.1.0.GA.jar
jboss-transaction-api_1.1_spec-1.0.0.Final.jar
json-path-0.9.1.jar
json-smart-1.2.jar
jstl.jar
junit-4.11.jar
log4j.jar
objenesis-2.1.jar
Read Me.txt
slf4j-api-1.6.1.jar
slf4j-api-1.7.7.jar
slf4j-simple-1.7.7.jar
spring-aop-4.0.2.RELEASE.jar
spring-aspects-4.0.2.RELEASE.jar
spring-beans-4.0.2.RELEASE.jar
spring-context-4.0.2.RELEASE.jar
spring-context-support-4.0.2.RELEASE.jar
spring-core-4.0.2.RELEASE.jar
spring-expression-4.0.2.RELEASE.jar
spring-framework-bom-4.0.2.RELEASE.jar
spring-hateoas-0.16.0.RELEASE.jar
spring-instrument-4.0.2.RELEASE.jar
spring-instrument-tomcat-4.0.2.RELEASE.jar
spring-jdbc-4.0.2.RELEASE.jar
spring-jms-4.0.2.RELEASE.jar
spring-messaging-4.0.2.RELEASE.jar
spring-orm-4.0.2.RELEASE.jar
spring-oxm-4.0.2.RELEASE.jar
spring-plugin-core-1.1.0.RELEASE.jar
spring-test-4.0.2.RELEASE.jar
spring-tx-4.0.2.RELEASE.jar
spring-web-4.0.2.RELEASE.jar
spring-webmvc-4.0.2.RELEASE.jar
spring-webmvc-portlet-4.0.2.RELEASE.jar
spring-websocket-4.0.2.RELEASE.jar
standard.jar
validation-api-1.1.0.Final.jar
