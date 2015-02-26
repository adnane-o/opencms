<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../layouts/dashboard.header.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
            </li>
            <li class="active">Users</li>
            <li class="active">${action} user</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${action} user</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-9">
            <form:form role="form" commandName="user" method="post">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="form-group">
                        <label>Email</label>
                        <form:input cssClass="form-control" path="email" placeholder="Email"/>
                            <%--<input  placeholder="Title">--%>
                    </div>

                    <div class="form-group">
                        <label>Name</label>
                        <form:input cssClass="form-control" path="name" placeholder="Name"/>
                            <%--<input  placeholder="Title">--%>
                    </div>

                    <div class="form-group">
                        <label>Nickname</label>
                        <form:input cssClass="form-control" path="nickname" placeholder="Name"/>
                            <%--<input  placeholder="Title">--%>
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <input name="password" class="form-control" placeholder="******" type="password">

                    </div>
                    <div class="form-group">
                        <label>Password confirmation</label>
                        <input name="password-confirmation" class="form-control" placeholder="******" type="password">
                    </div>
                        <%--<div class="form-group">--%>
                        <%--<label>Cover image</label>--%>
                        <%--<input type="file">--%>

                        <%--<p class="help-block">Example block-level help text here.</p>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                        <%--<label>Categories</label>--%>

                        <%--<div class="checkbox">--%>
                        <%--<c:forEach items="${categories}" var="category" varStatus="loopStatus">--%>
                        <%--<label>--%>
                        <%--<c:choose>--%>
                        <%--<c:when test="${user.categories.contains(category)}">--%>
                        <%--<form:checkbox path="categories[${loopStatus.index}].id"--%>
                        <%--value="${category.id}" checked="checked"/>--%>
                        <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                        <%--<form:checkbox path="categories[${loopStatus.index}].id"--%>
                        <%--value="${category.id}"/>--%>
                        <%--</c:otherwise>--%>
                        <%--</c:choose>--%>
                        <%--${category.name}--%>
                        <%--</label>--%>
                        <%--</c:forEach>--%>
                        <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                        <%--<label>Comments</label>--%>

                        <%--<div class="radio">--%>
                        <%--<label>--%>
                        <%--<form:radiobutton path="commentsState" value="true"/>Yes--%>
                        <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio">--%>
                        <%--<label>--%>
                        <%--<form:radiobutton path="commentsState" value="false"/>No--%>
                        <%--</label>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                </div>

            </div>

        </div>

        <div class="col-lg-3">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary pull-right">${action}</button>
                            <a href="/user/${user.id}/delete" class="btn btn-danger">Remove</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Roles
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <form:checkboxes path="roles" items="${roles}"/>
                                <%--<c:forEach items="${roles}" var="role" varStatus="loop">--%>
                                <%--<tr>--%>
                                <%--<td>${role}</td>--%>
                                <%--<td>--%>
                                <%--&lt;%&ndash;<form:checkbox path="roles[${loop.index}].authority" value="${role}"/>&ndash;%&gt;--%>
                                <%--<c:if test="${user.hasRole('role')==true}">--%>
                                <%--<form:checkbox path="roles[${loop.index}].authority"--%>
                                <%--value="${role}" checked="checked"/>--%>
                                <%--</c:if>--%>

                                <%--<c:if test="${user.hasRole(role)==false }">--%>
                                <%--<form:checkbox path="roles[${loop.index}].authority"--%>
                                <%--value="${role}"/>--%>
                                <%--</c:if>--%>

                                <%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<c:when test="">&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<form:checkbox path="roles[${loop.index}].authority"&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;value="${role}" checked="checked"/>&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;</c:when>&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<c:otherwise>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<form:checkbox path="roles[${loop.index}].authority"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;value="${role}"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</c:otherwise>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>
                                <%--</td>--%>
                                <%--</tr>--%>
                                <%--</c:forEach>--%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </form:form>
        <!-- /.col-->
    </div>
    <!-- /.row -->
</div>
<jsp:include page="../layouts/dashboard.footer.jsp"/>
