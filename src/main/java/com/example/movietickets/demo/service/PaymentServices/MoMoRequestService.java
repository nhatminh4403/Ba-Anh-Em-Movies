package com.example.movietickets.demo.service.PaymentServices;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class MoMoRequestService {
    public static String accessKey = "F8BBA842ECF85";
    public static String secretKey = "K951B6PE1waDMi640xX08PD3vg6EkVlz";
    public static String partnerCode = "MOMO";
    public static String redirectUrl = "https://ea88-2405-4803-c7a5-2c60-1400-3cc5-db6b-3c13.ngrok-free.app/purchase/history";
    public static String ipnUrl = "https://ea88-2405-4803-c7a5-2c60-1400-3cc5-db6b-3c13.ngrok-free.app/purchase/history";
    public static String orderInfo = "paywithmethod";
    public static String requestType = "captureWallet";
    public static String orderId = String.valueOf(System.currentTimeMillis()); // Mã đơn hàng
    public static String requestId = String.valueOf(System.currentTimeMillis());
    public static String LANGUAGE = "vi";
    public static String Extra_Data = "";
    public static Boolean Auto_Capture = true;
    public static String Endpoint = "https://test-payment.momo.vn/v2/gateway/api/create/";

    public static String HmacSHA256(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);  // Sử dụng Hex thay vì Base64 nếu MoMo yêu cầu
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String sendToHTTPPost(String url, String jsonBody) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(jsonBody));
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            }
        }
    }
}
