package com.example.practice_movie_app_group_melissa_suganya_cole_lindsey.Model;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;

import java.io.IOException;

public class Movie {
    private String title;
    private String description;
    private int rating;
    private String IMDBRating;

    public String getIMDBRating() {
        return IMDBRating;
    }

    public void setIMDBRating(String IMDBRating) {
        this.IMDBRating = IMDBRating;
    }



    public Movie() {
    }

    public Movie(String title, int rating) {
        this.title = title;
        try {
            this.description = generateDescription(this.title);
        } catch (HttpException | IOException e) {
            throw new RuntimeException("Failed to generate description", e);
        }
        this.rating = rating;

        try {
            this.IMDBRating = generateIMDBRating(this.title);
        } catch (HttpException | IOException e) {
            throw new RuntimeException("Failed to generate IMDB Rating", e);
        }

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String generateDescription(String title) throws HttpException, IOException, HttpException, IOException {
        Client client = new Client();
        String query = "Write a description for the movie" + this.title;
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);

        return response.text();
    }

    public String generateIMDBRating(String title) throws HttpException, IOException, HttpException, IOException {
        Client client = new Client();
        String IMDBRating = "Please retrieve the IMDB rating for the movie "+ title;

        GenerateContentResponse IMDBResponse = client.models.generateContent("gemini-2.0-flash-001", IMDBRating, null);

        return IMDBResponse.text();
    }



    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "<strong>Title:</strong> " + title + "<br />" +
                "<strong>Description:</strong> " + description + "<br />" +
                "<strong> Your Rating:</strong> " + rating+ "<strong> IMDB Rating:</strong>" + IMDBRating +"<br />" ;

    }
}
