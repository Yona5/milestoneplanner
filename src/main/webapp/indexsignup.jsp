<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MilestonePlanner | Signup</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="Landing PAGE Html5 Template">

    <meta name="keywords" content="landing,startup,flat">


    <title>MilestonePlanner | Signup</title>



    <!-- // PLUGINS (css files) // -->

    <link href="../js/plugins/bootsnav_files/skins/color.css" rel="stylesheet">

    <link href="../js/plugins/bootsnav_files/css/animate.css" rel="stylesheet">

    <link href="../js/plugins/bootsnav_files/css/bootsnav.css" rel="stylesheet">

    <link href="../js/plugins/bootsnav_files/css/overwrite.css" rel="stylesheet">

    <link href="../js/plugins/owl-carousel/owl.carousel.css" rel="stylesheet">

    <link href="../js/plugins/owl-carousel/owl.theme.css" rel="stylesheet">

    <link href="../js/plugins/owl-carousel/owl.transitions.css" rel="stylesheet">

    <link href="../js/plugins/Magnific-Popup-master/Magnific-Popup-master/dist/magnific-popup.css" rel="stylesheet">

    <!--// ICONS //-->

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!--// BOOTSTRAP & Main //-->

    <link href="../bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../css/main.css" rel="stylesheet">

    </head>



    <body>



    <!--========================================

           Preloader

    ========================================-->

    <div class="page-preloader">

        <div class="spinner">

            <div class="rect1"></div>

            <div class="rect2"></div>

            <div class="rect3"></div>

            <div class="rect4"></div>

            <div class="rect5"></div>

        </div>

    </div>

    <!--========================================

           Header

    ========================================-->



    <!--//** Navigation**//-->

    <nav class="navbar navbar-default navbar-fixed white no-background bootsnav navbar-scrollspy" data-minus-value-desktop="70" data-minus-value-mobile="55" data-speed="1000">



        <div class="container">

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">

                    <i class="fa fa-bars"></i>

                </button>
                <ul class="nav navbar-nav">
                    <li>
                        <a class="navbar-brand" href="#brand">
                        </a>
                    </li>
                </ul>
            </div>

            <div class="collapse navbar-collapse" id="navbar-menu">

                <ul class="nav navbar-nav navbar-right">

                    <li class="button-holder">

                        <a style="font-size:17px;" href="/login.jsp">Sign in</a>

                    </li>

                </ul>

            </div>

            <!-- /.navbar-collapse -->

        </div>

    </nav>



    <!--//** Banner**//-->

    <section id="home">

        <div class="container">

            <div class="row">

                <!-- Introduction -->

                <div class="col-md-6 caption">

                    <h1>Welcome To MilestonePlanner</h1>

                    <p>Plan your milestones with this tool, and experience the potential to delivery every
                        single goal on time. Unleash your potential!</p>
                </div>

                <!-- Sign Up -->

                <div class="col-md-5 col-md-offset-1">
                    <form class="signup-form" action = "UserServlet" method = "POST">
                        <h2 class="text-center">Signup Now</h2>
                        <hr>
                        <div class="form-group">
                            <input type="text" name="first" class="form-control" placeholder="First Name" required="required">
                        </div>
                        <div class="form-group">
                            <input type="text" name="last" class="form-control" placeholder="Last Name" required="required">
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" placeholder="Email Address" required="required">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-blue btn-block">Sign up</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>

    </section>

    <!-- Modal -->

    <div class="modal fade" id="SignIn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

        <div class="modal-dialog" role="document">

            <div class="modal-content">

                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                    <h4 class="modal-title text-center" id="myModalLabel">Sign In</h4>

                </div>

                <%--<div class="modal-body">--%>

                    <%--<form class="signup-form" action="LoginServlet" method="POST">--%>
                        <%--<div class="form-group">--%>
                            <%--<input type="text" name="email" class="form-control" placeholder="User email" required="required">--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<input type="password" name="password" class="form-control" placeholder="Password" required="required">--%>
                        <%--</div>--%>

                        <%--<div class="form-group text-center">--%>
                            <%--<button type="submit" class="btn btn-blue btn-block">Log In</button>--%>
                        <%--</div>--%>
                    <%--</form>--%>

                <%--</div>--%>

                <div class="modal-footer text-center">

                </div>

            </div>

        </div>

    </div>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

            <!-- Include all compiled plugins (below), or include individual files as needed -->

            <script src="../bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

            <script src="../js/plugins/owl-carousel/owl.carousel.min.js"></script>

            <script src="../js/plugins/bootsnav_files/js/bootsnav.js"></script>

            <script src="../js/plugins/typed.js-master/typed.js-master/dist/typed.min.js"></script>

            <script src="https://maps.googleapis.com/maps/api/js"></script>

            <script src="../js/plugins/Magnific-Popup-master/Magnific-Popup-master/dist/jquery.magnific-popup.js"></script>

            <script src="../js/main.js"></script>

    </body>



</html>
