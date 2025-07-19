<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Scripting elements</title>
</head>
<body>
    <%! 
        int number = 42;
        // This is a declaration in JSP
    %>
    <h2><%= "Hello World!"+
    "This is Expression tag in JSP" +
    " and it is used to output data." +
    " The current date and time is: " + new java.util.Date()
    %></h2>
    <h3>Scriptlet Example</h3>
    <%
        String message = "This is a scriptlet example in JSP.";
        out.println(message);
    %>
    <h3>Declaration Example</h3>
    <%
        String declarationMessage = "The answer to life, the universe, and everything is: " + number;
        out.println(declarationMessage);
    %>
</body>
</html>