<#import "templ/templ.ftl" as p>
<@p.pages>
    <h1>Products</h1>

    <hr>
    <h2> Save Product to DB </h2>

    <form action="/saveNewProduct" method="post">


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
                <td><label for="teacher">Teacher</label><br>
                    <input type="text" name="teacher" placeholder="teacher" id="teacher"><br>
                </td>
            </tr>
            <tr>
                <td><label for="image">Image</label><br>
                    <input type="text" name="image" id="image" placeholder="link"><br>
                </td>
            </tr>

            <tr>

                <#--                -->
                <td><label for="category">Category</label><br>

                    <select name="categoryId">

                        <#list allCategory as category>
                            <option value="${category.id}">${category.name}</option>
                        </#list>

                    </select>
                    <br>
                </td>

            </tr>

            <tr>
                <td>
                    <input type="submit" value="save">
                </td>
            </tr>
            </tbody>
        </table>


        <br>
        <hr>
        <h2> ProductList </h2>

        <table>
            <thead>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Description</td>
                <td>Images</td>
                <td>Teacher</td>
                <td>Category</td>
            </tr>
            </thead>

            <tbody>

            <#if allProduct??>
                <#list allProduct as product>
                    <tr>
                        <td>${product.id}</td>
                        <td><a href="/productmanager/${product.id}"> ${product.name} </a></td>
                        <td>${product.description}</td>
                        <td>${product.image}</td>
                        <td>${product.teacher}</td>
                        <td>${product.categories.name}</td>
                    </tr>
                </#list>
            </#if>

            </tbody>
        </table>

        <br>
        <hr>


    </form>



    <br>
    <hr>
    <h2> Update/Delete </h2>

    <table>
        <thead>
        <tr>
            <#--            <td>Id</td>-->
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
            <td>Teacher</td>
            <td>Category</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        </thead>

        <tbody>

        <#if allProduct??>
            <#list allProduct as product>

                <form action="/updateProduct" method="post">
                    <tr>
                        <#--                    <td>-->
                        <input type="hidden" name="id" value="${product.id}">
                        <#--                    </td>-->
                        <td>
                            <input type="text" name="description" value="${product.description}">
                        </td>
                        <td><input type="text" name="driver" value="${product.name}"></td>
                        <td><input type="text" name="description" value="${product.description}"></td>
                        <td><input type="text" name="images" value="${product.image}"></td>
                        <td><input type="text" name="teacher" value="${product.teacher}"></td>

                        <td>
                            <select name="categoryId">
                                <#list allCategory as category>
                                    <#if "${category.id}"=="${product.categories.id}">
                                        <option value="${category.id}" selected>${category.name}</option>
                                    <#else>
                                        <option value="${category.id}">${category.name}</option>
                                    </#if>
                                </#list>
                            </select>


                        </td>

                        <td><input type="submit" value="update"></td>
                </form>


                <td>
                    <form action="/deleteProduct" method="post">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <br>
    <hr>
    <h2> Delete All Product </h2>
    <form method="post" action="/deleteAllProduct">
        <input type="submit" value="delete">
    </form>

    <br>
    <hr>



    </form>









</@p.pages>