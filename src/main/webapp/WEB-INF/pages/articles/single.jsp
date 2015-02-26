<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
            <h1 class="page-header">${post.title}</h1>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    ${post.title} |
                    By: ${post.author.nickname} |
                    <c:forEach items="${post.categories}" var="category" varStatus="loop">
                        <a href="#" class="small">${category.name}</a> <c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                    <span class="label label-primary pull-right">${post['class'].simpleName}</span>

                </div>

                <div class="panel-body">
                    <div><p>
                        <c:if test="${post['class'].simpleName.equals('Note')}"><h1></c:if>
                            ${post.content}
                            <c:if test="${post['class'].simpleName.equals('Note')}"></h1></c:if></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-default chat">
                <div class="panel-heading" id="accordion"><span class="glyphicon glyphicon-comment"></span> Comments
                </div>

                <div class="panel-body">
                    <ul>
                        <c:forEach items="${post.comments}" var="comment">
                            <li class="right clearfix">
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="pull-left primary-font">${comment.user.nickname}</strong>
                                        <small class="text-muted">${comment.date}</small>
                                    </div>
                                    <p>
                                            ${comment.content}
                                    </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <div class="panel-footer">
                        <form role="form" action="/post/${post.id}/comment" method="post">
                            <div class="input-group">

                                <input id="btn-input" name="content" type="text" class="form-control input-md"
                                       placeholder="Type your comment here..."/>
							<span class="input-group-btn">
								<button class="btn btn-success btn-md" id="btn-chat">Comment</button>
							</span>

                            </div>
                        </form>
                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>
    <!--/.row-->


</div>
<!--/.main-->
<jsp:include page="../layouts/guest.footer.jsp"/>