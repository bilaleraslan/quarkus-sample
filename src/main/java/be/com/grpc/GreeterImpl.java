package be.com.grpc;

import be.com.*;
import io.quarkus.grpc.GrpcService;
import io.quarkus.logging.Log;
import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.UUID;

@GrpcService
public class GreeterImpl implements Greeter {
    Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        Log.info("Q ; GreeterImpl sayHello called");
        logger.info("4j ; GreeterImpl sayHello called {}", UUID.randomUUID().toString());
        return Uni.createFrom().item(() ->
                HelloReply.newBuilder().setFullName("Hello Grpc , fullName: "
                        + request.getName() + " " + request.getLastName()).build());
    }

    @Authenticated
    @Override
    public Uni<CalculateAgeResponse> calculateAge(CalculateAgeRequest request) {
        Log.info("Q ; GreeterImpl calculateAge called");
        logger.info("4j ; GreeterImpl calculateAge called {}", UUID.randomUUID().toString());

        int age = LocalDate.now().getYear() - request.getBirthYear();
        return Uni.createFrom().item(() ->
                CalculateAgeResponse.newBuilder().setAge(age).build());
    }
}
