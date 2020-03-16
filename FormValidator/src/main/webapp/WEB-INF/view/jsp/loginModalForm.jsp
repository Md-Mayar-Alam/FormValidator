<html>
	<head>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<link rel="stylesheet" href="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.14.0/css/mdb.min.css">
  		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  		
  		<script type="text/javascript" src="js/jQuery/3.4.0/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		
  		<style type="text/css">
  			.d-flex{
  				display: flex !important;
  			}
  			.justify-content-center{
  				justify-content: center !important;
  			}
  		</style>
	</head>
	
	<body>
		<div class="container">
			<div class="text-center">
				<a href="#" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#loginModal">Open Login Form</a>
			</div>
			
			<div id="loginModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header text-center">
							<button class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Sign In</h4>
						</div>
						
						<div class="modal-body mx-3">
							<div class="md-form mb-5">
								<i class="fas fa-envelope prefix grey-text"></i>
								<label for="loginEmail" class="">Your Email</label>
								<input type="email" id="loginEmail" class="form-control validate"/>
							</div>
							<div class="md-form mb-4">
								<i class="fas fa-lock prefix grey-text"></i>
								<label for="loginPassword" class="">Your Password</label>
								<input type="password" id="loginPassword" class="form-control validate"/>
							</div>
						</div>
						
						<div class="modal-footer d-flex justify-content-center">
							<button class="btn btn-default">Login</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>