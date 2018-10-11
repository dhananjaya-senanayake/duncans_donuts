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
        <h1 class="msg">Duncan's Donuts Orders More Info Order Id : ${order.orderId}</h1>
        <br>
        
        <c:if test="${empty order}">

            <h4 class='error'>No Matching Order found for Order ID : ${orderId} to be Displayed</h4>

        </c:if>
        
        <c:if test="${not empty order}">
            <table class="warning" style="margin-left: 50px;padding-top: 20px;padding-bottom: 20px;">
                <tbody>
                    <c:if test="${not empty message}">
                        <tr colspan="3" class="msg">
                            <td style="text-align: center" >${message}</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Order Date</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.orderDate}"/></td>
                    </tr>
                    <tr>
                        <td>Order Time</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.orderTime}"/></td>
                    </tr>
                    <tr>
                        <td>Order Due Date</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.orderDueDate}"/></td>
                    </tr>
                    <tr>
                        <td>Order Status</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td>
                            <form action=<c:url value="/admin/updateOrderStatus"/> method="post">
                            <select name="orderStatus">
                                <option value="Pending" ${order.orderStatus == 'Pending' ? 'selected' : ''} ${order.orderStatus == 'In Progress' || order.orderStatus == 'In Delivery'?'disabled':'' }>Pending</option>
                                <option value="In Progress" ${order.orderStatus == 'In Progress' ? 'selected' : ''} ${order.orderStatus == 'In Delivery' ? 'disabled' : ''}>In Progress</option>
                                <option value="In Delivery" ${order.orderStatus == 'In Delivery' ? 'selected' : ''}>In Delivery</option>
                            </select>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="orderId" value="${order.orderId}"/>
                            <input type="submit" value="Change"/>
                            <form>
                        </td>
                    </tr>
                    <tr>
                        <td># of Cake Donuts</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.noOfCakeDonuts}"/></td>
                    </tr>
                    <tr>
                        <td># of Glazed Donuts</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.noOfGlazedDonuts}"/></td>
                    </tr>
                    <tr>
                        <td>Sub Total</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.subTotal}"/></td>
                    </tr>
                    <tr>
                        <td>Tax</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.tax}"/></td>
                    </tr>
                    <tr>
                        <td>Total </td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.total}"/></td>
                    </tr>
                    <tr>
                        <td rowspan="5">Address</td>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.houseNumber}"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.street}"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.city}"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.state}"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;:&nbsp;</td>
                        <td><c:out value="${order.zipCode}"/></td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        

<br>
<h4><a href="<c:url value='/admin/viewOrders/update' />" > Back</a></h4>
</body>
</html>
