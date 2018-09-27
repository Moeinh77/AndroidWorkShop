<?php

// $$$$$$$$$$$$$$$$$$$$$$$     response Function   $$$$$$$$$$$$$$$$$$$$$$$
function json_response($message, $code = 200)
{
    $status = array(
        200 => '200 OK',
        400 => '400 Bad Request',
        422 => 'Unprocessable Entity',
        500 => '500 Internal Server Error'
        );

    // return the encoded json
    return json_encode(array(
        'status' => $code < 300, // success or not?
        'message' => $message
        ));
}

$db = new mysqli( 'localhost',
                  'professo_admin',
                  '##webofshadows##222',
                  'professo_presentation');

$db->set_charset("utf8");

$req = json_decode(file_get_contents('php://input'));

if ($_SERVER['REQUEST_METHOD'] == 'POST' && $req -> action){

  if($req -> action == 'test'){
    echo json_response("test Succeeded !",200);
  }

  // $$$$$$$$$$$$$$$$$$$$$$$     SIGNUP USER   $$$$$$$$$$$$$$$$$$$$$$$
  if($req -> action == 'signup'){

    $noErrors = True;

    // receive all input values from the form
    $username = $req -> username;
    $email = $req -> email;
    $password_1 = $req -> password;
    $password_2 = $req -> confPassword;
    $location=$req -> location;
    $mobile=$req -> mobile;

    if (empty($username)) {
      echo json_response("Please enter an username !"
                    ,400);
      $noErrors=false;
    }
    if (empty($email)) {
        echo json_response("Please enter your Email !"
                      ,400);
        $noErrors=false;
    }
    if (empty($password_1)) {
        echo json_response( "Please enter a password !"
                      ,400);
        $noErrors=false;
    }
    if ($password_1 != $password_2) {
        echo json_response( "Passwords don't match !"
                      ,400);
        $noErrors=false;
    }

    // first check the database to make sure
    // a user does not already exist with the same username and/or email
    $user_check_query = "SELECT * FROM users WHERE username='$username' OR email='$email' LIMIT 1";
    $user = $db->query($user_check_query)->fetch_assoc();

    if ($user) { // if user exists
        if ($user['username'] === $username) {
            echo json_response( "Sorry,This username is already taken !"
                          ,400);
            $noErrors=false;
        }

        if ($user['email'] === $email) {
            echo json_response( "There is another account associated with this Email !"
                          ,400);
            $noErrors=false;
        }
    }

    // Finally, register user if there are no errors in the form
    if ($noErrors) {

        $password = md5($password_1);//encrypt the password before saving in the database

        $query = "INSERT INTO users (`username`, `password`, `email`,`mobile`, `location`)
  			  VALUES('$username', '$password', '$email','$mobile','$location')";

        $result = $db->query($query);

        if ($result) {
          echo json_response("Successfully Signed up, Welcome $name !"
                      ,200);
        } else {
          echo json_response("Error: $db->error"
                        ,500);
        }
    }
}
// $$$$$$$$$$$$$$$$$$$$$$$     LOGIN USER   $$$$$$$$$$$$$$$$$$$$$$$

if($req -> action == 'login'){

   $noErrors = True;

   $username = $req -> username;
   $password = $req -> password;

    if (empty($username)) {
       echo json_response("Please enter your Username !"
                    ,400);
        $noErrors=false;
    }
    if (empty($password)) {
       echo json_response("Please enter your Password !"
                   ,400);
        $noErrors=false;
    }

    if ($noErrors) {
        $password = md5($password);//encodes the pass word so that it would be same as saved one

        $query = "SELECT * FROM users WHERE `username`='$username' AND `password`='$password'";
        $result = $db->query($query);

        $res=$result->fetch_assoc();

        echo json_response($query
                    ,200);
        if ($result->num_rows > 0) {
          echo json_response("Successfully Loged in,Welcome back $name !"
                      ,200);
        } else {
          echo json_response("Error: no user with this info was found !"
                        ,500);
        }

      }
}
}
?>
