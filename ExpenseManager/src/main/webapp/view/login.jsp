<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<head>
    <style>
      #loginform {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background: #f2f2f2;
      }
      #loginform h1 {
        text-align: center;
        margin: 0 0 10px 0;
      }
      #loginform input {
        box-sizing: border-box;
        width: 100%;
        margin: 10px;
        padding: 10px;
      }
      #loginform input[type=submit] {
        border: 0;
        background: #4367c4;
        color: #fff;
      }
    </style>
  </head>
 <body>
    <form  action="loginform" id="loginform">
      <h1>LOGIN</h1>
      <input type="email" placeholder="userEmail" name="userEmail" id="useremail" required/>
      <input type="password" placeholder="userPassword" name="userPassword" id="userpass" required/>
      <input type="submit" value="Sign In"/>
      <a href="openRegister">New Registration...</a>
    </form>
  </body>
</html>
