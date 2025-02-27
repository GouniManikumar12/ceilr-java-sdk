package main.java.com.ceilr.utils;

import okhttp3.*;

import java.io.IOException;

public class HttpClient {
    private final OkHttpClient client;

    public HttpClient() {
        this.client = new OkHttpClient();
    }

    public String post(String url, String jsonPayload) throws IOException {
        RequestBody body = RequestBody.create(jsonPayload, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String get(String url, String apiKey) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
