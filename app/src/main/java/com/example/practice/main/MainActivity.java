package com.example.practice.main;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

import org.tensorflow.lite.Interpreter;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client;
    private static final String TAG = "WebSocket";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // شروع اتصال WebSocket
        client = new OkHttpClient();
        Request request = new Request.Builder().url("ws://echo.websocket.org").build();
        WebSocketEcho webSocketEcho = new WebSocketEcho();
        WebSocket webSocket = client.newWebSocket(request, webSocketEcho);

        Log.d(TAG, "WebSocket connection initiated");
    }

    public class WebSocketEcho extends WebSocketListener {
        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            Log.d(TAG, "Received message: " + text);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
            Log.e(TAG, "Connection failed", t);
            if (response != null) {
                Log.e(TAG, "Response: " + response.toString());
            }
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            Log.d(TAG, "WebSocket opened, sending messages...");
            webSocket.send("Android");
            webSocket.send("Service connection");
            webSocket.close(1000, "Closing connection");
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
            Log.d(TAG, "WebSocket closed: " + reason + " (Code: " + code + ")");
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
            Log.d(TAG, "WebSocket is closing: " + reason + " (Code: " + code + ")");
        }
    }
}
