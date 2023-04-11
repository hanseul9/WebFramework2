<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2023-03-18
  Time: 오후 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>

    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
        <table class="formtable">
            <tr>
                <td class="label"> Name:</td>
                <td><sf:input class="control" type="text" path="name"/>  <br/>
                    <sf:errors class="error" path="name" />
                </td>
            </tr>
            <tr>
                <td class="label"> Email:</td>
                <td><sf:input class="control" type="text" path="email"/> <br/>
                    <sf:errors class="error" path="email" />
                </td>
            </tr>
            <tr>
                <td class="label"> Offer:</td>
                <td><sf:textarea class="control" rows="10" cols="10" path="text"/> <br/>
                    <sf:errors class="error" path="text" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="새 제안"/> </td>
            </tr>
        </table>
    </sf:form>

</body>
</html>
