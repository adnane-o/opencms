<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layouts/dashboard.header.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
            </li>
            <li class="active">Users</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Users</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="panel-body">
                    <form role="search">
                        <div class="form-group col-md-offset-9 col-md-3">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                    </form>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Email</th>
                            <th>Name</th>
                            <th>Nickname</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <th scope="row">
                                    <a href="/user/${user.id}/update">${user.id}</a>
                                </th>
                                <td>
                                    <a href="/user/${user.id}/update">
                                            ${user.email}
                                    </a>
                                </td>
                                <td>
                                        ${user.name}
                                </td>
                                <td>
                                        ${user.nickname}

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <jsp:include page="../partials/pagination.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layouts/dashboard.footer.jsp"/>

