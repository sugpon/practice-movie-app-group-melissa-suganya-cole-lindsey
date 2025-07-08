package com.example.practice_movie_app_group_melissa_suganya_cole_lindsey.Model;

public class Movie {
    private String title;
    private String description;
    private int rating;

    public Movie() {
    }

    public Movie(String title, String description, int rating) {
        this.title = title;
        this.description = generateDescription(this.name);
        this.rating = rating;
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

    public String generateDescription(String name) throws HttpException, IOException {
        Client client = new Client();
        String query = "Write a description for the movie" + this.name;
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);

        return response.text();
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
                "<strong>Rating:</strong> " + rating+ "<br />";
    }
}
