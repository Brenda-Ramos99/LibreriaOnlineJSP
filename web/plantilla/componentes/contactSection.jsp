<%-- 
    Document   : contactSection
    Created on : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    
       <script src="jquery.js" type="text/javascript"></script>
       <script src="sweetalert2.all.min.js" type="text/javascript"></script>
       <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
       
</head>
<section class="page-section" id="contactenos">
    <div class="container">

      <!-- Contact Section Heading -->
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Contactanos</h2>

      <!-- Icon Divider -->
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>

      <!-- Contact Section Form -->
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
          <form name="sentMessage" id="contactForm" novalidate="novalidate"><div id="ocultar"></div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Nombre</label>
                <input class="form-control" id="name" type="text" placeholder="Nombre" required="required" data-validation-required-message="Please enter your name.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Correo Electronico</label>
                <input class="form-control" id="email" type="email" placeholder="Correo Electronico" required="required" data-validation-required-message="Please enter your email address.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Numero Telefonico</label>
                <input class="form-control" id="phone" type="tel" placeholder="Numero Telefonico" required="required" data-validation-required-message="Please enter your phone number.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Mensaje</label>
                <textarea class="form-control" id="message" rows="5" placeholder="Mensaje" required="required" data-validation-required-message="Please enter a message."></textarea>
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            <div id="success"></div>
            <div class="form-group">
                <button type="submit" name="btnEnviar" class="btn btn-primary btn-xl" id="sendMessageButton">Enviar</button>
            </div>
          </form>
          <%
          if(request.getParameter("btnEnviar") != null){
              %>
          <script>
            $(document).ready(function(){
                $('#Enviar').click(function(){
                    Swal.fire({
                        type:"info",
                        title:"Notificacion",
                        text:"Se envio correctamente su correo",
                        showCancelButton:true,
                        cancelButtonColor:"red",
                        confirmButtonColor:"green",
                    }).then(result=>{
                        if(result.value){
                            $("#ocultar").append("<input type='hidden' name='btnEnviar'>");
                            $("#contactForm").submit();
                        }
                    });
                });
            });
        </script>
          <%
          }
          %>
        </div>
      </div>

    </div>
  </section>

