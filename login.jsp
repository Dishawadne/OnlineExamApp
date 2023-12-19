<html>

<head>

<link href="/css/common.css" rel="stylesheet">


		<style>
				input,select
				{
						padding:10px;
				}
				
				
		</style>

<script>

	sessionStorage.setItem("duration",1210);
	
</script>

</head>


<body>

	<span style="color:red">  ${message} </span>
		
<form>

<h1 style="text-align: center;color:red;margin-bottom:100px;"> Online Exam Login </h1>


<div id="maincontent">

	<input type="text" name="username" placeholder="Enter username"> <br><br>
	
	<input type="password" name="password" placeholder="Enter password"> <br><br>
	
	
	<select name="subject"> 
			
		<option>select subject</option>
		<option>java</option>
		<option value="gk">general knowldge</option>
		
	</select>
	
	<br><br>
	
	
	<input type="submit" value='sign in' formaction="validate" formmethod="post" class="btn">
	
    <input type="submit" value='sign up' formaction="register" class="btn">
    
    
</div>		

</form>

</body>

</html>