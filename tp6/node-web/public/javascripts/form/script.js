function envio(){
    window.location.assign("trends?site=" + document.getElementById("site").value + "&" + "category=" +
    document.getElementById("category").value + "&" + "rows=" + document.getElementById("raws").value + "&" + "columns=" + document.getElementById("columns").value);
}

(function() {
  var endPointSites = "https://api.mercadolibre.com/sites";
  callApiAndFoo(endPointSites, inflateSitesOptions);
})();

function seleccionSitio(element){ 
  let endPointCategories = "https://api.mercadolibre.com/sites/" + element.value + "/categories";
  callApiAndFoo(endPointCategories, inflateCategoriesOptions);  
}

function callApiAndFoo(url, foo) {
  fetch(url)
  .then(response => response.json())
  .then(data => foo(data))
  .catch(function(error) {
      alert(error.errorMessage);
  })
}

function inflateCategoriesOptions(data) {
    cleanElement(document.getElementById("category"));
    data.forEach(cat => {
    var opt=document.createElement("option");
    opt.value=cat.id;
    opt.innerHTML=cat.name;
    document.getElementById("category").appendChild(opt);
  });    
}

function inflateSitesOptions(data) {
    data.forEach(site => {
      var opt=document.createElement("option");
      opt.value=site.id;
      opt.innerHTML=site.name;
      document.getElementById("site").appendChild(opt);
    });
}

function cleanElement(element) {
  while (element.firstChild) {
    element.removeChild(element.firstChild)
  }
}