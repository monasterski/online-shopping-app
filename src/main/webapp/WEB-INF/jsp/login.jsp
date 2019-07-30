<!DOCTYPE html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous">
    <style>
        body {
            background: url('https://oldschoolgrappling.com/wp-content/uploads/2018/08/Background-opera-speeddials-community-web-simple-backgrounds.jpg') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            -o-background-size: cover;
        }
        /* Shared */
        .loginBtn {
          box-sizing: border-box;
          position: relative;
          /* width: 13em;  - apply for fixed size */
          margin: 0.2em;
          padding: 0 15px 0 46px;
          border: none;
          text-align: left;
          line-height: 34px;
          white-space: nowrap;
          border-radius: 0.2em;
          font-size: 16px;
          color: #FFF;
        }
        .loginBtn:before {
          content: "";
          box-sizing: border-box;
          position: absolute;
          top: 0;
          left: 0;
          width: 34px;
          height: 100%;
        }
        .loginBtn:focus {
          outline: none;
        }
        .loginBtn:active {
          box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
        }


        /* Facebook */
        .loginBtn--facebook {
          background-color: #4C69BA;
          background-image: linear-gradient(#4C69BA, #3B55A0);
          /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
          text-shadow: 0 -1px 0 #354C8C;
        }
        .loginBtn--facebook:before {
          border-right: #364e92 1px solid;
          background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png') 6px 6px no-repeat;
        }
        .loginBtn--facebook:hover,
        .loginBtn--facebook:focus {
          background-color: #5B7BD5;
          background-image: linear-gradient(#5B7BD5, #4864B1);
        }
    </style>
</head>
<body>

    <div style="max-width:20%; margin-top: 10%; margin-left: auto; margin-right: auto;">
    <sf:form method="POST" modelAttribute="user">
      <div class="form-groups">
        <div class="col text-danger font-weight-bold" style="margin-bottom:3%; text-align:center;">
            <c:out value="${error}"/>
        </div>
        <div class="col" style="margin-bottom:3%">
            <sf:input path="username" type="text" class="form-control" placeholder="Login"/>
        </div>
        <div class="col" style="margin-bottom:3%">
            <sf:input path="password" type="password" class="form-control" placeholder="Password"/>
        </div>
        <input class="btn btn-info" style="margin-left:5%; margin-bottom:2%" value="Zaloguj" type="submit"/>
        <a href="<c:url value="/register"/>">
            <button class="btn btn-info" type="button" style="margin-bottom:2%">
                Zarejestruj
            </button>
        </a>
      </div>
    </sf:form>
    <form action="${pageContext.request.contextPath}/signin/facebook" method="POST">
        <button style="margin-left:5%" type="submit" class="loginBtn loginBtn--facebook">
          Login with Facebook
        </button>
    </form>
    </div>

</body>

</html>