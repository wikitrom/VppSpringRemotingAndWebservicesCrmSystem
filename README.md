# For Personal EDU only! #

VPP Spring Remoting and Webservices - chapter 14-28, using REST

**Note**: 
 - The exercise use a server-client application setup.
 - This repo holds the server-side app.
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
