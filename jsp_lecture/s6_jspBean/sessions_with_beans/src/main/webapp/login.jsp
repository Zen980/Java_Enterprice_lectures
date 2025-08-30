
<jsp:useBean id="user" class="com.user" scope="session"/>
<jsp:setProperty name="user" property="*" />

Record : <br>
<jsp:getProperty name="user" property="username"/>
<jsp:getProperty name="user" property="password"/>

<a href="second.jsp">Visit Page</a>