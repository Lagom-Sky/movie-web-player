<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="ee.ssm.en.Movie"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../lib/html5shiv.js"></script>
<script type="text/javascript" src="../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>图片列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 电影信息 <span class="c-gray en">&gt;</span> 电影列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="/20200817day/Movie/like.do" >
		<div class="text-c"> 
			<input type="text" name="like" id="" placeholder="电影名称、导演、演员、版本状态" style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜电影</button>
		</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius"  href="/20200817day/Movie//movie_add.do"><i class="Hui-iconfont">&#xe600;</i> 添加视频 </a></span> <span class="r">共有数据：<strong>${count}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="" type="checkbox" value=""></th>
					<th width="80">编号</th>
					<th width="100">电影名称</th>
					<th width="100">导演</th>
					<th>封面</th>
					<th width="150">地区</th>
					<th width="150">演员</th>
					<th width="60">上架时间</th>
			        <th width="60">电影地址</th>
			        <th width="60">版本状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${MovieList}" var="m">
					<tr class="text-c">
						<td><input name="" type="checkbox" value=""></td>
						<td>${m.mid}</td>
						<td>${m.name}</td>
					    <td>${m.director}</td>
						<td><img width="70px" class="picture-thumb" src="${m.pic_url}"></td>
						<td>${m.distrit}</td>
						<td>${m.actor}</td>
						<td>${m.date}</td>
						<td>${m.m_url}</td>
						<td class="td-status"><span class="label label-success radius">${m.type}</span></td>
						<td class="td-manage">
						
						<% 
						Movie mm =  (Movie)pageContext.getAttribute("m");
						
						if(mm.getType().equals("已上架")){
							%>
								<a style="text-decoration:none"  href="/20200817day/Movie/down.do?mid=${m.mid}" title="下架">
									<i class="Hui-iconfont">&#xe6de;</i><!-- &#xe603 发布图标 -->
								</a>
						
							<% 
						}else{
							%>
								<a style="text-decoration:none"  href="/20200817day/Movie/up.do?mid=${m.mid}" title="发布">
									<i class="Hui-iconfont">&#xe603;</i><!-- &#xe603 发布图标 -->
								</a>
							<% 
						}
						
						%>
						
							<%-- 	
						<a style="text-decoration:none"  href="/20200817day/Movie/down.do?mid=${m.mid}" title="下架">
							<i class="Hui-iconfont">&#xe6de;</i><!-- &#xe603 发布图标 -->
							
							int mid;
							String name;
							String director;
							String actor;
							String distrit;
							String date;
							String pic_url;
							String m_url;
							String type;
							mid=${m.mid}&name=${m.name}&director=${m.director}&actor=${m.actor}&distrit=${m.distrit}&date=${m.date}&pic_url=${m.pic_url}&m_url=${m.m_url}&type=${m.type}
						</a>
						 --%>
						 <a style="text-decoration:none" class="ml-5"  href="/20200817day/Movie/updateMovieInfo.do?mid=${m.mid}&name=${m.name}&director=${m.director}&actor=${m.actor}&distrit=${m.distrit}&date=${m.date}&pic_url=${m.pic_url}&m_url=${m.m_url}&type=${m.type}" title="编辑">
						 	<i class="Hui-iconfont">&#xe6df;</i>
						 </a> 
						 </td>
					</tr>
				</c:forEach>
			
				
			</tbody>
		</table>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});

/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-查看*/
function picture_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-审核*/
function picture_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过'], 
		shade: false
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}

/*图片-下架*/
function picture_stop(obj,id,mid){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		alert(mid);
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*图片-发布*/
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}

/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

/*图片-编辑*/
function picture_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-删除*/
function picture_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script>
</body>
</html>