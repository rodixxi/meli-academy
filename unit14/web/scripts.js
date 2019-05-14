const app = document.getElementById('root');

const logo = document.createElement('img');

const sitesUrl = 'https://api.mercadolibre.com/sites';

const categoriessUrl = 'https://api.mercadolibre.com/sites/';


logo.src = 'logo.png';

const container = document.createElement('div');
container.setAttribute('class', 'container');

app.appendChild(logo);
app.appendChild(container);

getSites();

function getSites() {
  fetch(sitesUrl)
  .then(response => response.json())
  .then(data => inflateData(data))
  .catch(function(error) {
    const errorMessage = document.createElement('marquee');
    errorMessage.textContent = error.errorMessage;
    app.appendChild(errorMessage);
  })
}

function inflateData(data) {
  cleanElement(container);
  data.forEach(site => {
    let card = document.createElement('div');
    card.setAttribute('class', 'card');
    card.setAttribute('onclick', 'getCategory("' + site.id + '")');
    //card.onclick = getCategory("" + site.id);
    let h1 = document.createElement('h1');
    h1.textContent = site.name;

    let p = document.createElement('p');
    p.textContent = "ID: " + site.id;
   
    container.appendChild(card);
    card.appendChild(h1);
    card.appendChild(p);
  });
}

function getCategory(id) {
  fetch(categoriessUrl + id + "/categories")
  .then(response => response.json())
  .then(data => inflateData(data))
  .catch(function(error) {
    const errorMessage = document.createElement('marquee');
    errorMessage.textContent = error.errorMessage;
    app.appendChild(errorMessage);
  })
}

function cleanElement(element) {
  while (element.firstChild) {
    element.removeChild(element.firstChild)
  }
}