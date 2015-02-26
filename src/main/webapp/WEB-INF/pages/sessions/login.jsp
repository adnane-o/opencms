<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layouts/guest.header.jsp"/>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">Log in</div>
            <div class="panel-body">
                <form role="form" action="j_spring_security_check" method="post">
                    <fieldset>
                        <c:if test="${not empty error}">
                            Your Login was unsuccessful. <br/>
                        </c:if>

                        <div class="form-group">
                            <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password"
                                   value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Login">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <!-- /.col-->
</div>
<!-- /.row -->

<jsp:include page="../layouts/guest.footer.jsp"/>
