package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.WebSocketAdapter;
import com.github.czyzby.websocket.WebSockets;
import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.github.czyzby.websocket.net.ExtendedNet;

/**
 * Created by x002 on 2018/7/2.
 */

public class WebSocketUtils implements Disposable {
    private WebSocket socket;
    public WebSocketUtils(){
        socket = ExtendedNet.getNet().newWebSocket("localhost", 8000);
        socket.addListener(getListener());
        socket.connect();
    }

    private static WebSocketAdapter getListener() {
        return new WebSocketAdapter() {
            @Override
            public boolean onOpen(final WebSocket webSocket) {
                Gdx.app.log("WS", "Connected!");
                webSocket.send("Hello from client!");
                return FULLY_HANDLED;
            }

            @Override
            public boolean onClose(final WebSocket webSocket, final WebSocketCloseCode code, final String reason) {
                Gdx.app.log("WS", "Disconnected - status: " + code + ", reason: " + reason);
                return FULLY_HANDLED;
            }

            @Override
            public boolean onMessage(final WebSocket webSocket, final String packet) {
                Gdx.app.log("WS", "Got message: " + packet);
                return FULLY_HANDLED;
            }
        };
    }

    @Override
    public void dispose() {
        WebSockets.closeGracefully(socket); // Null-safe closing method that catches and logs any exceptions.

    }
}
