<%--
  Created by IntelliJ IDEA.
  User: rcrespillo
  Date: 2019-04-26
  Time: 09:27
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Agencies</title>
</head>

<body>
    <form class="needs-validation" novalidate action="search">
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="lat">First name</label>
                <input type="number" step="any" class="form-control" id="lat" name="lat" placeholder="Latitud*" value="-31.412971" required>
                <div class="valid-feedback">
                    Bien
                </div>
                <div class="invalid-feedback">
                    Valor faltante.
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="lon">Last name</label>
                <input type="number" step="any" class="form-control" id="lon" name="lon" placeholder="Longitud*" value="-64.18758" required>
                <div class="valid-feedback">
                    Bien
                </div>
                <div class="invalid-feedback">
                    Valor faltante.
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="near_to">Distancia</label>
                <input type="number" class="form-control" id="near_to" name="near_to" placeholder="Distancia">
            </div>
            <div class="col-md-3 mb-3">
                <label for="limit">Cantidad</label>
                <input type="number" class="form-control" id="limit" name="limit" placeholder="Cantidad">
            </div>
            <div class="col-md-3 mb-3">
                <label for="offset">Offset</label>
                <input type="number" class="form-control" id="offset" name="offset" placeholder="Offset">
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Buscar</button>
    </form>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>