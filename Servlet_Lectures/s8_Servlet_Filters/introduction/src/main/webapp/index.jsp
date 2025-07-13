<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet filters</title>
</head>

<body>
    <a href="#">FirstServlet</a>
    
    <div id="demo">

    </div>
    <script>
        let doc = document.getElementById("demo");
        let a = document.querySelector("a");
        a.addEventListener("click", async (e) => {
            e.preventDefault();
            const response = await fetch("servlet/firstServlet");
            const data = await response.text();
            doc.innerHTML = data;
        })
    </script>
</body>
<!-- 
        
 
 
 -->
</html>