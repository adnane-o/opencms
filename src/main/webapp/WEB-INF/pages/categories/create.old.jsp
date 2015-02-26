<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../layouts/dashboard.header.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
            </li>
            <li class="active">Category</li>
            <li class="active">New category</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">New category</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12">
                        <form:form role="form" commandName="category" method="post">

                        <div class="form-group">
                            <label>Name</label>
                            <form:input cssClass="form-control" path="name" placeholder="Name"/>
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