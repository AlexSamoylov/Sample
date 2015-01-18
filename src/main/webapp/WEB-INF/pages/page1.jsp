<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h2>Peace, World!</h2>
<h1>${message}</h1>
<h2>Peace, World!</h2>


<form:form method="POST" action="/page2">
    <table>
        <tr>
            <td><form:label path="text">Text:</form:label></td>
            <td><form:input path="text"></form:input></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>



</body>
</html>
