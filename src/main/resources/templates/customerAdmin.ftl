<#import "templ/templ.ftl" as p>
<@p.pages>

    <#if customers??>

        <#list customers as customer>
            <ul>
                <li>${customer.id}</li>
                <li>${customer.name}</li>
                <li>${customer.surname}</li>
                <li>Username : ${customer.user.username}</li>
                <li>Password : ${customer.user.password}</li>
                <li>${customer.email}</li>
                <li>${customer.phone}</li>
            </ul>
        </#list>

    </#if>

</@p.pages>