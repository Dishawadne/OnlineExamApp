
<html>

<head>

	<script>

	        function change(input)
			{
		       		input.style.color="white";
		       		input.style.background="black";
	        }
	        
    </script>
   
	
</head>
<h1> Register Page </h1>

<form enctype="multipart/form-data">
		
		<input type="text" name="username" placeholder="Enter username" onfocus="change(this)"><br><br>
		
		<input type="password" name="password" placeholder="Enter password" onfocus="change(this)"><br><br>
		
		<input type="text" name="mobno" placeholder="Enter mobno" onfocus="change(this)"><br><br>
		
		<input type="email" name="emailid" placeholder="Enter emailid" onfocus="change(this)"><br><br>
		
		<input type="file" name="image"><br><br>
		
		<input type=submit value=register formaction="saveToDB" formmethod=post>

</form>


</html>
