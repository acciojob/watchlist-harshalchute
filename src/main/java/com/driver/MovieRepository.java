package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        movieMap.put(movie.getName(),movie);
    }

    public void saveDirector(Director director){
        // your code here
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here
            if(!directorMovieMapping.isEmpty()){
                for(String str : directorMovieMapping.keySet()){
                    if(str.equals(director)){
                        List<String> list = directorMovieMapping.get(str);
                        list.add(movie);
                        directorMovieMapping.put(director,list);
                        return;
                    }
                }
            }
            List<String> list = new ArrayList<>();
            list.add(movie);
            directorMovieMapping.put(director,list);
        }
    }

    public Movie findMovie(String movie){
        // your code here
        for(Movie movie1 : movieMap.values()){
            if(movie.equals(movie1)){
                return movieMap.get(movie);
            }
        }
        return new Movie();
    }

    public Director findDirector(String director){
        // your code here
        for(Director director1 : directorMap.values()){
            if(director.equals(director1)){
                return directorMap.get(director);
            }
        }
        return new Director();
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here
        List<String> list = new ArrayList<>();
        for(String director1 : directorMovieMapping.keySet()){
            if(director1.equals(director)){
                return directorMovieMapping.get(director);
            }
        }
        return list;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        // your code here
        for (String director1 : directorMap.keySet()){
            if(director1.equals(director)){
                directorMap.remove(director);
                directorMovieMapping.remove(director);
            }
        }
    }

    public void deleteAllDirector(){
        // your code here
        directorMap.clear();
        directorMovieMapping.clear();
    }
}