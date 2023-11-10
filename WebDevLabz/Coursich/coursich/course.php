<?php
// start the session
session_start();

// Check if the user is not logged in, then redirect the user to login page
if ($_SESSION["loggedIn"] !== true) {
    header("location: login.php");
    global $name;
    $name=$_SESSION["username"];
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oxanium&family=Share+Tech+Mono&display=swap" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <link href="styles/styles.css" rel="stylesheet">
</head>
<body>
    <input type="checkbox" id="check">
    <label for="check">
        <i class="fas fa-bars" id="btn"></i>
        <i class="fas fa-times" id="cancel"></i>
    </label>
    <div class="sidebar">
        <header class="glitch">Menu</header>
        <a href="#" class="active">
            <i class="fas fa-qrcode"></i>
            <span>Dashboard</span>
        </a>
        <a href="#">
            <i class="fas fa-link"></i>
            <span>Shortcuts</span>
        </a>
        <a href="#">
            <i class="fas fa-stream"></i>
            <span>Overview</span>
        </a>
        <a href="#">
            <i class="fas fa-calendar"></i>
            <span>Events</span>
        </a>
        <a href="#">
            <i class="far fa-question-circle"></i>
            <span>About</span>
        </a>
        <a href="#">
            <i class="fas fa-sliders-h"></i>
            <span>Services</span>
        </a>
        <!-- IN PROGGRESS -->
        <a target="_blank" rel="noopener noreferrer" href="https://vk.com/wemik2323">
            <i class="far fa-envelope"></i>
            <span>Contact</span>
        </a>
        <a href="logout.php">
            <i class="far fa-address-card"></i>
            <span>Log Out</span>
        </a>
    </div>
</body>
    
<div class="Main_Window">
    <p> Welcome </p>
    <h2 class="delayAppearence"><?=$_SESSION["email"]?></h2>
    <p></p>
</div>

</html>