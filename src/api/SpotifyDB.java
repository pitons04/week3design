package api;

import okhttp3.*;
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
        Request request = new Request.Builder().url(String.format("https://api.spotify.com/v1/users/:%/playlists", userid))
                .addHeader("Authorization", API_TOKEN)
                .build();
        return null;
    }
}
