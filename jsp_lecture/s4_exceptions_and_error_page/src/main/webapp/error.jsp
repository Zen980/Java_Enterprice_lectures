<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>error page</title>
</head>
<body>
    <h3>Sorry an exception occured!</h3>  
    Exception is: <%= exception %> <br><br>
    <a href="index.jsp">Back to index page</a>
</body>
</html>
