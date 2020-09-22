<!DOCTYPE html>
<html>
	<head>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
   <script src="//geodata.solutions/includes/statecity.js"></script>
				
   </head>





<body>
 
   <form id="formname" name="formname" method="post" action="Display.jsp" >
    <input type="hidden" name="country" id="countryId" value="IN" style="font-size: 17px; padding: 2px; width:200px;"/>
         <table style="border-spacing: 25px; border:2px solid white  ">
       <caption style="font-family: cursive; font-size:25px;">SEARCH HERE</caption>
<tr>
<td>
<select required="required" name="country" class="countery order-alpha" id="countryId"  style="font-size: 17px; padding: 2px; width:200px;">
    <option value="" >Select Country</option>
    <option value="IN" >India</option>
</select>
</td>
</tr>
  <tr>
            <td >
<select name="state" class="states order-alpha" id="stateId" style="font-size: 17px; padding: 2px; width:200px;">
    <option value="">Select State</option>
</select>
  </td>
        </tr>

  <tr>
            <td >
<select name="city" class="cities order-alpha" id="cityId" style="font-size: 17px; padding: 2px; width:200px;">
    <option value="">Select City</option>
</select>
 </td>
        </tr>
       

											
	 	<tr>
			<td >
					<select required name="category" id="category" style="font-size: 17px; padding: 2px; width:200px;">
	               <option value="">Searching For </option>
	               <option value="College">College</option>
	               <option value="Coaching Center">Coaching Center</option>
	               <option value="Hospital">Hospital</option>
	               <option value="Hotel">Hotel</option>
	               <option value="Tourist place">Tourist place</option>
	               <option value="Cinema">Cinema</option>
	               <option value="Bus Station">Bus Station</option>
	               <option value="Book Store">Book Store</option>
	                </select>	
			</td>
		 </tr>
				
		<tr>
				<td align="center">
				<input type="submit" style="font-size: 20px;padding: 2px;" value="SUBMIT" />
				</td>
		</tr>
				
				
		</table>		
			
	</form>
		
</body> 
</html>