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
        Request request = new Request.Builder().url(String.format("https://api.spotify.com/v1/users/:%s/playlists", userid))
                .addHeader("Authorization", API_TOKEN)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONObject playlist = responseBody.getJSONObject("playlist");
                return playlist.getString("playlist");
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
