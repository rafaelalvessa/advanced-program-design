FROM openjdk:7
COPY ./src /usr/src/room_heating_simulation
WORKDIR /usr/src/room_heating_simulation
RUN javac Heating.java HeatingSimulation.java
CMD ["java", "HeatingSimulation"]
