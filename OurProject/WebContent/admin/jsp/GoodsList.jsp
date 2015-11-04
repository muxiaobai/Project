<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DataBaseFactory.DaoFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>DNH管理系统 商品管理</title>
<meta name="description" content="这是一个 table 页面">
<meta name="keywords" content="table">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">

<link href="../../bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="assets/js/date/laydate.js"></script>
<script src="assets/js/date.js"></script>

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

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li><a href="javascript:;"><span class="am-icon-envelope-o"></span>
						收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 管理员 <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="admin-user.html"><span class="am-icon-user"></span>
								资料</a></li>
						<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
						<li><a href="#"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
				<li><a href="javascript:;" id="admin-fullscreen"><span
						class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>


	<div class="am-cf admin-main">


		<input id="Page" type="hidden" name="menuURL" value="Goods" />




		<!-- sidebar start -->
		<div class="admin-sidebar">
			<ul class="am-list admin-sidebar-list">
				<li><a href="Index.jsp"><span class="am-icon-home"></span>
						首页</a></li>


				<li id="Order"><a href="Order.jsp" class="am-cf"><span
						class="am-icon-file"></span> 订单管理<span
						class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
				<li id="Goods"><a href="GoodsList.jsp" class="am-cf"><span
						class="am-icon-shopping-cart"></span> 商品管理</a></li>
				<li id="Consumer"><a href="ConsumerList.jsp" class="am-cf"><span
						class="am-icon-male"></span> 消费者列表</a></li>
				<li id="Supplier"><a href="Supplier.jsp" class="am-cf"><span
						class="am-icon-truck"></span> 供应商列表</a></li>


				<li id="Need" class="admin-parent"><a class="am-cf"
					data-am-collapse="{target: '#collapse-nav8'}"><span
						class="am-icon-sign-out"></span> 需求管理<span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav8">
						<li><a href="" class="am-cf"><span class="am-icon-check"></span>
								查看供应商需求</a></li>
						<li><a href="" class="am-cf"><span class="am-icon-check"></span>
								发布需求</a></li>
					</ul></li>

				<li id="Task" class="admin-parent"><a class="am-cf"
					data-am-collapse="{target: '#collapse-nav9'}"><span
						class="am-icon-sign-out"></span> 任务管理<span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav9">
						<li><a href="Connector_TaskQueryDo.jsp" class="am-cf"><span
								class="am-icon-check"></span> 任务列表</a></li>
						<li><a href="" class="am-cf"><span class="am-icon-check"></span>
								发布任务</a></li>
					</ul></li>

				<li id="BackGoods" class="admin-parent"><a class="am-cf"
					data-am-collapse="{target: '#collapse-nav10'}"><span
						class="am-icon-sign-out"></span> 售后管理<span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav10">
						<li><a href="" class="am-cf"><span class="am-icon-check"></span>
								查看供应商需求</a></li>
						<li><a href="" class="am-cf"><span class="am-icon-check"></span>
								发布需求</a></li>
					</ul></li>


				<li id="Station"><a href="StationList.jsp" class="am-cf"><span
						class="am-icon-map-marker"></span> 服务站管理</a></li>

				<li id="Camera"><a href="#"><span class="am-icon-camera"></span>
						摄像头管理</a></li>
				<li id="Web"><a href="#"><span class="am-icon-camera"></span>
						网站管理</a></li>


				<li class="admin-parent"><a id="Staff" class="am-cf"
					data-am-collapse="{target: '#collapse-nav11'}"><span
						class="am-icon-user"></span> 员工管理 <span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav11">
						<li><a href="StaffList.jsp" class="am-cf"><span
								class="am-icon-list"></span> 员工列表</a></li>
						<li><a href="../html/StaffAdd.html"><span
								class="am-icon-plus"></span> 添加员工</a></li>
					</ul></li>

				<li class="admin-parent"><a id="Role" class="am-cf"
					data-am-collapse="{target: '#collapse-nav12'}"><span
						class="am-icon-users"></span> 角色管理 <span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav12">
						<li><a href="RoleList.jsp" class="am-cf"><span
								class="am-icon-list"></span> 角色列表</a></li>
						<li id="RoleListCheck"><a href="RoleListCheck.jsp"><span
								class="am-icon-puzzle-piece"></span> 审核角色</a></li>
					</ul></li>

				<li class="admin-parent"><a id="Department" class="am-cf"
					data-am-collapse="{target: '#collapse-nav13'}"><span
						class="am-icon-bookmark-o"></span> 部门管理 <span
						class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub "
						id="collapse-nav13">
						<li id="DepartmentList"><a href="DepartmentList.jsp"
							class="am-cf"><span class="am-icon-list"></span> 部门列表</a></li>
						<li id="DepartmentListCheck"><a
							href="DepartmentListCheck.jsp" class="am-cf"><span
								class="am-icon-list"></span> 审核部门</a></li>
					</ul></li>

			</ul>


			<div data-am-widget="tabs" class="am-tabs am-tabs-default">
				<ul class="am-tabs-nav am-cf">
					<li class="am-active"><a href="[data-tab-panel-0]">今日公告</a></li>
					<li class=""><a href="[data-tab-panel-1]">其它公告</a></li>
				</ul>
				<div class="am-tabs-bd">
					<div data-tab-panel-0 class="am-tab-panel am-active">
						＃＃＃今日完成订单破千＃＃ 2015.10.01</div>
					<div data-tab-panel-1 class="am-tab-panel ">＃＃＃＃系统bug已修复＃＃
						2015.09.27</div>

				</div>
			</div>



		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">商品管理</strong> <small>goods
						management</small>
				</div>
			</div>


			<div class="am-tabs am-margin" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
					<li class="am-active"><a href="#tab1">商品列表</a></li>
					<li><a href="#tab2">添加商品</a></li>
					<!-- <li><a href="#tab3">库存</a></li> -->
				</ul>

				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">所属类别</div>
							<div class="am-u-sm-10">

								<select name="dalei" id="dalei">
									<option selected>请选择</option>
									<%
										Tool.Menu op = new Tool.Menu();
										out.println(op.getcanton());
									%>
								</select> <select name="xiaolei" id="xiaolei">
									<option selected value="">请选择</option>
								</select> <select name="pinzhong" id="pinzhong">
									<option selected value="">请选择</option>
								</select> &nbsp; <input type="button" id="categoryquery"
									class="am-btn am-btn-primary am-btn-xs" value="筛选">
							</div>
						</div>

						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">显示状态</div>
							<div class="am-u-sm-10">
								<!--  onclick="res(1);" -->
								<input type="radio" name="state" id="option1" value="1"
									onclick="res(1);"> 待审核商品 <input type="radio"
									name="state" id="option2" value="2" onclick="res(2);">
								在售商品 <input type="radio" name="state" id="option3" value="3"
									onclick="res(3);"> 下架商品
							</div>
						</div>


						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">发布时间</div>
							<div class="am-u-sm-10">
								<form action="">

									<input type=text name="date" id="date" placeholder="请输入日期"
										onClick="laydate({istime: true, format: 'YYYY-MM-DD'})" />
								</form>
							</div>
						</div>
						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">搜索</div>
							<div class="am-u-sm-10">
								<form action="">
									<input type=text name="keyword" id="keyword"
										placeholder="请输入商品名称" /> <input type="button" name="query"
										id="query" class="am-btn am-btn-primary am-btn-xs" value="搜索" />
								</form>
							</div>
						</div>

						<div class="am-u-sm-12">
							<form class="am-form">
								<table id="#table"
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<th class="table-choice">选择</th>
											<th class="table-id">编号</th>
											<th class="table-title">商品名称</th>
											<th class="table-type">类别</th>
											<th class="table-date">价格</th>
											<th>库存</th>
											<th>状态</th>
											<th class="table-set">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="goods"
											items="${DaoFactory.getGoodsDaoInstance().findAll('')}">
											<c:set var="category"
												value="${DaoFactory.getCategoryDaoInstance().findById(goods.goods_category)}" />
											<c:set var="facategory"
												value="${DaoFactory.getCategoryDaoInstance().findById(category.category_fanumber)}" />

											<tr class="goods_tr" id="goods_tr${goods.goods_id}"
												data-ulid="${goods.goods_id}">
												<td><input id="choice" type="checkbox" name="checkAll"
													id="checkAll" onclick="setSelectAll();"
													value="${goods.goods_id}" /></td>
												<td>${goods.goods_id}</td>
												<td>${goods.goods_name}</td>
												<td>${facategory.category_name}</td>
												<td>${goods.goods_price}元/${goods.goods_unit}</td>
												<td>${goods.goods_inventory}</td>
												<c:choose>
													<c:when test="${goods.goods_state==1}">
														<td>等待审核</td>
													</c:when>
													<c:when test="${goods.goods_state==2}">
														<td>在售</td>
													</c:when>
													<c:when test="${goods.goods_state==3}">
														<td>下架</td>
													</c:when>
													<c:otherwise>
													</c:otherwise>

												</c:choose>

												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs">
															<button id="edit"
																class="am-btn am-btn-default am-btn-xs am-text-secondary"
																onclick="window.open('GoodListUpdate.jsp?goods_id=${goods.goods_id}')">
																<span class="am-icon-pencil-square-o"></span> 编辑
															</button>
															<!-- <button id="delete${goods.goods_id}" data-goodsid="${goods.goods_id}" class="am-btn am-btn-default am-btn-xs am-text-danger"><span class="am-icon-trash-o"></span> 删除</button>
                     -->
														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="am-cf">
									&nbsp;<input type="checkbox" id="selAll" onclick="selectAll();" />&nbsp;全选
									&nbsp;&nbsp; <input type="button" id="del" value="删除选中商品">
									<br /> 共 5 条记录
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
								<p>备注：.....</p>
							</form>
						</div>
					</div>



					<div class="am-tab-panel am-fade" id="tab2">
						<form class="am-form" action="../../GoodsAdd" method="post" enctype="multipart/form-data">

							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品所属类别</div>
								<div class="am-u-sm-6">
									<div class="am-u-sm-6">
										<select name="dalei1" id="dalei1">
											<option selected>请选择</option>
											<%
												Tool.Menu option = new Tool.Menu();
												out.println(option.getcanton());
											%>
										</select>
									</div>
									<div class="am-u-sm-6">
										<select name="xiaolei1" id="xiaolei1">
											<option selected value="">请选择</option>
										</select>
									</div>
								</div>
								<div class="am-u-sm-4">*必填</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品名称</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" name="goods_name"
										id="goods_name" required="required">
								</div>
								<div class="am-u-sm-6">
									<label id="namecheck">*必填，不可重复</label>
								</div>
							</div>

							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品别名</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" name="goods_anothername"
										required="required">
								</div>
								<div class="am-u-sm-6">
									<label>必填</label>
								</div>
							</div>

							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品等级</div>
								<div class="am-u-sm-4">
									<select name="goods_grade">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
								<div class="am-u-sm-6">
									<label>*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品价格</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" id="goods_price"
										name="goods_price" required="required"
										onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')">
								</div>
								<div class="am-u-sm-6">
									元 &nbsp;&nbsp;&nbsp;<label id="pricecheck">*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品单位</div>
								<div class="am-u-sm-4">
									<select name="goods_unit">
										<option>箱</option>
										<option>斤</option>
										<option>千克</option>
										<option>吨</option>
									</select>
								</div>
								<div class="am-u-sm-6">
									<label>*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品库存</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" id="goods_inventory"
										name="goods_inventory" required="required"
										onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')">
								</div>
								<div class="am-u-sm-6">
									<label id="inventorycheck">*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">起售量</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" id="goods_sendnumber"
										name="goods_sendnumber" required="required">
								</div>
								<div class="am-u-sm-6">
									<label id="sendnumbercheck">*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品产地</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" id="goods_place"
										name="goods_place" required="required">
								</div>
								<div class="am-u-sm-6">
									<label id="placecheck">*必填</label>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品功能</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" name="goods_vantage">
								</div>
								<div class="am-u-sm-6"></div>
							</div>

							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">商品视频</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" name="goods_video">
								</div>
								<div class="am-u-sm-6"></div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">生产时间</div>
								<div class="am-u-sm-4">
									<input type="text" name="goods_producetime" id="date"
										class="form-control"
										onClick="laydate({istime: true, format: 'YYYY-MM-DD'})"
										title="">
								</div>
								<div class="am-u-sm-6"></div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">发售时间</div>
								<div class="am-u-sm-4">
									<input type="text" name="goods_saletime" id="date"
										class="form-control"
										onClick="laydate({istime: true, format: 'YYYY-MM-DD'})"
										title="">
								</div>
								<div class="am-u-sm-6"></div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">截止时间</div>
								<div class="am-u-sm-4">
									<input type="text" name="goods_offtime" id="date"
										class="form-control"
										onClick="laydate({istime: true, format: 'YYYY-MM-DD'})"
										title="">
								</div>
								<div class="am-u-sm-6"></div>
							</div>
							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">商品描述</div>
								<div class="am-u-sm-10">
									<textarea rows="10"  name="goods_info" placeholder="请使用富文本编辑插件"></textarea>
								</div>
							</div>
							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">商品简介图片</div>
								<div class="am-u-sm-10">
								<div class="am-u-sm-4">
									<input type="file" class="form-control" name="url1"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="url2"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="url3"/>
								</div>
								</div>
							</div>
							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">商品详情图片</div>
								<div class="am-u-sm-10">
								<div class="am-u-sm-4">
									<input type="file" class="form-control" name="otherurl1"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="otherurl2"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="otherurl3"/>
								</div>
								</div>
								<div class="am-u-sm-10">
								<div class="am-u-sm-4">
									<input type="file" class="form-control" name="otherurl4"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="otherurl5"/>
								</div>
								<div class="am-u-sm-4">
								<input type="file" class="form-control" name="otherurl6"/>
								</div>
								</div>
							</div>

							<div class="am-u-sm-6">
								<input type="submit" value="添加" class="am-btn am-btn-primary">

								<input type="reset" value="重置" class="am-btn am-btn-default">

							</div>

						</form>
					</div>

					<!--   <div class="am-tab-panel am-fade" id="tab3">
        <form class="am-form">
          <div class="am-g am-margin-top-sm">
            <div class="am-u-sm-2 am-text-right">
              库存查询
            </div>
            <div class="am-u-sm-4 am-u-end">
              <input type="text" class="am-input-sm">
            </div>
          </div>

          <div class="am-g am-margin-top-sm">
            <div class="am-u-sm-2 am-text-right">
              关键字搜索
            </div>
            <div class="am-u-sm-4 am-u-end">
              <input type="text" class="am-input-sm">
            </div>
          </div>

          <div class="am-g am-margin-top-sm">
            <div class="am-u-sm-2 am-text-right">
              商品描述
            </div>
            <div class="am-u-sm-4 am-u-end">
              <textarea rows="4"></textarea>
            </div>
          </div>  
        </form>-->
				</div>

			</div>
		</div>

	</div>
	<!-- content end -->




	<footer>
		<hr>
		<p class="am-padding-left">
			© 2015 DNH后台管理 <a href="＃" target="_blank">大农合</a>
		</p>
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
	<script src="../../bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/app.js"></script>
	<script src="../js/PrivilegeManage.js"></script>

	<script type="text/javascript">
		//     var asd=$(".goods_tr").data('ulid')
		//     $("#delete"+goods_tr).click(function(){
		//     	var goodsid=$(this).data('goodsid');
		//     	//alert(goodsid);
		//     	  $.post("../../DeleteGood",
		//     	  {		  
		//     	    goodsid: goodsid,    
		//     	  },

		//     	  function(data,status){
		//     	    if(data==1){    	
		//     	    //var asd=$("#goods_tr"+goodsid).data('ulid')	
		//     	    alert("删除成功");
		//     	    $("#good_tr"+goodsid).remove(); 
		//     	    document.execCommand('Refresh') 

		//     	    }else if(data==0){ 
		//     	    	alert("删除失败");
		//     	    }
		//     	  }); });

		//类别筛选
		$(document).ready(function() {
			$("#dalei").change(function() {
				SelectChange();
			});
			function SelectChange() {
				//获取下拉框选中项的value属性值
				var dalei = $("#dalei").val()
				$.get("../../Menu1", {
					category_fanumber : dalei
				}, function(m) {
					$("#xiaolei :gt(0)").remove();
					$("#xiaolei").append(m);
				});
			}

			$("#xiaolei").change(function() {
				SelectChange1();
			});
			function SelectChange1() {
				//获取下拉框选中项的value属性值
				var xiaolei = $("#xiaolei").val();

				$.get("../../Menu1", {
					category_fanumber : xiaolei
				}, function(m1) {
					$("#pinzhong :gt(0)").remove();
					$("#pinzhong").append(m1);
				});
			}

		});

		$(document).ready(function() {
			$("#dalei1").change(function() {
				SelectChange();
			});
			function SelectChange() {
				//获取下拉框选中项的value属性值
				var dalei = $("#dalei1").val()
				$.get("../../Menu1", {
					category_fanumber : dalei
				}, function(m) {
					$("#xiaolei1 :gt(0)").remove();
					$("#xiaolei1").append(m);
				});
			}
			$("#xiaolei1").change(function() {
				alert($("#xiaolei1").val());
			});

		});

		//通过类别查找 
		$("#categoryquery")
				.click(
						function() {
							var category = $("#pinzhong").val();
							alert(category);
							$
									.get(
											"../../GoodList_category",
											{
												category : category
											},
											function(m2) {
												alert(m2);
												$("table tr:gt(0)").remove();//除了第一行的数据后，其他行都删除
												var html = "";
												for (var i = 0; i < m2.rows.length; i++) {
													//alert("1");
													var r = m2.rows[i];
													html += "<tr id='goods_tr"+r.goodsid +"' data-ulid="+r.goodsid+">";
													html += "<td><input id='choice' type='checkbox' name='checkAll' id='checkAll' onclick='setSelectAll();' value='"
															+ r.goodsid
															+ "'></td>"
													html += "<td>" + r.goodsid
															+ "</td>";
													html += "<td>" + r.name
															+ "</td>";
													html += "<td>" + r.category
															+ "</td>";
													html += "<td>" + r.price
															+ "元/" + r.unit
															+ "</td>";
													html += "<td>"
															+ r.inventory
															+ "</td>";
													html += "<td>" + r.state
															+ "</td>";
													html += "<td><div class='am-btn-toolbar' ><div class='am-btn-group am-btn-group-xs'>";
													html += "<button id='edit' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> 编辑</button></div></div></td></tr>";
													//alert("2");
												}
												//alert("3");
												$("table").append(html);

											});
						});

		//根据状态筛选 
		function res(cs) {
			//alert("ok");
			var param = "";
			if (cs == 1) {
				param = "1";

			}
			if (cs == 2) {
				param = "2";

			}
			if (cs == 3) {
				param = "3";

			}
			// alert(param);

			$
					.get(
							"../../GoodList_state",
							{
								param : param
							},
							function(m3) {
								//alert("1");

								$("table tr:gt(0)").remove();//除了第一行的数据后，其他行都删除
								var html = "";
								for (var i = 0; i < m3.rows.length; i++) {
									//alert("2");
									var r = m3.rows[i];
									html += "<tr id='goods_tr"+r.goodsid +"' data-ulid="+r.goodsid+">";
									html += "<td><input id='choice' type='checkbox' name='checkAll' id='checkAll' onclick='setSelectAll();' value='"
											+ r.goodsid + "'></td>"
									html += "<td>" + r.goodsid + "</td>";
									html += "<td>" + r.name + "</td>";
									html += "<td>" + r.category + "</td>";
									html += "<td>" + r.price + "元/" + r.unit
											+ "</td>";
									html += "<td>" + r.inventory + "</td>";
									html += "<td>" + r.state + "</td>";
									html += "<td><div class='am-btn-toolbar' ><div class='am-btn-group am-btn-group-xs'>";
									html += "<button id='edit' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> 编辑</button></div></div></td></tr>";
									//$("#option"+param).checked=checked;
								}
								//alert("3");
								$("table").append(html);
							});
		}

		var selAll = document.getElementById("selAll");
		function selectAll() {
			var obj = document.getElementsByName("checkAll");
			if (document.getElementById("selAll").checked == false) {
				for (var i = 0; i < obj.length; i++) {
					obj[i].checked = false;
				}
			} else {
				for (var i = 0; i < obj.length; i++) {
					obj[i].checked = true;
				}
			}

		}

		//当选中所有的时候，全选按钮会勾上 
		function setSelectAll() {
			var obj = document.getElementsByName("checkAll");
			var count = obj.length;
			var selectCount = 0;

			for (var i = 0; i < count; i++) {
				if (obj[i].checked == true) {
					selectCount++;
				}
			}
			if (count == selectCount) {
				document.all.selAll.checked = true;
			} else {
				document.all.selAll.checked = false;
			}
		}

		//反选按钮 

		//批量删除
		$("#del").click(function() {
			//window.confirm("确定删除所选记录？");
			var input = document.getElementsByName("checkAll");
			var ids = "";
			for (var i = 0; i <= input.length - 1; i++) {
				if (input[i].checked == true) {
					alert("2");

					ids += input[i].value + ",";
					alert(ids);
				}
			}
			if (ids != "") {
				$.ajax({
					type : "post",
					url : '../../MultiDelete?ids=' + ids, //要自行删除的action  
					//dataType : 'json',  
					success : function(data) {
						if (data == "1") {
							alert("删除成功");
							location = location;
						} else if (data == "0") {
							alert("删除失败 ")
						}
					},
				});
			} else {
				alert("请选择要删除的记录");
			}
			//}}
		});
	</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#goods_name")
									.blur(
											function() {
												if (this.value == "") {
													alert("请输入商品名称 ");
												} else {
													// alert(this.value);
													$
															.post(
																	"../../GoodsNameTest",
																	{

																		goods_name : document
																				.getElementById("goods_name").value,

																	},

																	function(
																			data,
																			status) {
																		if (data == 1) {
																			//alert("ok");
																			$(
																					"#namecheck")
																					.text(
																							"商品名可用");
																		} else if (data == 0) {
																			$(
																					"#namecheck")
																					.text(
																							"商品名不可用");
																			document
																					.getElementById("goods_name").value = "";
																		}
																	});
												}
											});

						});

		$(document)
				.ready(
						function() {
							$("#goods_price").blur(function() {
								if (this.value == "") {
									$("#pricecheck").text("请输入商品价格 ");

								}
							});
							$("#goods_inventory").blur(function() {
								if (this.value == "") {
									$("#inventorycheck").text("请输入商品库存  ");
								}
							});
							$("#goods_sendnumber").blur(function() {
								if (this.value == "") {
									$("#sendnumbercheck").text("请输入商品起售量 ");
								}
							});
							$("#goods_place").blur(function() {
								if (this.value == "") {
									$("#placecheck").text("请输入商品产地 ");
								}
							});

							$("#query")
									.click(
											function() {
												var keyword = $("#keyword")
														.val();
												$
														.post(
																"../../GoodsNameQuery ",
																{
																	keyword : keyword
																},
																function(k) {
																	$(
																			"table tr:gt(0)")
																			.remove();//除了第一行的数据后，其他行都删除
																	var html = "";
																	for (var i = 0; i < k.rows.length; i++) {
																		//alert("2");
																		var r = k.rows[i];
																		html += "<tr id='goods_tr"+r.goodsid +"' data-ulid="+r.goodsid+">";
																		html += "<td><input id='choice' type='checkbox' name='checkAll' id='checkAll' onclick='setSelectAll();' value='"
																				+ r.goodsid
																				+ "'></td>"
																		html += "<td>"
																				+ r.goodsid
																				+ "</td>";
																		html += "<td>"
																				+ r.name
																				+ "</td>";
																		html += "<td>"
																				+ r.category
																				+ "</td>";
																		html += "<td>"
																				+ r.price
																				+ "元/"
																				+ r.unit
																				+ "</td>";
																		html += "<td>"
																				+ r.inventory
																				+ "</td>";
																		html += "<td>"
																				+ r.state
																				+ "</td>";
																		html += "<td><div class='am-btn-toolbar' ><div class='am-btn-group am-btn-group-xs'>";
																		html += "<button id='edit' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> 编辑</button></div></div></td></tr>";
																	}
																	//alert("3");
																	$("table")
																			.append(
																					html);

																});

											})
						});
	</script>
</body>
</html>
