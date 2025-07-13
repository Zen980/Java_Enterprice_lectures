<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>resource redirection</title>
</head>

<body>
    <h1>Welcome to resource redirection</h1>
    <h3><a href="servlet1">wana visit google</a></h3>
    <h3><a href="servlet2">includeing resource</a></h3>

    <!-- 
        In this servlet example, a form is submit to servlet 2 
        but response will be retrieved through servlet 3
        due to RequestDispatcher's forward method
    -->
    <form action="servlet2" method="post">
        <h3>forwording resource</h3>
        <input type="text" name="name"> <input type="submit" value="go">
    </form>
</body>

</html>