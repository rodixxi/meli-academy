<%--
  Created by IntelliJ IDEA.
  User: rcrespillo
  Date: 2019-04-26
  Time: 11:06
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <title></title>
</head>

<body>
<h1>Agencias</h1>
    <ul class="list-group">
        <g:each var="a" in="${agencies}">
            <li class="list-group-item">
                <button id="${a.id}" type="button" class="btn btn-default btn-sm" onclick="change(this.id)">
                    <span class=""><i class="far fa-heart"></i></span>
                </button>
                ${a.description} - Distancia: ${a.distance}
            </li>
        </g:each>
    </ul>

<script>
    function change(id) {
        var url = "/like?id=" + id;
        fetch(url, {
            method: 'post'
        }).then(function () {
            $("#" + id + " > span").addClass("text-danger");
            $("#" + id + " > i").addClass("fas").removeClass("far");
        });
    }
</script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>