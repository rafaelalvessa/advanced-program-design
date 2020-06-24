FROM openjdk:7
COPY ./src /usr/src/observer_and_decorator_design_patterns
WORKDIR /usr/src/observer_and_decorator_design_patterns
RUN javac DogBot.java DogWatcher.java ObservableDogBot.java RacingDogBot.java \
ObservableRacingDogBot.java TestDogBot.java
CMD ["java", "TestDogBot"]
