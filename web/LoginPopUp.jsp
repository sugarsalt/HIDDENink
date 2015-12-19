<%
    session = request.getSession();
    String Email = (String) session.getAttribute("Email");

%>
<div class="modal fade" id="LoginModal" tabindex="-1" style="font-family: majalla;font-size: 24px;margin-top: 60px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 30px;color: black;">Login</a></li>
            </ul>

            <div id="cd-login" class="is-selected" style="color: black; "> <!-- log in form -->
                <form class="cd-form" action="loginverify"method="POST">
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signin-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="Email"  id="signin-email" type="email" placeholder="E-mail" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">Password</label>
                        <input class="full-width has-padding has-border" name="password"  id="signin-password" type="password" placeholder="Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <%-- <p class="fieldset">
                         <input type="checkbox" id="remember-me" checked="">
                         <label for="remember-me" style="font-size: 22px;">Remember me</label>
                     </p>
                    --%>

                    <button class="btn btn-danger" style="font-size: 28px;padding-left: 200px;padding-right: 200px;padding-bottom: 10px;padding-top: 10px;"type="submit" value="Login">Login</button>

                </form>
            </div> <!-- cd-login -->>
        </div>
    </div>
</div>
<div class="modal fade" id="SignupModal" tabindex="-1" style="font-family: majalla;font-size: 20px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 30px;color: black;">Sign Up</a></li>
            </ul>

            <div id="cd-signup" class="is-selected" style="color: black;"> <!-- sign up form -->
                <form class="cd-form" action="SignupServlet" method="POST" >
                    <p class="fieldset">
                        <label class="image-replace cd-username" for="signup-Fname">First Name</label>
                        <input class="full-width has-padding has-border" name="Fname" id="signup-username" type="text" placeholder="First Name" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-username" for="signup-Lname">Last Name</label>
                        <input class="full-width has-padding has-border" name="Lname" id="signup-username" type="text" placeholder="Last Name" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signup-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="Email" id="signup-email" type="email" placeholder="E-mail" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signup-password">Password</label>
                        <input class="full-width has-padding has-border" name="password" id="signup-password" type="password" placeholder="Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-password" for="confirm-password">Confirm Password</label>
                        <input class="full-width has-padding has-border" name="Confirmpassword" id="confirm-password" type="password" placeholder="Confirm Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <%--<p class="fieldset">
                        <input type="checkbox" id="accept-terms" required="required" >
                        <label for="accept-terms" style="font-size: 22px;">I agree to the <a href="#0">Terms</a></label>
                    </p>
                    --%>

                    <button class="btn btn-danger" style="font-size: 28px;padding-left: 200px;padding-right: 200px;padding-bottom: 10px;padding-top: 10px;"type="submit" value="Sign Up">Sign Up</button>
                </form>

                <!-- <a href="#0" class="cd-close-form">Close</a> -->
            </div> <!-- cd-signup -->

        </div>
    </div>
</div>

<div class="modal fade" id="AccountModal" tabindex="-1" style="font-family: majalla;font-size: 24px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 30px;color: black;">Change Password</a></li>
            </ul>

            <div id="cd-reset-password" class="is-selected" style="color: black; "> <!-- log in form -->
                <form class="cd-form" action="EditPassword"method="POST">
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

                    <button class="btn btn-danger" style="font-size: 28px;padding-left: 144px;padding-right: 144px;padding-bottom: 7px;padding-top: 7px;"type="submit" value="Login">Change Password</button>

                </form>
            </div> <!-- cd-login -->
        </div>
    </div>
</div>

<div class="modal fade" id="AdminModal" tabindex="-1" style="font-family: majalla;font-size: 24px;"
     role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#" class="active" style="font-size: 30px;color: black;">Admin</a></li>
            </ul>

            <div id="cd-login" class="is-selected" style="color: black; "> <!-- log in form -->
                <form class="cd-form" action="Adminverify"method="POST">
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signin-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="Email"  id="signin-email" type="email" placeholder="Admin Email" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">Password</label>
                        <input class="full-width has-padding has-border" name="password"  id="signin-password" type="password" placeholder="Password" required="required">
                        <span class="cd-error-message">Error message here!</span>
                    </p>

                    <%-- <p class="fieldset">
                         <input type="checkbox" id="remember-me" checked="">
                         <label for="remember-me" style="font-size: 22px;">Remember me</label>
                     </p>
                    --%>

                    <button class="btn btn-danger" style="font-size: 28px;padding-left: 197px;padding-right: 197px;padding-bottom: 10px;padding-top: 10px;"type="submit" value="Login">Login</button>

                </form>
            </div> <!-- cd-login -->>
        </div>
    </div>
</div>


<script src="js/main.js"></script> <!-- Gem jQuery -->