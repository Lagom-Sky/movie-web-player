package ee.ssm.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ee.ssm.en.Movie;
import ee.ssm.service.MovieService;


//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory; 错误，需要导入我们刚刚放进项目的包

@Controller
@RequestMapping("/Movie")
public class MovieController {
	//注入
	//读取
	//注入值
	@Autowired
	private MovieService movieService;


	//前端客户端显示
	//读取数据
	// http://localhost:8080/20200817day/Movie/index_m.do
	@RequestMapping("/index_m.do")
	public String index_m(Model m) {
		//读取数据
		List<Movie> MovieList = movieService.selectMovieByType();

		//System.out.println(MovieList.get(0).getName());

		m.addAttribute("MovieList", MovieList);
		//给他电影信息的值
		return "index_m";
	}

	//play.jsp
	//http://localhost:8080/20200817day/Movie/play.do
	@RequestMapping("/play.do")
	public String play(String m_url,Model m) {
		System.out.println("电影地址："+m_url);
		m.addAttribute("m_url",m_url);
		//给他电影信息的值
		return "play";
	}

	//后台界面显示
	//movie.jsp
	//http://localhost:8080/20200817day/Movie/movie.do
	@RequestMapping("/movie.do")
	public String movie(Model m) {
		List<Movie> MovieList = movieService.selectMovie();
		m.addAttribute("MovieList", MovieList);
		m.addAttribute("count",MovieList.size());
		return "movie";
	}


	@RequestMapping("/like.do")
	public String like(String like,Model m) {
		List<Movie> MovieList = null;
		if(like.equals("")) {
			//selectMovie这个方法是查询所有
			MovieList = movieService.selectMovie();
		}else {
			MovieList = movieService.selectMovielikeXXX(like);
		}


		//读取数据总量
		m.addAttribute("count",MovieList.size());

		m.addAttribute("MovieList", MovieList);
		return "movie";
	}


	//上架
	@RequestMapping("/up.do")
	public String up(String mid,Model m) {

		//字符串转整型
		int mid_int = Integer.parseInt(mid);
		//修改上架内容
		movieService.updateMovieTypeByMid_up(mid_int);


		List<Movie> MovieList = null;
		MovieList = movieService.selectMovie();
		//读取数据总量
		m.addAttribute("count",MovieList.size());
		m.addAttribute("MovieList", MovieList);
		return "movie";
	}

	//下架
	@RequestMapping("/down.do")
	public String down(String mid,Model m) {

		//字符串转整型
		int mid_int = Integer.parseInt(mid);
		//修改上架内容
		movieService.updateMovieTypeByMid_down(mid_int);
		List<Movie> MovieList = null;
		MovieList = movieService.selectMovie();
		//读取数据总量
		m.addAttribute("count",MovieList.size());
		m.addAttribute("MovieList", MovieList);
		return "movie";
	}

	//修改功能 中转站
	@RequestMapping("/updateMovieInfo.do")
	public String updateMovieInfo(Movie movie,Model m,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		m.addAttribute("movie", movie);
		System.out.println(movie.toString());
		return "movie_update";
	}

	//修改功能实现
	@RequestMapping("/update.do")
	public String update(Movie movie,Model m) {
		//修改功能
		movieService.update(movie);

		List<Movie> MovieList = movieService.selectMovie();
		m.addAttribute("MovieList", MovieList);
		m.addAttribute("count",MovieList.size());
		return "movie";
	}

	//中转
	@RequestMapping("/movie_add.do")
	public String movie_add() {
		return "movie_add";
	}



	//视频上传
	@RequestMapping("/upload.do")
	public String upload(Model m) {

		// 通过ServletRequestAttributes去获取请求，响应
		ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest  request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();
		//视频上传
		movie_upload(request,response);

		//数据库新增操作 存到实体类
		Movie movie = new Movie();
		String director = (String) request.getAttribute("director");
		movie.setDirector(director);

		String name = (String) request.getAttribute("name");
		movie.setName(name);

		String actor = (String) request.getAttribute("actor");
		movie.setActor(actor);

		String distrit = (String) request.getAttribute("distrit");
		movie.setDistrit(distrit);

		String date = (String) request.getAttribute("date");
		movie.setDate(date);

		String pic_url = (String) request.getAttribute("pic_url");
		movie.setPic_url(pic_url);

		String m_url = (String) request.getAttribute("m_url");
		movie.setM_url(m_url);

		String type = (String) request.getAttribute("type");
		movie.setType(type);


		//新增操作
		movieService.insert(movie);


		//返回电影信息列表
		List<Movie> MovieList = movieService.selectMovie();
		m.addAttribute("MovieList", MovieList);
		m.addAttribute("count",MovieList.size());
		return "movie";
	}


	//视频上传功能实现 存储到数据库
	public void movie_upload(HttpServletRequest request,HttpServletResponse response) {
		//文件名
		String filename = null;
		//获取磁盘文件条目
		DiskFileItemFactory factory  = new DiskFileItemFactory();
		//获取请求中的路劲，就是上传的路径 import org.apache.commons.fileupload.disk.DiskFileItemFactory;
		String path = "C:\\Users\\Lenovo\\IdeaProjects\\yqyy\\src\\main\\webapp\\";
		//这里必须导入IO流的包
		factory.setRepository(new File(path));
		//这里的名字差不多，选择一个有带参数的方法进行添加
		factory.setSizeThreshold(1024*1024);

		ServletFileUpload upload = new ServletFileUpload(factory);

		InputStream in = null;

		byte[] buf=null;

		try {
			List<FileItem> list = upload.parseRequest(request);


			for(FileItem item:list) {
				//获取名称
				String name = item.getFieldName();;
				if(item.isFormField()) {
					//设置为utf-8
					String value=item.getString("utf-8");
					request.setAttribute(name, value);
				}else {
					//路径名称
					String value=item.getName();
					System.out.println(name);
					System.out.println(value);
					//剪切点的内容
					String cut = value.substring(value.lastIndexOf("."));
					if(name.equals("m_url"))
						//设置文件的名称
						filename="video/movie"+String.valueOf(((new Date()).getTime())%100000)+cut;

					if(name.equals("pic_url"))
						//设置文件的名称
						filename="images/image"+String.valueOf(((new Date()).getTime())%100000)+cut;

					//设置请求请求作用域中的值
					request.setAttribute(name,"../"+filename);

					//预写入文件到video文件夹里面
					OutputStream out = new FileOutputStream(new File(path,filename));

					//写入到文件里面去
					in = item.getInputStream();
					int length =0;
					buf = new byte[1024];

					while((length = in.read(buf))!=-1) {
						out.write(buf, 0, length);
					}
					//读取视频的大小
					System.out.println("读取文件的大小"+item.getSize());
					in.close();
					out.close();
				}
			}

		}catch (Exception e) {
			System.out.println("错误"+e.getMessage());
		}
	}
}
