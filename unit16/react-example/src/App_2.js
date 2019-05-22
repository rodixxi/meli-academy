import React from 'react';
import ReactDom from 'react-dom'
import './App.css';

class Hello2 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      mesaje: "Lindo dia!"
    };
    this.updateMesaje = this.updateMesaje.bind(this);
  }
  updateMesaje() {
    this.setState({
      mesaje: "Bueno.. no tanto..."
    })
  }
  render() {
    return (
        <div>
          <h1>Hola {this.props.name} {this.props.mesaje}</h1>
          <button onClick={this.updateMesaje}>Te parece ?</button>
        </div>
    )}
}

Hello2.defaultProps = {
  name: "Rodri"
};

ReactDom.render(<Hello2 name={"Mercado Libre"}/>,
    document.getElementById('hello-meli'));

export default Hello2;
