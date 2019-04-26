<%--
  Created by IntelliJ IDEA.
  User: rcrespillo
  Date: 2019-04-25
  Time: 13:38
--%>

<div class="list-group">
    <g:each var="category" in="${category}">
        <button id="${category.id}" type="button" class="list-group-item list-group-item-action" onclick="getCategory(this.id)">${category.name}</button>
    </g:each>
</div>