<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<c:if test="${not empty message}">

			<div class=col-xs-12>
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}

				</div>

			</div>

		</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">


				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body"></div>

				<sf:form class="form-horizontal" modelAttribute="product"
				action="${contextRoot}/manage/products"
				method="POST"
				enctype="multipart/form-data"
				>

					<div class="form-group">
						<label class="control-label col-md-4">Enter Product name:</label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="name"
								placeholder="Enter Product Name!" />
							<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Enter Product name:</label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand"
								placeholder="Enter Brand Name!" />
							<sf:errors path="brand" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Enter Unit Price:</label>
						<div class="col-md-8">
							<sf:input type="number" path="unitPrice" id="unitPrice"
								placeholder="Enter Unit Price!" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Enter Description:</label>
						<div class="col-md-8">
							<sf:textarea path="description" id="desc"
								placeholder="Enter Description!" />

							<sf:errors path="description" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Quantity Available</label>
						<div class="col-md-8">
							<sf:input type="number" path="quantity" id="quantity"
								placeholder="Enter Quantity Available" />
							<sf:errors path="quantity" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="file">Upload an image</label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file"
								 />
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Select Category:</label>
						<div class="col-md-6">
							<sf:select class="form-control" id="catagoryId" path="catagoryId"
								items="${catagories}" itemLabel="name" itemValue="id" />


						</div>
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" id="submit" value="Submit">
							<sf:hidden path="id" />
							<sf:hidden path="purchases" />
							<sf:hidden path="code" />
							<sf:hidden path="views" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
						</div>
					</div>
				</sf:form>

			</div>




		</div>




	</div>



</div>