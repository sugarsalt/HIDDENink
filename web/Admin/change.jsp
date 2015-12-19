<%@page import="java.sql.ResultSet"%>
<%@page import="model.Users"%>
<%
    session = request.getSession();
    String Email = (String) session.getAttribute("Email");

%>

<div class="modal fade" id="AdminChangePasswordModal" tabindex="-1" style="font-family: majalla;font-size: 20px;margin-top: 05px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 25px;color: black;">Change Password</a></li>
            </ul>

            <div id="cd-reset-password" class="is-selected" style="color: black; "> <!-- log in form -->
                <form class="cd-form" action="../EditPasswordAdmin"method="POST">
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signin-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="Email"  id="signin-email" type="email"  value='<%=Email%>'class="form-control" readonly/>
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">Old Password</label>
                        <input class="full-width has-padding has-border" name="Oldpassword"  id="Oldpassword" type="password" placeholder="Old Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">New Password</label>
                        <input class="full-width has-padding has-border" name="Newpassword"  id="Newpassword" type="password" placeholder="New Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">Confirm Password</label>
                        <input class="full-width has-padding has-border" name="Confirmpassword"  id="Confirmpassword" type="password" placeholder="Confirm Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <button class="btn btn-danger" style="font-size: 23px;padding-left: 151px;padding-right: 151px;padding-bottom: 7px;padding-top: 7px;"type="submit" value="Login">Change Password</button>

                </form>
            </div> <!-- cd-login -->
        </div>
    </div>
</div>

<div class="modal fade" id="EditModal" tabindex="-1" style="font-family: majalla;font-size: 15px;margin-top: 5px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 30px;color: black;">Update</a></li>
            </ul>

            <div id="cd-update" class="is-selected" style="font-size: 20px;color: black;"> <!-- sign up form -->
                <form class="cd-form" action="../UpdateServlet" method="POST" >
                    <p class="fieldset">
                        <label class="image-replace cd-username" for="Update-Fname">First Name</label>
                        <input class="full-width has-padding has-border" name="Fname" id="Update-username1" type="text" placeholder="First Name" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-username" for="Update-Lname">Last Name</label>
                        <input class="full-width has-padding has-border" name="Lname" id="Update-username2" type="text" placeholder="Last Name" required="required" >
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="Update-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="Email" id="Update-email" type="email" placeholder="E-mail" readonly>
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="Update-password">Password</label>
                        <input class="full-width has-padding has-border" name="password" id="Update-password" type="text" placeholder="Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-password" >Status</label>
                        <input class="full-width has-padding has-border" name="status" id="Update-status" type="text" placeholder="Status" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <button class="btn btn-danger" style="font-size: 20px;padding-left: 200px;padding-right: 200px;padding-bottom: 10px;padding-top: 10px;" type="submit" value="update">UPDATE</button>
                </form>


            </div> <!-- cd-update-->

        </div>
    </div>
</div>

<div class="modal fade" id="DeleteModal" tabindex="-1" style="font-family: majalla;font-size: 15px;margin-top: 170px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 25px;color: black;">Delete</a></li>
            </ul>

            <div id="cd-update" class="is-selected" style="color: black;"> <!-- sign up form -->
                <form class="cd-form" action="../DeleteServlet" method="POST" >
                    <p class="fieldset">
                        <label class="image-replace cd-password" for="Delete-messageID">Message ID</label>
                        <input class="full-width has-padding has-border" name="messageID" id="Delete-messageID" type="text" placeholder="Message ID" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <button class="btn btn-danger" style="font-size: 20px;padding-left: 200px;padding-right: 200px;padding-bottom: 10px;padding-top: 10px;" type="submit" value="Delete">DELETE</button>
                </form>


            </div> <!-- cd-update-->

        </div>
    </div>
</div>

<script src="../js/main.js"></script>