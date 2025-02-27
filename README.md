# CeilR Java SDK

🚀 **CeilR SDK** is a Java library for feature access management, usage tracking, and entitlement fetching.

## 📦 Installation

### **Using Maven**
Add this to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.GouniManikumar12</groupId>
    <artifactId>ceilr-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### **Using Gradle**
Add this to your `build.gradle`:

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.GouniManikumar12:ceilr-java-sdk:1.0.0'
}
```

## 🛠️ Setup

Initialize the SDK:

```java
CeilR ceilr = new CeilR("your-api-key", "customer-id");
```

## 🚀 Features

### ✅ **Check Feature Access**
```java
boolean hasAccess = ceilr.checkFeature("premium_feature");
System.out.println("Feature Access: " + hasAccess);
```

### 📊 **Track Usage**
```java
ceilr.trackUsage("api_calls", 1);
```

### 🔑 **Get User Entitlements**
```java
String[] entitlements = ceilr.getUserEntitlements();
System.out.println("User Entitlements: " + String.join(", ", entitlements));
```

## 📡 Offline Support
- Requests are **queued when offline** and retried when the device is back online.

## 🔄 Updating the SDK
To update to the latest version:

```sh
mvn clean install
```

## 🛠️ Running Tests
To verify SDK functionality, create a test file (`TestCeilR.java`) and add:

```java
import com.ceilr.CeilR;

public class TestCeilR {
    public static void main(String[] args) {
        try {
            CeilR ceilr = new CeilR("your-api-key", "your-customer-id");
            boolean hasAccess = ceilr.checkFeature("premium_feature");
            System.out.println("Feature Access: " + hasAccess);
            ceilr.trackUsage("api_calls", 5);
            System.out.println("Usage tracked successfully!");
            String[] entitlements = ceilr.getUserEntitlements();
            System.out.println("User Entitlements: " + String.join(", ", entitlements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Compile and run:

```sh
mvn compile
mvn exec:java -Dexec.mainClass="TestCeilR"
```

## 🤝 Contributing
1. Fork the repo
2. Create a feature branch (`git checkout -b feature-name`)
3. Commit changes (`git commit -m "Add new feature"`)
4. Push to GitHub (`git push origin feature-name`)
5. Open a Pull Request 🚀

## 📜 License
This project is licensed under the **MIT License**.

## 📞 Support
For any issues or questions, reach out via:
- **GitHub Issues**: [https://github.com/GouniManikumar12/ceilr-java-sdk/issues](https://github.com/GouniManikumar12/ceilr-java-sdk/issues)
- **Email**: support@ceilr.com