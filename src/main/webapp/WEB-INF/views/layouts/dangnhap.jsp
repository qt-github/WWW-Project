<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><decorator:title default="Đăng nhập" /></title>
    <link href=" <c:url value="/resources/admin/css/styles.css"/> " rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    
      <!-- Icons font CSS-->
   <link href="<c:url value="/resources/dangky/vendor/mdi-font/css/material-design-iconic-font.min.css"/>" rel="stylesheet" media="all">
    
     <!-- Vendor CSS-->
    <link href="<c:url value="/resources/dangky/vendor/select2/select2.min.css"/>" rel="stylesheet" media="all">
	<link href="<c:url value="/resources/dangky/vendor/datepicker/daterangepicker.css"/>" rel="stylesheet" media="all">
    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">

</head>
<body id="LoginForm">

    <decorator:body/>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src=" <c:url value="/resources/admin/js/scripts.js"/>"></script>
    

    <!-- Vendor JS-->
    <script src="<c:url value="/resources/dangky/vendor/select2/select2.min.js"/>"></script>
    <script src="<c:url value="/resources/dangky/vendor/datepicker/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/dangky/vendor/datepicker/daterangepicker.js"/>"></script>
    <script src="<c:url value="/resources/dangky/js/global.js"/>"></script>
    <!-- Main JS-->
</body>
</html>