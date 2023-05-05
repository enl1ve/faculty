<#import "templ/templ.ftl" as c>
<@c.pages>
    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if allRoutesByCategory??>
            <#list allRoutesByCategory as faculty>
                <div class="col">
                    <div class="card">

                        <form action="/cart" method="post">

                            <input type="hidden" name="id" id="id_" value="${faculty.id}">
                            <img src="${faculty.image}" class="card-img-top" alt="${faculty.name}">
                            <div class="card-body">
                                <h5 class="card-title">Назва: ${faculty.name}</h5>
                                <p class="card-text">Опис: ${faculty.description}</p>
                                <p class="card-text">Вчитель: ${faculty.teacher}</p>
                                <h5 class="card-title">Категорія: <a>${faculty.categories.name}</a></h5>

<#--                                <div>-->
<#--                                    <button class="minus btn btn-success"> - </button>-->
<#--                                    <input type="text" name="quantity" value="1" size="3">-->
<#--                                    <button class="plus btn btn-success"> + </button>-->
<#--                                    <p class="my_text"> </p>-->
<#--                                </div>-->


                                <button type="submit" class="btn btn-primary"> Add to Cart</button>
                                <a href="/category" class="card-link" class="btn btn-success">to category</a>
                            </div>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>

    </div>

</@c.pages>