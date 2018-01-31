<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>

<%!Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohoradb");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>

<%
    String id = request.getParameter("id");

			try {
				this.setConnection();
				String sql = "select * from g_per where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CATCH 아이디 중복 확인</title>
</head>
<body>
	<script>
		function checkIdClose(id) {
			opener.form.id.value = id;
			window.close();
			opener.form.password.focus();
		}
	</script>
	<form method="post" action="checkId.jsp">
		<%
		    try {
		        if (rs.next() || (id == null)) {
		%>

		현재
		<%=id%>
		사용불가능<br> <br> 아이디: <input type="text" name="id"></input> <input
			type="submit" value="중복체크"></input>

		<%
		    } else {
		%>

		현재
		<%=id%>
		사용가능 <a href="checkId.jsp">다른 아이디 고르기</a><br> <br> <input
			type="button" value="현재 아이디 선택" onclick="checkIdClose('<%=id%>')">
		<%
		    }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if(pstmt!=null) pstmt.close();
		            if(con != null) con.close();
		        } catch (SQLException e2) {
		            e2.printStackTrace();
		        }
		    }
		%>
	</form>
</body>
</html>