<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>request and response</title>
</head>
<body>
    <!-- in this servlet we are going to create a form to understand the request and response objects -->
     <form action="responseServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>
        <p>Gender</p>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br><br>
        <p>Hobbies</p>
        <input type="checkbox" id="reading" name="hobbies" value="reading">
        <label for="reading">Reading</label>
        <input type="checkbox" id="swimming" name="hobbies" value="swimming">
        <label for="swimming">Swimming</label>
        <input type="checkbox" id="painting" name="hobbies" value="painting">
        <label for="painting">Painting</label><br><br>
        <input type="submit" value="Submit">
     </form>
</body>
</html>