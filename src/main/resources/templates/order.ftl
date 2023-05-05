<#import "templ/templ.ftl" as c>
<@c.pages>

    <h1> Order </h1>
    <table class="table">
        <thead>
        <tr>
            <th>image</th>
            <th>name</th>
            <th>driver</th>
            <th>price</th>
        </tr>
        </thead>

        <tbody>
        <#if ItemCart??>
            <#list itemCart as item>
                <tr>
                    <td><img src="${item.faculty.image}" alt="${item.faculty.name}" height="40px"></td>
                    <td>${item.faculty.name}</td>
                    <td>${item.faculty.description}</td>
                    <td>${item.faculty.teacher}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h2>Student</h2>

    <table class="table">
        <thead>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>phone</th>
            <th>email</th>
        </tr>
        </thead>
        <tbody>
        <form action="/order" method="post">
            <tr>

            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.phone}</td>
            <td>${student.email}</td>
            <td> <button type="submit">Add to DB</button> </td>

        </tr>
        </form>
        </tbody>
    </table>
</@c.pages>
