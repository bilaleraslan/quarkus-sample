//package be.com;
//
//import io.grpc.stub.StreamObserver;
//import io.quarkus.grpc.GrpcService;
//import io.smallrye.mutiny.Uni;
//
//@GrpcService
//public class GreeterImplv2 extends GreeterGrpc.GreeterImplBase {
//
//    @Override
//    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
//        String name = request.getName();
//        String message = "Hello " + name;
//        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
//        responseObserver.onCompleted();
//    }
//}
