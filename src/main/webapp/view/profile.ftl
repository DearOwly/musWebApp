<#-- @ftlvariable name="user" type="so.sonya.dto.UserEntityDto" -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./styles/aut.css">
    <title>Profile</title>
</head>
<body>
<header></header>
<main>
    <form class="container">
        <h2>ПРОФИЛЬ</h2>
        <div class="user">
            <img src="./images/profile.png" alt="profile img">
            <div class="user__info">${user.name}</div>
            <div class="user__info">${user.surname}</div>
            <div class="user__info">${user.email}</div>
        </div>
        <a href="/authorization">ВЫХОД</a>
    </form>
</main>
</body>
</html>