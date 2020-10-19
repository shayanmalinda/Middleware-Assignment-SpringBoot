<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Books</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body style="background-color: #F7F7F7">
<div class="container-fluid">
    <div class="row" style="text-align: center; margin-top: 30px; margin-bottom: 30px">

        <div class="col-md-1"><a href="/"><i class="fa fa-3x fa-home"></i></a></div>
        <div class="col-md-2"></div>
        <div class="col-md-6"><div><h2>Books Management</h2></div></div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="card"  style="padding: 20px 0px">
            <div class="card-body">
                <form action="/addBookUI" class="mb-5">
                    <div class="row">
                        <div class="col-md-5"></div>
                        <div class="col-md-2 mt-2"><button type="submit" class="btn btn-success" style="width: 100%"><i class="fas fa-plus-square mr-2"></i>Add New Book</button></div>
                        <div class="col-md-5"></div>
                    </div>
                </form>
                <div class="col-md-12">
                        <table class="table  table-hover">
                            <thead>
                                <tr>
                                    <th>ISBN</th>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Count</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Book}" var="book">
                                    <tr>
                                        <td>${book.isbn}</td>
                                        <td>${book.title}</td>
                                        <td>${book.author}</td>
                                        <td>${book.count}</td>
                                        <td>
                                            <form action="getBook" method="get">
                                                <button class="btn btn-success" style="width: 85%" name="id" value="${book.id}">Edit</button>
                                            </form>
                                        </td>
                                        <td><a class="btn btn-danger" style="width: 70%" href="/deleteBook/${book.id}">Delete</a></td>

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