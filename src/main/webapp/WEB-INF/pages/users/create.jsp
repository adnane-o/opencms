<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../layouts/guest.header.jsp"/>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <h1>
                <div class="panel-heading">
                    Register
                </div>
            </h1>
            <div class="panel-body">
                <form:form role="form" commandName="user" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label>Name</label>
                            <form:input path="name" cssClass="form-control" placeholder="Ahmed Ali" autofocus=""/>
                        </div>
                        <div class="form-group">
                            <label>Email</label>

                            <form:input path="email" class="form-control" placeholder="name@mail.com" type="email"
                                        autofocus=""/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <form:input path="password" class="form-control" placeholder="******" type="password"/>
                        </div>
                        <div class="form-group">
                            <label>Password confirmation</label>
                            <input name="password-confirmation" class="form-control" placeholder="******"
                                   type="password">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Register">
                        <a href="/login" class="btn btn-default">Login</a>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
    <!-- /.col-->
</div>
<!-- /.row -->

<jsp:include page="../layouts/guest.footer.jsp"/>
