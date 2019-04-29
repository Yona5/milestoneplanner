<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">-->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/dashboard.css">
</head>
<body>
<div class="center">
    <div class="left">
        <div class="logo"><svg viewBox="0 0 200 400" width="100" height="100"><path d=" M 174.627 77.683 C 173.776 78.815 142.411 133.739 129.968 166.414 C
            129.34 168.064 128.78 169.45 128.204 171.119 C 127.727 172.503 127.488 173.714 126.933 175.086 C 126.212 176.871 126.006 177.829 125.667 179.358 C 125.301 181.008 124.477 184.693 124.121 187.63 C 123.856 189.808 123.741 191.662 123.663 193.853 C 123.462 199.472 123.876 204.233 124.636 209.8 C 127.42 230.202 135.691 246.266 147.665 262.895 C 148.73 264.375 149.618 265.639 150.777 267.047 C 152.739 269.432 154.445 271.444 156.857 273.381 C 159.729 275.688 162.496 277.205 165.903 278.596 C 168.996 279.859 171.753 280.586 175.056 281.078 C 178.597 281.605 181.659 281.725 185.216 281.306 C 188.955 280.865 192.024 279.892 195.522 278.517 C 197.728 277.65 199.557 276.802 201.61 275.62 C 204.662 273.863 225.417 262.219 236.258 252.224 C 239.451 249.28 244.212 243.928 244.962 243.452 C 245.712 242.977 264.83 213.834 259.473 198.687 Q 256.513 190.317 211.583 109.026 Q 196.037 82.262 193.522 78.637 C 191.452 75.653 188.937 70.289 183.683 70.278 C 178.429 70.267 175.231 76.89 175.106 76.877 M 236.638 249.594" fill-rule="evenodd" fill="rgb(219,223,255)"></path><linearGradient id="_lgradient_0" x1="93.56120204019503%" y1="13.017241572786997%" x2="89.84577303569424%" y2="99.2065293458878%"><stop offset="21%" stop-opacity="1" style="stop-color:rgb(185,193,255);"></stop><stop offset="100%" stop-opacity="1" style="stop-color:rgb(133,158,255);"></stop><stop offset="100%" stop-opacity="1" style="stop-color:rgb(185,193,255);"></stop></linearGradient><path d=" M 257.964 96.772 C 256.66 97.325 201.992 129.135 174.849 151.174 C 173.478 152.287 172.299 153.205 170.965 154.361 C 169.858 155.319 169.044 156.248 167.877 157.157 C 166.358 158.34 165.7 159.066 164.64 160.219 C 163.496 161.464 160.937 164.24 159.156 166.603 C 157.836 168.354 156.807 169.901 155.641 171.758 C 152.652 176.52 150.624 180.847 148.491 186.045 C 140.676 205.095 139.782 223.141 141.81 243.533 C 141.99 245.347 142.125 246.886 142.422 248.685 C 142.924 251.732 143.393 254.328 144.509 257.213 C 145.838 260.649 147.472 263.349 149.723 266.26 C 151.767 268.902 153.788 270.914 156.4 272.995 C 159.2 275.226 161.798 276.845 165.078 278.284 C 170.601 280.707 175.792 281.319 181.797 281.467 C 194.524 281.78 204.4 276.078 215.486 270.231 C 227.384 263.956 237.187 257.466 245.557 246.856 C 251.368 239.49 255.506 232.649 258.295 223.53 Q 265.443 200.163 271.169 142.865 Q 274.197 111.464 273.837 107.067 C 273.54 103.447 274.053 97.545 269.512 94.902 C 264.971 92.26 258.884 96.388 258.782 96.315 M 211.637 266.477" fill-rule="evenodd" fill="url(#_lgradient_0)"></path></svg></div>
        <div class="company">
            <div class="company-name">MilestonePlanner</div>
            <div class="company-description">MilestonePlanner for all your work,Witness more realtime achievements</div>
        </div>
        <div class="navigation">
            <ul style=" padding-left: 20px; padding-right: 20px;">
                <form action="/ListSharedServlet" method="get" >
                    <input type="text" name="sharedLink" class="form-control" id="link" placeholder="Insert Link" required="required">
                    <button type="submit" class="btn btn-primary btn-sm" style="margin-top: 20px;">
                        Import
                    </button>
                </form>

            </ul>
        </div>
    </div>
    <div class="right">
        <!--<div class="title">Projects Dashboard</div>-->
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">Projects Dashboard</a>
            <form class="form-inline">
                <a class="btn btn-primary" style="margin-right: 20px; color:white;" onclick="revealLink()">Share</a>

                    <a class="btn btn-primary" href="/logout">Logout</a>
                        <!--<button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#exampleModal" type="submit">Create Project</button>-->
            </form>
        </nav>
        <div id="shared" style="display:none">Link:  ${sharedLink}</div>
        <div class="row column">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-sm " data-toggle="modal" data-target="#basicExampleModal">
                Add a milestone
            </button>

            <%--<form action="ListServlet" class="form-inline" method="post">--%>
            <%--<button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">List Mile</button>--%>
            <%--<!--<button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#exampleModal" type="submit">Create Project</button>-->--%>
            <%--</form>--%>
        </div>
        <c:if test="${not empty listMilestone}">
            <div>
            <div>
                <h6>Project Milestones</h6>
            </div>
            <div align="left">
                <table class="table table-bordered" border="1" cellpadding="5">
                    <tr class=" table-primary">
                        <th>Name</th>
                        <th>Description</th>
                        <th>Start Date</th>
                        <th>Completion Date</th>
                        <th style="text-align: center;" colspan="2">Action</th>
                    </tr>
                    <c:forEach  items="${listMilestone}" var="milestone">
                        <tr>
                            <td>  ${milestone.name} </td>
                            <td> ${milestone.description} </td>
                            <td>${milestone.dueDate}</td>
                            <td>${milestone.completionDate}</td>
                            <td>

                                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#editModal" value='${milestone.id}' onclick="myFunction(this)">Edit</button>
                            </td>
                            <td><%--<a href="/EditServlet?id=${milestone.id}">Edit</a>--%>
                                <a class="btn btn-primary" href="/DeleteServlet?id=${milestone.id}">Delete</a >
                            </td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
        </div>
        </c:if>

    </div>

</div>
<!-- Modal for adding a new project-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add a new project name:</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Name:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Description:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Add</button>
            </div>
        </div>
    </div>
</div>
<!-- End of modal for creating project-->


<!-- Modal for adding a milestone -->

<!-- Modal -->
<div class="modal fade" id="basicExampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New Milestone</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="AddServlet" method="POST">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Name</label>
                        <input type="text" name="milestone_name" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Description</label>
                        <input type="text" name="milestone_des" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label" >Start Date</label>
                        <input type="date" name="due_date" class="form-control" id="recipient-name" required="required>
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label" >Completion Date</label>
                        <input type="date" name="completion_date" class="form-control" id="recipient-name" required="required">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<%--<c:forEach  items="${listMilestone}" var="milestone">--%>
<!-- edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="exampleModalLabel">Edit Milestone</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="EditServlet" method="POST">

                    <input id = "hidden" type="hidden" name="id" />

                    <%--<input type="hidden" name="id" value='${milestone.id}'  />--%>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Name</label>
                        <input type="text" name="milestone_name" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Description</label>
                        <input type="text" name="milestone_des" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Due Date</label>
                        <input type="date" name="due_date" class="form-control" id="recipient-name" required="required">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Completion Date</label>
                        <input type="date" name="completion_date" class="form-control" id="recipient-name" required="required">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<%--</c:forEach>--%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function revealLink(){
        document.getElementById("shared").style.display = "block";
    }
    function toggle_visibility(id) {
        var e = document.getElementById(id);
        if(e.style.display == 'block')
            e.style.display = 'none';
        else
            e.style.display = 'block';
    }
    function myFunction(thiss) {
        var val = thiss.getAttribute("value");
        console.log(val);
        document.getElementById("hidden").setAttribute("value", val);
    }
    $(function () {

        $('.showButton').click(function () {

            $('.hidden').show();

            $('.show').hide();

        });

        $('.hideButton').click(function () {

            $('.hidden').hide();

            $('.show').show();

        });

    });

</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>