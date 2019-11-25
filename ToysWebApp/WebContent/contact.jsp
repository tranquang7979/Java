<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ include file="top.jsp" %>
   
   <jsp:useBean id="contact" class="beans.ContactBean"></jsp:useBean>
   <jsp:setProperty property="*" name="contact"/>
   <%
   if(contact.getTitle() != null)
	   contact.createContact();
   %>
   
       <!--contact -->
      <section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
         <div class="container py-lg-5 py-md-4 py-sm-4 py-3">
            <h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Contact US</h3>
            <div class="contact-list-grid">
               <form action="./contact.jsp" method="post">
                  <div class=" agile-wls-contact-mid">
                     <div class="form-group contact-forms">
                        <input type="text" class="form-control" name="title" placeholder="Name">
                     </div>
                     <div class="form-group contact-forms">
                        <input type="email" class="form-control" name="email" placeholder="Email">
                     </div>
                     <div class="form-group contact-forms">
                        <input type="text" class="form-control" name="phone" placeholder="Phone">
                     </div>
                     <div class="form-group contact-forms">
                        <textarea class="form-control" rows="3" name="content"></textarea>
                     </div>
                     <button type="submit" class="btn btn-block sent-butnn">Send</button>
                  </div>
               </form>
            </div>
         </div>
         <!--//contact-map -->
      </section>
   
   
   <%@ include file="footer.jsp" %>