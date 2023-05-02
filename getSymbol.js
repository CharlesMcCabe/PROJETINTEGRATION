function getSymbol() {

var input;
  var abbreviation;
  element = document.getElementById("txtActions");
  if (element != null) {
    input = element.value;
    abbreviation = input.substring(0, input.indexOf(' '));
  }
  return abbreviation;
}