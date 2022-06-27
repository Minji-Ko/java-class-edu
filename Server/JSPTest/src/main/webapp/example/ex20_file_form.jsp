<%@page import="java.util.Comparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//디렉토리 탐색
	
	String path = application.getRealPath("/example/images");
	
	File dir = new File(path);
	
	File[] list = dir.listFiles();
	
	//System.out.println(list[0].getName());
	//System.out.println(list[0].lastModified());
	
	//Calendar temp = Calendar.getInstance();
	//temp.setTimeInMillis(list[0].lastModified());
	//System.out.printf("%tF %tT\n", temp, temp);
	
	/* 	
	Arrays.sort(list, (a, b) -> {
		return Long.compare(a.lastModified(), b.lastModified());
	});  
	*/ //Lambda expressions are allowed only at source level 1.8 or above
	
	
	
	Arrays.sort(list, new Comparator<File>() {
		public int compare(File a, File b) {
			return Long.compare(a.lastModified(), b.lastModified());
		}
	}); //오름차순 정렬
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	#list {
		width: 800px;
		margin: 30px 0; 
	}
	#list > div {
		float: left;
		border: 1px solid #999;
		margin: 15px;
		width: 126px;
		height: 126px;
		background-size: contain;
		background-repeat: no-repeat;
		background-position: center center;
		position: relative;
		left: 0;
		top: 0;
	}
	
	#list > div > span {
		font-size: 1.5em;
		position: absolute;
		right: 6px;
		top: 0px; 
		cursor: pointer;
		display: none;
	}
	
	#list::after {
		content: '';
		display: block;
		clear: both;
	}
	#list > div:hover > span {
		display: inline;
	}
	
	/* #list > div > img {
		width: 126px;
		height: 126px;
	} */  

	.modal-body img {
		display: block;
		margin: 15px auto;
		
		
		/* 	width : 고정 크기 
			max-width : 작을 땐 객체 크기, 클땐 최대 지정
			min-width : 클 땐 객체 크기, 작을 땐 지정 크기 
		*/
		max-width: 560px;
	}
	
	#exampleModal .modal-dialog {
       -webkit-transform: translate(0,-50%);
       -o-transform: translate(0,-50%);
       transform: translate(0,-50%);
       top: 50%;
       margin: 0 auto;
   }
</style>
</head>
<body>
	
	<div class="container">
		<h1>Image Gallery</h1>
		
		<div id="list">
		
			<% for (File img : list) { %>
			<%-- <img src="images/<%= img.getName() %>"> --%>
			<div style="background-image:url(images/<%= img.getName() %>);" data-toggle="modal" data-target="#exampleModal" onclick="showImage('<%= img.getName() %>');"> 
				<span title="delete" onclick="deleteImage('<%= img.getName() %>');">&times;</span>
			</div>
			<% } %> 
		</div> 

		<form method="POST" action="ex20_file_ok.jsp" enctype="multipart/form-data">
			<table class ="table table-bordered">
				<tr>
					<th>이미지</th>
					<td><input type="file" name="attach" required></td>
				</tr>
			</table>
			
			<div>
				<input type="submit" value="이미지 업로드" class="btn btn-success">
			</div>
		</form>
	</div>

	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-xl">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <img src="images/1.png">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
		function showImage(img) {
			//alert(img);
			$('.modal-body > img').attr('src', 'images/' + img);
			$('#exampleModalLabel').text(img);
		}
		function deleteImage(img) {
			location.href = 'ex20_file_delete.jsp?filename=' + img;
			
			if(confirm('delete?')) {
				location.href = 'ex20_file_delete.jsp?filename=' + img;
			}
			
			event.stopPropagation();
			
		}
	</script>
	
</body>
</html>