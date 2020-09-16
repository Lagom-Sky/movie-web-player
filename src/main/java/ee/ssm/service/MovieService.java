package ee.ssm.service;

import java.util.List;

import ee.ssm.en.Movie;

public interface MovieService {
	List<Movie> selectMovie();
	List<Movie> selectMovieByType();
	List<Movie> selectMovielikeXXX(String like);
	int updateMovieTypeByMid_up(int mid);
	int updateMovieTypeByMid_down(int mid);
	int update(Movie m);
	int insert(Movie m);
}
