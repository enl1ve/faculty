<#import "templ/templ.ftl" as p>
<@p.pages>
    <h1>Category</h1>
    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if allCategory??>
            <#list allCategory as category>
                <div class="col">
                    <div class="card">

                        <form action="/routesByCategory" method="post">

                            <input type="hidden" name="id" id="id_" value="${category.id}">
                            <a href="/category/${category.id}">
                            <img src="${category.image}" class="card-img-top" alt="${category.name}">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title">${category.name}</h5>
                                <p>${category.description}</p>
                            </div>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>

    </div>


</@p.pages>