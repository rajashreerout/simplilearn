FROM openjdk:17
COPY ./target/product.jar product.jar
CMD ["java","-jar","product.jar"]
