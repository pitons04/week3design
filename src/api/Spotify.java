package api;


import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class Spotify {

    private static final String API_URL = "https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("BQDgaXcTo1SaOmwO54LEtT4gtZzdc6V8k6RBVXmLUmDEq1lR6Ar3pqgXobsk_5P9KTwLNzqdEGvmfWyTpC8x6Bh5jT072-fn7sSdZcwtFBmrW44CpMaPtf-ZiUQ16HINAHydFh53ktHMuoQjohR-cRUaosHFduodV4JdgV81_vgeNG_5yaQ2KT3Y0runW-8br2bI7QhWbdCAvyhbAKllXTi1-oCeZdW5w6TOGfMZisqxyjyoYU5g59dN1Utwz5wkmw");

    public static String getApiToken() {
        return API_TOKEN;
    }


    public String getData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format(API_URL))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                return responseBody.toString();
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}

/*
Intended output:

        {
        "href": "https://api.spotify.com/v1/me/shows?offset=0&limit=20",
        "limit": 20,
        "next": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
        "offset": 0,
        "previous": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
        "total": 4,
        "items": [
        {
        "album_type": "compilation",
        "total_tracks": 9,
        "available_markets": ["CA", "BR", "IT"],
        "external_urls": {
        "spotify": "string"
        },
        "href": "string",
        "id": "2up3OPMp9Tb4dAKM2erWXQ",
        "images": [
        {
        "url": "https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228",
        "height": 300,
        "width": 300
        }
        ],
        "name": "string",
        "release_date": "1981-12",
        "release_date_precision": "year",
        "restrictions": {
        "reason": "market"
        },
        "type": "album",
        "uri": "spotify:album:2up3OPMp9Tb4dAKM2erWXQ",
        "artists": [
        {
        "external_urls": {
        "spotify": "string"
        },
        "href": "string",
        "id": "string",
        "name": "string",
        "type": "artist",
        "uri": "string"
        }
        ],
        "album_group": "compilation"
        }
        ]
        }

*/
