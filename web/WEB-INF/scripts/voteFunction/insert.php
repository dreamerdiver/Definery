<?php
	$db = new PDO("mysql:host=localhost;dbname=definery", "meesh", "DreamandDive406");
	$sql = "insert into tasks(description) values(:description)";
	$stmt = $db->prepare($sql);
	$stmt->bindParam(":description", $_POST["desc"]);
	$stmt->execute();

	echo $db->lastInsertId();
?>