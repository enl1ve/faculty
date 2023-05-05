<#import "templ/templ.ftl" as c>
<@c.pages>
        <div class="row justify-content-center">
            <div class="col-5"></div>


            <h2> Registration User </h2>
            <form action="/registration" method="post">
                <div class="mb-3">

                    <fieldset>
                        <label for="username">Username</label>
                        <input type="text" name="username" id="username" placeholder="user">

                        <p></p>

                        <label for="name">Surname</label>
                        <input type="text" name="name" id="name" placeholder="enter u`r name">

                        <p></p>

                        <label for="surname">Surname</label>
                        <input type="text" name="surname" id="surname" placeholder="surname">

                        <p></p>

                        <label for="phone">Phone</label>
                        <input type="text" name="phone" id="phone" placeholder="phone">

                        <p></p>

                        <label for="email">Email</label>
                        <input type="text" name="email" id="email" placeholder="email">

                        <p></p>

                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" placeholder="pass">
                    </fieldset>
                </div>

                <button type="submit"> add</button>
            </form>
        </div>

</@c.pages>