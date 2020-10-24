<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Issues</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body style="background-color: #F7F7F7">
<div class="container-fluid">
    <div class="row" style="text-align: center; margin-top: 30px; margin-bottom: 30px">

        <div class="col-md-1"><a href="/"><i class="fa fa-3x fa-home"></i></a></div>
        <div class="col-md-2"></div>
        <div class="col-md-6"><div><h2>Book Issues</h2></div></div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="card"  style="padding: 20px 0px">
            <div class="card-body">
                <form action="/addIssueUI" class="mb-5">
                    <div class="row">
                        <div class="col-md-5"></div>
                        <div class="col-md-2 mt-2"><button type="submit" class="btn btn-success" style="width: 100%"><i class="fas fa-book mr-2"></i>Issue Book</button></div>
                        <div class="col-md-5"></div>
                    </div>
                </form>
                <div class="col-md-12">
                        <table class="table  table-hover">
                            <thead>
                                <tr>
                                    <th>Book ISBN</th>
                                    <th>Borrower Name</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Issue}" var="issue">
                                    <tr>
                                        <td>${issue.isbn}</td>
                                        <td>${issue.name}</td>
                                        <td>${issue.date}</td>
                                        <td>${issue.time}</td>
                                        <td><a class="btn btn-success" style="width: 70%" href="/deleteIssue/${issue.id}">Return</a></td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>