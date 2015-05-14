<%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 08/05/15
  Time: 15.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Join Us</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/personal.css"/>

</head>
<body>
<f:view>
    <div class="row">
        <div id="contenitoreForm" class="container col-md-offset-4 col-md-4">
            <h:form styleClass="form">
                <div class="form-group">
                    <h:outputLabel for="name" value="Name"/>
                    <h:inputText id="name" styleClass="form-control" label="Name" value="#{customerController.name}"
                            required="true"/>
                    <h:message for="name" styleClass="alert-danger"/>
                </div>
                <div class="form-group">
                    <h:outputLabel for="lastName" value="Last Name"/>
                    <h:inputText id="lastName" styleClass="form-control" label="Last Name" value="#{customerController.lastName}"
                            required="true"/>
                    <h:message for="lastName" styleClass="alert-danger"/>
                </div>
                <div class="form-group">
                    <h:outputLabel for="birthDate" value="BirthDate"/>
                    <h:inputText id="birthDate" styleClass="form-control" label="Birth Date" value="#{customerController.birthDate}"
                            required="true"
                            converter="javax.faces.DateTime"/>
                    <h:message for="birthDate" styleClass="alert-danger"/>
                </div>

                <div class="form-group">
                    <h:outputLabel for="email" value="Email address"/>
                    <h:inputText id="email" styleClass="form-control" label="Email" value="#{customerController.email}"
                            required="true" />
                    <h:message for="email" styleClass="alert-danger"/>
                </div>

                <div class="form-group">
                    <h:outputLabel for="password" value="Password"/>
                    <h:inputSecret id="password" styleClass="form-control" label="Password" value="#{customerController.password}"
                            required="true" />
                    <h:message for="password" styleClass="alert-danger"/>
                </div>
                <h:commandButton value="Submit" styleClass="btn btn-primary" action="#{customerController.createCustomer}"/>

            </h:form>
        </div>
    </div>
    <%--<div>--%>
    <%--<h:form>--%>
        <%--<h:commandButton value="prova" action="?#{customerControllerBean.displayCustomers}"/>--%>
    <%--</h:form>--%>
    <%--</div>--%>
</f:view>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>