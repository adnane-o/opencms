<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layouts/guest.header.jsp"/>
<div class="col-sm-8 col-sm-offset-2 col-lg-8 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">Home</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Posts</h1>
        </div>
    </div>
    <!--/.row-->


    <c:forEach items="${posts}" var="post">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="/post/${post.id}">${post.title}</a> |
                        By: ${post.author.nickname} |
                        <c:forEach items="${post.categories}" var="category" varStatus="loop">
                            <a href="#" class="small">${category.name}</a> <c:if test="${!loop.last}">, </c:if>
                        </c:forEach>
                        <span class="label label-primary pull-right">${post['class'].simpleName}</span>

                    </div>

                    <div class="panel-body">
                        <div>
                            <c:if test="${post['class'].simpleName.equals('Note')}"><h1></c:if>
                                ${post.content}
                            <c:if test="${post['class'].simpleName.equals('Note')}"></h1></c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.row-->
    </c:forEach>


    <jsp:include page="../partials/pagination.jsp"/>


</div>
<!--/.main-->
<jsp:include page="../layouts/guest.footer.jsp"/>