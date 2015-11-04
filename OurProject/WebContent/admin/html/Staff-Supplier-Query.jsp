<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DataBaseFactory.DaoFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DNH管理系统 供应商管理</title>
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
      <li><a href="../jsp/Index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 订单管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="../jsp/Order.jsp" class="am-cf"><span class="am-icon-check"></span> 查看订单<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="../jsp/OrderDetail.jsp"><span class="am-icon-puzzle-piece"></span> 审核订单</a></li>
        </ul>
      </li>
       <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-male"></span> 消费者管理  <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li><a href="../jsp/Membership.html" class="am-cf"><span class="am-icon-list"></span> 消费者列表</a></li>
          <li><a href="#"><span class="am-icon-puzzle-piece"></span> 审核订单</a></li>
          <li><a href="../jsp/Staff_Consumer_Add.jsp"><span class="am-icon-plus"></span> 添加角色</a></li>
        </ul>
      </li>
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-shopping-cart"></span> 商品管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
          <li><a href="../jsp/Goods.html" class="am-cf"><span class="am-icon-check"></span> 查看商品</a></li>
          <li><a href="../jsp/Goods.html"><span class="am-icon-plus"></span> 添加商品</a></li>
        </ul>
      </li>
      
		<li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav6'}"><span class="am-icon-truck"></span> 供应商管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav6">
          <li><a href="../jsp/Supplier.jsp" class="am-cf"><span class="am-icon-check"></span> 供应商列表</a></li>
          <li><a href="#"><span class="am-icon-plus"></span> 添加供应商</a></li>
        </ul>
      </li>
      <li><a href="#"><span class="am-icon-camera"></span> 摄像头管理</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav6'}"><span class="am-icon-sign-out"></span> 发布需求<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav6">
          <li><a href="../html/Staff-Supplier-Query.jsp" class="am-cf"><span class="am-icon-check"></span> 需求审核</a></li>
          <li><a href="#"><span class="am-icon-plus"></span> 添加供应商</a></li>
        </ul>
      </li>
            
        <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-user"></span> 员工管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="../manageadmin/StaffList.jsp" class="am-cf"><span class="am-icon-list"></span> 员工列表</a></li>
          <li><a href="../html/StaffAdd.jsp"><span class="am-icon-plus"></span> 添加员工</a></li>
        </ul>
      </li>
      
    <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-users"></span> 角色管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="../manageadmin/RoleList.jsp" class="am-cf"><span class="am-icon-list"></span> 用户注册列表</a></li>
          <li><a href="#"><span class="am-icon-puzzle-piece"></span> 审核角色</a></li>
          <li><a href="../html/RoleAdd.html"><span class="am-icon-plus"></span> 添加角色</a></li>
       </ul>
      </li>
   
    <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-bookmark-o"></span> 部门管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
          <li><a href="../manageadmin/DepartmentList.jsp" class="am-cf"><span class="am-icon-list"></span> 部门列表</a></li>
         <li><a href="../html/DepartmentAdd.html"><span class="am-icon-plus"></span> 添加部门</a></li>
       </ul>
      </li>
      
      <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav7'}"><span class="am-icon-map-marker"></span> 站点管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav7">
          <li><a href="../jsp/StationList.jsp" class="am-cf"><span class="am-icon-list"></span> 站点列表</a></li>
         <li><a href="../jsp/StationDetail.jsp" class="am-cf"><span class="am-icon-puzzle-piece"></span> 站点审核</a></li>
         <li><a href="../html/StationAdd.html"><span class="am-icon-plus"></span> 添加站点</a></li>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">供应商管理</strong> / <small>supplier management</small></div>
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
<c:choose>
<c:when test="${param.msg==1}">
审核通过成功
</c:when>
<c:when test="${param.msg==2}">
审核不通过失败
</c:when>
<c:when test="${param.msg==3}">
审核不通过成功
</c:when>
<c:when test="${param.msg==4}">
审核不通过失败
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
   
    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
	            <th>序号</th>
	        	<th>供应商ID</th>
	        	<th>名字</th>
	        	<th>数量</th>
	        	<th>单位</th>
	        	<th>最高价格</th>
	        	<th>最低价格</th>
	        	<th>开始时间</th>
	        	<th>结束时间</th>
	        	<th>提交时间</th>
	        	<th>审核通过</th>
	        	<th>审核不通过</th>
              </tr>
          </thead>
          <tbody>
			 <c:forEach var="supplierneed" items="${DaoFactory.getSupplierneedDaoInstance().findState('')}">
			        <tr>
			        <td>${supplierneed.supplierneed_id}</td> 
			        <td>${supplierneed.supplierneed_supplierid}</td>  
			        <td>${supplierneed.supplierneed_name}</td>   
			        <td>${supplierneed.supplierneed_number}</td> 
			        <td>${supplierneed.supplierneed_unit}</td> 
			        <td>${supplierneed.supplierneed_highprice}</td> 
			        <td>${supplierneed.supplierneed_lowprice}</td> 
			        <td>${supplierneed.supplierneed_begintime}</td> 
			        <td>${supplierneed.supplierneed_endtime}</td> 
			        <td>${supplierneed.supplierneed_statetime}</td>  
			        <td><a href="../../Staff_ConsumerManagement_CheckNeed1?supplierneed_id=${supplierneed.supplierneed_id}">审核通过</a></td> 
			        <td><a href="../../Staff_ConsumerManagement_CheckNeed2?supplierneed_id=${supplierneed.supplierneed_id}">审核不通过</a></td>   
			        </tr>    
			</c:forEach>
           
        
           </tbody>
        </table>
          <div class="am-cf">
  共 11 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <li class="am-disabled"><a href="#">«</a></li>
      <li class="am-active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">»</a></li>
    </ul>
  </div>
</div>
          <hr />
          <p>注：.....</p>
        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>


<footer>
  <hr>
  <p class="am-padding-left">© 2015 DNH后台管理 <a href="＃" target="_blank"></a></p>
</footer>

<!--[if lt IE 9]>
<script src="assets/js/jquery1.11.1.min.js"></script>
<script src="assets/js/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>
