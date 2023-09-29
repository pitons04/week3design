package api;

import okhttp3.*;
import org.json.JSONObject;
//should I move this to SongOrganizer.java ?
public class SpotifyDB {
    private static final String API_URL = "https://api.spotify.com/v1";
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public String createPlaylist(String userid) {
        //creates a playlist under this userid
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("A PlayList", false); // false means it's a private playlist.
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(String.format("https://api.spotify.com/v1/users/:%/playlists", userid))
                .method("POST", body)
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        return null;
    }
}
