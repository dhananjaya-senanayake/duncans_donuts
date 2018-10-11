<%-- 
    Document   : admin
    Created on : Nov 14, 2016, 8:14:59 AM
    Author     : senanayake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
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
    <body>
        <div>
            <div>
                <h1 class="msg" style='text-align: center;font-size: 50px;'>Duncan's Donuts</h1>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div style='height: 70px' class="warning">
                    <div style='float: left'>
                        <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
                    </div>
                    <div style="float: right">
                        <h2><a href="javascript:formSubmit()"> Logout</a></h2>
                    </div>
                </div>
            </c:if>

            <div style="margin-left: 200px;display: block;float:left">
                <h3>Order Management</h3>
                    <ul>
                        <li>
                            <a href="<c:url value="/admin/searchOrder" />">Search Order</a>
                        </li>
                        <li>
                            <a href="<c:url value="/admin/viewOrders/update" />">Change Order Status</a>
                        </li>
                        <li>
                            <a href="<c:url value="/admin/viewOrders/info" />">View Orders</a>
                        </li>
                        <li>
                            <a href="<c:url value="/admin/viewOrders/delete" />">Remove Orders</a>
                        </li>
                    </ul>
                    
                
            </div>
            <div style="margin-left: 200px;display: block;float:left">
                <h3>Feedback Message Management</h3>
                    <ul>
                        <li>
                            <a href="<c:url value="/admin/viewMessages/info" />">View Feedback Messages</a>
                        </li>
                        <li>
                            <a href="<c:url value="/admin/viewMessages/delete" />">Remove Feedback Messages</a>
                        </li>
                    </ul>
                    
                
            </div>
        </div>
        
        <c:url value="/j_spring_security_logout" var="logoutUrl" />

        <!-- csrt support -->
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        
        
    </body>
</html>
