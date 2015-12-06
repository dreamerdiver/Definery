<?php
	$db = new PDO("mysql:host=localhost;dbname=definery", "meesh", "DreamandDive406");
	$sql = "select vote_count from entries";
	$stmt = $db->prepare($sql);
	$stmt->execute();
	$results = $stmt->fetchAll(PDO::FETCH_ASSOC);

	/*
	echo "<pre>";
	print_r($results);
	echo "</pre>";
	*/
	echo json_encode($results);
?>