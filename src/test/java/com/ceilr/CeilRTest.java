package test.java.com.ceilr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CeilRTest {
    private final CeilR ceilr = new CeilR("test-api-key", "test-customer-id");

    @Test
    public void testCheckFeature() {
        assertDoesNotThrow(() -> {
            boolean result = ceilr.checkFeature("premium_feature");
            System.out.println("Feature Access: " + result);
        });
    }

    @Test
    public void testTrackUsage() {
        assertDoesNotThrow(() -> ceilr.trackUsage("api_calls", 5));
    }

    @Test
    public void testGetUserEntitlements() {
        assertDoesNotThrow(() -> {
            String[] entitlements = ceilr.getUserEntitlements();
            System.out.println("User Entitlements: " + String.join(", ", entitlements));
        });
    }
}
