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
        <h1 class="msg">Duncan's Donuts Orders</h1>
        
        <c:if test="${not empty orders}">
            <table border="1px" class="warning" style="margin-left: 50px;padding-top: 20px;padding-bottom: 20px;border-collapse: collapse">
                    <thead>
                    <th>Order Id</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Due Date</th>
                    <th>Order Status</th>
                    <th># of Cake Donuts</th>
                    <th># of Glazed Donuts</th>
                    <th>Sub Total</th>
                    <th>Tax</th>
                    <th>Total</th>
                    <c:choose>
                        <c:when test="${option == 'info'}">
                            <th>More Info</th>
                        </c:when>
                        <c:when test="${option == 'delete'}">
                            <th>Remove</th>
                        </c:when>
                        <c:when test="${option == 'update'}">
                            <th>Change Order Status</th>
                        </c:when>
                    </c:choose>
                    
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><c:out value="${order.orderId}"/></td>
                            <td><c:out value="${order.orderDate}"/></td>
                            <td><c:out value="${order.orderTime}"/></td>
                            <td><c:out value="${order.orderDueDate}"/></td>
                            <td><c:out value="${order.orderStatus}"/></td>
                            <td><c:out value="${order.noOfCakeDonuts}"/></td>
                            <td><c:out value="${order.noOfGlazedDonuts}"/></td>
                            <td><c:out value="${order.subTotal}"/></td>
                            <td><c:out value="${order.tax}"/></td>
                            <td><c:out value="${order.total}"/></td>
                            <c:choose>
                                <c:when test="${option == 'info'}">
                                    <td><a href="<c:url value='/admin/viewOrderMore/${order.orderId}' />">More Info</a></td>
                                </c:when>
                                <c:when test="${option == 'delete'}">
                                    <td><a href="<c:url value='/admin/removeOrder/${order.orderId}' />">Remove</a></td>
                                </c:when>
                                <c:when test="${option == 'update'}">
                                    <td><a href="<c:url value='/admin/viewUpdateOrderStatus/${order.orderId}' />">Change Order Status</a></td>
                                </c:when>
                            </c:choose>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
        </c:if>
        <c:if test="${empty orders}">
            <h4 class='error'>No Orders to be Displayed</h4>
        </c:if>
        
        <br>
        <h4><a href="<c:url value='/admin' />" > Back</a></h4>
    </body>
</html>
