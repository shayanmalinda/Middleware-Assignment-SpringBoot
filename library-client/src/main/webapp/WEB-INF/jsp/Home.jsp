<%--
  Created by IntelliJ IDEA.
  User: Shayan Malinda
  Date: 10/18/2020
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Library System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="../css/shards.min.css"> -->
</head>
<body style="background-color: #F7F7F7; padding-top: 40px">
<div class="container">
    <div style="text-align: center; margin-top: 30px; margin-bottom: 30px"><h1>Library Management System</h1></div>
    <div class="row" style="margin-top: 120px">
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
            <img src="http://www.myiconfinder.com/uploads/iconsets/256-256-2874c29b56e4c8e8f5418c8c8d9109a5-users.png" class="card-img-top" alt="..." style="padding: 31px 30px 25px 30px">
            <form class="form-group" action="/library-client/users">
                <div class="card-body">
                    <h5 class="card-title">Users</h5>
                    <p class="card-text">Manage user who are using the Library</p>
                    <button class="btn btn-success" type="submit" style="width: 100%">Manage Users</button>
                </div>
            </form>
        </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="https://static.vecteezy.com/system/resources/previews/001/200/145/non_2x/books-png.png" class="card-img-top" alt="..." style="Height: 282px;padding: 55px 40px 35px 40px">
                <form class="form-group" action="/library-client/books">
                    <div class="card-body">
                        <h5 class="card-title">Books</h5>
                        <p class="card-text">Manage books currently available in the Library</p>
                        <button class="btn btn-success" type="submit" style="width: 100%">Manage Books</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ_QqFrd8y8j87FWJ0_lNIBdv8CjTaSH3QlWQ&usqp=CAU" class="card-img-top" alt="..." style="Height: 282px;padding: 55px 40px 35px 40px">
                <form class="form-group" action="/library-client/issues">
                    <div class="card-body">
                        <h5 class="card-title">Book Issue</h5>
                        <p class="card-text">Issue the available books in the Library to Users</p>
                        <button class="btn btn-success" type="submit" style="width: 100%">Issue Book</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
