<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layouts/dashboard.header.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
            </li>
            <li class="active">Categories</li>
            <li class="active">${action} category</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${action} category</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-9">
            <form:form role="form" commandName="category" method="post">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="form-group">
                        <label>Name</label>
                        <form:input cssClass="form-control" path="name" placeholder="Name"/>
                    </div>
                </div>

            </div>

        </div>
        <div class="col-lg-3">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <button type="submit" class="btn btn-primary pull-right">${action}</button>
                        <a href="/category/${category.id}/delete" class="btn btn-danger">Remove</a>
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
