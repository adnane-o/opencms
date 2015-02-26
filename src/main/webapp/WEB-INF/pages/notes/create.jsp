<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layouts/dashboard.header.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
            </li>
            <li class="active">Notes</li>
            <li class="active">${action} note</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${action} note</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-9">
            <form:form role="form" commandName="note" method="post">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="form-group">
                        <label>Title</label>
                        <form:input cssClass="form-control" path="title" placeholder="Title"/>
                            <%--<input  placeholder="Title">--%>
                    </div>

                    <div class="form-group">
                        <label>Content</label>
                        <form:textarea cssClass="form-control" path="content" placeholder="Content ..."
                                       type="textarea" rows="5"/>

                            <%--<textarea class="form-control" rows="3"></textarea>--%>
                    </div>
                        <%--<div class="form-group">--%>
                        <%--<label>Cover image</label>--%>
                        <%--<input type="file">--%>

                        <%--<p class="help-block">Example block-level help text here.</p>--%>
                        <%--</div>--%>

                    <div class="form-group">
                        <label>Categories</label>

                        <div class="checkbox">
                            <c:forEach items="${categories}" var="category" varStatus="loopStatus">
                                <label>
                                    <c:choose>
                                        <c:when test="${note.categories.contains(category)}">
                                            <form:checkbox path="categories[${loopStatus.index}].id"
                                                           value="${category.id}" checked="checked"/>
                                        </c:when>
                                        <c:otherwise>
                                            <form:checkbox path="categories[${loopStatus.index}].id"
                                                           value="${category.id}"/>
                                        </c:otherwise>
                                    </c:choose>
                                        ${category.name}
                                </label>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Comments</label>

                        <div class="radio">
                            <label>
                                <form:radiobutton path="commentsState" value="true"/>Yes
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <form:radiobutton path="commentsState" value="false"/>No
                            </label>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div class="col-lg-3">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>Public</label>

                            <div class="radio">
                                <label>
                                    <form:radiobutton path="published" value="true"/>Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="published" value="false"/>No
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-primary pull-right">${action}</button>
                            <a href="/post/${note.id}/delete" class="btn btn-danger">Remove</a>
                        </div>
                    </div>

                </div>
            </div>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Old versions
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <c:forEach items="${note.oldVersions}" var="note">
                                <tr>
                                    <td>
                                            ${note.date}
                                    </td>
                                    <td>
                                        <a href="/note/${note.id}/restore">View</a>
                                    </td>
                                </tr>
                            </c:forEach>
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
