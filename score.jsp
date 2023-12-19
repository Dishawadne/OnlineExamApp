
<html>

<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>

body
{
	background-color: pink;
}

table,th,td
{
	border : 1px solid green;
	//border-collapse:collapse;
	
}

td
{
	color:blue;
	
}

th
{
	color:red;
}

th,td
{
	padding:10px;
	text-align:center;
}

table
{
	margin-left : 300px;
}

</style>

</head>

<body>

<span style="color:red;font-size: 30px"> Your score is ${score} </span>

<br><br>

<table>
		<tr>
			<th>qno</th>
			<th>question</th>
			<th>submittedAnswer</th>
			<th>OriginalAnswer</th>
		</tr>
		
		<c:forEach var="answer" items="${allanswers}">
			
				<tr>
						<td>${answer.qno}</td>
						<td>${answer.qtext}</td>
						<td>${answer.submittedAnswer}</td>
						<td>${answer.originalAnswer}</td>
				</tr>
					
		</c:forEach>
		
</table>


<h1>Want to attempt exam again?</h1>

<a href="/" style="text-decoration:none;font-size:30px;">Go to Login</a>
 
 <!-- 
 href attribute needs url 
text-decoration's none value remove underline from link
 -->

</body>


</html>