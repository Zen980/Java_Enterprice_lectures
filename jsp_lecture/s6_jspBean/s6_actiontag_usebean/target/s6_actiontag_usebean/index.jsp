<jsp:useBean id="obj" class="com.calculator"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>use bean action tag</title>
</head>
<body>
    <%
        int m = obj.cube(5);
        out.println("Cube of 5 is "+m);
    %>
</body>
</html>