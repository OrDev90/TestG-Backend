package tests_generators.utils.JSON;

import application.entities.InputField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import tests_generators.output.objects.OutputField;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSON_Handler {

    private static JSON_Handler JSON_Handler = null;
    private final Gson gson;

    private JSON_Handler() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        this.gson = gsonBuilder.create();
    }

    public static JSON_Handler getInstance() {
        if (JSON_Handler == null) {
            JSON_Handler = new JSON_Handler();
        }
        return JSON_Handler;
    }

    public InputField convertJSONToObject(String body) {
        return this.gson.fromJson(body, InputField.class);
    }

    public String convertObjectToJSON(OutputField outputField) {
        return this.gson.toJson(outputField);
    }

    public HttpResponse<String> get(String url) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public org.apache.http.HttpResponse post(String url, String json) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            StringEntity postingString = new StringEntity(json);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            return httpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }

    public org.apache.http.HttpResponse put(String url) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut put = new HttpPut(url);
            return httpClient.execute(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
