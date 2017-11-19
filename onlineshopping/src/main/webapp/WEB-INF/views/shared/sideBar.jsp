
<h1 class="my-4">Shop Name</h1>
<div class="list-group">
	<c:forEach items="${catagories}" var="catagories">
		<a href="${contextRoot}/show/catagory/${catagories.id}/products" class="list-group-item" id="a_${catagories.name }">${catagories.name}</a>
	</c:forEach>
