package com.ceilr;

import com.ceilr.utils.HttpClient;
import com.ceilr.exceptions.CeilRException;
import org.json.JSONObject;
import java.io.IOException;

public class CeilR {
    private static final String BASE_URL = "https://api.ceilr.com";
    private String apiKey;
    private String customerId;
    private HttpClient httpClient;

    public CeilR(String apiKey, String customerId) {
        this.apiKey = apiKey;
        this.customerId = customerId;
        this.httpClient = new HttpClient();
    }

    public boolean checkFeature(String featureName) throws CeilRException {
        try {
            JSONObject payload = new JSONObject();
            payload.put("apiKey", apiKey);
            payload.put("customerId", customerId);
            payload.put("featureName", featureName);

            String response = httpClient.post(BASE_URL + "/check-feature", payload.toString());
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.optBoolean("allowed", false);
        } catch (Exception e) {
            throw new CeilRException("Failed to check feature", e);
        }
    }

    public void trackUsage(String featureName, int count) throws CeilRException {
        try {
            JSONObject payload = new JSONObject();
            payload.put("apiKey", apiKey);
            payload.put("customerId", customerId);
            payload.put("featureName", featureName);
            payload.put("count", count);

            httpClient.post(BASE_URL + "/track-usage", payload.toString());
        } catch (Exception e) {
            throw new CeilRException("Failed to track usage", e);
        }
    }

    public String[] getUserEntitlements() throws CeilRException {
        try {
            String response = httpClient.get(BASE_URL + "/user-entitlements", apiKey);
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.optJSONArray("entitlements").toList().toArray(new String[0]);
        } catch (Exception e) {
            throw new CeilRException("Failed to fetch entitlements", e);
        }
    }
}
