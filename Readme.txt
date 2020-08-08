# Aquarium-shop
Internet shop with possibility of creating account and buy necessary aquarium animals and equipments.

Most important functionalities:

creating own account in the system,
browsing shop as a guest without logging process,
products should be divided on categories - should be possible to filter on that categories (later we can introduce some tags for products which gives possibility to create more filters),
user is able to logging
logged user can browse products and add them to cart (which is some kind of container for user session which is cleared once user log out or buy goods),
user is able to buy products added to cart or remove products from cart. He has his own - let's say - monthly budget (right now defined once during registration for simplicity), which can be spent on bying some goods. Company budget (defined once on DB) should be increased in that case and user budget should be reduced. Important thing here - many transactions in same time should be synchronized!
admin should be able to log to the system,
admin is able to add new / modify exists / remove products.
Technologies (newest stable version should be used always if this is possible)

Spring Security, Spring Boot, Spring Data, JSON
JPA, Hibernate,
PostgreSQL, H2 database (for unit tests),
Java,
TestNG,
Gradle,
Agular, HTML