<?php
/**
 * used to send a get request
 */
ini_set('max_execution_time', 300);

$url = "http://localhost:3000/dogs/1";

$curl = curl_init($url);

curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_POST, false);

curl_setopt($curl, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json'
));

curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);

$response = curl_exec($curl);

curl_close($curl);

//see what we get
var_dump($response);

