<%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 08/05/15
  Time: 15.42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>join us</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/personal.css"/>

</head>
<body>
<div class="row">
    <div id="contenitoreForm" class="container col-md-offset-4 col-md-4">
        <form class="form">
            <div class="form-group">
                <label for="name">Name</label>
                <h:inputText id="name"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <h:inputText id="lastName"/>
            </div>
            <div class="form-group">
                <label for="birthDate">BirthDate</label>
                <h:inputText id="birthDate" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <h:inputText id="email" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
            <h:commandButton value="Submit" styleClass="btn btn-primary" action="#{customeControllerBean.createCustomer}"/>

        </form>
    </div>
</div>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>