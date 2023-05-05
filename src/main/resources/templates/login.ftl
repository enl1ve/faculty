<#import "templ/templ.ftl" as c>
<@c.pages>

    <div class="row justify-content-center">
        <div class="col-5"></div>


        <h2> Auth User </h2>
        <form action="/login" method="post">
            <div class="mb-3">

                <fieldset>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" placeholder="user">

                    <p></p>

                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="pass">
                </fieldset>
            </div>

            <button type="submit"> add</button>
        </form>
    </div>
</@c.pages>