<html>
<<div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>
        
       
        <p>  EMAIL : <%= ((String)session.getAttribute("email"))%> 
        
        <div style="margin:50px 400px;">
      <form action="Suggest"  method="post">
        <p><input class="w3-input w3-border" type="text" placeholder="Name" required name="Name"></p>
        <p><input class="w3-input w3-border" type="text" placeholder="Email" required name="Email"></p>
        <p><input class="w3-input w3-border" type="text" placeholder="Subject" required name="Subject"></p>
       <p><textarea class="w3-input w3-border" rows="5" placeholder="Message" required name="Message"></textarea></p>
        <p>
          <button class="w3-button w3-black"  type="submit">
            <i class="fa fa-paper-plane" ></i> SUGGEST
          </button>
        </p>
      </form>
   </div>
        
        
  
        
          
    <div id="footer1"  style="margin-top:100px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>