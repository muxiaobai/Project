<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="DataBaseFactory.DaoFactory" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DNH管理系统 会员管理</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
   <link href="../../bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->


<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>DNH</strong> <small>后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
        <c:set var="staff" value="${DaoFactory.getStaffDaoInstance().findById(sessionScope.staff_id)}"/>
          <span class="am-icon-users"></span>${staff.staff_name} <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="admin-user.html"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>


<div class="am-cf admin-main">

  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="Index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 订单管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="Order.jsp" class="am-cf"><span class="am-icon-check"></span> 查看订单<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="admin-order.html"><span class="am-icon-puzzle-piece"></span> 审核订单</a></li>
        </ul>
      </li>
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 消费者管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="Order.jsp" class="am-cf"><span class="am-icon-check"></span> 会员<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="admin-order.html"><span class="am-icon-puzzle-piece"></span> 会员</a></li>
        </ul>
      </li>
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 商品<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="Goods.jsp" class="am-cf"><span class="am-icon-check"></span> 会员<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="admin-order.html"><span class="am-icon-puzzle-piece"></span> 会员</a></li>
        </ul>
      </li>
      
		<li><a href="#"><span class="am-icon-sign-out"></span> 供应商管理</a></li>
      <li><a href="#"><span class="am-icon-table"></span> 摄像头管理</a></li>
   <li><a href="#"><span class="am-icon-sign-out"></span> 发布需求</a></li>
      <li><a href="../manageadmin/StaffList.jsp"><span class="am-icon-table"></span>员工管理</a></li>
   <li><a href="../manageadmin/RoleList.jsp"><span class="am-icon-table"></span>角色管理</a></li>
   <li><a href="../manageadmin/DepartmentList.jsp"><span class="am-icon-table"></span>部门管理</a></li>
   
   </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>＃＃＃＃＃＃＃＃＃—— Amaze</p>
      </div>
    </div>

    
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">订单管理</strong> / <small>order management</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
            </div>

            <div class="am-form-group am-margin-left am-fl">
              <select>
                <option value="option1">所有订单</option>
                <option value="option2">已完成</option>
                <option value="option3">交易中</option>
                <option value="option4">未完成</option>
             </select>
            </div>
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
                  <button class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>

   

    <div class="am-g">
      <div class="am-u-sm-12">
       





<c:choose>
<c:when test="${param.msg==1}">
新增成功
</c:when>
<c:when test="${param.msg==2}">
新增失败
</c:when>
<c:when test="${param.msg==3}">
删除成功
</c:when>
<c:when test="${param.msg==4}">
删除失败
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>



		<div class="table-responsive"></div>
	<table class="table table-hover  table-striped ">
	    <thead>
	        <tr>
	        	 <th>部门ID</th>
	            <th>部门名称</th>
	           <th>部门</th>
	           
	        </tr>
	    </thead>
	    <tbody>
	<c:forEach var="govnmt" items="${DaoFactory.getGovnmtDaoInstance().findAll('')}">


        <tr>
        <td>${govnmt.govnmt_id}</td> 
        <td>${govnmt.govnmt_name}</td>    
         <td>
         <c:choose>
<c:when test="${govnmt.govnmt_state==1}">
新增政府未审核
  </td> 
          <td><a href="../../GovnmtState?govnmt_id=${govnmt.govnmt_id}&govnmt_state=2&my=2">通过</a></td>    
      
</c:when>
<c:when test="${govnmt.govnmt_state==2}">
已通过创建<td></td>
</c:when>
<c:when test="${govnmt.govnmt_state==3}">
删除信息已提交</td> 
          <td><a href="../../GovnmtDelete?govnmt_id=${govnmt.govnmt_id}">通过</a></td>    
  
</c:when>
<c:when test="${govnmt.govnmt_state==4}">
删除信息提交失败
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
         
         
         
           </tr>     
</c:forEach>
	    
	    </tbody>
	    </table>


























          <div class="am-cf">
  共 11 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <li class="am-disabled"><a href="#">?</a></li>
      <li class="am-active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">?</a></li>
    </ul>
  </div>
</div>


          <hr />
          <p>注：.....</p>
        
      </div>
    </div>

</div>
  <!-- content end -->
</div>


<footer>
  <hr>
  <p class="am-padding-left">? 2015 DNH后台管理 <a href="＃" target="_blank"></a></p>
</footer>

<!--[if lt IE 9]>
<script src="assets/js/jquery1.11.1.min.js"></script>
<script src="assets/js/modernizr.js"></script>
<script src="assets/js/rem.min.js"></script>
<script src="assets/js/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
<script src="../../bootstrap/js/jquery-1.11.1.min.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
