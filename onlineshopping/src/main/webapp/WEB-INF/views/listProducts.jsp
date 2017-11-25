<div class="container">

	<div class="row">

		<div class="col-md-3">

			<%@include file="./shared/sideBar.jsp"%>


		</div>

		<div class="col-md-9">

			<div class="row">
			<div class="row">
			<div class ="col-md-12">
			<table id = "productlisttables" class="table table-striped table-borderd">
			
			<thead>
			
			<tr>
			<th></th>
			<th>Name</th>
			<th>Brand</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th></th>
			</tr>
			
			
			</thead>
			<tfoot>
			
			<tr>
			<th></th>
			<th>Name</th>
			<th>Brand</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th></th>
			</tr>
			
			
			</tfoot>
			</table>
			
			
			
			</div>
			</div>
				<div class="col-md-12" >
					<c:if test="${userClickAllProducts == true}">
					<script>
					window.catagoryId='';
					</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCatagoryProducts == true}">
					<script>
					window.catagoryId='${catagory.id}';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/Catagory</li>
							<li class="active">/${catagory.name}</li>
						</ol>
					</c:if>
				</div>


			</div>


		</div>


	</div>



</div>