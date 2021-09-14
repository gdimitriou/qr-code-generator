# qr-code-generator
This is a Spring Boot Microservice that generates QR Codes.

# Steps to run the program:
Clone the code to your favorite IDE.  
Run it.

# Endpoints:
1. Fire POST http://localhost:8080/api/v1/generate-qr/from-given-string
   Request Body: {"qrCodeMessage" : " "}  
   Expected Output: A QR Code that corresponds to the given string

2. Fire GET http://localhost:8080/api/v1/generate-qr/random  
   Expected Output: A unique QR-code that corresponds to a random UUID generated by the service
   
SwaggerUI can be found at: http://localhost:8080/swagger-ui.html
