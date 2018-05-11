<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Database Task</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.5/css/select.dataTables.min.css"> 
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h2>Database Project</h2>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-12">
        <form action="uploadFile" method="POST" enctype="multipart/form-data">
          <div class="form-group row">
            <input type="file" class="form-control-file col-4" id="uploadFile" name="uploadFile"
              accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="submit" class="btn btn-primary col-4" value="Upload">
          </div>
        </form>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-12">
        <div class="table-responsive">
          <table id="databaseTable" class="table table-striped table-bordered table-hover">
            <thead class="thead-dark">
              <tr>
                <th>FName</th>
                <th>LName</th>
                <th>Email</th>
                <th>Pswd</th>
                <th>State</th>
                <th>Country</th>
                <th>Age</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="t" items="${lst}">
                <tr>
                  <td>${t.getFirstname()}</td>
                  <td>${t.getLastname()}</td>
                  <td>${t.getEmail()}</td>
                  <td>${t.getPassword()}</td>
                  <td>${t.getState()}</td>
                  <td>${t.getCountry()}</td>
                  <td>${t.getAge()}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <br/>
    <div class="row">
      <div class="col-12 text-center">
      <h3>Remove Selected rows</h3>
      <form action="removeSelected" method="POST" id="removeSelected">
      <input type="text" name="rows" id="rows" hidden="hidden">
      <input type="submit" value="Delete"> 
      </form>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/select/1.2.5/js/dataTables.select.min.js"></script>
  <script type="text/javascript" src="resources/js/home.js"></script>
</body>
</html>
