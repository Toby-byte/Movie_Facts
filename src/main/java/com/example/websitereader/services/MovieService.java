package com.example.websitereader.services;

import com.example.websitereader.models.Movie;

import java.io.File;
import java.util.*;

import static java.lang.Math.random;

public class MovieService {

    String getMovieStuff() {
        File movieFile = new File("src/main/java/com/example/websitereader/imdb-data.csv");
        String firstMovie = "";
        try {
            Scanner databaseScanner = new Scanner(movieFile);
            int count = 0;

            while (databaseScanner.hasNextLine()) {
                String data = databaseScanner.nextLine();

                String[] stringsInArray = data.split(";");

                // husk at converter til Int senere hvis du skal bruge dem til beregning af noget

                String year = stringsInArray[0];
                String length = stringsInArray[1];
                String title = stringsInArray[2];
                String subject = stringsInArray[3];
                String popularity = stringsInArray[4];
                String awards = stringsInArray[5];
                count++;

                if (count == 2) {
                    firstMovie = title;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstMovie;
    }

    Movie RandomMovie() {
        File movieFile = new File("src/main/java/com/example/websitereader/imdb-data.csv");
        Random random = new Random();
        int randomNumber = random.nextInt(1584)+1;
        Movie RandomMovie = null;

        try {
            Scanner databaseScanner = new Scanner(movieFile);
            int count = 0;

            while (databaseScanner.hasNextLine()) {
                String data = databaseScanner.nextLine();

                String[] stringsInArray = data.split(";");

                // husk at converter til Int senere hvis du skal bruge dem til beregning af noget

                String year = stringsInArray[0];
                String length = stringsInArray[1];
                String title = stringsInArray[2];
                String subject = stringsInArray[3];
                int popularity = Integer.parseInt(stringsInArray[4]);
                String awards = stringsInArray[5];
                count++;

                Movie movie = new Movie(year,length,title,subject,popularity,awards);

                if (count == randomNumber) {
                    RandomMovie = movie;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return RandomMovie;
    }

    String allMovies() {
        File movieFile = new File("src/main/java/com/example/websitereader/imdb-data.csv");
        String firstMovie = "";
        try {
            Scanner databaseScanner = new Scanner(movieFile);
            int count = 0;

            while (databaseScanner.hasNextLine()) {
                String data = databaseScanner.nextLine();

                String[] stringsInArray = data.split(";");

                // husk at converter til Int senere hvis du skal bruge dem til beregning af noget

                String year = stringsInArray[0];
                String length = stringsInArray[1];
                String title = stringsInArray[2];
                String subject = stringsInArray[3];
                String popularity = stringsInArray[4];
                String awards = stringsInArray[5];
                count++;

                    firstMovie = firstMovie +"year: "+ year +" length: "+ length +" title: "+ title +" subject: "+ subject +" popularity: "+ popularity +" awards: "+ awards + "<br>" + "<br>";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstMovie;
    }

    String allAwardMovies() {
        File movieFile = new File("src/main/java/com/example/websitereader/imdb-data.csv");
        String firstMovie = "";
        try {
            Scanner databaseScanner = new Scanner(movieFile);
            int count = 0;

            while (databaseScanner.hasNextLine()) {
                String data = databaseScanner.nextLine();

                String[] stringsInArray = data.split(";");

                // husk at converter til Int senere hvis du skal bruge dem til beregning af noget

                String year = stringsInArray[0];
                String length = stringsInArray[1];
                String title = stringsInArray[2];
                String subject = stringsInArray[3];
                String popularity = stringsInArray[4];
                String awards = stringsInArray[5];
                count++;

                if (awards.equals("Yes")) {
                    firstMovie = firstMovie +"year: "+ year +" length: "+ length +" title: "+ title +" subject: "+ subject +" popularity: "+ popularity +" awards: "+ awards + "<br>" + "<br>";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstMovie;
    }

    List<Movie> SortTenMoviesByPop() {
        ArrayList<Movie> MovieList = new ArrayList<>();
        try {

            for (int i = 0; i < 10; i++) {
                MovieList.add(RandomMovie());
            }

            MovieList.sort(Movie::compareTo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return MovieList;
    }

    public String getRandomMovie() {
        return RandomMovie().toString();
    }

    public List<Movie> getSortTenMoviesByPop() {
        return SortTenMoviesByPop();
    }

    public String getMovie() {
        return getMovieStuff();
    }

    public String getAllMovies() {
        return allMovies();
    }

    public String getAllAwardMovies() {
        return allAwardMovies();
    }


}
