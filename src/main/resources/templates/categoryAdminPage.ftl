<#import "templ/templ.ftl" as p>
<@p.pages>



    <h1>Categories</h1>

    <hr>
    <h2> Save Category to DB </h2>

    <form action="/saveNewCategory" method="post">

        <table>
            <tbody>
            <tr>
                <td><label for="name">Name</label><br>
                    <input type="text" name="name" placeholder="name" id="name"><br>
                </td>
            </tr>
            <tr>
                <td><label for="description">Description</label><br>
                    <input type="text" name="description" placeholder="description" id="description"><br>
                </td>
            </tr>
            <tr>
                <td><label for="image">Image</label><br>
                    <input type="text" name="image" id="image" placeholder="link"><br>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="save">
                </td>
            </tr>
            </tbody>
        </table>

    </form>

    <br>
    <hr>
    <h2> CategoryList </h2>

    <table>
        <thead>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
        </tr>
        </thead>

        <tbody>

        <#if allCategory??>
            <#list allCategory as category>
                <tr>
                    <td>${category.id}</td>
                    <td><a href="/categorymanager/${category.id}"> ${category.name} </a></td>
                    <td>${category.description}</td>
                    <td>${category.image}</td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <br>
    <hr>
    <h2> Update/Delete Category </h2>


    <table>
        <thead>
        <tr>
            <#--            <td>Id</td>-->
            <td>City</td>
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        </thead>

        <tbody>
        <#if allCategory??>
            <#list allCategory as category>
                <tr>
                    <form method="post" action="/updateCategory">
                        <input type="hidden" name="id" value="${category.id}">
                        <td><input type="text" name="name" value="${category.name}"></td>
                        <td><input type="text" name="description" value="${category.description}"></td>
                        <td><input type="text" name="image" value="${category.image}"></td>

                        <td>
                            <input type="submit" value="update">
                        </td>
                    </form>
                    <td>
                        <form method="post" action="/deleteCategory">
                            <input type="hidden" name="id" value="${category.id}">
                            <input type="submit" value="delete"> ${Err}
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>
    <br>
    <hr>
    <h2> Delete All Category </h2>
    <form method="post" action="/deleteAllCategory"> ${Error}
        <input type="submit" value="delete">
    </form>

</@p.pages>
