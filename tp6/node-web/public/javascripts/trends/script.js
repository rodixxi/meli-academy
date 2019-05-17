var container = document.body;

// slide options
var slideEase = function(t) {
  return t * t * t;
},
    slideDuration = 1000;

// text options
var delay = {
  before: 300,
  between: 200,
  after: 2500
};

// trends snapshot (can't think of a JS only way to load these dynamically)
var trends = ['MELI','Trends'];
var url_string = window.location.href;
var url = new URL(url_string);
var site = url.searchParams.get("site");
var category = url.searchParams.get("category");
var rows = parseInt(url.searchParams.get("rows"));
var columns = parseInt(url.searchParams.get("columns"));
var endPointMeliSearch = "https://api.mercadolibre.com/sites/MLA/search?q=";
var endPointMeliItems = "https://api.mercadolibre.com/items/";
var endPointSites = "https://api.mercadolibre.com/trends/" + site + "/" + category;

callApiAndFoo(endPointSites, inflateTrendsText);
function randomTrend() {
  return trends[Math.floor(trends.length * Math.random())];
}

// colors
var colors = ['#ff3031', '#68ac0d', '#00a8da', '#fbc500'];
function randomColor() {
  return colors[Math.floor(colors.length * Math.random())];
}

var Cell = function(x, y) {
  // create the node
  var node = document.createElement('div');
  node.className = 'cell';
  node.style.left = x * 20 + '%';
  node.style.top  = y * 20 + '%';
  this.node = node;
  
  // create and add the panes
  var panes = [new Pane(this), new Pane(this)];
  node.appendChild(panes[0].node);
  node.appendChild(panes[1].node);
  panes[0].setOtherNode(panes[1].node);
  panes[1].setOtherNode(panes[0].node);
  
  // handles sliding in next pane
  var currentPane = 0;
  this.nextPane = function() {
    // swap z-indexes
    panes[currentPane].node.style.zIndex = '-1';
    currentPane = ++currentPane % 2;
    panes[currentPane].node.style.zIndex = '1';
    
    panes[currentPane].init();
  }
  
  // quickstart
  panes[0].quickStart();
  panes[0].node.style.zIndex = '1';
}

var Pane = function(cell) {
  var otherNode;
  this.setOtherNode = function(other) {
    otherNode = other;
  }
  
  // create the node
  var node = document.createElement('div');
  node.className = 'pane';
  this.node = node;
  
  // a place to write the trends
  var trend = document.createElement('a');
  trend.className = 'trend';
  node.appendChild(trend);
  
  // (re-)initialize pane when sliding in
  this.init = function() {
    var dir = Math.floor(4 * Math.random());
    switch (dir) {
      case 0:
        slideStart = {left:0,top:-100};
        break;
      case 1:
        slideStart = {left:100,top:0};
        break;
      case 2:
        slideStart = {left:0,top:100};
        break;
      case 3:
        slideStart = {left:-100,top:0};
        break;
    }
    // make sure it's a different background color
    do
      node.style.backgroundColor = randomColor();
    while (node.style.backgroundColor == otherNode.style.backgroundColor);
    
    trend.title = randomTrend();
    trend.href = 'https://www.google.com/search?q=' + trend.title;
    trend.innerHTML = '';
    
    // start sliding in
    slideValue = 0;
    slideIn();
  }
  
  // handles sliding in
  var slideStart,
      slideValue;
  var slideIn = function() {
    slideValue += 20 / slideDuration;
    if (slideValue >= 1) {
      // end of sliding in
      slideValue = 1;
      setTimeout(nextChar, delay.before);
    } else {
      setTimeout(slideIn, 20);
    }
    node.style.left = slideEase(1 - slideValue) * slideStart.left + '%';
    node.style.top  = slideEase(1 - slideValue) * slideStart.top  + '%';
    // push other node away
    otherNode.style.left =
      (slideEase(1 - slideValue) - 1) * slideStart.left + '%';
    otherNode.style.top  =
      (slideEase(1 - slideValue) - 1) * slideStart.top  + '%';
  }
  
  // handles text
  var nextChar = function() {
    if (trend.innerHTML.length < trend.title.length) {
      trend.innerHTML =
        trend.title.slice(0, trend.innerHTML.length + 1);
      setTimeout(nextChar, delay.between);
    } else {
      setTimeout(cell.nextPane, delay.after);
    }
  }
  
  // initial start
  this.quickStart = function() {
    node.style.backgroundColor = colors[3];
    trend.title = randomTrend();
    trend.href = 'https://www.google.com/search?q=' + trend.title;
    nextChar();
  }
}

// create the cells
var cells = [];
for (var i = 0; i < (rows * columns); i++) {
  cells[i] = new Cell(i % columns, Math.floor(i / columns));
  container.appendChild(cells[i].node);
}

// handles font size on resize
// quick and dirty, needs a fix
function calcFontsize() {
  var fontSize = Math.min(
    container.clientHeight / 18,
    container.clientWidth / 46
  );
  fontSize = Math.floor(fontSize);
  container.style.fontSize = fontSize + 'px';
}
calcFontsize();
window.onresize = calcFontsize;

//MELI Trends

function callApi(url) {
    var data;
    fetch(url)
    .then(response => data = response.json())
    .catch(function(error) {
        data = error.errorMessage;
    })
    return data;
}

function callApiAndFoo(url, foo) {
    var data;
    fetch(url)
    .then(response => response.json())
    .then(data => foo(data))
    .catch(function(error) {
        alert(error.errorMessage);
    })
}

function inflateTrendsText(data){
    var newTrends = [];
    let i = 0;
    data.forEach(trend => {
        newTrends[i]=trend.keyword;
        i++;
      }); 
    trends = newTrends;
}

function inflateTrendsWithImage(data) {
    var imageArray = []
    i = 0
    data.forEach(trend => {
        getImage(trend, imageArray, i)
        i++
    });
}

function getImage(text, array, idx) {
    fetch(endPointMeliSearch + text)
    .then(response => response.json())
    .then(function(data) {
        getImageFromItemId(data.results[0].id, array, idx);
    })
    .catch(function(error) {
        alert(error.errorMessage);
    })
}

function getImageFromItemId(itemId) {
    fetch(endPointMeliItems + itemId)
    .then(response => response.json())
    .then(function(data) {
        array[idx] = data.pictures[0].url;
    })
    .catch(function(error) {
        alert(error.errorMessage);
    })
}


