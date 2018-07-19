package com.github.czyzby;


import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.WebSocketFrame;

public class ServerLauncher {
//    static Handler<ServerWebSocket> webSocket=new Handler<ServerWebSocket>() {
//        @Override
//        public void handle(ServerWebSocket serverWebSocket) {
//            serverWebSocket.frameHandler(new Handler<WebSocketFrame>() {
//                @Override
//                public void handle(WebSocketFrame frame) {
//                    System.out.println("Received packet: " + frame.textData());
//                }
//            });
//            serverWebSocket.close();
//
//
//        }
//    };
    //Note that server web socket implementation is not provided by gdx-websocket. This class uses an external library: Vert.x.
    public static void main(final String... args) throws Exception {
        System.out.println("Launching web socket server...");
        final Vertx vertx = Vertx.vertx();
        final HttpServer server = vertx.createHttpServer();
        server.websocketHandler(webSocket -> {
            // Printing received packets to console:
            webSocket.frameHandler(frame ->
                    System.out.println("Received packet: " + frame.textData())

            );

            webSocket.closeHandler(v -> {
                System.out.println("connection closed");
            });
            // Sending a simple message:
            webSocket.writeFinalTextFrame("Hello from server!");
            // Closing the socket in 5 seconds:
            vertx.setTimer(5000L, id -> webSocket.close());
        }).listen(8000);

    }
}
