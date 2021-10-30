package com.monicals.monicalspizza;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


    public class JsonUtil {
        private static final JsonParser PARSER = new JsonParser();
        private static final String resister ="https://marketing.foodtecsolutions.com/api/users/register";
        private static final String signIn ="https://marketing.foodtecsolutions.com/api/oauth/introspect";

        private static final String token ="https://marketing.foodtecsolutions.com/api/oauth/token";





        public static String Session_key="";
        private static final Gson gson = new Gson();

   /* public static JsonArray request(String content) throws IOException {
        return request(objectFromString(content));
    }
    public static JsonArray request1(String content) throws IOException {
        return request1(objectFromString(content));
    }*/

        public static JsonObject requestSignUP(JsonObject post) throws IOException {
            URL url = new URL(resister);
            String content = post.toString();
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic RFNEYXZpc0Btb25pY2Fscy5jb206ZW9VcmE4dm9Za05lbjIxOGg1ZHI=");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(contentBytes, 0, contentBytes.length);
            os.close();
            Log.e("codeeeee", String.valueOf(connection.getResponseCode()));

            BufferedReader rs = (connection.getResponseCode() == 400) ?
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                    new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder extracted = new StringBuilder();
            String line = rs.readLine();
            while(line != null) {
                extracted.append(line);
                line = rs.readLine();
            }
            rs.close();
            connection.disconnect();
            return objectFromString(extracted.toString());
        }

        public static JsonArray requestSignIn(JsonObject post) throws IOException {
            URL url = new URL(signIn);
            String content = post.toString();
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic RFNEYXZpc0Btb25pY2Fscy5jb206ZW9VcmE4dm9Za05lbjIxOGg1ZHI=");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(contentBytes, 0, contentBytes.length);
            os.close();
            Log.e("codeeeee", String.valueOf(connection.getResponseCode()));

            BufferedReader rs = (connection.getResponseCode() == 200) ?
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                    new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder extracted = new StringBuilder();
            String line = rs.readLine();
            while(line != null) {
                extracted.append(line);
                line = rs.readLine();
            }
            rs.close();
            connection.disconnect();
            return arrayFromString(extracted.toString());
        }

        public static JsonObject requestToken(JsonObject post) throws IOException {
            URL url = new URL(token);
            String content = post.toString();
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic RFNEYXZpc0Btb25pY2Fscy5jb206ZW9VcmE4dm9Za05lbjIxOGg1ZHI=");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(contentBytes, 0, contentBytes.length);
            os.close();
            Log.e("codeeeee", String.valueOf(connection.getResponseCode()));

            BufferedReader rs = (connection.getResponseCode() == 400) ?
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                    new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder extracted = new StringBuilder();
            String line = rs.readLine();
            while(line != null) {
                extracted.append(line);
                line = rs.readLine();
            }
            rs.close();
            connection.disconnect();
            return objectFromString(extracted.toString());
        }


        public static JsonObject request2(JsonObject post) throws IOException {
            URL url = new URL(resister);
            String content = post.toString();
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(contentBytes.length));

            OutputStream os = connection.getOutputStream();
            os.write(contentBytes, 0, contentBytes.length);
            os.close();
            Log.e("codeeeee", String.valueOf(connection.getResponseCode()));

            BufferedReader rs = (connection.getResponseCode() == 200) ?
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                    new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder extracted = new StringBuilder();
            String line = rs.readLine();
            while(line != null) {
                extracted.append(line);
                line = rs.readLine();
            }
            rs.close();
            connection.disconnect();
            return objectFromString(extracted.toString());
        }


        public static JsonArray request(JsonObject post) throws IOException {
            URL url = new URL(resister);
            String content = post.toString();
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("DSDavis@monicals.com", "Basic RFNEYXZpc0Btb25pY2Fscy5jb206ZW9VcmE4dm9Za05lbjIxOGg1ZHI=");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(contentBytes.length));

            OutputStream os = connection.getOutputStream();
            os.write(contentBytes, 0, contentBytes.length);
            os.close();

            Log.e("codeeeee", String.valueOf(connection.getResponseCode()));

            BufferedReader rs = (connection.getResponseCode() == 400) ?
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                    new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder extracted = new StringBuilder();
            String line = rs.readLine();
            while(line != null) {
                extracted.append(line);
                line = rs.readLine();
            }
            rs.close();
            connection.disconnect();
            return arrayFromString(extracted.toString());
        }


        /* public static BufferedImage[] getImagesFromJson(JsonArray json) {
             BufferedImage[] bufferedImages = new BufferedImage[json.size()];
             for (int i = 0; i < json.size(); i++) {
                 try {
                     JsonObject jsonObject = JsonUtil.objectFromString(json.get(i).toString());
                     byte[] data = JsonUtil.gson().fromJson(jsonObject.get("image").toString().replace("\"", ""), byte[].class);
                     InputStream inputStream = new ByteArrayInputStream(data);
                     BufferedImage bufferedImage = ImageIO.read(inputStream);
                     bufferedImages[i] = bufferedImage;
                 }catch(Exception ignored) {
                     // maybe handle error appropriately
                 }
             }
             return bufferedImages;
         }
     */
        public static JsonObject objectFromString(String jsonString) {
            JsonObject jsonObject = new JsonObject();
            if ((jsonString != null) && !(jsonString.isEmpty())) {
                jsonObject = (JsonObject) PARSER.parse(jsonString.replaceAll("\\s"," "));
            }
            return jsonObject;
        }

        public static JsonArray arrayFromString(String jsonString) {
            JsonArray jsonArray = new JsonArray();
            if ((jsonString != null) && !(jsonString.isEmpty())) {
                jsonArray = PARSER.parse(jsonString.replaceAll("\\s"," ")).getAsJsonArray();
            }
            return jsonArray;
        }

        public static Gson gson() {
            return gson;
        }
    }