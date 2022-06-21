<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<style>
      #tbl {
          border: 1px solid #999;
          border-collapse: collapse;
      }
      #tbl th, #tbl td {
          border: 1px solid #999;
          padding: 15px;
          
      }
      #tbl input[type=number] {
      	width: 100px;
      }
      #tbl input[type=range] {
      	width: 100%;
      }
      #box {
      	display: none;
		border: 1px solid #DDD;
		border-radius: 2px;
      	background-color: #EEE;
      	margin: 10px 0;
      	padding: 20px;
      }
      #box input {
 		width: 100px;  
 		margin: 10px;  
      }
      #btn {
      	margin-top: 10px;
      	background-color: cornflowerblue;
      	color: white;
      	padding: 10px;
      	border: 0px;
      	border-radius: 3px;
      }
</style>
</head>
<body>
	
    <h1>버튼 만들기</h1>
    <form method="POST" action="ex11_ok.jsp">
	    <table id="tbl">
	        <tr>
	            <th width="100px">너비(px)</th>
	            <td width="400px"><input type="number" name="width"></td>
	        </tr>
	        <tr>
	            <th>높이(px)</th>
	            <td><input type="number" name="height"></td>
	        </tr>
	        <tr>
	            <th>텍스트</th>
	            <td><input type="text" name="txt"></td>
	        </tr>
	        <tr>
	            <th>배경색</th>
	            <td>
	                <input type="color" name="bgcolor">
	            </td>
	        </tr>
	        <tr>
	            <th>글자색</th>
	            <td><input type="color" name="color"></td>
	        </tr>
	        <tr>
	            <th>글자 크기(px)</th>
	            <td><input type="number" name="fontsize"></td>
	        </tr>
	        <tr>
	            <th>버튼 개수(ea)</th>
	            <td><input type="number" name="num" min="0"></td>
	        </tr>
	        <tr>
	            <th>버튼 간격</th>
	            <td>
	                좌우 간격:<input type="range" name="marginleft">
	                상하 간격:<input type="range" name="margintop">
	            </td>
	        </tr>
	        <tr>
	            <th>아이콘</th>
	            <td>
	                <input type="radio" name="icon" value="" checked>없음
	                <input type="radio" name="icon" value="🍎">🍎
	                <input type="radio" name="icon" value="🌳">🌳
	                <input type="radio" name="icon" value="😊">😊
	                <input type="radio" name="icon" value="☕">☕
	            </td>
	        </tr>
	        <tr> 
	            <th>테두리</th>
	            <td>
	                <select name="sel" id="sel">
	                    <option value="감추기" name="감추기" selected>감추기</option>
	                    <option value="보이기" name="보이기">보이기</option>
	                </select>
	                <div id="box">
	                	두께(px): <input type="number" name="thick"><br>
	                	색상: <input type="color" name="bcolor"><br>
	                	스타일: 
	                	<select name="style">
	                		<option value="solid">실선</option>
	                		<option value="dashed">쇄선</option>
	                		<option value="dotted">점선</option>
	                	</select><br>
	                	모서리(px): <input type="number" name="radius"><br>
	                </div>
	            </td>
	        </tr>
	    </table>
	    <input type="submit" value="만들기" id="btn">
    </form>

	<script>
		$('#sel').click(function(evt){
			
			
			if (evt.target.value == "보이기"){
				$('#box').css('display', 'block');
			} else {
				$('#box').css('display', 'none');
			}
			
		});
		
	</script>
</body>
</html>