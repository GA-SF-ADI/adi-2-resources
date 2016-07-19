package com.example.hollis.gson_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    public static final String SPOTIFY_JSON = "{\n" +
            "  \"artists\" : [ {\n" +
            "    \"external_urls\" : {\n" +
            "      \"spotify\" : \"https://open.spotify.com/artist/2CIMQHirSU0MQqyYHq0eOx\"\n" +
            "    },\n" +
            "    \"followers\" : {\n" +
            "      \"href\" : null,\n" +
            "      \"total\" : 1458036\n" +
            "    },\n" +
            "    \"genres\" : [ \"edm\", \"electro house\", \"house\", \"progressive house\" ],\n" +
            "    \"href\" : \"https://api.spotify.com/v1/artists/2CIMQHirSU0MQqyYHq0eOx\",\n" +
            "    \"id\" : \"2CIMQHirSU0MQqyYHq0eOx\",\n" +
            "    \"images\" : [ {\n" +
            "      \"height\" : 591,\n" +
            "      \"url\" : \"https://i.scdn.co/image/3e671ea42708d84694e05a2d2b9346a8e107ebcc\",\n" +
            "      \"width\" : 999\n" +
            "    }, {\n" +
            "      \"height\" : 378,\n" +
            "      \"url\" : \"https://i.scdn.co/image/0daee8c3012757223dfc03f3a9bf7b5dbb66293b\",\n" +
            "      \"width\" : 639\n" +
            "    }, {\n" +
            "      \"height\" : 118,\n" +
            "      \"url\" : \"https://i.scdn.co/image/4942d0bdad167cc744167a290896f7f968d9cf74\",\n" +
            "      \"width\" : 200\n" +
            "    }, {\n" +
            "      \"height\" : 38,\n" +
            "      \"url\" : \"https://i.scdn.co/image/8a65b7fecbe8ee6b3eb644f0bd5e3f86ba9f06cb\",\n" +
            "      \"width\" : 64\n" +
            "    } ],\n" +
            "    \"name\" : \"deadmau5\",\n" +
            "    \"popularity\" : 68,\n" +
            "    \"type\" : \"artist\",\n" +
            "    \"uri\" : \"spotify:artist:2CIMQHirSU0MQqyYHq0eOx\"\n" +
            "  }, {\n" +
            "    \"external_urls\" : {\n" +
            "      \"spotify\" : \"https://open.spotify.com/artist/57dN52uHvrHOxijzpIgu3E\"\n" +
            "    },\n" +
            "    \"followers\" : {\n" +
            "      \"href\" : null,\n" +
            "      \"total\" : 305748\n" +
            "    },\n" +
            "    \"genres\" : [ ],\n" +
            "    \"href\" : \"https://api.spotify.com/v1/artists/57dN52uHvrHOxijzpIgu3E\",\n" +
            "    \"id\" : \"57dN52uHvrHOxijzpIgu3E\",\n" +
            "    \"images\" : [ {\n" +
            "      \"height\" : 693,\n" +
            "      \"url\" : \"https://i.scdn.co/image/2f0c6c465a83cd196e651e3d4e7625ba799a6f60\",\n" +
            "      \"width\" : 1000\n" +
            "    }, {\n" +
            "      \"height\" : 444,\n" +
            "      \"url\" : \"https://i.scdn.co/image/4e3e13c8b993bde9898e49509fb9ae121636e05f\",\n" +
            "      \"width\" : 640\n" +
            "    }, {\n" +
            "      \"height\" : 139,\n" +
            "      \"url\" : \"https://i.scdn.co/image/dc68dd24b45b74ecce9d4ed486423673d683ced3\",\n" +
            "      \"width\" : 200\n" +
            "    }, {\n" +
            "      \"height\" : 44,\n" +
            "      \"url\" : \"https://i.scdn.co/image/4e55ca05d4f336a2fa0e3062a7ec9778a201e8bc\",\n" +
            "      \"width\" : 63\n" +
            "    } ],\n" +
            "    \"name\" : \"Ratatat\",\n" +
            "    \"popularity\" : 67,\n" +
            "    \"type\" : \"artist\",\n" +
            "    \"uri\" : \"spotify:artist:57dN52uHvrHOxijzpIgu3E\"\n" +
            "  }, {\n" +
            "    \"external_urls\" : {\n" +
            "      \"spotify\" : \"https://open.spotify.com/artist/1vCWHaC5f2uS3yhpwWbIA6\"\n" +
            "    },\n" +
            "    \"followers\" : {\n" +
            "      \"href\" : null,\n" +
            "      \"total\" : 4934160\n" +
            "    },\n" +
            "    \"genres\" : [ \"big room\", \"edm\", \"electro house\", \"house\", \"progressive electro house\" ],\n" +
            "    \"href\" : \"https://api.spotify.com/v1/artists/1vCWHaC5f2uS3yhpwWbIA6\",\n" +
            "    \"id\" : \"1vCWHaC5f2uS3yhpwWbIA6\",\n" +
            "    \"images\" : [ {\n" +
            "      \"height\" : 667,\n" +
            "      \"url\" : \"https://i.scdn.co/image/169c6b331c258259999e20c6a5f2056470759ba9\",\n" +
            "      \"width\" : 1000\n" +
            "    }, {\n" +
            "      \"height\" : 427,\n" +
            "      \"url\" : \"https://i.scdn.co/image/3d1ca7f8d9faa341f7662b9e1ef39d6a739a7e8d\",\n" +
            "      \"width\" : 640\n" +
            "    }, {\n" +
            "      \"height\" : 133,\n" +
            "      \"url\" : \"https://i.scdn.co/image/4efe383b43e0c5a00eb59877cc8919a342863c9d\",\n" +
            "      \"width\" : 199\n" +
            "    }, {\n" +
            "      \"height\" : 43,\n" +
            "      \"url\" : \"https://i.scdn.co/image/e7d9e02ce4c00aabd29074b938ef0d7da3f5b4ef\",\n" +
            "      \"width\" : 64\n" +
            "    } ],\n" +
            "    \"name\" : \"Avicii\",\n" +
            "    \"popularity\" : 82,\n" +
            "    \"type\" : \"artist\",\n" +
            "    \"uri\" : \"spotify:artist:1vCWHaC5f2uS3yhpwWbIA6\"\n" +
            "  } ]\n" +
            "}";
    public static final String WEATHER_JSON = "{\"query\":{\"count\":1,\"created\":\"2016-07-18T19:09:28Z\",\"lang\":\"en-US\",\"results\":{\"channel\":{\"units\":{\"distance\":\"mi\",\"pressure\":\"in\",\"speed\":\"mph\",\"temperature\":\"F\"},\"title\":\"Yahoo! Weather - Nome, AK, US\",\"link\":\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\",\"description\":\"Yahoo! Weather for Nome, AK, US\",\"language\":\"en-us\",\"lastBuildDate\":\"Mon, 18 Jul 2016 11:09 AM AKDT\",\"ttl\":\"60\",\"location\":{\"city\":\"Nome\",\"country\":\"United States\",\"region\":\" AK\"},\"wind\":{\"chill\":\"46\",\"direction\":\"270\",\"speed\":\"11\"},\"atmosphere\":{\"humidity\":\"100\",\"pressure\":\"1017.0\",\"rising\":\"0\",\"visibility\":\"4.3\"},\"astronomy\":{\"sunrise\":\"0:52 am\",\"sunset\":\"5:22 am\"},\"image\":{\"title\":\"Yahoo! Weather\",\"width\":\"142\",\"height\":\"18\",\"link\":\"http://weather.yahoo.com\",\"url\":\"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif\"},\"item\":{\"title\":\"Conditions for Nome, AK, US at 10:00 AM AKDT\",\"lat\":\"64.499474\",\"long\":\"-165.405792\",\"link\":\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\",\"pubDate\":\"Mon, 18 Jul 2016 10:00 AM AKDT\",\"condition\":{\"code\":\"12\",\"date\":\"Mon, 18 Jul 2016 10:00 AM AKDT\",\"temp\":\"50\",\"text\":\"Rain\"},\"forecast\":[{\"code\":\"11\",\"date\":\"18 Jul 2016\",\"day\":\"Mon\",\"high\":\"55\",\"low\":\"49\",\"text\":\"Showers\"},{\"code\":\"12\",\"date\":\"19 Jul 2016\",\"day\":\"Tue\",\"high\":\"53\",\"low\":\"50\",\"text\":\"Rain\"},{\"code\":\"11\",\"date\":\"20 Jul 2016\",\"day\":\"Wed\",\"high\":\"54\",\"low\":\"50\",\"text\":\"Showers\"},{\"code\":\"11\",\"date\":\"21 Jul 2016\",\"day\":\"Thu\",\"high\":\"54\",\"low\":\"49\",\"text\":\"Showers\"},{\"code\":\"34\",\"date\":\"22 Jul 2016\",\"day\":\"Fri\",\"high\":\"62\",\"low\":\"51\",\"text\":\"Mostly Sunny\"},{\"code\":\"28\",\"date\":\"23 Jul 2016\",\"day\":\"Sat\",\"high\":\"55\",\"low\":\"48\",\"text\":\"Mostly Cloudy\"},{\"code\":\"39\",\"date\":\"24 Jul 2016\",\"day\":\"Sun\",\"high\":\"54\",\"low\":\"52\",\"text\":\"Scattered Showers\"},{\"code\":\"26\",\"date\":\"25 Jul 2016\",\"day\":\"Mon\",\"high\":\"54\",\"low\":\"52\",\"text\":\"Cloudy\"},{\"code\":\"26\",\"date\":\"26 Jul 2016\",\"day\":\"Tue\",\"high\":\"54\",\"low\":\"48\",\"text\":\"Cloudy\"},{\"code\":\"12\",\"date\":\"27 Jul 2016\",\"day\":\"Wed\",\"high\":\"53\",\"low\":\"45\",\"text\":\"Rain\"}],\"description\":\"<![CDATA[<img src=\\\"http://l.yimg.com/a/i/us/we/52/12.gif\\\"/>\\n<BR />\\n<b>Current Conditions:</b>\\n<BR />Rain\\n<BR />\\n<BR />\\n<b>Forecast:</b>\\n<BR /> Mon - Showers. High: 55Low: 49\\n<BR /> Tue - Rain. High: 53Low: 50\\n<BR /> Wed - Showers. High: 54Low: 50\\n<BR /> Thu - Showers. High: 54Low: 49\\n<BR /> Fri - Mostly Sunny. High: 62Low: 51\\n<BR />\\n<BR />\\n<a href=\\\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\\\">Full Forecast at Yahoo! Weather</a>\\n<BR />\\n<BR />\\n(provided by <a href=\\\"http://www.weather.com\\\" >The Weather Channel</a>)\\n<BR />\\n]]>\",\"guid\":{\"isPermaLink\":\"false\"}}}}}}";


    //TODO: Create a WeatherObject that mirrors the weather JSON String
    public  MarvelResult marvelResult;
    //TODO: Create a String that mirrors the marvelResult object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createMarvelResult();

        Gson gson = new Gson();
        final Weather weather = gson.fromJson(WEATHER_JSON, Weather.class);
        weather.getQuery().getResults().getChannel().getAstronomy().getSunrise();
        Log.d("MainActivity", "onCreate: info" + weather.getQuery().getResults().getChannel().getAstronomy().getSunrise());
    }

    public void createMarvelResult(){
        MarvelCharacter cyclops = new MarvelCharacter("Cyclops", 32, "laser vision");
        MarvelCharacter thor = new MarvelCharacter("Thor", 1243, "is a Norse God");
        MarvelCharacter wolverine = new MarvelCharacter("Wolverine", 120, "regeneration");
        MarvelTeam xmen = new MarvelTeam("X-men", "Xavier's School For Gifted Children", new MarvelCharacter[]{cyclops, wolverine});
        MarvelTeam avengers = new MarvelTeam("Avengers", "Avengers Mansion", new MarvelCharacter[]{thor, wolverine});
        marvelResult = new MarvelResult(new MarvelTeam[]{xmen, avengers});

    }
}
