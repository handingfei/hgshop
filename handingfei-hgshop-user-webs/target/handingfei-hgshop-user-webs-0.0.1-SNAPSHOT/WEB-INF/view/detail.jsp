<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
   <script type="text/javascript" src='${pageContext.request.contextPath}/resource/jquery/jquery-3.4.1.js'></script>
  <link href="${pageContext.request.contextPath}/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >	
  <link href="${pageContext.request.contextPath}/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
  <script src="${pageContext.request.contextPath}/resource/bootstrap-treeview/js/bootstrap-treeview.js" ></script>
</head>
<body>
	<div class="container">
	
		<div class="row">
			 <!-- 显示商品 信息--> 
			<div class="col-md-3">
				<div class="card" style="width: 18rem;">
				<img src="/pic/${spu.smallPic}" width="120px" height="120px" class="card-img-top" alt="${spu.caption}">
					  <div class="card-body">
					    <h5 class="card-title">${spu.goodsName}</h5>
					    <p class="card-text">${spu.caption}</p>
					</div>
				</div>
			</div>
			
			<!-- 显示sku的信息 -->
			<div class="col-md-3">
				<c:forEach items="${skuList}"  var="sku">
					<div>
						${sku.title}
					</div>
				</c:forEach>
			</div>
			
		</div>
		
	</div>
	<!-- end row -->
</div>
	
</body>
</html>