<#import "templ/templ.ftl" as p>
<@p.pages>
    <h1>Login</h1>
    <form action="/login" method="post">
        <label for="username">Username</label><br>
        <input type="text" name="username" placeholder="username" id="username"><br><br>
        <label for="password">Pass</label><br>
        <input type="text" name="password" placeholder="password" id="password"><br>

        <input type="submit" value="add">
        <#--        <button type="submit">add</button>-->
    </form>
    <a href="/registration">Перехід на сторінку реєстрації</a>

</@p.pages>