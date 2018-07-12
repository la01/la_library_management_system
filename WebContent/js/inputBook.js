function getDataFromISBN() {
	document.ISBNForm.searchISBN.value = document.getElementById("isbn").value;
	document.ISBNForm.submit();
}