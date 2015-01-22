<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap-responsive.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap-responsive.min.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.js"></script>
<script src="jquery1_11_2.js"></script>
<script src="scriptjava.js"></script>
<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
</head>
<body>
       
 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         
          <div class="nav-collapse collapse">
        <form action="signoutServlet" method="post">
    <input type="submit" class="navbar-text pull-right" value="Logout" />
</form>
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link"><%= session.getAttribute("username") %></a>
            </p>
            <ul class="nav nav-pills">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    <div class="page-header">
    <h1>My Diary <small>Memory... is the diary that we all carry about with us.</small></h1>
    </div>
    
     <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Profile</li>
              <li class="active"><img src="Penguins.jpg" style="width: 120px; height: 130px" class="img-polaroid"></li>
              <li></br><h3 ><%= session.getAttribute("firstName") %> <%=session.getAttribute("lastName") %></h3>	</li>
              <li><h5 >Email  : <small><%= session.getAttribute("email") %></small></h5>	</li>
              <li><h5>Living In  :  <small>USA</small></h5>
    			</li>
              </ul>
          </div><!--/.well -->
        </div><!--/span-->
       
       <div class="span9">
          <div class="hero-unit">
            <h3>Hello, world!</h3>
            <form class="form-horizontal" method="get" action="AddDiaryServlet">
             <div class="control-group">
						<label class="control-label" >Enter Title</label>
						<div class="controls">
						<input type="text" id="text" placeholder="Title" name="title">
						</div>
						</div>
    		 			
    		 			<label class="control-label" >Enter Yours Daily Memories </label>
						<div class="controls">
						    <textarea rows="3" name="aboutDiary"></textarea>
						
						<br>
						<select class="span3" name="feeling">
    		 				<option>Feeling good</option>
    		 				<option>Feeling bad</option>
    		 				<option>Feeling boring</option>
    		 				<option>In Movie</option>
    		 				
    		 			</select>
    		 			</br>
    		 			<button class="btn" type="submit">Submit</button>
    		 			</div>
    		 			
    		 		</form>
    		 		</div>
    		 		
    		 		<div class="spam9">
    		 		<div class="hero-unit">
    		 		<h4>List Of Post</h4>
    		 		<% int count=1;  %>
    		 		<c:forEach items="${diaryList}" var="post">
           <div class="blog-post">
           
    		<form name="postedForm" id="postedForm" action="editviewServlet">
            <h2 class="blog-post-title">${post.title }</h2>
            <small  >Posted On:${post.postedDate }</small>
            <input type="hidden" id="postdate" name="postdate" value="${post.countId}" >
            <small >${post.feelings }</small>

            <p class="lead">${post.description }</p>
            <input type="submit" name="edit" id="edit" value="edit" class="navbar-text pull-right"> 
            <input type="submit" name="delete" id="delete"  value="delete" class="navbar-text pull-right"> 
            </form>
           </div>
            </c:forEach>
            </div>
         </div>
        </div><!--/span-->
      </div><!--/row-->
      </div>
      
      <script type="text/javascript">
      if(<%= session.getAttribute("username") %> == null){
    	  window.location="login.jsp";
      }
      $("#edit").click(function(){
    	  alert("edit");
      });
      $("#delete").click(function(){
    	 alert("delete"); 
      });
      
      
      </script>
</body>
</html>