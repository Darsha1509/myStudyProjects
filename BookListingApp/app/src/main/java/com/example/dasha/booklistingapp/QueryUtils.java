package com.example.dasha.booklistingapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Dasha on 13.09.2017.
 */

public class QueryUtils {

    private static final String OPENLIBRARY_REQUEST_URL=
            "http://openlibrary.org/search.json?q=";

    public static final String LOG_TAG= QueryUtils.class.getSimpleName();

    public QueryUtils() {
    }

    private static String userRequest(){
        StringBuilder request = new StringBuilder();
        String[] arrayRequest;
        if(BookActivity.keyWords.contains(" ")){
            arrayRequest = BookActivity.keyWords.split(" ");
            for(String s: arrayRequest){
                request.append(s+"+");
                if(s.equals(arrayRequest[arrayRequest.length-1])){
                    request.deleteCharAt(request.length()-1);
                }
            }
        } else {
            request.append(BookActivity.keyWords);
        }
        return request.toString();
    }

    private static URL createUrl(){
        URL url = null;
        String stringUrl = OPENLIBRARY_REQUEST_URL;
        stringUrl += userRequest();
        stringUrl += "&limit=10";
        try{
            url = new URL(stringUrl);
        }catch (MalformedURLException exception){
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Log.e(LOG_TAG, "makeHttpRequest");
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error: response code is " + urlConnection.getResponseCode());
            }
        } catch (IOException e){
            Log.e(LOG_TAG, "IOException get thrown");
        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (inputStream != null){
                inputStream.close();
            }
        }
        return  jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line !=null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static ArrayList<Book> extractBooksFromJson(String jsonResponse){
        ArrayList<Book> books = new ArrayList<Book>();

        try{
            JSONObject rootObject = new JSONObject(jsonResponse);
            JSONArray booksArray = rootObject.getJSONArray("docs");

            for (int i = 0; i < booksArray.length(); i++){
                JSONObject jsonBook = booksArray.getJSONObject(i);
                String title = jsonBook.getString("title_suggest");
                JSONArray authors = jsonBook.getJSONArray("author_name");
                String bookAuthor = "";
                for (int j=0; j < authors.length(); j++){
                   bookAuthor = bookAuthor + authors.getString(j) + " ";
                }
                Book book = null;
                if(jsonBook.has("cover_edition_key")){
                    String imageKey = jsonBook.getString("cover_edition_key");
                    book = new Book(title, bookAuthor, imageKey);
                } else {
                    book = new Book(title, bookAuthor);
                }

                books.add(book);
            }

        }catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the books JSON result", e);
        }
        return books;
    }

    public static ArrayList<Book> getBooks(){
        URL bookUrl = createUrl();
        String jsonResponse = "";
        try{
            jsonResponse = makeHttpRequest(bookUrl);
        } catch (IOException e){
            Log.e(LOG_TAG, "IOException in makeHttpRequest");
        }

        return extractBooksFromJson(jsonResponse);
    }
}
