<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lumino - Dashboard</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/datepicker3.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">


    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><span>OPEN</span>CMS</a>
            <sec:authorize access="isAnonymous()">
                <ul class="user-menu">
                    <a href="/login"> <span class="glyphicon glyphicon-log-in"></span> Login </a>
                </ul>
                <ul class="user-menu">
                    <a href="/users/create"> <span class="glyphicon  glyphicon-pencil"></span> Register </a>
                </ul>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <ul class="user-menu">
                    <li class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                                class="glyphicon glyphicon-user"></span> ${user.nickname} <span
                                class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/dashboard/"><span class="glyphicon glyphicon-user"></span> Dashboard</a>
                            </li>
                            <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Profile</a>
                            </li>
                            <li><a href="<c:url value="/j_spring_security_logout" />"><span
                                    class="glyphicon glyphicon-log-out"></span> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </sec:authorize>

        </div>
    </div>
    <!-- /.container-fluid -->
</nav>
