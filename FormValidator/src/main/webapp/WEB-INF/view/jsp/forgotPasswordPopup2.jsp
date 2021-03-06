<!DOCTYPE html>
<html>
  <head>
    <title>Title of the document</title>
    <style>
      * {
      box-sizing: border-box;
      }
      body {
      font-family: Roboto, Helvetica, sans-serif;
      }
      #loginPopup {
      display: none; /* Hidden by default */
      position: fixed; /* Stay in place */
      z-index: 1; /* Sit on top */
      padding-top: 100px; /* Location of the box */
      left: 0;
      top: 0;
      width: 100%; /* Full width */
      height: 100%; /* Full height */
      overflow: auto; /* Enable scroll if needed */
      background-color: rgb(0,0,0); /* Fallback color */
      background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
      }
      /* Fix the button on the left side of the page */
      .open-btn {
      display: flex;
      justify-content: left;
      }
      /* Style and fix the button on the page */
      .open-button {
      background-color: #1c87c9;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      opacity: 0.8;
      position: fixed;
      }
      /* Hide the Popup form */
      .form-popup {
      border: 2px solid #666;
      z-index: 9;
      max-width: 300px;
      margin: 0 auto;
      }
      /* Styles for the form container */
      .form-container {
      max-width: 300px;
      padding: 20px;
      background-color: #fff;
      }
      /* Full-width for input fields */
      .form-container input[type=text], .form-container input[type=password] {
      width: 100%;
      padding: 10px;
      margin: 5px 0 22px 0;
      border: none;
      background: #eee;
      }
      /* When the inputs get focus, do something */
      .form-container input[type=text]:focus, .form-container input[type=password]:focus {
      background-color: #ddd;
      outline: none;
      }
      /* Style submit/login button */
      .form-container .btn {
      background-color: #8ebf42;
      color: #fff;
      padding: 12px 20px;
      border: none;
      cursor: pointer;
      width: 100%;
      margin-bottom:10px;
      opacity: 0.8;
      }
      /* Style cancel button */
      .form-container .cancel {
      background-color: #cc0000;
      }
      /* Hover effects for buttons */
      .form-container .btn:hover, .open-button:hover {
      opacity: 1;
      }
    </style>
  </head>
  <body>
    <h2>Popup Form</h2>
    <p>Click on the "Open Form" button to open the Popup form.</p>
    <p>Then, you can click anywhere outside of the box to close it.</p>
    <div class="open-btn">
      <button class="open-button" onclick="openForm()">
      <strong>Open Form</strong>
      </button>
    </div>
    <div id="loginPopup">
      <div class="form-popup" id="popupForm">
        <form action="/action_page.php" class="form-container">
          <h2>Please Log in</h2>
          <label for="email">
          <strong>E-mail</strong>
          </label>
          <input type="text" id="email" placeholder="Your Email" name="email" required>
          <label for="psw">
          <strong>Password</strong>
          </label>
          <input type="password" id="psw" placeholder="Your Password" name="psw" required>
          <button type="submit" class="btn">Log in</button>
          <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
      </div>
    </div>
    <script>
      function openForm() {
        document.getElementById("loginPopup").style.display="block";
      }
      
      function closeForm() {
        document.getElementById("loginPopup").style.display= "none";
      }
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
        var modal = document.getElementById('loginPopup');
        if (event.target == modal) {
          closeForm();
        }
      }
      
    </script>
  </body>
</html>