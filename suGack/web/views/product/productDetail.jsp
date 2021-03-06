<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 자세히 보기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	.navdiv{
		height:200px;
		background:black;
	}
	
	.container{
		background:yellow;
	}
	
	.productDiv{
		background:beige;
		padding:15px;
		
	}
	.img{
		float:left;
		padding:20px;
		width:430px;
		background:green;
	}
	img{
		width:400px;
	}
	.qnaArea {
		border:2px solid lightgray;
		margin: 20px 0px 20px 0px;
		box-shadow:2px 2px lightgray;
		width:80%;
		height:100%;
		background:beige;
		margin:0 auto;
		margin-top:20px;
	}
	.qnaTitle {
		border-bottom:1px solid lightgray;
		margin: 20px 0px 20px 0px;
		padding-left:20px;
	}
	.qnaContents {
		margin: 20px 0px 20px 0px;
		padding-left:20px;
		padding-right:20px;
		
	}
	.qnaContents div{
		margin: 20px 0px 20px 0px;
	}
	
	.qna{
		height:40px;
	}
	
	#qnaBtn{
		width:30%;
		padding:5px;
		color:white;
		border:2px solid gray; 
		background:gray;
		
		
	}
	
	
/* .shortInfo{
	margin-left:40px;
	width:400px;
	height:550px;
	padding:25px;
	margin-right:100px;
	background:white;
	margin-top:23px;
} */

hr{
	border:1px solid gray;
}

.totalPrice{
	/* margin-top:10px;
	
	float:right; */
	width:100%;
	height:50px;
	border:1px solid black;
	margin-top:15px;
	margin-bottom:15px;
	/* background:orange; */
	}
.totalPrice>h4{
	
	margin-top:15px;
}
input[type:image]{
	border:1px solid black;
} 

.information{
	padding:30px;
}
</style>
</head>
<body>
<div class="navdiv">
 
</div> 
  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-6 " >
        <img class="img-fluid rounded mb-4 mb-lg-0" src="../images/tvxq.jpg" style="width:100%;">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-6 productDiv">
        <!-- <h1 class="font-weight-light">Business Name or Tagline</h1>
        <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it makes a great use of the standard Bootstrap core components. Feel free to use this template for any project you want!</p>
        <a class="btn btn-primary" href="#">Call to Action!</a> -->
        <h5>품명 및 모델명</h5>
			<h5>기본가격</h5>
			<hr>
			<h5>배송비:3000원</h5>
			<hr>
			<h5>옵션선택</h5>
			<select id="sel1"style="width:350px; height:20px;">
				<option value=""  selected>옵션을 선택해주세요.</option>
				<option class="sel" value="op1" id="op1">옵션1</option>
				<option class="sel" value="op2">옵션2</option>
			</select>
			<select id="sel2"style="width:350px; height:20px;">
				<option value=""  selected>옵션을 선택해주세요.</option>
				<option class="sel" value="op1" id="op1">옵션1</option>
				<option class="sel" value="op2">옵션2</option>
			</select>
			<hr>
			<div class="selectOpt" style="width:100%; height:80px; background:white; margin-top:70px;">	
			</div>
			<div class="totalPrice">
				<p style="float:left; margin-top:10px; font-size:20px;">총가격: </p>
				<p style="float:right; margin-top:10px; font-size:20px;">10000원</p>
			</div>
			<div class="btns" style="margin-top:5px;">
			<button style="color:white; float:left;width:70px; height:50px; border:2px solid pink; background:pink; border-radius:7px; font-size:33px;">♡</button>
			<!-- <input type="image" src="../images/heart.png" style="width:80px; height:50px; border:2px solid pink; background:pink; border-radius:7px;"> -->
			<input type="image" src="../images/shopping-basket.png" style="width:70px; margin-left:5px;height:50px; border:2px solid lightblue; background:lightblue; border-radius:7px;">
			<!-- <input type="submit" value="구매하기" style="float:right; font-size:15px;width:170px; height:50px; color:white;border:2px solid gray; background:gray; border-radius:7px;"> -->
			<button class="all-btn"style="float:right; font-size:15px;width:170px; height:50px;/*  color:white;border:2px solid gray; background:gray; */ border-radius:7px;"
					id="purchase">구매하기</button>
				
			
			</div>
	  </div>
	 </div>
	 <hr>
	<div class="row information">
	<ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#menu0">기본정보</a></li>
    <li><a data-toggle="tab" href="#menu1">배송/판매/교환/환불</a></li>
    <li><a data-toggle="tab" href="#menu2">별점 및 응원글</a></li>
    <li><a data-toggle="tab" href="#menu3">문의</a></li>
 	 </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>기본정보</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>배송/판매/교환/환불</h3>
      <p>Ut enim minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>별점 및 응원글</h3>
      
      <div class="star" style="background:beige;  padding:10px; width:100%; height:150px;">
      <form id="review" action="<%=request.getContextPath() %>/insertReview.bo" method="post">
      	<textarea style="width:100%; height:80px;" name="content"></textarea>
      	<select name="star" style="float:left; width:200px; height:40px;">
      		<option value="★★★★★">★★★★★ 아주좋아요</option>
      		<option value="★★★★☆">★★★★☆ 마음에 들어요</option>
      		<option value="★★★☆☆ ">★★★☆☆ 보통이에요</option>
      		<option value="★★☆☆☆">★★☆☆☆ 그냥그래요</option>
      		<option value="★★☆☆☆">★★☆☆☆ 별로에요</option>
      	</select>
      	<input type="submit" id="registar" value="리뷰등록하기" style=" float:right; width:150px; height:40px; background:gray; color:white; border:1px solid gray;">
       <!--  <button style=" float:right; width:150px; height:40px; background:gray; color:white; border:1px solid gray;">리뷰등록하기</button> -->
      </form>
      </div>
      
      <script>
      	$(function(){
      		
      	})
      </script>
      <!-- <div class="row">
      	<div class="outer" style="border:1px solid black;">
      	<div class="nick">
     		<label>닉네임</label>
      	</div>
      	<div class="date">
      		<label>2019년 4월 5일</label>
      	</div>
      	<div>내용</div>
      	</div>
      </div> -->
    </div>
    
    <div id="menu3" class="tab-pane fade">
    
    
    			<form id="qna" action="<%=request.getContextPath() %>/insertProQna.bo" method="post">
   					 <div class="qnaArea">
							<div class="qnaTitle">
								<h2>문의하기!</h2>
							</div>
							<div class="qnaContents">
									<table class="searchBox" style="width:100%;" >
										<tr class="qna">
											<td><label >문의 제목:</label></td>
											
											<!-- <td><input type="text" name="title" style="width:100%;"></td> -->
											<td>
												<select name="category" style="width:100%;">
													<!-- <option value="10" id="product">상품문의</option>
													<option value="20" id="delivery">배송문의</option>
													<option value="30" id="change">교환/환불문의</option>
													<option value="40" id="etc">기타문의</option> -->
													
													<option value="상품문의" id="product">상품문의</option>
													<option value="배송문의" id="delivery">배송문의</option>
													<option value="교환/환불문의" id="change">교환/환불문의</option>
													<option value="기타문의" id="etc">기타문의</option>
												</select>
											</td>
											
										</tr>
										<!-- <tr class="qna">
											<td><label >작성자:</label></td>
											<td><input type="text" name="writer"
												style="width: 100%;"></td>
										</tr> -->
										<!-- <tr class="qna">
											<td><label>작성일:</label></td>
											<td><input type="text" name="writeDate"
												style="width: 100%;"></td>
										</tr> -->
										<tr class="qna">
											<td><label>내용:</label></td>
											<td><textarea name="content" style="width:100%;" rows="7"></textarea></td>
										</tr>
										<tr class="qna">
											<td colspan="2"><input type="submit" name="writeBtn"value="작성하기" id="qnaBtn" style="float:right;"></td>
										</tr>
									</table>
								
								</div>
							</div>
							
						</form>
   
  </div>
  <!--   <div id="menu3" class="tab-pane fade">
      <h3>문의</h3>
      	<form id="question" method="post">
      <div class="quest" style="border:1px solid black;background:beige;padding:20px; width:60%; height:200px";>
            <table align="center">
               <tr>
                  <td>제목 </td>
                  <td colspan="3">
                    <input type="text" size="50" name="title">
                  </td>
               </tr>
           
               <tr>
                  <td>작성자 </td>
                  <td>
                    <input type="text" size="50" name="writer" >
                  </td>
               </tr>
               <tr>
                  <td>작성일</td>
                  <td>
               		<input type="date" name="date"  style="width:395px;">
              	  </td>
               </tr>
               <tr>
                  <td>내용 </td>
                  <td>
                 	<textarea name="content" style="width:395px;"></textarea>
                 	
                  </td>
               </tr>
               
            </table>
            <br>
            <div align="center">
               <button onclick="complet();">작성완료</button>
               <button onclick="deleteNotice();">삭제하기</button>
            </div>
      	</form>
      </div>
     -->
  </div>
  </div>
    
      <!-- /.col-md-4 -->
    
</div>

<script>
	$(function(){
		
		 
		 //최선
		    $("#sel1").change(function(){
				$(".selectOpt").append($("#sel1 option:selected").text());
		 });
		
		    $("#sel2").change(function(){
				$(".selectOpt").append($("#sel2 option:selected").text());
		 });
				 
		 //최선12
		  /* $("#sel1").change(function(){
				$(".selectOpt").append($("#sel1 option:selected").text());
		 })   */
		
		 
		
		 
	});
</script>
<!-- <div class="container">
  <div class="row">
	<div class="proDiv">
		<div class="img col-sm-5">
			<img src="../images/tvxq.jpg">
		</div>
		<div class="col-sm-2"></div>
		<div class="shortInfo col-sm-5">
			<h5>품명 및 모델명</h5>
			<h5>기본가격</h5>
			<hr>
			<h5>배송비:3000원</h5>
			<hr>
			<h5>옵션선택</h5>
			<select style="width:350px; height:20px;">
				<option value="op1">옵션1</option>
				<option value="op2">옵션2</option>
			</select>
			<select style="width:350px; height:20px;">
				<option value="op1">옵션1</option>
				<option value="op2">옵션2</option>
			</select>
			<hr>
			<div class="selectOpt" style="width:350px; height:100px; background:black; margin-top:70px;">	
			</div>
			<div class="totalPrice">
				<h4>총가격:</h4>
				<p style="float:right; margin-top:-30px; font-size:15px;">10000원</p>
			</div>
		</div>
	  </div>
	</div>
  </div> -->
<script>
	$("#purchase").click(function(){
		console.log("test");
		location.href="../common/purchase.jsp";
	});
</script>
</body>
</html>