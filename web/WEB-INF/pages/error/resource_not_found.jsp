<%-- 
    Document   : error_bad_request
    Created on : Nov 16, 2016, 10:58:58 AM
    Author     : senanayake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Duncan's Donuts</title>
    </head>
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
    </style>
    <body>
        <h1 style="text-align: center"  class='msg'>Duncan's Donuts</h1>
        <h3 class='error'>Opps Something has Gone Wrong.......</h3>
        <br>
        <h3 class='msg'>Sorry we don't have what you expect (Resource Not Found)</h3>
        <br>
        
    </body>
</html>
