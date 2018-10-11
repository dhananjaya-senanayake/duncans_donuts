<%-- 
    Document   : login
    Created on : Nov 14, 2016, 3:05:51 PM
    Author     : senanayake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
                background-color: #feefb3;
            }
            
            .warning {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #000;
                background-color: #feefb3;
                border-color: #bce8f1;
            }
            td{
                width: 150px;
            }
        </style>
    </head>
    <body onload='document.loginForm.username.focus();'>

        <h1 style="text-align: center" class='msg'>Duncan's Donuts</h1>

        <div id="login-box" class="warning">

            <h2>Login</h2>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name='loginForm'
                  action="<c:url value='j_spring_security_check' />" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='j_username' id='j_username' value=''></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='j_password' id='j_password' /></td>
                    </tr>
                    <tr>
                        
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <input name="submit" type="submit" value="submit" />
                        </td>
                        <td style="text-align: center">
                            <input name="reset" type="reset" value="&nbsp;&nbsp;Clear&nbsp;&nbsp;" />
                        </td>
                    </tr>
                </table>

                <input type="hidden"
                       name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>

    </body>
</html>
