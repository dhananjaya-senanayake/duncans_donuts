<%-- 
    Document   : hello
    Created on : Nov 14, 2016, 8:12:52 AM
    Author     : senanayake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Duncan's Donuts</title>
        <style>
            a{
                text-decoration: none;
            }

            a:hover{
                font-size: 20px;
                color: deeppink;
            }

            li{
                margin-top: 40px;
            }
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            } 

            .warning {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #9f6000;
                background-color: #feefb3;
                border-color: #bce8f1;
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
        </style>
    </head>
    <div>
        <h1 class="msg" style='text-align: center;font-size: 50px;'>Duncan's Donuts</h1>
    </div>

    <a href="<c:url value="/login" />" > Login</a></h2>

</html>
