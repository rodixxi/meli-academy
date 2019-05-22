import React from 'react';
import ReactDom from "react-dom";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "Pepe"
    };
    this.updateMesaje = this.updateMesaje.bind(this);
    this.forceUpdateHandler =  this.forceUpdateHandler.bind(this);
    this.findFirstNode = this.findFirstNode.bind(this);
    this.findSecondtNode = this.findSecondtNode.bind(this);

  }e

  findFirstNode() {
    var divOne = document.getElementById("divOne");
    ReactDom.findDOMNode(divOne).style.color = "green";
  }

  findSecondtNode() {
    var divTwo = document.getElementById("divTwo");
    ReactDom.findDOMNode(divTwo).style.color = "red";
  }

  forceUpdateHandler() {
    this.forceUpdate()
  }
  updateMesaje() {
    this.setState({
      mesaje: "Bueno.. no tanto..."
    })
  }
  render() {
    return (
        <div>
          <h1>Hola</h1>
          <h4>Numero aleatorio: {Math.random()}</h4>
          <button onClick={this.findFirstNode}>Nodo 1</button>
          <button onClick={this.findSecondtNode}>Nodo 2</button>
          <h4 id="divOne">NODO 1</h4>
          <h4 id="divTwo">NODO 2</h4>
        </div>
    )}
}

App.defaultProps = {
  name: "Rodri"
};

export default App;
