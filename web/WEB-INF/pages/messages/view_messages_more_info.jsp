<%-- 
    Document   : view_order_more_info
    Created on : Nov 16, 2016, 10:14:13 AM
    Author     : senanayake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Duncan's Donuts</title>
        <style>
            td{
               column-width: 200px;
               padding-left: 50px;
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
    </head>
    <body>
        <h1 class="msg">Duncan's Donuts Customer Feedbacks More Info Message Id : ${message.messageId}</h1>
        <br>
        
        <c:if test="${empty message}">

            <h4 class='error'>No Matching Message found for Message ID : ${messageId} to be Displayed</h4>

        </c:if>
        
        <c:if test="${not empty message}">
            <table class="warning" style="margin-left: 50px;padding-top: 20px;padding-bottom: 20px;">
                <tbody>
                    <tr>
                        <td>Customer Name</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${message.userName}"/></td>
                    </tr>
                    <tr>
                        <td>E Mail</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${message.userEmail}"/></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${message.messageSubject}"/></td>
                    </tr>
                    <tr>
                        <td>Content</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${message.messageContent}"/></td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        

<br>
<h4><a href="<c:url value='/admin/viewMessages/info' />" > Back</a></h4>
</body>
</html>
