<html>
<div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>
        
     
        
         <p>  EMAIL : <%= ((String)session.getAttribute("email"))%> 
        
       
      <form action="EditData.jsp" method="post">
      
      
    
      <table  align="center" style="margin-top:100px; border-spacing: 15px; ">
      <caption style="font-family:times new roman; font-style: italic; font-size:x-large;color:white;">EDIT THE DETAILS</caption>
      
       <tr> 
     <th>
      COUNTRY
      </th>
            <td >
<select required="required" name="country" class="countery order-alpha" id="countryId"  style="font-size: 17px; padding: 2px; width:405px;">
    <option value="IN" selected="selected">Select Country</option>
    <option value="IN" >India</option>
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
	               <option value="">Select Category</option>
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
				
    
      
     
 
      
      </table> <br>
      <input type="hidden" name="uploadby" value="<%= ((String)session.getAttribute("email"))%>">
      
      <input type="submit" value="submit" style="width:405px; margin-left: 480px; " placeholder=""  required>
        
        
       </form>  
        
        
        
        
        
        
        
            
    <div id="footer1"  style="margin-top:200px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>