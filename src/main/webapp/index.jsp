<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>

		<h1>Formulaire</h1>

	</div>
	<form action="renseignerBasaDonnee" method="post">
	<p>
		<label for="text"> Nom :</label> <input type="text" name="nom"
			size="20" />
	</p>

	<p>
		<label for="text"> Prenom :</label> <input type="text" name="prenom"
			size="20" />
	</p>

	<p>
		<label for="text"> Adresse_mail :</label> <input type="text"
			name="mail" size="40" />
	</p>

	<p>
		<label for="text"> Identifiant :</label> <input type="text"
			name="identifiant" size="20" />
	</p>
	<p>
		<label for="password"> MotDePasse :</label> <input type="password" name="motDePasse"
			size="20" />
	</p>

	<p>

		<input type="submit" value="Creer"> <input type="reset"
			value="Annuler">

	</p>
	</form>
</body>
</html>