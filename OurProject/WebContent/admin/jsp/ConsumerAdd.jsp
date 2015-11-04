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
     	
     
     	 <li id="Order"><a href="Order.jsp" class="am-cf"><span class="am-icon-file"></span> 订单管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
      	<li id="Goods" ><a href="GoodsList.jsp" class="am-cf"><span class="am-icon-shopping-cart"></span> 商品管理</a></li>
         <li id="Consumer" ><a href="ConsumerList.jsp" class="am-cf"><span class="am-icon-male"></span> 消费者列表</a></li>
          <li id="Supplier"><a href="Supplier.jsp" class="am-cf"><span class="am-icon-truck"></span> 供应商列表</a></li>
  
  
      <li id="Need" class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav8'}"><span class="am-icon-sign-out"></span> 需求管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav8">
          <li><a href="" class="am-cf"><span class="am-icon-check"></span> 查看供应商需求</a></li>
          <li><a href="" class="am-cf"><span class="am-icon-check"></span> 发布需求</a></li>
         </ul>
      </li>
      
      <li id="Task" class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav9'}"><span class="am-icon-sign-out"></span> 任务管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav9">
          <li><a href="Connector_TaskQueryDo.jsp" class="am-cf"><span class="am-icon-check"></span> 任务列表</a></li>
          <li><a href="" class="am-cf"><span class="am-icon-check"></span> 发布任务</a></li>
         </ul>
      </li>
      
      <li id="BackGoods" class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav10'}"><span class="am-icon-sign-out"></span> 售后管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav10">
          <li><a href="" class="am-cf"><span class="am-icon-check"></span> 查看供应商需求</a></li>
          <li><a href="" class="am-cf"><span class="am-icon-check"></span> 发布需求</a></li>
         </ul>
      </li>


      <li id="Station"><a href="StationList.jsp" class="am-cf"><span class="am-icon-map-marker"></span> 服务站管理</a></li>
      
      <li id="Camera"><a href="#"><span class="am-icon-camera"></span> 摄像头管理</a></li>
      <li id="Web"><a href="#"><span class="am-icon-camera"></span> 网站管理</a></li>
      
            
        <li  class="admin-parent">
       <a id="Staff" class="am-cf" data-am-collapse="{target: '#collapse-nav11'}"><span class="am-icon-user"></span> 员工管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav11">
          <li><a href="StaffList.jsp" class="am-cf"><span class="am-icon-list"></span> 员工列表</a></li>
          <li><a href="../html/StaffAdd.html"><span class="am-icon-plus"></span> 添加员工</a></li>
        </ul>
      </li>
      
    <li class="admin-parent">
       <a id="Role" class="am-cf" data-am-collapse="{target: '#collapse-nav12'}"><span class="am-icon-users"></span> 角色管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav12">
          <li><a href="RoleList.jsp" class="am-cf"><span class="am-icon-list"></span> 角色列表</a></li>
          <li id="RoleListCheck"><a href="RoleListCheck.jsp"><span class="am-icon-puzzle-piece"></span> 审核角色</a></li>
          </ul>
      </li>
   
    <li  class="admin-parent">
       <a id="Department" class="am-cf" data-am-collapse="{target: '#collapse-nav13'}"><span class="am-icon-bookmark-o"></span> 部门管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav13">
          <li id="DepartmentList"><a href="DepartmentList.jsp" class="am-cf"><span class="am-icon-list"></span> 部门列表</a></li>
          <li id="DepartmentListCheck"><a href="DepartmentListCheck.jsp" class="am-cf"><span class="am-icon-list"></span> 审核部门</a></li>
       </ul>
      </li>
      
   </ul>


   <div data-am-widget="tabs"
       class="am-tabs am-tabs-default"
        >
      <ul class="am-tabs-nav am-cf">
          <li class="am-active"><a href="[data-tab-panel-0]">今日公告</a></li>
          <li class=""><a href="[data-tab-panel-1]">其它公告</a></li>
      </ul>
      <div class="am-tabs-bd">
          <div data-tab-panel-0 class="am-tab-panel am-active">
            ＃＃＃今日完成订单破千＃＃   2015.10.01
          </div>
          <div data-tab-panel-1 class="am-tab-panel ">
            ＃＃＃＃系统bug已修复＃＃   2015.09.27
          </div>
         
      </div>
  </div>


    
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">会员添加</strong> / <small>staff update</small></div>
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

          
          </div>
        </div>
      </div>
      
    </div>

   

    <div class="am-g">
      <div class="am-u-sm-12">
        
   

<form action="../../StaffUpdate" method="POST" role="form" class="form-horizontal">
   <input type="hidden" name="staff_id" value=""/>

   
   
     <div class="form-group">
        <label for="inputNumber" class="col-sm-2 control-label">会员编号:</label>
        <div class="col-sm-10">
            <input type="number" name="staff_number" value="" id="inputNumber" class="form-control"   required="required" title="">
        </div>
    </div>

    <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">用户名:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_name" value="" id="inputText" class="form-control" value="" required="required" placeholder="姓名" >
        </div>
    </div>
      <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">用户状态:</label>
        <select class="col-sm-2 control-label" name="user_state">
		<option>正常</option>
		<option>禁用</option>
		</select>
    </div>
   
     <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">用户类型:</label>
        <select class="col-sm-2 control-label" name="user_type">
		<option>普通消费者</option>
		<option>供应商</option>
		</select>
    </div>
    
    <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_password" value="" id="inputText" class="form-control" value="" required="required" placeholder="密码" >
        </div>
    </div>
  
   <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">现有积分:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_password" value="" id="inputText" class="form-control" value="" required="required" placeholder="积分" >
        </div>
    </div>
    <div class="form-group">
        <label for="input" class="col-sm-2 control-label">注册时间:</label>
        <div class="col-sm-10">
            <input type="date" name="staff_into" id="input" class="form-control" value="" required="required" title="">
        </div>
    </div>
   
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">电子邮箱:</label>
        <div class="col-sm-10">
            <input type="email" name="staff_email" value="" id="inputEmail" class="form-control" value="" required="required" title="">
        </div>
    </div>

    <div class="form-group">
        <label for="inputTel" class="col-sm-2 control-label">联系方式:</label>
        <div class="col-sm-10">
            <input type="tel" name="staff_tel"  value="" id="inputTel" class="form-control" value="" required="required" title="">
        </div>
    </div>
     <div class="form-group">
        <label for="inputTel" class="col-sm-2 control-label">qq:</label>
        <div class="col-sm-10">
            <input type="tel" name="staff_qq"  value="" id="inputTel" class="form-control" value="" required="required" title="">
        </div>
    </div>
    <div class="form-group">
        <label for="inputTel" class="col-sm-2 control-label">微博:</label>
        <div class="col-sm-10">
            <input type="tel" name="staff_weibo"  value="" id="inputTel" class="form-control" value="" required="required" title="">
        </div>
    </div>
    <div class="form-group">
        <label for="inputTel" class="col-sm-2 control-label">微信:</label>
        <div class="col-sm-10">
            <input type="tel" name="staff_weixin"  value="" id="inputTel" class="form-control" value="" required="required" title="">
        </div>
    </div>
     <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">支付宝:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_password" value="" id="inputText" class="form-control" value="" required="required" placeholder="支付宝" >
        </div>
    </div>
     <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">身份证号:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_password" value="" id="inputText" class="form-control" value="" required="required" placeholder="身份证" >
        </div>
    </div>
   <div class="form-group">
        <label for="inputText" class="col-sm-2 control-label">详细地址:</label>
        <div class="col-sm-10">
            <input type="text" name="staff_address" value="" id="inputText" class="form-control" value="" required="required" placeholder="地址" >
        </div>
    </div>
    
    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">确定</button>
        </div>
    </div>
</form>




  
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
<script src="../js/PrivilegeManage.js"></script>

</body>
</html>
