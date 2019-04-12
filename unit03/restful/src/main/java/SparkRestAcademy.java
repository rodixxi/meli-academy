import com.google.gson.Gson;

import static spark.Spark.*;

public class SparkRestAcademy {
    public static void main(String[] args) {

        port(8080);

        StudentServiceMapImpl studentService = new StudentServiceMapImpl();

        post("/students", (request, response) -> {
            response.type("application/json");
            Student student = new Gson().fromJson(request.body(), Student.class);
            studentService.addStudent(student);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/students", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                    .toJsonTree(studentService.getStudents()))
            );
        });

        get("/students/lastName/starsWith", (request, response) -> {
            response.type("application/json");
            String [] capitalLetters = request.queryParams("q").toLowerCase().split(",");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(studentService.getFilterStudentByLastNameCapitalLeter(capitalLetters)))
            );
        });

        get("/students/lastName/contains", (request, response) -> {
            response.type("application/json");
            String capitalLetters = request.queryParams("q").toLowerCase().trim();

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(studentService.getFilterStudentByLastNameContains(capitalLetters)))
            );
        });

        get("/students/email/longerThat", (request, response) -> {
            response.type("application/json");
            int longerThat = Integer.parseInt(request.queryParams("q").toLowerCase().trim());

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(studentService.getFilterStudentByEmailLenght(longerThat)))
            );
        });

        get("/students/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                    .toJsonTree(studentService.getStudent(request.params("id"))))
            );
        });

        put("/students", (request, response) -> {
            String errorMesaje = "User not found or error in edit.";
            response.type("application/json");
            Student studentToEdit = new Gson().fromJson(request.body(), Student.class);
            Student editedStudent = null;
            try {
                editedStudent = studentService.editStudent(studentToEdit);
            } catch (StudentException e) {
                errorMesaje = e.getMessage();
            }

            if (editedStudent != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                        .toJsonTree(editedStudent))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson(errorMesaje))
                );
            }
        });

        delete("/students/:id", (request, response) -> {
            response.type("application/json");
            Student deletedStudent = studentService.deleteStudent(request.params("id"));

            if (deletedStudent != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(deletedStudent))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson("User not found or error in delete."))
                );
            }
        });

        options("/students/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            (studentService.existStudent(request.params("id")) ? "Student exist." : "Student DONT exist."))
            );
        });

    }
}
