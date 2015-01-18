<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title>тест</title>



  <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
  <script type="text/javascript">

    function printComment(comment)
    {
      var respContent = "";
      respContent += "<tr>";
      respContent += "<td>" + comment.name + "</td>";
      respContent += "<td>" + comment.text + "</td>";
      respContent += "<td>" + comment.number + "</td>";
      respContent += "<td><td><a class='delete' href='#' title='"+comment.id+"'>Удалить</a></td>";
      respContent += "</tr>";
      return respContent;
    }


    function ajaxAddComment() {
      //alert("ееей");
      var id = null;
      var name = $('#name').val();
      var text = $('#text').val();
      var number = $('#number').val();
      var json = {id: id, name: name, text: text, number: number};
      var data = JSON.stringify(json);

      $.ajax({
        url: "/comment/add",
        contentType: "application/json",
        data: data,
        type: "POST",
        success: function (comment) {
          $("#allComment").append(printComment(comment));
        },
        error: function (xhr, status, error) {
          alert(error+": Заметьте, что имя должно быть уникальным, а число - числом");
        }
      });
    }

    $(document).on('click', '.delete', function() {
      //alert("w");
        var data = $(this).attr("title");
        //alert(data);
        $.ajax({
          url: "/comment/delete",
          contentType: "application/json",
          data: data,
          type: "POST",
          success: function (comments) {
            //alert("good");
            //alert( comments.length);
            var respContent = "<tr><th>Уникальное имя:</th><th>Текст:</th><th>Число:</th></tr>";
            for (i = 0; i < comments.length; ++i) {
            respContent += printComment(comments[i])
            }
            $("#allComment").html(respContent);
          },
          error: function (xhr, status, error) {
            alert(error);
          }
        });

        event.preventDefault();
      });



  </script>
</head>
<body>

Коменты

<form method="post" action="add" commandName="comment">

  <table>
    <tr>
      <td><label path="name">
        Уникальное имя:
      </label></td>
      <td><input id="name" path="name" /></td>
    </tr>
    <tr>
      <td><label  path="text">
        Текст:
      </label></td>
      <td><input id="text" path="text" /></td>
    </tr>
    <tr>
      <td><label path="number">
        Число:
      </label></td>
      <td><input id="number" path="number" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" ><input type="button" value="Добавить" onclick="ajaxAddComment();"></td>
    </tr>
  </table>
</form>


<h3>Список коментариев</h3>
<if test="${!empty commentList}">
  <table class="data" id="allComment">
    <tr>
      <th>Уникальное имя:</th>
      <th>Текст:</th>
      <th>Число:</th>
    </tr>
    <c:forEach items="${commentList}" var="comment">
      <tr>
        <td>${comment.name}</td>
        <td>${comment.text}</td>
        <td>${comment.number}</td>
        <td><a class="delete" href="#" title="${comment.id}">Удалить</a></td>
      </tr>
    </c:forEach>
  </table>
</if>

</body>
</html>