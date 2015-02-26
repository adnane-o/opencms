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
            <li class="active">New note</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">New note</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12">
                        <form:form role="form" commandName="note" method="post">

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
                                    <%--<form:checkboxes path="categories" items="${categories}" itemLabel="name"--%>
                                    <%--itemValue="id"/>--%>

                                <c:forEach items="${categories}" var="category" varStatus="loopStatus">
                                    <label><form:checkbox path="categories[${loopStatus.index}].id"
                                                          value="${category.id}"/>${category.name}</label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Public</label>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="published" id="optionsRadios1" value="true"
                                           checked>Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="status" id="optionsRadios2" value="false">No
                                </label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Publish</button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- /.col-->
    </div>
    <!-- /.row -->
</div>
<jsp:include page="../layouts/dashboard.footer.jsp"/>
