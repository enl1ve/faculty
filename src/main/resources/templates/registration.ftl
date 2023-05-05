<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>

<@p.pages>
    <h1> Registration </h1>

    <form action="/registration" method="post">

        <@spring.bind "users"/>

        <label>Username</label><br>
        <@spring.formInput "users.username"/>
        <@spring.showErrors "<br>"/><br>

        <label>Password</label><br>
        <@spring.formInput "users.password"/>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "customer"/>

        <label>First Name</label><br>
        <@spring.formInput "customer.name"/>
        <@spring.showErrors "<br>"/><br>

        <label>Last Name</label><br>
        <@spring.formInput "customer.surname"/>
        <@spring.showErrors "<br>"/><br>

        <label>Phone</label><br>
        <@spring.formInput "customer.phone"/>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label><br>
        <@spring.formInput "customer.email"/>
        <@spring.showErrors "<br>"/><br>


        <input type="submit" value="save">

    </form>

</@p.pages>