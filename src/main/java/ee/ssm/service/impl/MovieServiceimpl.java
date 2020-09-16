package ee.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ssm.en.Movie;
import ee.ssm.mapper.MovieMapper;
import ee.ssm.service.MovieService;

@Service
public class MovieServiceimpl implements MovieService{
	
	//注入数据动作
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<Movie> selectMovie() {
		// TODO Auto-generated method stub
		return movieMapper.selectMovie();
	}

	@Override
	public List<Movie> selectMovieByType() {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByType();
	}

	@Override
	public List<Movie> selectMovielikeXXX(String like) {
		// TODO Auto-generated method stub
		return movieMapper.selectMovielikeXXX(like);
	}

	@Override
	public int updateMovieTypeByMid_up(int mid) {
		// TODO Auto-generated method stub
		return movieMapper.updateMovieTypeByMid_up(mid);
	}

	@Override
	public int updateMovieTypeByMid_down(int mid) {
		// TODO Auto-generated method stub
		return movieMapper.updateMovieTypeByMid_down(mid);
	}

	@Override
	public int update(Movie m) {
		// TODO Auto-generated method stub
		return  movieMapper.update(m);
	}

	@Override
	public int insert(Movie m) {
		// TODO Auto-generated method stub
		return movieMapper.insert(m);
	}
	
}
