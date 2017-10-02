<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <script type="text/javascript">
         function del(){
        	 if (confirm("是否确认要删除这些收藏?")){
        	           var f = document.forms[1];
        	           f.action = "collection?action=delete";
        	           f.submit();
        	 }else{
        		 return ;
        	 }
         }
    </script>
</head>
<body>
<form action="collection?action=save" method="post">
    <table border="0">
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        
        <tr>
            <td>url:</td>
            <td><input type="text" name="url"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Collection"></td>
        </tr>
    </table>

</form>

<form action="" method="post">
       <c:forEach var="x" items="${ColledList }">
            ${x.id }
            ${x.name }
            <a href="${x.url }" target="_blank">${x.url }</a>
            <a href="/Collection/collection?action=get&id=${x.id }">Edit</a>
            <input type="checkbox" name="its" value="${x.id }">
            <br/>
       </c:forEach>
     <input type="button" value="Delete" onclick="del()">
</form>
</body>
</html>