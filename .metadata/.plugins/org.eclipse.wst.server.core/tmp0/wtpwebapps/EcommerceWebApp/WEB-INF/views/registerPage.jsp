<form action="register" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an order.</p>
    <hr>

    <label for="firstName"><b>Firstname</b></label>
    <input type="text" placeholder="Enter Firstname" name="firstName" required>

    <label for="lastName"><b>Lastname</b></label>
    <input type="text" placeholder="Enter Lastname" name="lastName" required>

	<label for="address"><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="address" required>

    <label for="contact"><b>Contact</b></label>
    <input type="text" placeholder="Enter Contact" name="contact" required>
    
    <label for="userId"><b>UserId</b></label>
    <input type="text" placeholder="Enter UserId" name="userId" required>

    <label for="orderId"><b>OrderId</b></label>
    <input type="text" placeholder="Enter OrderId" name="orderId" required>
    
	
    

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>