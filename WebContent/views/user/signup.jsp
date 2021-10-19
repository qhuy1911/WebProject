<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/login.css">
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="heading">
                <h1>Signup</h1>
            </div>
            <p class="text-danger text-center message">${message}</p>
            <form action="SignupServlet" method="post">
                <div>
                    <input type="text" name="username" id="username" placeholder="Username" required>
                </div>
                <div>
                    <input type="password" name="password" id="password" placeholder="Password" required>
                </div>
                <div>
                    <input type="password" name="repassword" id="repassword" placeholder="Repeat password" required>
                </div>
                <div>
                    <input type="email" name="email" id="email" placeholder="Email address" required>
                </div>
                <div>
                    <input type="submit" value="signup">
                </div>
            </form>
            <div class="footer">
                <p>Already signed up?</p>
                <a href="LoginServlet">Login now</a>
            </div>
        </div>
    </div>
</body>
</html>