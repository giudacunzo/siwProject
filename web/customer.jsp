<%--
  Created by IntelliJ IDEA.
  User: gabbo
  Date: 12/05/15
  Time: 17.13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<html>
<head>
  <title></title>
</head>
<body>
<f:view>

  <h:form styleClass="form">
    <h:commandButton value="Submit" styleClass="btn btn-primary" action="#{customerController.getCustomer(\"bbb\")}"/>
  </h:form>
  <p>${customerController.cust.name}</p>
  <p>${customerController.cust.lastname}</p>
  <p>${customerController.cust.email}</p>
</f:view>
</body>
</html>
