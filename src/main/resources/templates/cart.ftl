<#import "templ/templ.ftl" as c>
<@c.pages>
<h2> Routes </h2>


<table class="table">
  <thead>
  <tr>
    <th>images</th>
    <th>name</th>
    <th>description</th>
    <th>category </th>
    <th>teacher</th>
  </tr>
  </thead>

  <tbody>
  <#if itemCart??>
  <#list itemCart as item>
  <tr>
    <td><img src="${item.faculty.image}" alt="image" height="40px"></td>
    <td>${item.faculty.name}</td>
    <td>${item.faculty.description}</td>
    <td>${item.faculty.categories.name}</td>
    <td>₴ ${item.faculty.teacher}</td>
    <form action="/deleteItem" method="post">
      <td>
        <input type="hidden" name="id" value="${item.faculty.id}">
        <button type="submit" class="btn btn-danger">delete</button>
      </td>
    </form>
  </tr>
  </#list>
</#if>
</tbody>
</table>

  <p></p>
  <h2>go to Form Order</h2>
  <form action="/login" method="get">
    <button type="submit"> go to Auth </button>
  </form>

  <p></p>
</@c.pages>