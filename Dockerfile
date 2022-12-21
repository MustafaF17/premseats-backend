From openjdk:8
copy ./build/libs/PremSeats-0.0.1-SNAPSHOT.jar PremSeats-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","PremSeats-0.0.1-SNAPSHOT.jar"]