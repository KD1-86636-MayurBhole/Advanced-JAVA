<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0;">
    <div style="width: 100%; max-width: 400px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px;">
        <h1 style="text-align: center; color: #333; margin-bottom: 20px;">Login</h1>
        <form method="post" action="login.jsp" style="display: flex; flex-direction: column;">
            <label for="email" style="margin-bottom: 5px; color: #555;">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter Email" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            
            <label for="password" style="margin-bottom: 5px; color: #555;">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter Password" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            
            <input type="submit" value="Sign In" 
                   style="padding: 10px; background-color: #ffcc00; color: #fff; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
            
            <p style="text-align: center; margin-top: 15px; font-size: 14px; color: #555;">
                Don't have an account? 
                <a href="register.html" style="color: #ffcc00; text-decoration: none;">Sign up</a>
            </p>
        </form>
    </div>
</body>
</html>
