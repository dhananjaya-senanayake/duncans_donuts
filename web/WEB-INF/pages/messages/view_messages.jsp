<%-- 
    Document   : view_orders
    Created on : Nov 16, 2016, 9:39:13 AM
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
                text-align: center;
            }
            th{
                text-align: center;
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
            
            .warning {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #000;
                background-color: #feefb3;
                border-color: #bce8f1;
            }
        </style>
    </head>
    <body >
        <h1 class="msg">Duncan's Donuts Customer FeedBacks</h1>
        
        <c:if test="${not empty messages}">
            <table border="1px" class="warning" style="margin-left: 50px;padding-top: 20px;padding-bottom: 20px;border-collapse: collapse">
                    <thead>
                    <th>Customer Name</th>
                    <th>Subject</th>
                    <th>Email</th>
                    <c:choose>
                        <c:when test="${option == 'info'}">
                            <th>Read Message</th>
                        </c:when>
                        <c:when test="${option == 'delete'}">
                            <th>Remove Message</th>
                        </c:when>
                    </c:choose>
                    
                </thead>
                <tbody>
                    <c:forEach items="${messages}" var="message">
                        <tr>
                            <td><c:out value="${message.userName}"/></td>
                            <td><c:out value="${message.messageSubject}"/></td>
                            <td><c:out value="${message.userEmail}"/></td>
                            <c:choose>
                                <c:when test="${option == 'info'}">
                                    <td><a href="<c:url value='/admin/viewMessagesMore/${message.messageId}' />">More Info</a></td>
                                </c:when>
                                <c:when test="${option == 'delete'}">
                                    <td><a href="<c:url value='/admin/removeMessage/${message.messageId}' />">Remove</a></td>
                                </c:when>
                            </c:choose>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
        </c:if>
        <c:if test="${empty messages}">
            <h4 class='error'>No Customer Feedbacks to be Displayed</h4>
        </c:if>
        
        <br>
        <h4><a href="<c:url value='/admin' />" > Back</a></h4>
    </body>
</html>
