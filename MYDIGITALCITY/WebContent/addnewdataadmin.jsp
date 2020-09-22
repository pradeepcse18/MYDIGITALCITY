<html>
<div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
             </div>
        
       
        
        
      <p> EMAIL : <%= ((String)session.getAttribute("email"))%> 
        
       
      <form action="AInsertNewData" method="post" enctype="multipart/form-data">
      
      
      <table  align="center" style="margin-top:100px; border-spacing: 15px; ">
      <caption style="font-family:times new roman; font-style: italic; font-size:x-large;color:white;">ADD NEW DETAILS</caption>
      
       <tr> 
     <th>
      COUNTRY
      </th>
            <td >
<select required="required" name="country" class="countery order-alpha" id="countryId"  style="font-size: 17px; padding: 2px; width:405px;">
    <option value="IN" selected="selected">INDIA</option>
    
</select>
  </td>
        </tr>
     <tr> 
     <th>
      STATE
      </th>
            <td >
<select name="state" class="states order-alpha" id="stateId"  style="font-size: 17px; padding: 2px; width:405px;">
    <option value="">Select State</option>
</select>
  </td>
        </tr>

  <tr>
  <th>
      CITY
      </th>
            <td >
<select name="city" class="cities order-alpha" id="cityId"  style="font-size: 17px; padding: 2px; width:405px;">
    <option value="">Select City</option>
</select>
 </td>
        </tr>
       

											
	 	<tr>
	 	<th>
      CATEGORY
      </th>
			<td >
			
					<select required name="category" id="category"  style="font-size: 17px; padding: 2px; width:405px;">
	               <option value="">Select Category </option>
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
      <th>
      NAME
      </th>
      <td>
      <input type="text" name="name" size="31px" placeholder="" required>
      </td>
      </tr>
      
       <tr>
      <th>
       WEBSITE
      </th>
      <td>
     <input type="text" name="website" size="31px" placeholder=""  required>
      </td>
      </tr>
       
       <tr>
      <th>
      ADDRESS
      </th>
      <td>
       <input type="text" name="address"  size="31px" placeholder="" required>
      </td>
      </tr>
     
       <tr>
      <th>
        CONTACT
      </th>
      <td>
    <input type="number" name="contact" id="Contact" size="60px" placeholder=""  style="width:405px" required>
      </td>
      </tr>
      
       <tr>
      <th>
      EMAIL
      </th>
      <td>
      <input type="email" name="email" size="31px" placeholder=""  required>
      </td>
      </tr>
      
     
  
      
      <tr>
      <th>
      IMAGE
      </th>
      <td>
      <input type="file" name="photo" style="width:405px" placeholder="Upload the Image"  required="required"/>
      </td>
      </tr>
      
      
     
      
     
      
     
 
      
      </table> <br>
      <input type="hidden" name="uploadby" value="<%= ((String)session.getAttribute("email"))%>">
      
      <input type="submit" value="submit" onclick="return Validate()" style="width:405px; margin-left: 480px; " placeholder=""  required>
        
        
       </form>  
        
        
        <script type="text/javascript">
    function Validate() {
       
        var Contact = document.getElementById("Contact").value.toString().length;
        
      
       if((Contact<10) ||(Contact>12))
    	   {
    	   alert("Please enter the correct Contact No ");
    	   return false;
    	   }
        return true;
    }
    </script>
        
        
        
        
        
        
        
        
        
         
    <div id="footer1"  style="margin-top:100px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>