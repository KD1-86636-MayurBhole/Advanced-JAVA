<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0;">
    <div style="width: 100%; max-width: 450px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px;">
        <h1 style="text-align: center; color: #343a40; margin-bottom: 20px;">Registration</h1>
        <form  action="register.jsp" style="display: flex; flex-direction: column;">
            <label for="firstname" style="margin-bottom: 5px; color: #495057;">Firstname:</label>
            <input type="text" id="firstname" name="firstname" placeholder="Enter firstname" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;">
            
            <label for="lastname" style="margin-bottom: 5px; color: #495057;">Lastname:</label>
            <input type="text" id="lastname" name="lastname" placeholder="Enter lastname" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;">
            
            <label for="email" style="margin-bottom: 5px; color: #495057;">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter Email" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;">
            
            <label for="password" style="margin-bottom: 5px; color: #495057;">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter password" 
                   style="padding: 10px; margin-bottom: 15px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;">
            
            <label for="birthdate" style="margin-bottom: 5px; color: #495057;">Birthdate:</label>
            <input type="date" id="birthdate" name="date" 
                   style="padding: 10px; margin-bottom: 20px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;">
            
            <input type="submit" value="Sign In" 
                   style="padding: 10px; background-color: #007bff; color: #fff; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
        </form>
        <p style="text-align: center; margin-top: 15px; font-size: 14px; color: #495057;">
            Already have an account? 
            <a href="index.html" style="color: #007bff; text-decoration: none;">Sign in</a>
        </p>
    </div>
</body>
</html>
