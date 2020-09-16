package ee.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.ssm.en.Tuser;
import ee.ssm.service.TuserService;

@Controller
@RequestMapping("/user")
public class UserController {
	//注入值
	@Autowired
	private TuserService tuserService;
	
	//读取数据
	@RequestMapping("/list.do")
	public String userlist(Model m) {
		//读取数据
		List<Tuser> users = tuserService.selectTuser();
		/*for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i).getUsername());
		}*/
		m.addAttribute("users", users);
		return "NewFile";
	}
	
	//http://localhost:8080/20200817day/user/test.do
	@RequestMapping("/test.do")
	public String login() {
		return "login";
	}
	
	//欢迎界面
	@RequestMapping("/welcome.do")
	public String welcome() {
		return "welcome";
	}
	
	//20200817day/user/userList.do
	@RequestMapping("/userList.do")
	public String userList(Model m) {
		//在跳转之前获取数据，然后放到model里面进行数据传输
		//读取数据
		List<Tuser> users = tuserService.selectTuser();
		m.addAttribute("users", users);
		return "userList";
	}
	
	
	//登录提交的方法，在方法里面处理事件  http://localhost:8080/20200817day/user/login.do
	@RequestMapping("/login.do")
	public String loginByPassword(String username,String password,Model m) {
		System.out.println(username+password);
		//判断用户名和密码是否正确，如果正确则返回主页面index,否则回去login
		
		//存储到实体类
		Tuser t = new Tuser();
		t.setUsername(username);
		t.setPassword(password);
		
		//数据库操作
		Tuser tuser = tuserService.selectTuserByPassword(t);
		
		if(null==tuser||"".equals(tuser.getUsername())) {
			//登录失败前进行数据传输   当进入到该方法的时候，表示已经登录失败，所以设置model方法，给数据登录界面login,
			//所有只需要去登录界面获取错误信息即可
			m.addAttribute("login", "密码或账号错误");
			//没有数据
			return "login";
		}
		//登录成功，进行数据传输 如果代码执行到这个地方，表示登录已经成功，所以设置model方法，给数据主页面index
		m.addAttribute("index", tuser);
		return "index";
	}
	
	//deleteUserByTid.do
	@RequestMapping("/deleteUserByTid.do")
	public String deleteUserByTid(int tid,Model m) {
		tuserService.deleteUserByTid(tid);
		List<Tuser> users = tuserService.selectTuser();
		m.addAttribute("users", users);
		return "userList";
	}
	
	
	//查询功能
	@RequestMapping("/find.do")
	public String find(String find,Model m) {
		//如果判断值为空则查询所有
		List<Tuser> users =null;
		if(find.equals("")) {
			 users = tuserService.selectTuser();
		}else {
			 users = tuserService.selectUserByUsername(find);
		}
		m.addAttribute("users", users);
		return "userList";
	}
	
	//访问用户添加界面 http://localhost:8080/20200817day/user/tuser_add.do
	//tuser_add.jsp界面
	@RequestMapping("/tuser_add.do")
	public String Tuser_add() {
		return "tuser_add";
	}
	
	//20200817day/user/tuser_insert.do
	@RequestMapping("/tuser_insert.do")
	public String tuser_insert(Tuser tuser,Model m) {
		System.out.println("进入");
		//读取数据 读取tuser_add提交的数据
		/*System.out.println(tuser.getUsername()+tuser.getPassword());
		System.out.println(tuser.getAge()+tuser.getSex());
		System.out.println(tuser.getAddress()+tuser.getPhone());*/
		//数据库添加操作 添加tuser表主键约束，添加主键的自动递增
		tuserService.insertTuser(tuser);
		
		//List<Tuser> users = tuserService.selectTuser();
		m.addAttribute("tuser_add", "用户信息"+tuser.getUsername()+"添加成功");
		//做一个返回值
		return "tuser_add";
	}
	
	//访问 /20200817day/user/update_jsp.do
	@RequestMapping("/update_jsp.do")
	public String update_jsp(Tuser tuser,Model m){
		m.addAttribute("tuser", tuser);
		return "tuser_update";
	}
	
	
	//修改操作
	///20200817day/user/tuser_update.do
	@RequestMapping("/tuser_update.do")
	public String tuser_update(Tuser tuser,Model m){
		//操作
		tuserService.updateTuser(tuser);
		
		
		m.addAttribute("tuser_update", "用户信息"+tuser.getUsername()+"修改成功");
		//做一个返回值
		return "tuser_update";
	}
	
	
	
	
	
	
	
}
