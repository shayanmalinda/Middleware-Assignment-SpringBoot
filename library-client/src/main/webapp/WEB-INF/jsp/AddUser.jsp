<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="../css/shards.min.css"> -->
</head>
<body style="background-color: #F7F7F7">
    <div class="container">
        <div class="row" style="margin-top: 40px">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="card" style="padding: 20px 30px">
                    <div style="text-align: center; margin-top: 0px; margin-bottom: 20px"><h2>Add New User</h2></div>
                    <form class="form-group" action="addUser">
                        <label for="name">First Name</label>
                        <input class="form-control" type="text" name="firstName"><br>
                        <label for="name">Last Name</label>
                        <input class="form-control" type="text" name="lastName"><br>
                        <label for="name">Email</label>
                        <input class="form-control" type="text" name="email"><br>
                        <label for="name">Phone Number</label>
                        <input class="form-control" type="text" name="phoneNo"><br>
                        <label for="name">NIC Number</label>
                        <input class="form-control" type="text" name="nic"><br>
                        <div class="row">
                            <div class="col-md-8">
                                <button class="btn btn-success" type="submit" style="width:100%">Add User</button>
                            </div>
                            <div class="col-md-4 pr-2">
                                <a class="btn btn-danger" href="/cancelUser" style="width:100%">Cancel </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</body>
</html>

