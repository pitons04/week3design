package api;

import okhttp3.*;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

//should I move this to SongOrganizer.java ?
public class SpotifyDB {
    private static final String API_URL = "https://api.spotify.com/v1";
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public String createPlaylist(String userid) {
        //creates a playlist under this userid
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("A PlayList", false); // false means it's a private playlist.
        RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        Request request = new Request.Builder()
                .url(String.format("https://api.spotify.com/v1/users/:%s/playlists", userid))
                .method("POST", body)
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONObject playlist = responseBody.getJSONObject("name");
                return playlist.getString("name");
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
