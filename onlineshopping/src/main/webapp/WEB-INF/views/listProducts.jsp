<div class="container">

	<div class="row">

		<div class="col-md-3">

			<%@include file="./shared/sideBar.jsp"%>


		</div>

		<div class="col-md-9">

			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCatagoryProducts == true}">
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